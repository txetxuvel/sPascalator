/*
 * Created on 18-jun-06
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interprete;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ErrorLexicoException extends java.io.IOException {

	public ErrorLexicoException(String descripcion){
		super("Error Léxico: " + descripcion);
	}

}
