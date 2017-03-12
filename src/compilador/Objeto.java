/*
 * Created on 30-may-2005
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
public class Objeto {

	private String nombre = null;
	
	public Objeto(){
		
	}
	
	public Objeto(String n){
		nombre = n;
	}
	
	/**
	 * @return Returns the nombre.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param nombre The nombre to set.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
