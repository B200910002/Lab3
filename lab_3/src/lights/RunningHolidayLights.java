package lights;

import java.util.ArrayList;
import java.util.List;

public class RunningHolidayLights implements HolidayLights {
	
	protected ArrayList<Light> lights;
	protected int length;
	public int turn = -1;
	
	/**
	 * Creates new running holiday lights.
	 * @param length - length of this set of lights.
	 */
	public RunningHolidayLights(int length) {
		// TODO
//		throw new RuntimeException("RunningHolidayLights(length) not yet implemented!");
		this.length = length;
	}
	
	public List<Light> next() {
		// TODO
//		throw new RuntimeException("RunningHolidayLights.next() not yet implemented!");
		lights = new ArrayList<Light>();	
		for(int i=0;i<this.length;i++) {
			Light light = new Light();
			lights.add(light);
		}
		lights.get(++turn).setOn(true);
		if(turn >= this.length-1)
			turn = -1;
		return lights;
	}
	
	/**
	 * Returns the length of this
	 * @return length of this
	 */
	public int getLength() {
		// TODO
//		throw new RuntimeException("RunningHolidayLights.getLength() not yet implemented!");
		return length;
	}

	@Override
	public List<Light> nextLvl2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Light> nextLvl3() {
		// TODO Auto-generated method stub
		return null;
	}
						
}