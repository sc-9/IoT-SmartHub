package ece448.iot_sim;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ece448.iot_sim.MqttCommands;
import ece448.iot_sim.http_server.RequestHandler;

public class MqttCommands implements RequestHandler {
    
    private final String topicPrefix;

    private final TreeMap<String, PlugSim> plugs = new TreeMap<>();

    public MqttCommands(List<PlugSim> plugs, String topicPrefix) {
        for (PlugSim plug : plugs)
            this.plugs.put(plug.getName(), plug);
        this.topicPrefix = topicPrefix;
    }

    public String getTopic() {
        return topicPrefix + "action/#";
    }

    public String getMessage(MqttMessage msg) {
        return msg.toString();
    }

    public String handlMessage(String topic, MqttMessage msg) {

        try {
        // switch on, switch off, toggle
        String[] topicsplit=topic.split("/");
        String action= topicsplit[topicsplit.length-1];

        PlugSim plug = plugs.get(topicsplit[topicsplit.length-2]);  
        //Check null values
        if (plug == null || action == null)
        {
        } 
        else{

            //handle on request
            if(action.equals("on")){
                plug.updateState(true);
            }
            //handle off request
            else if(action.equals("off")){
                plug.updateState(false);
            }
            //handle toggle request
            else if(action.equals("toggle")){
                plug.toggle();

            } 
        }

        String V = plug.isOn() ? "on" : "off";
        double power = plug.getPower();
        return plug.getName() + "/" + V + "/" + power;
    
    }catch (Exception e) {
    }
        return null;
       

    }
    private static final Logger logger = LoggerFactory.getLogger(MqttCommands.class);

    @Override
    public String handleGet(String path, Map<String, String> params) {
        return null;
    }

}