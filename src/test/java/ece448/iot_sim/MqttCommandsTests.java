// package ece448.iot_sim;

// import static org.junit.Assert.*;

// import java.util.ArrayList;
// import java.util.Arrays;


// import org.eclipse.paho.client.mqttv3.MqttMessage;
// import org.junit.Test;

// import ece448.iot_sim.PlugSim.Observer;

// public class MqttCommandsTests {
// public static class ObserverOne implements Observer {
// 	private String name, key, value;

// 	@Override
// 	public void update (String name, String key, String value){
// 		this.name = name;
// 		this.key = key;
// 		this.value = value;
// 	}

// 	public String getName() {
// 		return name;
// 	}

// 	public void setName(String name) {
// 		this.name = name;
// 	}

// 	public String getKey() {
// 		return key;
// 	}

// 	public void setKey(String key) {
// 		this.key = key;
// 	}

// 	public String getValue() {
// 		return value;
// 	}

// 	public void setValue(String value) {
// 		this.value = value;
// 	}
	
// }

// @Test
// public void testObserver() {
// 	PlugSim plug = new PlugSim("a");
// 	ObserverOne o1 = new ObserverOne();
// 	plug.addObserver(o1);
// 	plug.switchOn();
// 	assertEquals(o1.getName(), "a");
// 	assertEquals(o1.getKey(), "state");
// 	assertEquals(o1.getValue(), "on");
// 	plug.switchOff();
// 	assertEquals(o1.getName(), "a");
// 	assertEquals(o1.getKey(), "state");
// 	assertEquals(o1.getValue(), "off");
// }


// @Test
// public void test002() {
// 	PlugSim plug = new PlugSim("Saluton");
// 	ArrayList<PlugSim> plugs = new ArrayList<>();
// 	plugs.add(plug);
// 	MqttCommands mqttCmd = new MqttCommands(plugs, "iot_ece448/");
// 	MqttUpdates mqttupd = new MqttUpdates("iot_ece448/");
// 	System.out.println(mqttCmd);
// 	System.out.println(mqttupd);
// }

// @Test
// public void test003() {
// 	PlugSim plug = new PlugSim("Hola");
// 	ArrayList<PlugSim> plugs = new ArrayList<>();
// 	plugs.add(plug);
// 	SimConfig config = new SimConfig(8080, Arrays.asList(plug.getName()), "tacp://127.0.0.1", "iot_sim", "iot_ece448");
// 	try {
// 		Main mm = new Main(config);
// 	} catch (Exception e) {
// 		e.printStackTrace();
// 	}

// 	MqttCommands mqttCmd = new MqttCommands(plugs, "iot_ece448");
// 	MqttUpdates mqttupd = new MqttUpdates("iot_ece448");
// 	String topic = "update/hello/state";
// 	MqttMessage msg = mqttupd.getMessage("toggle");
// 	System.out.print(mqttCmd.getTopic());
// 	mqttCmd.handleMessage(topic, msg);
// }

// @Test
// public void test004() {
// 	PlugSim plug = new PlugSim("Hola");
// 	ArrayList<PlugSim> plugs = new ArrayList<>();
// 	plugs.add(plug);
// 	MqttUpdates mqttupd = new MqttUpdates("iot_ece448");
// 	mqttupd.getTopic("state", "on");
// }

// @Test
// public void test005() {
// 	PlugSim plug = new PlugSim("Hola");
// 	ArrayList<PlugSim> plugs = new ArrayList<>();
// 	plugs.add(plug);
// 	SimConfig config = new SimConfig(8080, Arrays.asList(plug.getName()), "tacp://127.0.0.1", "iot_sim", "iot_ece448");
// 	config.getMqttTopicPrefix();
// }
// @Test
// public void test006() {
// 	PlugSim plug = new PlugSim("Hola");
// 	ArrayList<PlugSim> plugs = new ArrayList<>();
// 	plugs.add(plug);
// 	MqttUpdates mqttupd = new MqttUpdates("iot_ece448");
// 	mqttupd.getTopic("power", "100.00");
// }


// @Test
// public void test007() {
// 	PlugSim plug = new PlugSim("Hola");
// 	ArrayList<PlugSim> plugs = new ArrayList<>();
// 	plugs.add(plug);
// 	MqttUpdates mqttupd = new MqttUpdates("iot_ece448");
// 	mqttupd.getTopic("state", "off");
// }
// @Test
// public void test008() {
// 	PlugSim plug = new PlugSim("Hola");
// 	ArrayList<PlugSim> plugs = new ArrayList<>();
// 	plugs.add(plug);
// 	MqttUpdates mqttupd = new MqttUpdates("iot_ece448");
// 	mqttupd.getTopic("power", "0.0");
// }

// @Test
// public void test009() {
// 	PlugSim plug = new PlugSim("Hola");
// 	ArrayList<PlugSim> plugs = new ArrayList<>();
// 	plugs.add(plug);
// 	MqttUpdates mqttupd = new MqttUpdates("iot_ece448");
// 	mqttupd.getTopic("state", "toggle");
// }

// @Test
// public void test010() {
// 	PlugSim plug = new PlugSim("Hola");
// 	ArrayList<PlugSim> plugs = new ArrayList<>();
// 	plugs.add(plug);
// 	MqttUpdates mqttupd = new MqttUpdates("iot_ece448");
// 	mqttupd.getTopic("state", "off");
// }

// @Test
// public void test011() {
// 	PlugSim plug = new PlugSim("xyz");
// 	ObserverOne o1 = new ObserverOne();
// 	plug.addObserver(o1);
// 	if(plug.isOn()) {
// 	plug.switchOn();
// 	assertEquals(o1.getName(), "xyz");
// 	assertEquals(o1.getKey(), "state");
// 	assertEquals(o1.getValue(), "on");
// 	} else {
// 	plug.switchOff();
// 	assertEquals(o1.getName(), "xyz");
// 	assertEquals(o1.getKey(), "state");
// 	assertEquals(o1.getValue(), "off");
// 	}
// }
// }