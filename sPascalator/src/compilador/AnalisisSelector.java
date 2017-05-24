/*
 * Created on 20-jun-2005
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
public class AnalisisSelector {
	
	private int tipo;
	private String selector;
	
	public final static int ARRAY = 0;
	public final static int RECORD = 1;
	
	public AnalisisSelector(int tipo, String selector){
		this.selector = selector;
		this.tipo = tipo;
	}

	public AnalisisSelector(int tipo){
		this.tipo = tipo;
	}

	public String getSelector(){
		return selector;
	}
	
	public int getTipo(){
		return tipo;
	}
}
