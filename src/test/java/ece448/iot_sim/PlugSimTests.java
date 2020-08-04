// package ece448.iot_sim;

// import static org.junit.Assert.*;

// import org.junit.Test;




// public class PlugSimTests {

// 	@Test
// 	public void testInit() {
// 		PlugSim plug = new PlugSim("a");

// 		assertFalse(plug.isOn());
// 	}

// 	@Test
// 	public void testSwitchOn() {
// 		PlugSim plug = new PlugSim("a");

// 		plug.switchOn();

// 		assertTrue(plug.isOn());
// 	}

// 	@Test
// 	public void testSwitchOff() {
// 		PlugSim plug = new PlugSim("a");

// 		plug.switchOff();

// 		assertFalse(plug.isOn());
// 	}

// 	@Test
// 	public void testSwitchToggle() {
// 		PlugSim plug = new PlugSim("a");
// 		plug.toggle();
// 		plug.toggle();
// 		assertTrue(!plug.isOn());
// 	}

// 	@Test
// 	public void testMeasurePower() {
// 		PlugSim plug = new PlugSim("a");
// 		plug.switchOff();
// 		plug.toggle();
// 		plug.measurePower();
// 		assertTrue(plug.getPower() > 0)	;
// 	}

// 	@Test
// 	public void testMeasurePower1() {
// 		PlugSim plug = new PlugSim("a.101");
// 		plug.switchOn();
// 		plug.measurePower();
// 		assertTrue(plug.getPower() >  0);
// 	}

// 	@Test
// 	public void testMeasurePowerZero() {
// 		PlugSim plug = new PlugSim("a.2");
// 		plug.switchOff();
// 		plug.measurePower();
// 		assertTrue(plug.getPower() == 0);
// 	}

// 	// @Test
// 	// public void testMeasurePower300() {
// 	// 	PlugSim plug = new PlugSim("a.301");
// 	// 	plug.switchOn();
// 	// 	plug.measurePower();
// 	// 	//assertTrue(plug.getPower() < 300);

// 	// }

// 	@Test
// 	public void testGetPower() {
// 		PlugSim plug = new PlugSim("a");
		
// 		plug.getPower();
// 	}

// 	@Test
// 	public void testGetName() {
// 		PlugSim plug = new PlugSim("a");
// 		plug.getName(); 
// 	}

// 	@Test
// 	public void testOnMeasureUpdate() {
// 		PlugSim plug = new PlugSim("a");
// 		plug.switchOn();
// 		plug.measurePower();
// 		plug.switchOff();
// 	}

	
// 	@Test
// 	public void testOnMeasureUpdate2() {
// 		PlugSim plug = new PlugSim("a");
// 		plug.switchOn();
// 		plug.toggle();
// 		plug.toggle();
// 		plug.measurePower();
// 	}

	
// }