package lights;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
public class MyHolidyLightTest {
	
	@Test public void testNext() {
		MyHolidayLights myLight = new MyHolidayLights(10);
		List<Light> lights = myLight.next();
		
		for(int i=0;i<lights.size();i++) {
			if(myLight.turn == i) 
				Assert.assertTrue(lights.get(i).isOn());
			else
				Assert.assertFalse(lights.get(i).isOn());
		}
	}
	@Test public void testNext2() {
		MyHolidayLights myLight = new MyHolidayLights(10);
		List<Light> lights = myLight.nextLvl2();
		
		for(int i=0;i<lights.size();i++) { 
			Assert.assertTrue(lights.get(i).isOn());
		}
	}
}
