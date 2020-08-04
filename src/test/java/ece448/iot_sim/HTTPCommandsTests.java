package ece448.iot_sim;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class HTTPCommandsTests {

	@Test
	public void testInit() {
		PlugSim plug = new PlugSim("Hello");
		ArrayList<PlugSim> plugs = new ArrayList<>();
		plugs.add(plug);
		HTTPCommands cmds = new HTTPCommands(plugs);
		HashMap<String,String> params = new HashMap<>();
		cmds.handleGet("/",params);
		assertTrue(cmds.handleGet("/",params).contains("Hello"));
	}
	@Test
	public void testInit00() {
		PlugSim plug = new PlugSim("Hola");
		ArrayList<PlugSim> plugs = new ArrayList<>();
		plugs.add(plug);
		HTTPCommands cmds = new HTTPCommands(plugs);
		HashMap<String,String> params = new HashMap<>();
		System.out.println(cmds.handleGet("/",params));
		assertTrue(cmds.handleGet("/",params).contains("Hola"));
	}

	@Test
	public void testInit1() {
		// PlugSim plug = new PlugSim("a");
		ArrayList<PlugSim> plugs = new ArrayList<>();
		HTTPCommands cmds = new HTTPCommands(plugs);
		HashMap<String,String> params = new HashMap<>();
		assertTrue(cmds.handleGet("/a",params)== null);
	}

	@Test
	public void testInit3() {
		PlugSim plug = new PlugSim("a");
		ArrayList<PlugSim> plugs = new ArrayList<>();
		HTTPCommands cmds = new HTTPCommands(plugs);
		HashMap<String,String> params = new HashMap<>();
		params.get("a");
		cmds.report(plug);
	}

	@Test
	public void testInit4() {
		PlugSim plug = new PlugSim("a");
		ArrayList<PlugSim> plugs = new ArrayList<>();
		HTTPCommands cmds = new HTTPCommands(plugs);
		HashMap<String,String> params = new HashMap<>();
		// plug.switchOn();
		// plug.measurePower();
		params.get("a");
		cmds.report(plug);
	}

	
	@Test
	public void testInit5() {
		PlugSim plug = new PlugSim(null);
		ArrayList<PlugSim> plugs = new ArrayList<>();
		HTTPCommands cmds = new HTTPCommands(plugs);
		HashMap<String,String> params = new HashMap<>();
		params.get(null);
		
		cmds.report(plug);
		
	}

	@Test
	public void testInit6() {
		PlugSim plug = new PlugSim("a");
		ArrayList<PlugSim> plugs = new ArrayList<>();
		HTTPCommands cmds = new HTTPCommands(plugs);
		if(plug.isOn()){
			plug.switchOff();
			cmds.report(plug);
		} else {
		plug.switchOn();
		cmds.report(plug);
		}
		
		cmds.report(plug);
		
	}
	
	@Test
	public void testInit07() {
		PlugSim plug = new PlugSim("a");
		ArrayList<PlugSim> plugs = new ArrayList<>();
		plugs.add(plug);
		plug.switchOff();
		plug.measurePower();
		HTTPCommands cmds = new HTTPCommands(plugs);
		HashMap<String,String> params = new HashMap<>();
		params.get("d");
		cmds.report(plug);
		assertTrue(cmds.handleGet("/a",params).contains("off"));
	}
	@Test
	public void testInit08() {
		PlugSim plug = new PlugSim("a");
		ArrayList<PlugSim> plugs = new ArrayList<>();
		plugs.add(plug);
		plug.toggle();
		plug.toggle();
		plug.measurePower();
		HTTPCommands cmds = new HTTPCommands(plugs);
		HashMap<String,String> params = new HashMap<>();
		params.get("a");
		cmds.report(plug);
		assertTrue(cmds.handleGet("/a",params).contains("toggle"));
	
	}

	@Test
	public void testInit09() {
		PlugSim plug = new PlugSim("a");
		ArrayList<PlugSim> plugs = new ArrayList<>();
		plugs.add(plug);
		plug.switchOn();
		plug.getPower();
		HTTPCommands cmds = new HTTPCommands(plugs);
		HashMap<String,String> params = new HashMap<>();
		params.get("a");
		cmds.report(plug);
		assertTrue(cmds.handleGet("/a",params).contains("on"));
	
	}
	@Test
	public void testInit10() {
		PlugSim plug = new PlugSim("a");
		ArrayList<PlugSim> plugs = new ArrayList<>();
		plugs.add(plug);
		plug.switchOn();
		plug.measurePower();
		HTTPCommands cmds = new HTTPCommands(plugs);
		HashMap<String,String> params = new HashMap<>();
		params.get("a");
		cmds.handleGet("/a",params).contains("toggle");
		plug.switchOff();
		plug.measurePower();
		cmds.handleGet("/a",params).contains("toggle");
	}

}