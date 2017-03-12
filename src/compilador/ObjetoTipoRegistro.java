/*
 * Created on 31-may-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package compilador;

import java.util.HashMap;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ObjetoTipoRegistro extends ObjetoTipo {

	private HashMap hash = null;
	
	public ObjetoTipoRegistro(String nombre, String descripcion){
		super(nombre, descripcion);
		hash = new HashMap(); 
	}
	
	public ObjetoTipoRegistro(){
		hash = new HashMap(); 
	}
	
	public void insertaCampo(ObjetoCampo campo){
		hash.put(campo.getNombre(),campo);
		this.setSize(this.getSize()+((ObjetoTipoPredefinido)campo.getTipo()).getSize());
//		this.setSize(this.getSize()+((ObjetoTipo)campo.getTipo()).getSize()); // Esto vale cuando se permitan campos de tipos no predefinidos
	}
	
	public ObjetoCampo getCampo(String id){
		return (ObjetoCampo) hash.get(id);
	}
	
}
