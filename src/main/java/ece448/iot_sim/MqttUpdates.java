package ece448.iot_sim;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import java.util.*;
public class MqttUpdates {
    
    private String topicPrefix;
  
    
    public MqttUpdates(String mqttTopicPrefix) {
        this.topicPrefix = mqttTopicPrefix;
	}

	public String getTopic(String name, String key) {
        
         return topicPrefix+"update/"+name+"/"+key;
        
    }
    
    public MqttMessage getMessage(String value) {
        MqttMessage msg = new MqttMessage(value.getBytes());
        msg.setRetained(true);
        
        return msg;
    
    }
}
    