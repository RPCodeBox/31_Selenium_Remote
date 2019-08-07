package Utilities;

//Construct for ConfiFile
class ConfigFile {
	String Field;
	String Value;

	public ConfigFile(String Field, String Value) {
		this.Field = Field;
		this.Value = Value;
	}

	public String getField() {
		return Field;
	}

	public void setField(String Field) {
		this.Field = Field;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String Value) {
		this.Value = Value;
	}

	@Override
	public String toString() {
		return "\nField= " + getField() + "::Value= " + getValue();
	}
}
