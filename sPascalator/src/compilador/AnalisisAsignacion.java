/*
 * Created on 31-jul-2005
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
public class AnalisisAsignacion {

	/*private int tipoExp;*/
	private ObjetoTipo tipoExp = null;
	private int tipo;
	
	private AnalisisSelector selector=null;
	private ArrayList param = null;
	
	public final static int ASIGNACION = 0;
	public final static int LLAMADA = 1;
	
	public AnalisisAsignacion(int tipo, AnalisisSelector selector, ObjetoTipo tipoExp){
		this.selector = selector;
		this.tipoExp = tipoExp;
		this.tipo = tipo;
	}
/*	public AnalisisAsignacion(int tipo, AnalisisSelector selector, int tipoExp){
		this.selector = selector;
		this.tipoExp = tipoExp;
		this.tipo = tipo;
	}*/
	
	public AnalisisAsignacion(int tipo, ArrayList param){
		this.tipo = LLAMADA;
		this.param = param;
	}

	public int getTipo(){
		return tipo;
	}
	
	public ArrayList getParametros(){
		return param;
	}
	
	public ObjetoTipo getTipoExp(){
		return tipoExp;
	}
/*	public int getTipoExp(){
		return tipoExp;
	}*/
	
	public AnalisisSelector getSelector(){
		return selector;
	}
	
}
