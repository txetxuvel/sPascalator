/*
 * Created on 03-jun-2005
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
public class ObjetoTipoEnumerado extends ObjetoTipo {

	ArrayList etiquetas = null;
	
	public ObjetoTipoEnumerado(String nombre, String descripcion){
/* Podría ser interesante pasar un parámetro con el número de 
 * etiquetas del tipo y crear el array con su tamaño final
 */
		super(nombre, descripcion);
		etiquetas = new ArrayList();
	}
	
	public ObjetoTipoEnumerado (ArrayList etq){
		etiquetas = etq;
	}
	
	public int getValor(String etiqueta){
		return etiquetas.indexOf(etiqueta) + 1; // + 1 porque Pascal empieza en 1 y java en 0
	}
	
	public int getTamanio(){
		return etiquetas.size();
	}
}
