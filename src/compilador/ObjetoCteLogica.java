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
public class ObjetoCteLogica extends ObjetoCte{
	
	private boolean valor;
	
	public ObjetoCteLogica(String nombre, boolean valor){
		super(nombre);
		this.valor = valor;
	}

	public boolean getValor(){
		return valor;
	}
}
