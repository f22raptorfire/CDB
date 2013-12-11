package wci.runtime;

public class Referencer {

	private Object value;
	
	public static void main(String[] args) {
		Referencer ref = new Referencer("Test");
		System.out.println((String) null);
	}
	
	public Referencer(String val) {
		value = val;
	}
	public Referencer(int val) {
		value = new Integer(val);
	}
	
	public void setValue(String val) {
		value = val;
	}
	public void setValue(int val) {
		value = new Integer(val);
	}
	
	public String getStringValue() {
		return (String) value;
	}
	public int getIntegerValue() {
		return (Integer) value;
	}
}