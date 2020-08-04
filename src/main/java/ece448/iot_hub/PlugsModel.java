package ece448.iot_hub;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PlugsModel {

    @Autowired
    App app;

    @Autowired
    Environment env;

    private HashMap<String, HashSet<String>> plugs = new HashMap<>();

    PlugsModel() { 
       // App app = new App();   
    }

    public void updatePlug(String plugName, String action){

        app.publishAction(plugName, action);
    }

	synchronized public Set<String> getPlugs() {
        Set<String> pgs = app.getStates().keySet();
		return  pgs;
	}

	synchronized public String getPlugState(String plug) {
		String state = app.getState(plug);
		return state != null ? state : "off";
	}


	synchronized String getPlugPower(String plug) {
		String power= app.getPower(plug);
		return power != null ? power : "0.000";
	}
}