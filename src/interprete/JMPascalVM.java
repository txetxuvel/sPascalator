/*
 * Created on 31-may-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interprete;

import java.util.ArrayList;

import user.Screen;
import user.VisorInterprete;
import user.Log;

import utils.PrintfFormat;
import utils.Semaphore;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class JMPascalVM{

	/* *************** LIMITACIONES DE LA MÁQUINA ***************/
	public final static int TAMMEMORIA = 16384;
	public final static int MAXLITERAL = 1024; // Tamaño de la memoria máximo asignado a literales
	//private final static int MAXCODIGO = ;
	public final static int TAMDIR = 1;
	public final static int TAMENTERO = 1;
	public final static int TAMLOGICA = 1;
	public final static int TAMREAL = 2;
	public final static int MAXINT = 65535;
	public final static int MAXDECIMALES = 6;
	public final static int TRUE = 1;
	public final static int FALSE = 0;
	
	public final static int INTEGER = 0;
	public final static int REAL = 1;
	public final static int STRING = 2;
	public final static int BOOLEAN = 3;

	public final static int MAXSUBPROGRAMAS = 255;
	public final static int MAXCONDICIONALES = 8192;
	
	private int tamFuncion = -1;
	private int tamGlobal = -1;
	
	private Semaphore semIO = null;

	private Semaphore semDebug = null;
	private boolean debug=false;
	
	//private final static int MAXLITERALES = 30; // Se implementa mediante ArrayList y no se limita el número sólo el espacio
	
	/* ****************** MEMORIA DE LA MÁQUINA ****************/
	private int[] memoria = new int[TAMMEMORIA];
	
	/* ************** MEMORIAS AUXILIARES **********************/
	// private int[] dirLiterales = new int[MAXLITERALES];
	private ArrayList dirLiterales = null;
	
	private String fichero = null;
	
	public static final int CP = 0;
	public static final int BG = 1;
	public static final int LS = 2;
	public static final int PC = 3;
	public static final int BL = 4;
	
	public static final int DR = -1;
	public static final int EE = -2;
	
	/* ************ REGISTROS DE LA MÁQUINA ********************/
	private int dirLiteralActual = TAMMEMORIA - 1;
	private int dirInicio = 0;
	private int cp=0; // Contador de Programa
	private int bg; // Base Global (
	private int ls; // Limite Solicitado (Dirección a partir de la cual se puede reserva memoria
	private int pc; // Puntero de cima
	private int bl; // Base Local (Inicio del registro de activación actual.
	
	private Interprete interprete = null;
	private VisorInterprete interpreteViewer = null;
	
	private Screen screen = null;

	public void avanza(){
		//interprete.avanza();
		screen.permiteAvanzar(false);
		semDebug.semSignal();
	}

	public int carga(int contenido){
		memoria[cp]=contenido;
		int aux = cp;
		cp++;
		return aux;
	}

	public void cargaLiteral(String literal) throws Exception{
		// Hay que comprobar si funciona bien para la cadena vacía
		if (dirLiteralActual - literal.length() > TAMMEMORIA - MAXLITERAL){
			for(int i=1;i<=literal.length();i++,dirLiteralActual--){
				memoria[dirLiteralActual] = (int) literal.charAt(literal.length()-i);
			}
			dirLiterales.add(new Integer(dirLiteralActual + 1));
		}
		else
			throw new Exception("Error desbordamiento de pila al declarar un literal");
	}

	public void cargaPrograma(user.Log log, String filename) throws Exception{
		inicializaCarga();
		fichero = filename;
		interprete.analizaYCarga(log,filename);
		if (tamFuncion == -1){
			tamFuncion = 0;
		}
	    if (tamGlobal == -1){
			tamGlobal = 0;
		}
		bg = cp;
		ls = bg + tamFuncion + tamGlobal;
		cp = dirInicio;
		pc = dirLiteralActual;
		bl = bg;
	 	interpreteViewer.comienza(this);
	}

	public void cargaRealCP(float numero){
		int entera = (int) numero;
		int decimal = (int)((numero - (float)entera)*1000000);
		String aux = null;
		if (decimal==0)
			aux="0";
		else
	       for(aux="";decimal!=0;decimal/=10)
	    	  aux+=(decimal % 10);
		this.carga(entera);
		this.carga(new Integer(aux).intValue());
	}

	public void cargaReal(float numero, int direccion){
		int entera = (int) numero;
		int decimal = (int)((numero - (float)entera)*1000000);
		String aux = null;
		if (decimal==0)
			aux="0";
		else
	       for(aux="";decimal!=0;decimal/=10)
	    	  aux+=(decimal % 10);
		this.setPosMemoria(direccion,entera);
		this.setPosMemoria(direccion+1,new Integer(aux).intValue());
	}

	public void cargaReal(float numero){
		int entera = (int) numero;
		int decimal = (int)((numero - (float)entera)*1000000);
		String aux = null;
		if (decimal==0)
			aux="0";
		else{
		   String relleno = "";
		   if (decimal < 100000)
		   	  relleno+="0";
		   if (decimal < 10000)
		   	  relleno+="0";
		   if (decimal < 1000)
		   	  relleno+="0";
		   if (decimal < 100)
		   	  relleno+="0";
		   if (decimal < 10)
		   	  relleno+="0";
	       for(aux="";decimal!=0;decimal/=10)
	    	  aux+=(decimal % 10);
	       aux+=relleno;
		}
		this.insertaPC(new Integer(aux).intValue());
		this.insertaPC(entera);
	}

	public float creaReal(int entera, int decimal){
	 		String aux = null;
	 		if (decimal!=0)
	 		   for(aux="";decimal!=0;decimal/=10)
	 			  aux+=decimal % 10;
	 		else
	 		   aux="0";
	// 		float numero = new Float(entera + "." + aux).floatValue();
//	 		return new Float(construyeReal(entera + "." + aux)).floatValue();
	 		return new Float(entera + "." + aux).floatValue();
	 //		return numero; 
	 	}

	public void creaRegistro(int tamVT, int tamRF, int VL, boolean esPrincipal){
		if (esPrincipal){
			
		}
	}

	public void ejecuta(Log log) throws Exception{
		inicializaEjecucion();
		interprete.ejecuta(log,semDebug);
	}
	
	public void aborta(){
		interprete.aborta();
		this.avanza();
	}

	public void escribe(String valor){
		interpreteViewer.imprime(valor);
	}

	public void escribe(float valor){
		interpreteViewer.imprime(""+valor);
	}

	public void escribe(int valor){
		interpreteViewer.imprime(""+valor);
	}

	public void finalizaEjecucion(){
		screen.finalizaEjecucion();
		interpreteViewer.imprime("\n\nFinalizó la ejecucion de " + fichero + " correctamente\n");
		interpreteViewer.imprime("#################################################");
		interpreteViewer.actualizaMemoria();
	}

	public void finalizaEjecucionError(String mensaje){
		screen.finalizaEjecucion();
		interpreteViewer.imprime("\n\nFinalizó la ejecucion de " + fichero + " inesperadamente:\n     "+mensaje+"\n");
		interpreteViewer.imprime("#################################################");
		interpreteViewer.actualizaMemoria();
	}

	public void flipDebug(){
		debug=(!debug);
	}

	public int getCP(){
		// recuperar
		return memoria[cp++];
	}

	public boolean getDebug(){
		return debug;
	}

	public int getDireccionCarga(){
		return cp;
	}

	public int getDirLiteral(int etq){
		return ((Integer) dirLiterales.get(etq)).intValue();
	}

	public String getLiteral(int etqCadena, int tamanio){
		// No se contempla excepcion de fuera de rango porque habrá sido controlado en el análisis
		String cadena = "";
		Integer direccion = (Integer) dirLiterales.get(etqCadena);
		for(int i=0, pos = direccion.intValue(); i<tamanio; i++){
			cadena = cadena + (char) memoria[pos+i];
		}
		return cadena.replaceAll("\\n","\n");
	}

	public int getPC(){
		return memoria[++pc];
	}

	public int getPosMemoria(int direccion){
		return memoria[direccion];
	}

	public void setPosMemoria(int direccion,int valor){
		memoria[direccion]=valor;
	}

	public int getRegistro(int registro){
		switch(registro){
			case CP:
				return cp;
			case BG:
				return bg;
			case LS:
				return ls;
			case PC:
				return pc;
			case BL:
				return bl;
		}
		return 0;
	}

	public void inicializaCarga(){
		for (int i=0;i<TAMMEMORIA;i++){
			memoria[i]=0;
		}
		dirLiteralActual = TAMMEMORIA - 1;
		dirLiterales.clear();
		tamFuncion = -1;
		tamGlobal = -1;
		cp=0;
	}

	private void inicializaEjecucion(){
		interpreteViewer.imprime("\n\n #################################################\n");
		interpreteViewer.imprime("Comienzo ejecución de " + fichero + "\n\n");
	}

	public void insertaPC(int valor){
		memoria[pc--]=valor;
	}

	public JMPascalVM(VisorInterprete interpreteViewer,Screen screen){
		dirLiterales = new ArrayList();
		semIO = new Semaphore();
		semDebug = new Semaphore();
		this.interpreteViewer = interpreteViewer;
		interprete = new Interprete(this, this.interpreteViewer);
		this.screen = screen;
	}

   /*  public String construyeReal(String cteReal){
   		String cte = null;
   		for(int i=JMPascalVM.MAXDECIMALES - (cteReal.length() - cteReal.indexOf('.') - 1);i>0;i--)
   			cteReal+="0";
      	return cteReal;
    } */

	public Object lee(int tipo) throws ErrorEjecucionException{
			Object objeto = null;
			String entrada = interpreteViewer.lee();
			switch (tipo){ //***** Ojito con el parámetro
				case INTEGER:
					try{
					   objeto = (new Integer(entrada));
					}catch(NumberFormatException e){
						throw new ErrorEjecucionException("Se esperaba un valor entero como entrada");
					}
					break;
				case REAL:
	//				try{
//					   objeto = (new Float(construyeReal(entrada)));
					   objeto = (new Float(entrada));
		//			}catch(NumberFormatException e){
			//			throw new ErrorEjecucionException("Se esperaba un valor real como entrada");
				//	}
					break;
				case STRING: // Sin implementar
					objeto = entrada;
					break;
				case BOOLEAN:
					try{
					   objeto = (new Boolean(entrada));
					}catch(Exception e){
						throw new ErrorEjecucionException("Se esperaba un valor lógico");
					}
					break;
			}
			return objeto;
		}

	public void permiteAvanzar(boolean valor){
		screen.permiteAvanzar(valor);
	}

	public void setDirInicio(int dir){
		dirInicio = dir;
	}

	public void semIOWait(){
		semIO.semWait();
	}
	
	public void setRegistro(int registro,int valor){
		switch(registro){
			case CP:
				cp=valor;
				break;
			case BG:
				bg=valor;
				break;
			case LS:
				ls=valor;
				break;
			case PC:
				pc=valor;
				break;
			case BL:
				bl=valor;
				break;
		}
	}

	public void semSignal(){
		semIO.semSignal();
	}
	
 	public void setTamFuncion(int tamanyo){
 		tamFuncion=tamanyo;
 	}
 	
 	public void setTamGlobal(int tamanyo){
 		tamGlobal=tamanyo;
 	}

	public static void main(String[] args) {
	
	}
	

}
