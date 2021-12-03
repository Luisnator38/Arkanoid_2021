package codigo;

import java.awt.Color;

import acm.graphics.GImage;
import acm.graphics.GRect;

public class Cursor1 extends GImage{



	public Cursor1(String name, double x, double y) {
		super(name, x, y);
		// TODO Auto-generated constructor stub
	}

	public void muevete(int anchoPantalla, int posX){
		if (posX + getWidth() < anchoPantalla){
			setLocation(posX, getY());
		}
	}

}