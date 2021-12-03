package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Arkanoid extends GraphicsProgram {

	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 15;
	static final int ANCHO_PANTALLA = 520;


	/*
	 * Aqui modifico la bola y le añado una imagen npg 
	 * para que sea un portal de rick y morty
	 */
	Bola5 bola1 = new Bola5("imagenes/portalBola01.png", 10, 10);
	//meto una imagen de un pepinillo para que sea el nuevo cursor
	Cursor1 miCursor = new Cursor1("imagenes/pepinilloBarra1.png", 0, 400);
	//He metido un gif de rick pepinillo para darle movimiento al fondo
	GImage fondo = new GImage("imagenes/fondoPepinillo2.gif");

	GRect fondoMarcador1 = new GRect(300, 500);
	//He metido una foto para sustituir el rectangulo negro que ya estaba con el GRect
	Marcador1 miMarcador = new Marcador1("imagenes/marcadorverde.jpg", 20, 40);
	//esta es la foto de la pantalla de inicio
	GImage pantallaInicio = new GImage("imagenes/pantallaPrincipal4.jpg");
	//cuando pierdes sale esta foto
	GImage lose = new GImage("imagenes/lose1.gif");
	//cuando ganas sale esta foto
	GImage win = new GImage("imagenes/win23.gif");


	public void init(){
		fondoMarcador1.setFilled(true);
		add(fondoMarcador1, ANCHO_PANTALLA- 20,0);
		add(fondo);
		addMouseListeners();
		add(bola1, 400, 150);
		add(miCursor);
		setSize(ANCHO_PANTALLA + 300 ,500);
	}

	public void run(){
		//agregamos la pantalla de inicio la cual necesita que le des un click para pasar al Arkanoid
		add(pantallaInicio);
		pantallaInicio.setBounds(0,0,810,430);
		waitForClick();
		//Cuando se le da el click, se quita la pantalla de incicio y aparece el juego
		remove(pantallaInicio);
		init();
		creaPiramide();
		miMarcador.addMarcador(this);
		while (true){
			bola1.muevete(this); //paso el objeto arkanoid que se está ejecutando
			pause(2);
			miCursor.muevete(ANCHO_PANTALLA - 30, (int) bola1.getX());
			if(miMarcador.puntuacion == 91){
				removeAll();
				add (win);
				win.setBounds(0,0,810,440);
				waitForClick();
			}
			else if(bola1.getY() -40 > miCursor.getY()){
				removeAll();
				add(lose);
				lose.setBounds(0,0,810,440);
				waitForClick();
			}
		}
	}

	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(ANCHO_PANTALLA - 30, evento.getX());
	}



	private void creaPiramide(){
		int numeroLadrillos = 13;
		int desplazamiento_inicial_X = 20;
		int desplazamiento_inicial_Y = 15;

		for (int j=0; j<numeroLadrillos; j++){
			for (int i=j; i<numeroLadrillos; i++){
				Ladrillo miLadrillo = new Ladrillo(
						ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j + desplazamiento_inicial_X, //pos X
						ALTO_LADRILLO*j + desplazamiento_inicial_Y,  //pos Y
						ANCHO_LADRILLO, //ancho
						ALTO_LADRILLO, // alto
						Color.BLUE);
				add(miLadrillo);
			}
		}
	}


}