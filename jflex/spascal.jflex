package compilador;

import java_cup.runtime.*;
import interprete.JMPascalVM;
%%

%class Lexer
%unicode
%ignorecase
%cupsym Sym
%cup
%int
%line
%column
%char
%public

%{

   public int getLine(){
      return this.yyline;
   }

   public int getColumn(){
      return this.yycolumn;
   }

   public int getCharacter(){
      return this.yychar;
   }

   private boolean esEnteraValida(String cte){
		if ((new Integer(cte).intValue()) > JMPascalVM.MAXINT){
			//throw new ErrorLexicoException("Constante entera fuera de rango: " + cte);
			return false;
		}
		else
			return true;
   }
      
   private boolean esRealValida(String cteReal){
   		int entera = new Integer(cteReal.substring(0, cteReal.indexOf('.'))).intValue();
   		if (entera > JMPascalVM.MAXINT || cteReal.length() - cteReal.indexOf('.') - 1 > JMPascalVM.MAXDECIMALES){
			//throw new ErrorLexicoException("Constante real fuera de rango: " + cteReal);
			return false;
   		}
   		else
   			return true;
   }
   
   private String traduceCadena(String cadena){
   		String resultado = "";
   		for (int i=0; i<cadena.length(); i++){
   			if ((i==0) || !(cadena.charAt(i) == '\'' &&  cadena.charAt(i-1) == '\''))
   				resultado = resultado + cadena.charAt(i);
   		}
   		return resultado;
   }
%}


/* letra = [a-zA-Z] 
cifraInit = [1-9]
cifra = [0-9] */

%%

"(*"~"*)"	{/* System.out.println("Comentario en línea " + getLine() + ": " + yytext())*/;}
"{"~"}"		{/* System.out.println("Comentario en línea " + getLine() + ": " + yytext())*/;}

\'([^\']|\'\')*\'	{String cadena = yytext(); String subcadena = new String(cadena.substring(1,cadena.length()-1)); return new Symbol(Sym.pCADENA, yyline, yycolumn, traduceCadena(subcadena));}

AND			{return new Symbol(Sym.prAND, yyline, yycolumn);}
ARRAY		{return new Symbol(Sym.prARRAY, yyline, yycolumn);}
BEGIN		{return new Symbol(Sym.prBEGIN, yyline, yycolumn);}
CONST		{return new Symbol(Sym.prCONST, yyline, yycolumn);}
DIV			{return new Symbol(Sym.prDIV, yyline, yycolumn);}
DO			{return new Symbol(Sym.prDO, yyline, yycolumn);}
DOWNTO		{return new Symbol(Sym.prDOWNTO, yyline, yycolumn);}
ELSE		{return new Symbol(Sym.prELSE, yyline, yycolumn);}
END			{return new Symbol(Sym.prEND, yyline, yycolumn);}
FOR			{return new Symbol(Sym.prFOR, yyline, yycolumn);}
FUNCTION	{return new Symbol(Sym.prFUNCTION, yyline, yycolumn);}
IF			{return new Symbol(Sym.prIF, yyline, yycolumn);}
MOD			{return new Symbol(Sym.prMOD, yyline, yycolumn);}
NOT			{return new Symbol(Sym.prNOT, yyline, yycolumn);}
OF			{return new Symbol(Sym.prOF, yyline, yycolumn);}
OR			{return new Symbol(Sym.prOR, yyline, yycolumn);}
PROCEDURE	{return new Symbol(Sym.prPROCEDURE, yyline, yycolumn);}
PROGRAM		{return new Symbol(Sym.prPROGRAM, yyline, yycolumn);}
RECORD		{return new Symbol(Sym.prRECORD, yyline, yycolumn);}
REPEAT		{return new Symbol(Sym.prREPEAT, yyline, yycolumn);}
THEN		{return new Symbol(Sym.prTHEN, yyline, yycolumn);}
TO			{return new Symbol(Sym.prTO, yyline, yycolumn);}
TYPE		{return new Symbol(Sym.prTYPE, yyline, yycolumn);}
UNTIL		{return new Symbol(Sym.prUNTIL, yyline, yycolumn);}
VAR			{return new Symbol(Sym.prVAR, yyline, yycolumn);}
WHILE		{return new Symbol(Sym.prWHILE, yyline, yycolumn);}

/* con esta expresión se añade la ñ, Ç [:jletter:][:jletterdigit:]*	{return new Symbol(Sym.pID, yyline, yycolumn, new String(yytext()));}*/
[a-zA-Z]([a-zA-Z0-9])*			{return new Symbol(Sym.pID, yyline, yycolumn, new String(yytext()));}
[:digit:]+						{if (esEnteraValida(yytext())) return new Symbol(Sym.pCteEntera, yyline, yycolumn, new Integer(yytext())); else /*return new Symbol(Sym.error, yyline, yycolumn);*/ throw new ErrorLexicoException("Constante entera fuera de rango: "+yytext()+" Línea: "+yyline+" Columna: "+yycolumn);}
[:digit:]+"."[:digit:]+			{if (esRealValida(yytext())) return new Symbol(Sym.pCteReal, yyline, yycolumn, new Float(yytext())); else /*return new Symbol(Sym.error, yyline, yycolumn)*/throw new ErrorLexicoException("Constante real fuera de rango: "+yytext()+" Línea: "+yyline+" Columna: "+yycolumn);}

[\ \t\n\r]+						{;}

".."	{return new Symbol(Sym.sSUBRANGO, yyline, yycolumn);}
"<>"	{return new Symbol(Sym.sDISTINTO, yyline, yycolumn);}
"<="	{return new Symbol(Sym.sMENORIGU, yyline, yycolumn);}
">="	{return new Symbol(Sym.sMAYORIGU, yyline, yycolumn);}
"<"		{return new Symbol(Sym.sMENOR, yyline, yycolumn);}
">"		{return new Symbol(Sym.sMAYOR, yyline, yycolumn);}
"="		{return new Symbol(Sym.sIGUAL, yyline, yycolumn);}
":="	{return new Symbol(Sym.sASIGNACION, yyline, yycolumn);}
"+"		{return new Symbol(Sym.sMAS, yyline, yycolumn);}
"-"		{return new Symbol(Sym.sMENOS, yyline, yycolumn);}
"*"		{return new Symbol(Sym.sPOR, yyline, yycolumn);}
"("		{return new Symbol(Sym.sPARAPER, yyline, yycolumn);}
")"		{return new Symbol(Sym.sPARCIE, yyline, yycolumn);}
"["		{return new Symbol(Sym.sCORAPER, yyline, yycolumn);}
"]"		{return new Symbol(Sym.sCORCIE, yyline, yycolumn);}
","		{return new Symbol(Sym.sCOMA, yyline, yycolumn);}
";"		{return new Symbol(Sym.sPUNTOCOMA, yyline, yycolumn);}
":"		{return new Symbol(Sym.sDOSPUNTOS, yyline, yycolumn);}
"."		{return new Symbol(Sym.sPUNTO, yyline, yycolumn);}

.		{/*return new Symbol(Sym.error, yyline, yycolumn);*/throw new ErrorLexicoException("Símbolo no válido: " + yytext() + " Línea: " + yyline + " Columna: " + yycolumn);}