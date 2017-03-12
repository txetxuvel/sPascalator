/*
 * Created on 30-may-2005
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
public class ObjetoParametro extends ObjetoVariable{

	private boolean referencia = false;
	private Objeto subprograma = null;
	
	public ObjetoParametro(String nombre, ObjetoTipo tipo, int direccion, boolean ref, NivelTablaSimbolos activo){
		super(nombre, tipo, direccion, activo);
		referencia = ref;
	}

	public boolean isReferencia(){
		return referencia;
	}
}
