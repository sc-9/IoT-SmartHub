// package ece448.iot_sim;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collection;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Map;
// import java.util.TreeMap;

// import com.fasterxml.jackson.core.type.TypeReference;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import org.apache.http.client.fluent.Request;
// import org.apache.http.entity.ContentType;
// import org.junit.Test;
// import ece448.iot_sim.SimConfig;
// import ece448.grading.GradeP3.MqttController;
// import ece448.iot_hub.App;
// import ece448.iot_hub.GroupsModel;
// import ece448.iot_hub.GroupsResource;
// import ece448.iot_hub.HubConfig;

// import ece448.iot_hub.PlugsModel;
// import ece448.iot_hub.PlugsResource;

// import static org.junit.Assert.*;

// public class Assignment4Tests {

//     @Test
//     public void testCreateGroup() throws Exception {
    
//         PlugSim plug1 = new PlugSim("a");
//         PlugSim plug2 = new PlugSim("b");
//         GroupsModel groups = new GroupsModel();
//         GroupsResource resource = new GroupsResource(groups);
//         ArrayList<PlugSim> plugs = new ArrayList<>();
//         plugs.add(plug1);
//         plugs.add(plug2);

//         String member1 = "a";
//         String member2 = "b";
//         ArrayList<String> members = new ArrayList<>();
//         members.add(member1);
//         members.add(member2);
//         resource.createGroup("ab", members);
//         assertNotEquals(null, resource.getGroup("ab", null));
//     }   

// 	@Test
//     public void testCreateGroups() throws Exception {
    
//         PlugSim plug1 = new PlugSim("a");
//         PlugSim plug2 = new PlugSim("b");
//         GroupsModel groups = new GroupsModel();
//         GroupsResource resource = new GroupsResource(groups);
//         ArrayList<PlugSim> plugs = new ArrayList<>();
//         plugs.add(plug1);
//         plugs.add(plug2);

//         String member1 = "a";
// 		String member2 = "b";
// 		String member3 = "c";
// 		String member4 = "d";
//         ArrayList<String> members = new ArrayList<>();
//         members.add(member1);
// 		members.add(member2);
// 		members.add(member3);
// 		members.add(member4);
// 		resource.createGroup("ab", members);
// 		resource.createGroup("cd", members);

// 		members.remove("cd");

		
//         assertNotEquals(null, resource.getGroup("ab", null));
//     }   

// 	@Test
//     public void test01() throws Exception {
    
//         PlugSim plug1 = new PlugSim("a");
//         PlugSim plug2 = new PlugSim("b");
//         GroupsModel groups = new GroupsModel();
//         GroupsResource resource = new GroupsResource(groups);
//         ArrayList<PlugSim> plugs = new ArrayList<>();
//         plugs.add(plug1);
//         plugs.add(plug2);
// 		resource.getGroups();
// 		String member1 = "a";
// 		String member2 = "b";
//         ArrayList<String> members = new ArrayList<>();
//         members.add(member1);
// 		members.add(member2);
// 		resource.createGroup("ab", members);
// 		resource.removeGroup("ab");
// 		groups.removeGroup("ab");
// 		groups.getGroupMembers("ab");
// 	}
	
// 	@Test
//     public void test02() throws Exception {
    
//         PlugSim plug1 = new PlugSim("a");
// 		PlugSim plug2 = new PlugSim("b");
//         GroupsModel groups = new GroupsModel();
//         GroupsResource resource = new GroupsResource(groups);
//         ArrayList<PlugSim> plugs = new ArrayList<>();
//         plugs.add(plug1);
//         plugs.add(plug2);
// 		resource.getGroups();
// 		String member1 = "a";
// 		String member2 = "b";
// 		String member3 = "c";
// 		String member4 = "d";
//         ArrayList<String> members = new ArrayList<>();
//         members.add(member1);
// 		members.add(member2);
// 		members.add(member3);
// 		members.add(member4);
// 		resource.createGroup("ab", members);
// 		resource.createGroup("cd", members);
// 		resource.getGroups();
// 		resource.removeGroup("ab");
// 	}


// 	// @Test
//     // public void test03() throws Exception {
    
       
// 	// 		PlugSim plug = new PlugSim("hello world!!");
// 	// 		//ArrayList<PlugSim> plugs = new ArrayList<>();
// 	// 		//plugs.add(plug);
// 	// 		HubConfig hconfig = new HubConfig(8088, "tacp://127.0.0.1", "iot_sim", "iot_ece448");
// 	// 		hconfig.getMqttTopicPrefix();
// 	// 		hconfig.getMqttBroker();
// 	// 		hconfig.getMqttClientId();
// 	// 		hconfig.getHttpPort();
		
	  
// 	// }

// 	@Test
//     public void test04() throws Exception {
    
//         PlugSim plug1 = new PlugSim("a");
// 		PlugSim plug2 = new PlugSim("b");
//         GroupsModel groups = new GroupsModel();
//         GroupsResource resource = new GroupsResource(groups);
//         ArrayList<PlugSim> plugs = new ArrayList<>();
//         plugs.add(plug1);
//         plugs.add(plug2);
// 		resource.getGroups();
// 		String member1 = "a";
// 		String member2 = "b";
// 		String member3 = "c";
// 		String member4 = "d";
//         ArrayList<String> members = new ArrayList<>();
//         members.add(member1);
// 		members.add(member2);
// 		members.add(member3);
// 		members.add(member4);
// 		resource.createGroup("ab", members);
// 		resource.createGroup("cd", members);
// 		resource.getGroup("ab", null);
// 		resource.getGroup("ab", "on");
// 		resource.removeGroup("ab");
// 	}


// 	// @Test
// 	// public void testCase06() throws Exception{
// 	// 	String[] args = new String[0];
// 	// 	HubConfig hconfig = new HubConfig(8088, "tcp://127.0.0.1", "iot_sim", "iot_ece448");
// 	// 	Main config = new Main(hconfig, args);
// 	// 	config.close();
// 	// 	//config.main(args);

// 	// }
	
// 	@Test
// 	public void testCase07() throws Exception{
// 		// String[] args = new String[]{"a","b","c"};
// 		// HubConfig hconfig = new HubConfig(8088, "tacp://127.0.0.1", "iot_sim", "iot_ece448");
// 		// Main config = new Main(hconfig, args);
// 		// //config.main(args);
// 		// config.close();
	
// 	   PlugsModel plugs = new PlugsModel();
// 	   plugs.getGroups();
// 	   String member1 = "a";
// 	   String member2 = "b";
// 	   ArrayList<String> members = new ArrayList<>();
// 			 members.add(member1);
// 			 members.add(member2);
// 	   plugs.setGroupMembers("ab", members);
// 	   plugs.getGroupMembers("ab");
// 	   plugs.getGroupMembers(null);
// 	   plugs.removeGroup("ab");
	
// 	}
	
// 	@Test
// 	public void testCase08() throws Exception{
		
// 		PlugSim plug1 = new PlugSim("a");
// 			PlugSim plug2 = new PlugSim("b");
// 			GroupsModel groups = new GroupsModel();
// 			PlugsResource resource = new PlugsResource(groups);
// 			ArrayList<PlugSim> plugs = new ArrayList<>();
// 			plugs.add(plug1);
// 			plugs.add(plug2);
// 			String member1 = "a";
// 			String member2 = "b";
// 			ArrayList<String> members = new ArrayList<>();
// 			members.add(member1);
// 			members.add(member2);
// 			resource.createGroup("ab", members);
// 			resource.getGroups();
// 			resource.removeGroup("ab");
// 	}
	
// 	@Test
// 	public void testCase09() throws Exception{
	   
// 		PlugSim plug1 = new PlugSim("a");
// 			PlugSim plug2 = new PlugSim("b");
// 			GroupsModel groups = new GroupsModel();
// 			PlugsResource resource = new PlugsResource(groups);
// 			ArrayList<PlugSim> plugs = new ArrayList<>();
// 			plugs.add(plug1);
// 			plugs.add(plug2);
// 			String member1 = "a";
// 			String member2 = "b";
// 			ArrayList<String> members = new ArrayList<>();
// 			members.add(member1);
// 			members.add(member2);
// 			resource.getGroup("ab", null);
// 			resource.getGroup("aa", "on");
	
// 	}
	
// 	@Test
// 	public void testCase10() throws Exception{
	   
// 		PlugSim plug1 = new PlugSim("a");
// 			PlugSim plug2 = new PlugSim("b");
// 			GroupsModel groups = new GroupsModel();
// 			PlugsResource resource = new PlugsResource(groups);
// 			ArrayList<PlugSim> plugs = new ArrayList<>();
// 			plugs.add(plug1);
// 			plugs.add(plug2);
// 			String member1 = "a";
// 			String member2 = "b";
// 			ArrayList<String> members = new ArrayList<>();
// 			members.add(member1);
// 			members.add(member2);
// 			groups.getGroupMembers("ab");
// 	}

// 	@Test
// public void test05() {
//     HubConfig hconfig = new HubConfig(8088, "tacp://127.0.0.1", "iot_sim", "iot_ece448");
//     hconfig.getMqttTopicPrefix();
//     hconfig.getMqttBroker();
//     hconfig.getMqttClientId();
//     hconfig.getHttpPort();
// }

// }


