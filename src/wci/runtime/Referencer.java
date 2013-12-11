package wci.runtime;

public class Referencer {

	private Object value;
	
	public Referencer(String val) {
		value = val;
	}
	public Referencer(int val) {
		value = new Integer(val);
	}
	
	public Referencer(float val) {
		val = new Float(val);
	}
	
	public void setValue(String val) {
		value = val;
	}
	public void setValue(int val) {
		value = new Integer(val);
	}
	
	public void setValue(float val) {
		value = new Float(val);
	}
	
	public float getFloatValue() {
		return (Float) value;
	}
	
	public String getStringValue() {
		return (String) value;
	}
	public int getIntegerValue() {
		return (Integer) value;
	}
}