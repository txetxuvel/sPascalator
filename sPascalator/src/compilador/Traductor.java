/*
 * Created on 05-may-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package compilador;

import java.io.FileReader;
//import java.io.IOException;

import java_cup.runtime.Scanner;
import user.Log;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Traductor {
	
	private String fileName = null;
	
	public Traductor(String name){
		fileName = name;
	}
	
	private TablaSimbolos tabla = null;
	
	public void traducir(Log log) throws Exception{
/*		 //Versión para JFlex tipo lex cambio a CUP 
  		  Lexer lexer = null;
	   	  try{
	        lexer = new Lexer(new FileReader(this.fileName));
//C:\\tfc\\eclipse\\pbasic\\pBasic2PIC\\src\\compilador\\prueba1.bs2
	   	  }catch(FileNotFoundException x){
	   	  	System.out.println("Error: Fichero no encontrado o no se puede abrir el fichero");
	   	  	System.exit(1);
	   	  }
	      try{
	      	 int lexema;
	         while ((lexema=lexer.yylex())>0){
	         	System.out.println("Lexema: " + lexer.yytext() + " ("+lexema+") Longitud: " + lexer.yylength() + " Línea: " + lexer.getLine() + " Posición: " + lexer.getColumn());
	         }
	      }catch(IOException x){
		      System.out.println("Error. Línea: " + lexer.getLine() + " Columna: " + lexer.getColumn());
	      } */
/*		Lexer lexer = null;
		try{
			lexer = new Lexer(new FileReader(this.fileName));
			Parser parser = new Parser(lexer);
			Object resultado = parser.parse().value;
			System.out.println(resultado.getClass());
		}catch(FileNotFoundException e){
			log.appendLog("\nError al abrir el fichero para la compilación");
		}catch(IOException e){
			log.appendLog("\nError leyendo el fichero");
		}catch(Exception e){
			log.appendLog("\nError realizando la compilación: " + e.getMessage());
		}*/
// Versión copiada del main del parser

		tabla = new TablaSimbolos();
		Parser parser = new Parser(tabla, log, this.fileName);
		//try{
			log.anadirLog("Inicializando scanner.....");
			Scanner lexer = new Lexer(new FileReader(this.fileName));
			log.anadirLog("   Inicializado scanner\nInicializando parser.....");
			parser.setScanner(lexer);
			log.anadirLog("   Inicializado parser\nComienzo de análisis.....");
			parser.parse();
			log.anadirLog("  Análisis correcto");
/*		}catch (ErrorLexicoException e){
			log.appendLog("  Análisis incorrecto\n\n¡¡¡¡¡ " + e.getMessage() + " !!!\n");
		}catch (ErrorSintacticoException e){
			System.out.println("Salgo por sintáctico");
			log.appendLog("  Análisis incorrecto\n\n¡¡¡¡¡ " + e.getMessage() + " !!!\n");
		}catch (InsercionIlegalException e){
			
		}catch (IOException e){
			log.appendLog("  Análisis incorrecto\n\n¡¡¡¡¡ Ha habido un error al procesar el fichero: " + e.getMessage() + " !!!\n");
		}catch (ErrorSemanticoException e){
			log.appendLog("  Análisis incorrecto\n\n¡¡¡¡¡ " + e.getMessage() + " !!!\n");
		}catch(Exception e){
			log.appendLog("  Análisis incorrecto\n\n¡¡¡¡¡ El fichero contiene errores indeterminados: " + e.getMessage() + " !!!\n");
			e.printStackTrace();
		} */
	}
}
