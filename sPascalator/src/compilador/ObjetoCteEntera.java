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
public class ObjetoCteEntera extends ObjetoCte{

	private int valor;
	
	public ObjetoCteEntera(String nombre, int v){
		super(nombre);
		valor = v;
	}
	
	public int getValor (){
		return valor;
	}
	
}
