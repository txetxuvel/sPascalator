/*
 * Created on 21-jun-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interprete;

import java.util.ArrayList;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ObjetoInstruccion {

	private ArrayList parametros = null;
	private int instruccion;
	
	public ObjetoInstruccion(int instruccion, ArrayList parametros){
		this.parametros = parametros;
		this.instruccion = instruccion;
	}
	
	public ArrayList getParametros(){
		return parametros;
	}
	
	public int getInstruccion(){
		return instruccion;
	}
	
}
