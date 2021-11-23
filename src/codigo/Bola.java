package codigo;

import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Bola extends GOval{

	int dx = 1;//vel eje x
	int dy = 1;//vel eje y


	public Bola(double width, double height){
		super(width, height);
	}


	public Bola(double width, double height, Color c){
		super(width, height);
		this.setFillColor(c);
		this.setFilled(true);
	}

	public void muevete(Arkanoid ark){
		if (getY() > ark.getHeight() - getWidth() || getY() < 0){
			dy = dy * -1;
		}

		if (getX() > ark.getWidth() - getHeight() || getX() < 0){
			dx = dx * -1;
		}
		//chequeo la esquina superior izquierda de la bola
		if(chequeaColision(getX(), getY(), ark)){
			if(chequeaColision(getX() + getWidth(), getY(), ark)){
				if(chequeaColision(getX(), getY() + getHeight(), ark)){
					if(chequeaColision(getX() + getWidth(), getY() + getHeight(), ark)){

					}
				}
			}
		}

		//mueve la bola en la direccion correcta
		this.move(dx,dy);
	}
	private boolean chequeaColision(double posx, double posy, Arkanoid ark){
		boolean noHaChocado = true;

		GObject auxiliar;

		auxiliar = ark.getElementAt(posx, posy);

		if(auxiliar == ark.miCursor){//si entra aqui es que choca el cursor 
			dy = dy * -1;
			noHaChocado = false;
		}else if (auxiliar == null){ // si vale null es que no habia nada ahi

		}else if (auxiliar instanceof Ladrillo){//si es un ladrillo
			if(auxiliar.getY() + getHeight() == posy || auxiliar.getY() == posy){
				dy = dy * -1;
			}else if(auxiliar.getX() + getWidth() == posx || auxiliar.getX() == posx){
				dx = dx * -1;
			}
			ark.remove(auxiliar);
			
			
			noHaChocado = false;

		}

		return noHaChocado;
	}

}
