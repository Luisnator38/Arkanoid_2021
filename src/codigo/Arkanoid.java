package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GRect;
import acm.graphics.GRoundRect;
import acm.program.GraphicsProgram;


public class Arkanoid extends GraphicsProgram {

	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 15;


	Bola bola1 = new Bola(10,10, Color.BLUE);

	//declaro el cursor
	Cursor miCursor = new Cursor(0, 400, 60, 10, Color.BLUE);

	public void init(){
		addMouseListeners();
		add(bola1, 50, 100);
		add(miCursor);
	}


	public void run(){
		crearPiramide();
		while(true){
			bola1.muevete(this);
			pause (1);
			miCursor.muevete(getWidth(), (int)bola1.getX());
			
			
		}
	}



	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(getWidth(), evento.getX());
	}


	private void crearPiramide(){
		int numeroLadrillos = 14;

		for(int j = 0; j < numeroLadrillos; j++){
			for(int i = j; i < numeroLadrillos; i++){
				Ladrillo miLadrillo = new Ladrillo(
						ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j, //pos X
						ALTO_LADRILLO*j, //pos Y
						ANCHO_LADRILLO, //ancho
						ALTO_LADRILLO, //qlto
						Color.BLUE);

				add(miLadrillo);



			}

		}
	}


}