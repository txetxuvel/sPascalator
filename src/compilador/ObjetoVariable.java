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
public class ObjetoVariable extends Objeto{
	
	private ObjetoTipo tipo = null;
	private NivelTablaSimbolos nivel= null;
	private int direccion;
//	private int signo;
	
	public ObjetoVariable(String nombre, ObjetoTipo tipo,int direccion,NivelTablaSimbolos activo){
		super(nombre);
		this.tipo=tipo;
		this.direccion=direccion;
		this.nivel=activo;
	}

	public void setTipo(ObjetoTipo t){
		tipo = t;
	}
	
	public ObjetoTipo getTipo(){
		return tipo;
	}
	
	public int getDireccion(){
		return direccion;
	}
	
	public void setDireccion(int direccion){
		this.direccion=direccion;
	}

	public NivelTablaSimbolos getNivel(){
		return nivel;
	}
	
	public void setNivel(NivelTablaSimbolos nivel){
		this.nivel=nivel;
	}
}
