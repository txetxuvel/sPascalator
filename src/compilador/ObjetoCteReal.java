/*
 * Created on 31-may-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package compilador;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ObjetoCteReal extends ObjetoCte{

	private float valor;
	
	public ObjetoCteReal (String nombre, float v){
		super(nombre);
		valor = v;
	}
	
	public float getValor(){
		return valor;
	}
}
