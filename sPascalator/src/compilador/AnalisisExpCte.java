/*
 * Created on 09-jun-2005
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
public class AnalisisExpCte {
	
//	private ObjetoTipo tipo = null;
	private String valor = null;
	private int tipoValor;
	
	public static final int ENTERA = 0;
	public static final int REAL = 1;
	public static final int LITERAL = 2;
	public static final int LOGICA = 3;

	public AnalisisExpCte(int tipoValor, String valor){
		this.tipoValor=tipoValor;
		this.valor=valor;
	}
	
	public int getTipoValor(){
		return tipoValor;
	}

	public void setTipoValor(int t){
		tipoValor = t;
	}

	public String getValor(){
		return valor;
	}

	public void setValor(String cadena){
		valor = cadena;
	}
}
