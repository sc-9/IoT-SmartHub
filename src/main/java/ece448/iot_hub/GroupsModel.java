package ece448.iot_hub;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupsModel {
	private HashMap<String, ArrayList<HashMap<String, Object>>> groups = new HashMap<>();

	@Autowired
	PlugsModel plugs ;

	synchronized public List<String> getGroups() {
		return new ArrayList<>(groups.keySet());
	}

	synchronized public ArrayList<HashMap<String, Object>> getGroupMembers(String group) {
		ArrayList<HashMap<String, Object>> members = groups.get(group);
		return (members == null)? new ArrayList<>(): (members);
	}

	synchronized public void setGroupMembers(String group, List<String> members) {
		ArrayList<HashMap<String, Object>> ret = new ArrayList<>();
		for(String plug : members){
			ret.add(makePlug(plug));
			
		}

		//HashSet<Object> sorted = sort(ret);
		groups.put(group, (ret));
	}
	public ArrayList<HashMap<String, Object>> memsUpdate(String group, List<String> members){
		ArrayList<HashMap<String, Object>> ret = new ArrayList<>();
		for(String plug : members){
			ret.add(makePlug(plug));
			
		}
		return ret;
		
	}
	
/*
	private HashSet<Object> sort(HashSet<HashMap<String, Object>> ret) {
		HashMap<String, Object> temp = new HashMap<>();
		for(HashMap<String, Object> obj : ret){
			
		}
		return null;
	}*/

	synchronized public void removeGroup(String group) {
		groups.remove(group);
	}


	//form plug like name, state, poweer
	protected HashMap<String, Object> makePlug(String plug) {
		// modify code below to include plug states
		HashMap<String, Object> ret = new HashMap<>();
		ret.put("name", plug);
        ret.put("state", plugs.getPlugState(plug));
        ret.put("power", plugs.getPlugPower(plug));
		return ret;
	}

	public void updateAction(String group, ArrayList<HashMap<String, Object>> members, String action) {
		for(HashMap<String, Object> val : members){
			String plugName = (String)val.get("name");

			plugs.updatePlug(plugName, action);
			
		}

		//updateLocalGroupPlugs(group, members);

	}

	public void updateLocalGroupPlugs() {
		ArrayList v = new ArrayList<>();
		ArrayList<HashMap<String, Object>> t;
		for(String val : groups.keySet()){
			ArrayList<HashMap<String, Object>> members = getGroupMembers(val);
			for(HashMap<String, Object> abc: members){
				v.add(abc.get("name"));
			}
				t = memsUpdate(val, v);
				groups.replace(val, t);	
			v.clear();
		}
//ArrayList<HashMap<String, Object>> members; = getGroupMembers()
		
		

	}
}