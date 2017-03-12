/*
 * Created on 03-jun-2005
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
public class ObjetoEtiquetaEnumerado extends ObjetoCteEntera {

	private ObjetoTipoEnumerado tipo = null;
	
	public ObjetoEtiquetaEnumerado(String nombre, ObjetoTipoEnumerado t, int valor){
		super(nombre, valor);
		tipo = t;
	}
	
/*	public int getValor(){
		return tipo.getValor(this.getNombre());
	} */
	
	public ObjetoTipoEnumerado getTipo(){
		return tipo;
	}

}
