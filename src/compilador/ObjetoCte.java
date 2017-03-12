/*
 * Created on 06-jun-2005
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
public class ObjetoCte extends Objeto {

	public static final int ENTERA = 0;
	public static final int LOGICA = 1;
	public static final int LITERAL = 2;
	public static final int REAL = 3;
	
	public ObjetoCte(String nombre){
		super(nombre);
	}
	
}
