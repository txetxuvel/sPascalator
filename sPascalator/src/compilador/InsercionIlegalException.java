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
public class InsercionIlegalException extends Exception{

	public InsercionIlegalException(){
		super("No se puede insertar ese tipo de objeto en el nivel actual");
	}
}
