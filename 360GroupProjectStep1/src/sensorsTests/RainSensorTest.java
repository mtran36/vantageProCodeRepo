/**	
 * 
 */
package sensorsTests;

import static org.junit.jupiter.api.Assertions.*;	

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.Controller;
import controller.DataPacket;
import sensors.RainSensor;

/**
 * @author greghab
 *
 */
class RainSensorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//Controller con = new Controller();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}
	@Test
	void testGeneratedValues() {
		Double[] rainGeneratedValues = {0.43, 0.44 ,0.48};

		//ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		RainSensor rain = new RainSensor();
		rain.run();
		rain.run();
		rain.run();
		
		int i = 0;
		for (DataPacket<Double> dp : Controller.RAINFALL_SET) {
			if (Double.compare(dp.getValue(), rainGeneratedValues[i]) != 0) {
				fail("values dont match");
			}
			i++;
		}
	}
}
