package lights;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
public class RunningHolidayLightsTest {
	
	@Test public void makeRunHoliLights(){
		RunningHolidayLights rhLight = new RunningHolidayLights(10);
		Assert.assertNotNull(rhLight);
	}
	
	@Test public void TestNext(){
		RunningHolidayLights rhLight = new RunningHolidayLights(10);
		
		List<Light> lights = rhLight.next();
		for(int i=0;i<lights.size();i++) {
			if(rhLight.turn == i) 
				Assert.assertTrue(lights.get(i).isOn());
			else
				Assert.assertFalse(lights.get(i).isOn());
		}
	}
	@Test public void TestGetLength(){
		RunningHolidayLights light = new RunningHolidayLights(3);
		
		Assert.assertEquals(light.getLength(), 3);
	}
}
