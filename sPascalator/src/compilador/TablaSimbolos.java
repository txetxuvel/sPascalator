/*
 * Created on 30-may-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package compilador;

import java.util.Stack;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TablaSimbolos {
	
	NivelTablaSimbolos global = null;
	NivelTablaSimbolos activo = null;
	
	int tamEspacio = 0;

	public final static int REGISTRO = 0 ;
	public final static int PARAMETROS = 1 ;
	public final static int VARIABLES = 2 ;
	
	public static final int ENTERA = 0;
	public static final int REAL = 1;
	public static final int LITERAL = 2;
	public static final int LOGICA = 3;
	public static final int NOPRIMITVO = 4;
	

	private static final int NIVPREDEFINIDO = 0;
	
	int numSubpr = 0;
	int numCondicional = 0;
	int numCadena = 0;
	
	int nivAnidamiento = 0;
	
	private Stack subprogramas = null;
	private Stack condicionales = null;
	private Stack incondicionales = null;
	
	private ObjetoPrograma programa = null;
	
	public TablaSimbolos(){
		/* global = new NivelTablaSimbolos(null, NIVPREDEFINIDO);
		activo = global; */
		subprogramas = new Stack();
		condicionales = new Stack();
		incondicionales = new Stack();
	}
	
	public void setNivAnidamiento(int valor){
		this.nivAnidamiento=valor;
	}

	public int getNivAnidamiento(){
		return nivAnidamiento;
	}
	
	public void setTamEspacio(int valor){
		activo.setTamEspacio(valor);
	}

	public int getTamEspacio(){
		return activo.getTamEspacio();
	}
	
	public void setTamEspacioLocal(int valor){
		activo.setTamEspacioLocal(valor);
	}

	public int getTamEspacioLocal(){
		return activo.getTamEspacioLocal();
	}
	
	public Object buscarLocal(String nombre){
		return activo.getObjeto(nombre);
	}
	
	public Objeto buscarGlobal(String nombre){
		NivelTablaSimbolos aux = activo;
		Objeto objeto = null;
		do{
			objeto = aux.getObjeto(nombre);
			aux = aux.getNivelAnt();
		}while(aux != null && objeto==null);
		return objeto;
	}
	
	public Objeto buscarPredefinido(String nombre){
		Objeto objeto = null;
		objeto = global.getObjeto(nombre);
		return objeto;
	}

	public void insertar(String nombre, Object objeto) throws ObjetoExisteException, NullPointerException{
		activo.insertaObjeto(nombre, objeto);
	}
	
/*	public Object getObjeto(String nombre){
		return activo.getObjeto(nombre);
	} */

	public int actualizaNumSubpr(){
		subprogramas.push(new Integer(numSubpr));
		int aux = numSubpr;
		// **** mejorar con return numSubpr++;
		numSubpr++;
		return aux;
	}

	public int getNumSubprActual(){
		return (((Integer)subprogramas.pop()).intValue());
	}
	
	public int actualizaNumCondicional(){
		condicionales.push(new Integer(numCondicional));
		int aux = numCondicional;
		numCondicional++;
		return aux;
	}

	public int getNumCondicionalActual(){
		return (((Integer)condicionales.pop()).intValue());
	}

	public int actualizaNumIncondicional(){
		incondicionales.push(new Integer(numCondicional));
		int aux = numCondicional;
		numCondicional++;
		return aux;
	}

	public int getNumIncondicionalActual(){
		return (((Integer)incondicionales.pop()).intValue());
	}
	
	public int actualizaNumCadena(){
		int aux = numCadena;
		numCadena++;
		return aux;
	}
	
	public void creaNivel(){
		NivelTablaSimbolos nuevo = new NivelTablaSimbolos(activo, activo.getNivel() + 1);
		activo = nuevo;
	}

	public void suprimirNivel(){
		NivelTablaSimbolos aux = activo.getNivelAnt();
		activo.setNivelAnt(null);
		activo=aux;
	}
	
	public void insertaPredefinido(String nombre, Object objeto) throws InsercionIlegalException, ObjetoExisteException, NullPointerException{
		if (activo.getNivel()!=NIVPREDEFINIDO){
			throw new InsercionIlegalException();
		}
		else {
			activo.insertaObjeto(nombre, objeto);
		}
	}

	public ObjetoPrograma getPrograma(){
		return programa;
	}

	public void setPrograma(ObjetoPrograma p){
		programa = p;
	}
	
	public ObjetoTipoPredefinido getInteger(){
		return (ObjetoTipoPredefinido) this.buscarPredefinido("integer");
	}

	public ObjetoTipoPredefinido getReal(){
		return (ObjetoTipoPredefinido) this.buscarPredefinido("real");
	}

	public ObjetoTipoPredefinido getBoolean(){
		return (ObjetoTipoPredefinido) this.buscarPredefinido("boolean");
	}

	public ObjetoTipoPredefinido getString(){
		return (ObjetoTipoPredefinido) this.buscarPredefinido("string");
	}

	public ObjetoProcPredefinido getWrite(){
		return (ObjetoProcPredefinido) this.buscarPredefinido("write");
	}
	
	public ObjetoProcPredefinido getRead(){
		return (ObjetoProcPredefinido) this.buscarPredefinido("read");
	}

	public int getDireccion(){
		return activo.getDireccion();
	}
	
	public void setDireccion(int direccion){
		activo.setDireccion(direccion);
	}

	public NivelTablaSimbolos getActivo(){
		return activo;
	}

	public NivelTablaSimbolos getGlobal(){
		return global;
	}
	
	public void creaGlobal(){
		global = new NivelTablaSimbolos(null, NIVPREDEFINIDO);
		activo = global;
	}
	
	public int compruebaTipo(ObjetoTipo objeto){
		if (objeto == getInteger())
			return ENTERA;
		else
		   if (objeto == getReal())
			  return REAL;
		   else
		   	  if (objeto == getBoolean())
				 return LOGICA;
		   	  else
		   	  	 return NOPRIMITVO;
	}
}
