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
public class ObjetoCampo extends ObjetoVariable {

	public ObjetoCampo(String nombre, ObjetoTipo tipo,int direccionRelativa,NivelTablaSimbolos activo){
		super(nombre, tipo,direccionRelativa,activo);
	}

	public ObjetoTipoRegistro getRegistro(){
		return (ObjetoTipoRegistro) this.getTipo();
	}

}
