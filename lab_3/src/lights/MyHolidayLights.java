package lights;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class MyHolidayLights implements HolidayLights{

	protected ArrayList<Light> lights;
	protected int length;
	public int turn = -1;
	
	public MyHolidayLights(int length) {
		this.length = length;
	}
	
	@Override
	public List<Light> next() {
		lights = new ArrayList<Light>();
		Color c = Color.black;
		for(int i=0;i<this.length;i++) {
			Light light = new ColoredLight(c);
			light.setOn(false);
			lights.add(light);
		}
		lights.get(++turn).setOn(true);
		lights.get(turn).randomChange();
		if(turn >= this.length-1)
			turn = -1;
		return lights;
	}
	
	public List<Light> nextLvl2() {
		lights = new ArrayList<Light>();
		Color c = Color.black;
		for(int i=0;i<this.length;i++) {
			Light light = new ColoredLight(c);
			light.randomChange();
			lights.add(light);
		}
		return lights;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHolidayLights hl = new MyHolidayLights(32);
		
		// Create and show HolidayLightsWindow
		MyHolidayLightsWindow frame = new MyHolidayLightsWindow(hl);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public List<Light> nextLvl3() {
		// TODO Auto-generated method stub
		return null;
	}

}
