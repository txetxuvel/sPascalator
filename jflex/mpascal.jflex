package interprete;

import java_cup.runtime.*;

%%

%class Lexer
%unicode
%ignorecase
%cupsym Sym
%cup
%int
%line
%column
%public

%{

   public int getLine(){
      return this.yyline;
   }

   public int getColumn(){
      return this.yycolumn;
   }
   
   public boolean isEnteraValida(String cte){
		if ((new Integer(cte).intValue()) > JMPascalVM.MAXINT){
			//throw new ErrorLexicoException("Constante entera fuera de rango: " + cte);
			return false;
		}
		else
			return true;
   }
   

   private boolean isRealValida(String cteReal){
   		int entera = new Integer(cteReal.substring(0, cteReal.indexOf('.'))).intValue();
   		if (entera > JMPascalVM.MAXINT || cteReal.length() - cteReal.indexOf('.') - 1 > JMPascalVM.MAXDECIMALES){
			return false;
   		}
   		else
   			return true;
   }

/*   public String construyeReal(String cteReal){
   		String cte = null;
   		for(int i=JMPascalVM.MAXDECIMALES - (cteReal.length() - cteReal.indexOf('.') - 1);i>0;i--)
   		    cteReal+="0";
      	return cteReal;
   } */

%}

separador = [\ \t]+

%%

\'([^\']|\'\')*\'	{String cadena = yytext();  String subcadena = new String(cadena.substring(1,cadena.length()-1)); return new Symbol(Sym.pCADENA, yyline, yycolumn,subcadena);}

^AINDVALOR		{return new Symbol(Sym.prAINDVALOR, yyline, yycolumn);}
^AREAL			{return new Symbol(Sym.prAREAL, yyline, yycolumn);}
^ARESFUNC		{return new Symbol(Sym.prARESFUNC, yyline, yycolumn);}
^BIFCOND		{return new Symbol(Sym.prBIFCOND, yyline, yycolumn);}
^BIFINCOND		{return new Symbol(Sym.prBIFINCOND, yyline, yycolumn);}
^CCONSTANTE		{return new Symbol(Sym.prCCONSTANTE, yyline, yycolumn);}
^CCONSTANTEREAL	{return new Symbol(Sym.prCCONSTANTEREAL, yyline, yycolumn);}
^CDIRGLOBAL		{return new Symbol(Sym.prCDIRGLOBAL, yyline, yycolumn);}
^CDIRINTERM		{return new Symbol(Sym.prCDIRINTERM, yyline, yycolumn);}
^CLITERAL	{return new Symbol(Sym.prCLITERAL, yyline, yycolumn);}
^CDIRLOCAL		{return new Symbol(Sym.prCDIRLOCAL, yyline, yycolumn);}
^CINDVALOR		{return new Symbol(Sym.prCINDVALOR, yyline, yycolumn);}
^CONJUNCION  	{return new Symbol(Sym.prCONJUNCION, yyline, yycolumn);}
^CREGISTRO		{return new Symbol(Sym.prCREGISTRO, yyline, yycolumn);}
^DCAMPO			{return new Symbol(Sym.prDCAMPO, yyline, yycolumn);}
^DEFLITERAL		{return new Symbol(Sym.prDEFLITERAL, yyline, yycolumn);}
^DELEMENTO		{return new Symbol(Sym.prDELEMENTO, yyline, yycolumn);}
^DEVOLUCION		{return new Symbol(Sym.prDEVOLUCION, yyline, yycolumn);}
^DISTINTO		{return new Symbol(Sym.prDISTINTO, yyline, yycolumn);}
^DISYUNCION		{return new Symbol(Sym.prDISYUNCION, yyline, yycolumn);}
^GRABACION		{return new Symbol(Sym.prGRABACION, yyline, yycolumn);}
^GRABACIONLITERAL	{return new Symbol(Sym.prGRABACIONLITERAL, yyline, yycolumn);}
^GRABACIONREAL	{return new Symbol(Sym.prGRABACIONREAL, yyline, yycolumn);}
^DIVISION		{return new Symbol(Sym.prDIVISION, yyline, yycolumn);}
^DIVISIONREAL	{return new Symbol(Sym.prDIVISIONREAL, yyline, yycolumn);}
^IGUAL			{return new Symbol(Sym.prIGUAL, yyline, yycolumn);}
^IGUALREAL		{return new Symbol(Sym.prIGUALREAL, yyline, yycolumn);}
^LECTURA		{return new Symbol(Sym.prLECTURA, yyline, yycolumn);}
^LECTURAREAL	{return new Symbol(Sym.prLECTURAREAL, yyline, yycolumn);}
^LIMITACION		{return new Symbol(Sym.prLIMITACION, yyline, yycolumn);}
^LLAMADA		{return new Symbol(Sym.prLLAMADA, yyline, yycolumn);}
^MAYORIGU			{return new Symbol(Sym.prMAYORIGU, yyline, yycolumn);}
^MAYORIGUREAL		{return new Symbol(Sym.prMAYORIGUREAL, yyline, yycolumn);}
^MAYOR			{return new Symbol(Sym.prMAYOR, yyline, yycolumn);}
^MAYORREAL		{return new Symbol(Sym.prMAYORREAL, yyline, yycolumn);}
^MENORIGU		{return new Symbol(Sym.prMENORIGU, yyline, yycolumn);}
^MENORIGUREAL	{return new Symbol(Sym.prMENORIGUREAL, yyline, yycolumn);}
^MENOR			{return new Symbol(Sym.prMENOR, yyline, yycolumn);}
^MENORREAL		{return new Symbol(Sym.prMENORREAL, yyline, yycolumn);}
^MODULO      	{return new Symbol(Sym.prMODULO, yyline, yycolumn);}
^MODULOREAL    	{return new Symbol(Sym.prMODULOREAL, yyline, yycolumn);}
^NEGACION    	{return new Symbol(Sym.prNEGACION, yyline, yycolumn);}
^NEGATIVO		{return new Symbol(Sym.prNEGATIVO, yyline, yycolumn);}
^OCUPAESP		{return new Symbol(Sym.prOCUPAESP, yyline, yycolumn);}
^PRODUCTO		{return new Symbol(Sym.prPRODUCTO, yyline, yycolumn);}
^PRODUCTOREAL	{return new Symbol(Sym.prPRODUCTOREAL, yyline, yycolumn);}
^RESERVAESP		{return new Symbol(Sym.prRESERVAESP, yyline, yycolumn);}
^RESTA			{return new Symbol(Sym.prRESTA, yyline, yycolumn);}
^RESTAREAL		{return new Symbol(Sym.prRESTAREAL, yyline, yycolumn);}
^SUMA 			{return new Symbol(Sym.prSUMA, yyline, yycolumn);}
^SUMAREAL		{return new Symbol(Sym.prSUMAREAL, yyline, yycolumn);}
^"#"TAMFUNCION	{return new Symbol(Sym.prTAMFUNCION, yyline, yycolumn);}
^"#"TAMGLOBAL	{return new Symbol(Sym.prTAMGLOBAL, yyline, yycolumn);}
^"#"DEFLITERAL	{return new Symbol(Sym.prDEFLITERAL, yyline, yycolumn);}
^TERMINACION	{return new Symbol(Sym.prTERMINACION, yyline, yycolumn);}

/* ("-"|"")[:digit:]+"."[:digit:]+	{return new Symbol(Sym.pCteReal, yyline, yycolumn, new Float(yytext()));} */
/* ("-"|"")[:digit:]+				{return new Symbol(Sym.pCte, yyline, yycolumn, new Integer(yytext()));} */
/* ("-"|"")[:digit:]+"."[:digit:]+		{if (isRealValida(yytext())) return new Symbol(Sym.pCteReal, yyline, yycolumn, new Float(construyeReal(yytext()))); else throw new ErrorLexicoException("Constante real fuera de rango: "+yytext()+" Línea: "+yyline+" Columna: "+yycolumn);} */
("-"|"")[:digit:]+"."[:digit:]+		{if (isRealValida(yytext())) return new Symbol(Sym.pCteReal, yyline, yycolumn, new Float(yytext())); else throw new ErrorLexicoException("Constante real fuera de rango: "+yytext()+" Línea: "+yyline+" Columna: "+yycolumn);}
("-"|"")[:digit:]+					{if (isEnteraValida(yytext())) return new Symbol(Sym.pCte, yyline, yycolumn, new Integer(yytext())); else throw new ErrorLexicoException("Constante entera fuera de rango: "+yytext()+" Línea: "+yyline+" Columna: "+yycolumn);}

^"*"[:digit:]+		{return new Symbol(Sym.pEtqSubpr, yyline, yycolumn, new Integer(yytext().substring(1)));}
^"e"[:digit:]+		{return new Symbol(Sym.pEtqInst, yyline, yycolumn, new Integer(yytext().substring(1)));}

^"<".*				{System.out.println("Comentario: "+yytext()+"\n");}
{separador}"<".*	{System.out.println("Comentario: "+yytext()+"\n");}

{separador}			{return new Symbol(Sym.pSeparador, yyline, yycolumn);}
[\n\r]				{;}

.					{return new Symbol(Sym.error, yyline, yycolumn);}