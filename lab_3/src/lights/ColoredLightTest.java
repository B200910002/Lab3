package lights;

import org.junit.Assert;
import org.junit.Test;
import java.awt.Color;

public class ColoredLightTest {

	@Test public void makeColoredLight() {
		Color c = Color.red;
		ColoredLight cLight = new ColoredLight(c);
		
//		Assert.assertTrue(!(cLight.getColor() == null));
		Assert.assertNotNull(cLight.getColor());
	}
	@Test public void getColoredLight() {
		Color c = Color.red;
		ColoredLight cLight = new ColoredLight(c);
		
		Color rC = cLight.getColor();
//		Assert.assertTrue(!(cLight.getColor()==null));
//		Assert.assertSame(c, cLight.getColor());
		Assert.assertEquals(c, cLight.getColor());
	}
	@Test public void setColoredLight() {
		Color oldColor = Color.red;
		ColoredLight cLight = new ColoredLight(oldColor);
		Color newColor = Color.gray;
		cLight.setColor(newColor);
		
//		Assert.assertTrue( cLight.getColor() != oldColor);
//		Assert.assertNotEquals(cLight.getColor(), oldColor);
		Assert.assertNotSame(cLight.getColor(), oldColor);
	}
	@Test public void testRandomChange() {
		Color c = Color.white;
		ColoredLight cLight = new ColoredLight(c);
		
		//ulaan ungiig randomoor gargaj irhiig shalgah
		boolean lightChanged = false;
		for (int i = 0; i < 100; i++) {
			cLight.randomChange();
			if (cLight.getColor() == Color.red) {
				lightChanged = true;
				break;
			}
		}
		Assert.assertTrue(lightChanged);
		
		//ulaan ungiig randomoor gargaj irhiig shalgah
		cLight = new ColoredLight(c);
		lightChanged = false;
		for (int i = 0; i < 100; i++) {
			cLight.randomChange();
			if (cLight.getColor() == Color.green) {
				lightChanged = true;
				break;
			}
		}
		Assert.assertTrue(lightChanged);
		
		//ulaan ungiig randomoor gargaj irhiig shalgah
		cLight = new ColoredLight(c);
		lightChanged = false;
		for (int i = 0; i < 100; i++) {
			cLight.randomChange();
			if (cLight.getColor() == Color.blue) {
				lightChanged = true;
				break;
			}
		}
		Assert.assertTrue(lightChanged);	
	}
}
