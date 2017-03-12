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
public class ObjetoCteLiteral extends ObjetoCte {

	String valor = null;
	int numEtiqueta;
	
	public ObjetoCteLiteral(String nombre, String valor, int numEtiqueta){
		super(nombre);
		this.valor = valor;
		this.numEtiqueta = numEtiqueta;
	}
	
	public String getValor(){
		return valor;
	}
	
	public int getNumEtiqueta(){
		return numEtiqueta;
	}
}
