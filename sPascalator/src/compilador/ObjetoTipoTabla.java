/*
 * Created on 31-may-2005
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
public class ObjetoTipoTabla extends ObjetoTipo {

	private int inicio, fin;
	
	private ObjetoTipoPredefinido tipo;
	
	public ObjetoTipoTabla(String nombre, String descripcion){
		super(nombre, descripcion);
	}

	public ObjetoTipoTabla(int inicio, int fin, ObjetoTipoPredefinido tipo){
		this.inicio = inicio;
		this.fin = fin;
		this.tipo = tipo;
		this.setSize((fin-inicio+1)*tipo.getSize());
	}
	
	public boolean enRango(int valor){
		return (valor <=fin && valor >= inicio);
	}
	
	public ObjetoTipoPredefinido getTipo(){
		return tipo;
	}
	
	public int getInicio(){
		return inicio;
	}
	
	public int getFin(){
		return fin;
	}
	

}
