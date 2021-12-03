package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Marcador1 extends GImage{

	public Marcador1(String name, double x, double y) {
		super(name, x, y);
		texto.setLabel("0");
		texto.setColor(Color.BLACK);
		texto.setFont(new Font("Jokerman", Font.BOLD, 50));
		// TODO Auto-generated constructor stub
	}

	GLabel texto = new GLabel("");
	int puntuacion = 0;

    //suma el nº de puntos que se indica en la variable puntos 
	//a la puntuacion actual
	public void incrementaMarcador(int puntos){
		puntuacion = puntuacion + puntos; // puntuacion += puntos;
		texto.setLabel("" + puntuacion);
	}

	public void addMarcador(Arkanoid arkanoid){
		arkanoid.add(this, arkanoid.getWidth() - 310, 0);
		arkanoid.add(texto, arkanoid.getWidth() -75, 70);
	}
}