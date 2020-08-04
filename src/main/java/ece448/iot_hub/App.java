package ece448.iot_hub;

import java.util.*;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class App {

	private final HashMap<String, String> states = new HashMap<>();
	private final HashMap<String, String> powers = new HashMap<>();

	App(){
		
	}

	@Bean(destroyMethod = "disconnect")
	public MqttClient mqttClient(Environment env) throws Exception {
		broker = env.getProperty("mqtt.broker");
		clientId = env.getProperty("mqtt.clientId");
		topicPrefix = env.getProperty("mqtt.topicPrefix");
		
		mqtt = new MqttClient(broker, clientId, new MemoryPersistence());
		mqtt.connect();
		
		mqtt.subscribe(topicPrefix+"update/#", this::handleUpdate);
		logger.info("MqttClient {} connected: {}", clientId, broker);
		return mqtt;
	}

	synchronized protected void handleUpdate(String topic, MqttMessage msg) {
		logger.debug("MqttCtl {}: {} {}", clientId, topic, msg);

		String[] nameUpdate = topic.substring(topicPrefix.length()).split("/");
		if ((nameUpdate.length != 3) || !nameUpdate[0].equals("update"))
			return; // ignore unknown format

		switch (nameUpdate[2])
		{
		case "state":
			states.put(nameUpdate[1], msg.toString());
			break;
		case "power":
			powers.put(nameUpdate[1], msg.toString());
			break;
		default:
			return;
		}
	}

	synchronized public void publishAction(String plugName, String action) {
		String topic = topicPrefix+"action/"+plugName+"/"+action;
		try
		{
			mqtt.publish(topic, new MqttMessage());
		}
		catch (Exception e)
		{
			logger.error("MqttCtl {}: {} fail to publish", clientId, topic);
		}
	}

	synchronized public String getState(String plugName) {
		return states.get(plugName);
	}

	synchronized public String getPower(String plugName) {
		return powers.get(plugName);
	}

	synchronized public Map<String, String> getStates() {
		return new TreeMap<>(states);
	}

	synchronized public Map<String, String> getPowers() {
		return new TreeMap<>(powers);
	}
	
	private  String broker;
	private  String clientId;
	private  String topicPrefix;
	
	private MqttClient mqtt;
	private static final Logger logger = LoggerFactory.getLogger(App.class);
}