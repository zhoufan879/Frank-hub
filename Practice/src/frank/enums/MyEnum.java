package frank.enums;

public enum MyEnum {
	USER,
	PWD;
	
	public final String getCommand(){
		return this.name();
	}
}
