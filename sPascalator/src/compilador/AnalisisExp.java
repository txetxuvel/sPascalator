/*
 * Created on 17-jun-2005
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
public class AnalisisExp {

	
	private boolean esVariable;
	private ObjetoTipo tipo=null;

	private ArrayList colaInstrucciones = null;
	private String separador = System.getProperty("line.separator");
	
	public static final int ENTERA = 0;
	public static final int REAL = 1;
	public static final int LITERAL = 2;
	public static final int LOGICA = 3;
	public static final int NOPRIMITVO = 4;

	public AnalisisExp(ObjetoTipo tipo, boolean esVariable){
		this.esVariable = esVariable;
		this.tipo = tipo;
	}

	public void encolaInstruccion(ArrayList instruccion){
		ArrayList tmp = new ArrayList(2);
		tmp.add(instruccion.get(0));
		tmp.add(instruccion.get(1));
		if (colaInstrucciones == null)
			colaInstrucciones = new ArrayList();
		colaInstrucciones.add(tmp);
	}
	public void anyadeCola(ArrayList cola){
		if (colaInstrucciones == null)
			colaInstrucciones = cola;
		else
			for(int i=0;i<cola.size();colaInstrucciones.add(cola.get(i)),i++);
	}

	public ArrayList getCola(){
		return colaInstrucciones;
	}

	public ObjetoTipo getTipo(){
		return tipo;
	}

	public void setTipo(ObjetoTipo tipo){
		this.tipo = tipo;
	}
	
	public void setEsVariable(boolean esVariable){
		this.esVariable=esVariable;
	}
	
	public boolean getEsVariable(){
		return esVariable;
	}

}
