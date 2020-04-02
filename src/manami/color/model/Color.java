package manami.color.model;

import java.util.ArrayList;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Color {

	private int red = 0;
	private int green = 0;
	private int blue = 0;
	private String hex;
	private String[] hexArray;
	private static final String HEX_PATTERN = "^#([A-Fa-f0-9]{6})$";
	private char[] tabChar;

	public Color(int red, int green, int blue) {
		hexArray = new String[3];
		setRed(red);
		setGreen(green);
		setBlue(blue);
		//this.hex = convertRgbToHex(this.red, this.green, this.blue);
	}

	private void createHexArray(String hexString) {
		hexArray[0] = hex.substring( 1, 3 );
		hexArray[1] = hex.substring( 3, 5 );
		hexArray[2] = hex.substring( 5, 7 );
	}
	
	public Color(String paramHex) {
		hexArray = new String[3];
		setHexValue(paramHex);
	}
	
	private static String decimalToHexdecimal(int decimal) {
		return String.format("%02x", decimal);
	}
	

	
	public int getRed() {
		return this.red;
	}

	public void setRed(int red) {
		this.red = checkRgbValue(red);
		String valueHexRed = decimalToHexdecimal(this.red);
		hexArray[0] = valueHexRed;
	}

	public int getGreen() {
		return this.green;
	}

	public void setGreen(int green) {
		this.green = checkRgbValue(green);
		String valueHexGreen = decimalToHexdecimal(this.green);
		hexArray[1] = valueHexGreen;		
	}

	public int getBlue() {
		return this.blue;
	}

	public void setBlue(int blue) {
		this.blue = checkRgbValue(blue);
		String valueHexBlue = decimalToHexdecimal(this.blue);
		hexArray[2] = valueHexBlue;
	}
	
	public String getHexValue() {
		return "#" + String.join("", hexArray);
	}

	public void setHexValue(String hex) {
		this.hex = checkHexValue(hex);
		createHexArray(this.hex);
		updateRGB();
	}
	
	private void updateRGB() {
		red = Integer.valueOf( hexArray[0], 16 );
		green = Integer.valueOf( hexArray[1], 16 );
		blue = Integer.valueOf( hexArray[2], 16 );		
	}
		
	
	private String checkHexValue(String hex) {
		if (hex == null) {
			throw new IllegalArgumentException("Input value is null");
		} else if (7 != hex.length()) {
			throw new IllegalArgumentException("Hex must be 7 caracters.");
		} else if (!hex.startsWith("#")) {
			throw new IllegalArgumentException("Hex must be started with #.");
		} else {
			  Pattern pattern = Pattern.compile(HEX_PATTERN);

		        Matcher matcher = pattern.matcher(hex);
		      
		      if (!matcher.matches()) {
					throw new IllegalArgumentException("Something wrong with your hex value.");
				}
		}
		return hex;
	}

	private int checkRgbValue(int value) {
		if (value < 0 || 255 < value) {
			throw new IllegalArgumentException("Rgb value must be between 0 to 255.");
		} else {
			return value;
		}
	}
	
	private static String convertRgbToHex(int red, int green, int blue) {
		//System.out.println(String.format("#%02x%02x%02x", red, green, blue));
		return String.format("#%02x%02x%02x", red, green, blue);  
	}
	
	@Override
	public String toString() {
		return "[value=" + getHexValue() + ", r=" + getRed() + ", g=" + getGreen() + ", b=" + getBlue() + "]";
	}

	 

	  
}
