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
public class ObjetoTipo extends Objeto {

	private String descripcion = null;
	private int size=0;
	
	public ObjetoTipo(){
		
	}
	
	public ObjetoTipo (String n, String desc){
		super(n);
		descripcion = desc;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	
	public int getSize(){
		return size;
	}

	public void setSize(int size){
		this.size=size;
	}

}
