/*
 * Created on 06-jun-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package compilador;

import java.util.ArrayList;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ObjetoProc extends ObjetoPrograma {
	
	private ArrayList parametros = null; 
	private int nivAnidamiento;
	
	public ObjetoProc(String nombre, int etq, int nivAnidamiento){
		super(nombre, etq);
		this.nivAnidamiento = nivAnidamiento;
	}
	
	public int getTamanioLocal(){
		return 0;
	}
	
	public void setNivAnidamiento(int nivAnidamiento){
		this.nivAnidamiento = nivAnidamiento;
	}

	public int getNivAnidamiento(){
		return nivAnidamiento;
	}
	
	public ArrayList getParametros(){
		return parametros;
	}

	public void setParametros(ArrayList parametros){
		this.parametros = parametros;
	}

}
