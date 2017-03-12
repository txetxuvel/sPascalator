/*
 * Created on 03-jun-2005
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
public class ObjetoPrograma extends Objeto {

	int numSubpr;
	
	public ObjetoPrograma(String nombre, int numSubpr){
		super(nombre);
		this.numSubpr=numSubpr;
	}
	
	public void setNumSubpr(int numSubpr){
		this.numSubpr=numSubpr;
	}
	
	public int getNumSubpr(){
		return numSubpr;
	}
}
