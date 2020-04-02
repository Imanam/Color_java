package mamai.color;

import manami.color.model.Color;

public class Main {

	public static void main(String[] args) {
		// Color color = new Color(220, 20, 60);
		// Color color = new Color(218, 112, 214);
		// Color color = new Color(0, 0, 0);

		Color color = new Color(213, 100, 53);
		System.out.println(color);
		color.setGreen(215);
		System.out.println(color);
		color.setHexValue("#ffffAA");
		System.out.println(color);

		// TODO Auto-generated method stub
		Color color1 = new Color(255, 255, 255);
		System.out.println(color1);
		color1.setBlue(100);
		System.out.println(color1);
		
		Color color2 = new Color("#AAAAAA");
		System.out.println(color2);
		color2.setHexValue("#FFFFAA");
		System.out.println(color2);
		

	}

}