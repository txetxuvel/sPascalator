/*
 * Created on 21-jun-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package interprete;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;
import user.VisorInterprete;
import user.Log;

import utils.Semaphore;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Interprete{

	private JMPascalVM maquina = null;
	private Ejecutor ejecutor = null;
	
	private VisorInterprete interpreteViewer = null;
	
	private boolean parado = true ;
	
	public Interprete(JMPascalVM maquina, VisorInterprete interpreteViewer){
		this.maquina = maquina;
		this.interpreteViewer = interpreteViewer;
	}
	
	public void ejecuta(Log log,Semaphore semDebug) throws Exception{
		ejecutor = new Ejecutor(maquina,log,interpreteViewer,semDebug);
		ejecutor.start();
		// ejecutor=null;
	}
	
	public void aborta(){
		if (ejecutor!=null && ejecutor.isAlive())
			ejecutor.setAborta(true);
	}
	
	private void traduceDirecciones(ArrayList llamadasSubpr, ArrayList llamadasCond, ArrayList tradNumSubpr, ArrayList tradNumCond) throws Exception{
		if (!llamadasSubpr.isEmpty())
			for(int i=0;i<llamadasSubpr.size();i++){
				Integer direccion=(Integer)llamadasSubpr.get(i);
				if (direccion!=null){
					Integer etq = (Integer) tradNumSubpr.get(maquina.getPosMemoria(direccion.intValue()));
					if (etq!=null)
						maquina.setPosMemoria(direccion.intValue(),etq.intValue());
					else
						throw new Exception("Etiqueta de subprograma número " + i + " ha sido llamada sin haber sido declarada");
				}
			}
		if (!llamadasCond.isEmpty())
			for(int i=0;i<llamadasCond.size();i++){
				Integer direccion=(Integer)llamadasCond.get(i);
				if (direccion!=null){
					Integer etq = (Integer) tradNumCond.get(maquina.getPosMemoria(direccion.intValue()));
					if (etq!=null)
						maquina.setPosMemoria(direccion.intValue(),etq.intValue());
					else
						throw new Exception("Etiqueta condicional número " + i + " ha sido llamada sin haber sido declarada");
				}
			}
	}
	
	public void analizaYCarga(user.Log log,String fileName) throws Exception{
		ArrayList llamadasSubpr = new ArrayList();
		ArrayList llamadasCond = new ArrayList();
		ArrayList tradNumSubpr = new ArrayList();
		ArrayList tradNumCond = new ArrayList();
		
		Parser parser = new Parser(maquina, log, llamadasSubpr, llamadasCond, tradNumSubpr, tradNumCond);
		// try{
			log.anadirLog("Inicializando scanner.....");
			Scanner lexer = new Lexer(new FileReader(fileName));
			log.anadirLog("   Inicializado scanner\nInicializando parser.....");
			parser.setScanner(lexer);
			log.anadirLog("   Inicializado parser\nComienzo de análisis y carga.....");
			parser.parse();
			log.anadirLog("   Análisis correcto\n");
			log.anadirLog("Comienzo de traducción de direcciones.....");
			traduceDirecciones(llamadasSubpr, llamadasCond, tradNumSubpr, tradNumCond);
			log.anadirLog("   Traducción realizada\n");
		/*}catch (IOException e){
			log.anadirLog("  Análisis incorrecto\n\n¡¡¡¡¡ Ha habido un error al procesar el fichero: " + e.getMessage() + " !!!\n");
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			log.anadirLog("  Análisis incorrecto\n\n¡¡¡¡¡ El fichero contiene errores: #" + " !!!\n");
			e.printStackTrace();
		}*/
	}
	
	/*   *****************    PARA PROBAR EL LEXER  ***/
 	public void pruebaLexer(String fileName, Log log){
 		try{
 			Lexer lexer = new Lexer(new FileReader(fileName));
 			Symbol symbol = null;
 			log.cleanLog();
 			for(symbol = lexer.next_token();symbol.sym!=0;symbol = lexer.next_token()){
 				log.anadirLog("\nEncontrado símbolo: " + lexer.yytext() + " (" + symbol.sym + ")" +
 									" en la línea: " + lexer.getLine() +
									" en la columna: " + lexer.getColumn());
 			}
 		}catch (IOException e){
 			log.anadirLog("\nHa habido un error al leer el fichero: " + e.getMessage());
 		}catch (Exception e){
 			log.anadirLog("\nException" + e.getMessage());
 		}
 	}
	
	
}
