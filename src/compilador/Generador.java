/*
 * Created on 06-jun-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package compilador;

import java.io.FileWriter;
import java.io.IOException;
/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Generador {

	private String codigo = null;
	private String separador = System.getProperty("line.separator");
	private String fileName = null;
	
	public Generador(String fileName){
		this.fileName = fileName.substring(0,fileName.lastIndexOf(".")) + ".mps";
	}
	
	public void termina(){
		try{
			FileWriter writer = new FileWriter(fileName);
			codigo = codigo + separador +"TERMINACION";
			writer.write(codigo);
			writer.close();
		}catch(IOException e){
		}
	}
	
	public void anyadeCodigo(String instruccion){
		codigo = (codigo!=null)?codigo + separador + instruccion:instruccion;
		// System.out.println(instruccion);
	}


/* FUNCIONES ARITMÉTICAS */
	
	public void gSuma(){
		anyadeCodigo("SUMA");
	}

	public void gSumaReal(){
		anyadeCodigo("SUMAREAL");
	}

	public void gResta(){
		anyadeCodigo("RESTA");
	}

	public void gRestaReal(){
		anyadeCodigo("RESTAREAL");
	}

	public void gNegativo(){
		anyadeCodigo("NEGATIVO");
	}

	public void gNegativoReal(){
		anyadeCodigo("NEGATIVOREAL");
	}

	public void gProducto(){
		anyadeCodigo("PRODUCTO");
	}

	public void gProductoReal(){
		anyadeCodigo("PRODUCTOREAL");
	}
	
	public void gDivision(){
		anyadeCodigo("DIVISION");
	}
	
	public void gDivisionReal(){
		anyadeCodigo("DIVISIONREAL");
	}
	
	public void gModulo(){
		anyadeCodigo("MODULO");
	}
	
	public void gModuloReal(){
		anyadeCodigo("MODULOREAL");
	}

	
/* FUNCIONES LÓGICAS */
	
	public void gNegacion(){
		anyadeCodigo("NEGACION");
	}
	
	public void gConjuncion(){
		anyadeCodigo("CONJUNCION");
	}
	
	public void gDisyuncion(){
		anyadeCodigo("DISYUNCION");
	}
	
	public void gIgual(){
		anyadeCodigo("IGUAL");
	}
	
	public void gIgualReal(){
		anyadeCodigo("IGUALREAL");
	}
	
	public void gDistinto(){
		anyadeCodigo("DISTINTO");
	}
	
	public void gDistintoReal(){
		anyadeCodigo("DISTINTOREAL");
	}

	public void gMayor(){
		anyadeCodigo("MAYOR");
	}
	
	public void gMayorReal(){
		anyadeCodigo("MAYORREAL");
	}
	
	public void gMayorIgu(){
		anyadeCodigo("MAYORIGU");
	}
	
	public void gMayorIguReal(){
		anyadeCodigo("MAYORIGUREAL");
	}
	
	public void gMenor(){
		anyadeCodigo("MENOR");
	}
	
	public void gMenorReal(){
		anyadeCodigo("MENORREAL");
	}
	
	public void gMenorIgu(){
		anyadeCodigo("MENORIGU");
	}
	
	public void gMenorIguReal(){
		anyadeCodigo("MENORIGUREAL");
	}

	
/* FUNCIONES DE ENTRADA/SALIDA */
	
	public void gGrabacion(){
		anyadeCodigo("GRABACION");
	}
	
	public void gGrabacionReal(){
		anyadeCodigo("GRABACIONREAL");
	}

	public void gGrabacionLiteral(){
		anyadeCodigo("GRABACIONLITERAL");
	}
	
	public void gLectura(){
		anyadeCodigo("LECTURA");
	}

	public void gLecturaReal(){
		anyadeCodigo("LECTURAREAL");
	}

/* FUNCIONES DE CARGA */
	
	public void gCConstante(int cte){
		anyadeCodigo("CCONSTANTE " + cte);
	}
	
	public void gCConstanteReal(float cte){
		anyadeCodigo("CCONSTANTEREAL " + cte);
	}
	
	public void gCDirLocal(int l){
		anyadeCodigo("CDIRLOCAL " + l);
	}

	public void gCDirGlobal(int l){
		anyadeCodigo("CDIRGLOBAL " + l);
	}

	public void gCDirInterm(int p, int l){
		anyadeCodigo("CDIRINTERM " + p + " " + l);
	}

	public void gCIndValor(int w){
		anyadeCodigo("CINDVALOR " + w);
	}

	public void gCRegistro(int m){
		anyadeCodigo("CREGISTRO " + m);
	}
	
	public void gLimitacion(int inicio, int fin, int l){
		anyadeCodigo("LIMITACION " + inicio + " " + fin + " " + l);
	}

	public void gCLiteral(int etq){
		anyadeCodigo("CLITERAL " + etq);
	}

	public void gDefLiteral(String literal){
		anyadeCodigo("#DEFLITERAL '" + literal +"'");
	}
/* FUNCIONES DE ALMACENAMIENTO */
	
	public void gAIndValor(int w){
		anyadeCodigo("AINDVALOR " + w);
	}
	
	public void gAIndValorReal(int w){ // Comprobar si es necesaria
		anyadeCodigo("AINDVALORREAL " + w);
	}
	

/* PSEUDOINSTRUCCIONES PARA EL ÁREA GLOBAL */
	
	public void gTamGlobal(int w){
		anyadeCodigo("#TAMGLOBAL " + w);
	}

	public void gTamFuncion(int w){
		anyadeCodigo("#TAMFUNCION " + w);
	}

/* GESTIÓN DE MEMORIA */
	
	public void gReservaEsp(int w){
		anyadeCodigo("RESERVAESP " + w);
	}

	public void gOcupaEsp(int w){
		anyadeCodigo("OCUPAESP " + w);
	}

	public void gLlamada(int etq){
		anyadeCodigo("LLAMADA " + etq);
	}

	public void gDevolucion(int w){
		anyadeCodigo("DEVOLUCION " + w);
	}

/* INSTRUCCIONES DE BIFURCACIÓN */

	public void gBifCond(int etq){
		anyadeCodigo("BIFCOND " + etq);
	}

	public void gBifIncond(int etq){
		anyadeCodigo("BIFINCOND " + etq);
	}

	
/* INSTRUCCIONES DE ACCESO A ESTRUCTURAS */
	
// ESTAS POSIBLEMENTE HAYA QUE RETOCARLAS PARA QUE VALGAN PARA LOLS REALES
	
	public void gDCampo(int l){
		anyadeCodigo("DCAMPO " + l);
	}

	public void gDElemento(int b, int w){
		anyadeCodigo("DELEMENTO " + b + " " + w);
	}

	
/* FUNCIONES DE IMPRESIÓN DE ETIQUETAS */
	
	public void gEtqSubpr (int etq){
		anyadeCodigo("*" + etq);
	}
	
	public void gEtqCondicional (int etq){
		anyadeCodigo("e" + etq);
	}
	
/* OTRAS */
	public void gAReal(int l){
		anyadeCodigo("AREAL " + l);
	}

	
	
}
