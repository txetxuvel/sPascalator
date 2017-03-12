package interprete;

import java.util.Stack;

//import java.lang.InterruptedException;

import user.VisorInterprete;
import user.Log;

import utils.Semaphore;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Ejecutor extends Thread{
	
	private JMPascalVM maquina = null;
	private VisorInterprete interpreteViewer = null;
	private Semaphore semIO = null;
	private Semaphore semDebug = null;
	
	private boolean aborta = false;
	
	private Log log = null;
	
	public Ejecutor(JMPascalVM maquina,Log log,VisorInterprete interpreteViewer,Semaphore semDebug){
		this.maquina=maquina;
		this.interpreteViewer=interpreteViewer;
		this.semDebug=semDebug;
		this.log = log;
	}

	public void AIndValor(){
		for (int i=0, tamanyo=maquina.getCP(),direccion=maquina.getPC();i<tamanyo;i++)
			maquina.setPosMemoria(direccion+i,maquina.getPC());
	}
	
	public void AReal(){
		int pos = maquina.getCP();
		Stack pila = new Stack();
		for(int i=0;i<pos;i++)
		   pila.push(new Integer(maquina.getPC()));
		int entero = maquina.getPC();
		maquina.insertaPC(0);
		maquina.insertaPC(entero);
		for(;!pila.isEmpty();maquina.insertaPC(((Integer)pila.pop()).intValue()));
	}
	
	public void AResFunc(){
		// Funciones no implementadas
	}
	
	public void BifCond(){
		int direccion=maquina.getCP();
		if (maquina.getPC() == JMPascalVM.FALSE)
			maquina.setRegistro(JMPascalVM.CP,direccion);
	}
	
	public void BifIncond(){
		maquina.setRegistro(JMPascalVM.CP,maquina.getCP());
	}
	
	public void CConstante(){
		maquina.insertaPC(maquina.getCP());
	}
	
	public void CConstanteReal(){
		Stack pila = new Stack();
		for (int i=0;i<JMPascalVM.TAMREAL;i++)
			pila.push(new Integer(maquina.getCP()));
		for(;!pila.isEmpty();maquina.insertaPC(((Integer)pila.pop()).intValue()));
	}
	
	public void CDirGlobal(){
		maquina.insertaPC(maquina.getRegistro(JMPascalVM.BG) + maquina.getCP()); /****/
	}
	
	public void CDirInterm(){
		int pasos=maquina.getCP();
		int base=maquina.getPosMemoria(maquina.getRegistro(JMPascalVM.BL) + JMPascalVM.EE);
		for(int i=0;i<pasos;i++)
			base=maquina.getPosMemoria(base + JMPascalVM.EE);
		maquina.insertaPC(maquina.getCP());
	}
	
	public void CLiteral(){
		maquina.insertaPC(maquina.getCP());
		maquina.insertaPC(maquina.getCP());
	}
	
	public void CDirLocal(){
		maquina.insertaPC(maquina.getRegistro(JMPascalVM.BL) + maquina.getCP());
	}

	public void CIndValor(){
		int direccion=maquina.getPC();
		for(int i=1,tamanyo=maquina.getCP();i<=tamanyo;i++)
			maquina.insertaPC(maquina.getPosMemoria(direccion+tamanyo-i));
	}
	
	public void Conjuncion(){
		int segundo=maquina.getPC();
		int primero=maquina.getPC();
		if ((primero==JMPascalVM.TRUE) && (segundo==JMPascalVM.TRUE))
			maquina.insertaPC(JMPascalVM.TRUE);
		else
			maquina.insertaPC(JMPascalVM.FALSE);
	}
	
	public void CRegistro(){
		maquina.insertaPC(maquina.getRegistro(maquina.getCP()));
	}
	
	public void DCampo(){
		maquina.insertaPC(maquina.getPC()+maquina.getCP());
	}
	
	/* public void DefLiteral(){
		
	} */
	
	public void DElemento(){
		// tenemos en la cima de la pila la dirección de inicio del array
		// tenemos en la subcima de la pila el índice
		// El siguiente CP es el inicio del array
		// El siguiente CP es el tamaño de cada elemento
		int inicio=maquina.getCP();
		int tamanio=maquina.getCP();
		maquina.insertaPC(maquina.getPC() - (inicio * tamanio)+ (maquina.getPC() * tamanio));
	}
	
	public void Devolucion(){
		int devolucion = maquina.getCP();
		maquina.setRegistro(JMPascalVM.PC,maquina.getRegistro(JMPascalVM.BL)-1);
		maquina.setRegistro(JMPascalVM.BL,maquina.getPC());
		maquina.setRegistro(JMPascalVM.CP,maquina.getPC());
		maquina.setRegistro(JMPascalVM.PC,maquina.getRegistro(JMPascalVM.PC) + devolucion); 
	}
	
	public void Distinto(){
		if ((maquina.getPC()!=maquina.getPC()))
			maquina.insertaPC(JMPascalVM.TRUE);
		else
			maquina.insertaPC(JMPascalVM.FALSE);
	}
	
	public void Division(){
		int segundo=maquina.getPC();
		int primero=maquina.getPC();
		maquina.insertaPC(primero / segundo);
	}
	
	public void DivisionReal(){
		float operando2 = maquina.creaReal(maquina.getPC(),maquina.getPC());
		float operando1 = maquina.creaReal(maquina.getPC(),maquina.getPC());
//	    float division = operando1/operando2;
        maquina.cargaReal(operando1/operando2);
	}

	public void Disyuncion(){
		int segundo=maquina.getPC();
		int primero=maquina.getPC();
		if ((primero==JMPascalVM.TRUE) || (segundo==JMPascalVM.TRUE))
			maquina.insertaPC(JMPascalVM.TRUE);
		else
			maquina.insertaPC(JMPascalVM.FALSE);
	}
	
	public void Grabacion(){
		maquina.escribe(maquina.getPC());
	}
	
	public void GrabacionLiteral(){
		maquina.escribe(maquina.getLiteral(maquina.getPC(),maquina.getPC()));
	}

	public void GrabacionReal(){
		maquina.escribe(maquina.creaReal(maquina.getPC(),maquina.getPC()));
		//**** REAL
	}

	public void Igual(){
		if ((maquina.getPC()==maquina.getPC()))
			maquina.insertaPC(JMPascalVM.TRUE);
		else
			maquina.insertaPC(JMPascalVM.FALSE);
	}
	
	public void Lectura() throws ErrorEjecucionException{
		try{
			log.anadirLog("    Solicitada lectura de tipo INTEGER\n");
//			interpreteViewer.imprime("Introduzca un número entero (éste número puede encontrarse en el búffer): ");
			maquina.setPosMemoria(maquina.getPC(),((Integer)maquina.lee(JMPascalVM.INTEGER)).intValue()); //***** Ojito con el parámetro
		}catch(ClassCastException e){
			throw new ErrorEjecucionException("Entrada de tipo inválido. Se esperaba un entero");
		}
	}
	
	public void LecturaReal() throws ErrorEjecucionException{
		try{
			log.anadirLog("    Solicitada lectura de tipo REAL\n");
			// interpreteViewer.imprime("Introduzca un número real (éste número puede encontrarse en el búffer): ");
			maquina.cargaReal(((Float)maquina.lee(JMPascalVM.REAL)).floatValue(),maquina.getPC()); //***** Ojito con el parámetro
		}catch(ClassCastException e){
			throw new ErrorEjecucionException("Entrada de tipo inválido. Se esperaba un real");
		}
		//**** REAL
	}

	public void Limitacion() throws ErrorEjecucionException{
		int inicio = maquina.getCP();
		int fin = maquina.getCP();
		int elementosEncima = maquina.getCP();
		/* Versión A moviendo la pila */
		/* Se usa esta para poder el índice en la pila de la cima */
		Stack pila = new Stack();
		for(int i=0;i<elementosEncima;i++){
			pila.push(new Integer(maquina.getPC()));
		}
		int valor = maquina.getPC();
		if (valor >= inicio && valor <= fin){
			for(;!pila.isEmpty();maquina.insertaPC(((Integer)pila.pop()).intValue()));
			maquina.insertaPC(valor);
		}
		else
		   throw new ErrorEjecucionException("Índice fuera de rango");
		/* Versión B (acceder directamente a la dirección) */
		/*int valor = maquina.getPosMemoria(maquina.getRegistro(JMPascalVM.PC)+elementosEncima+1);
		if (!(valor >= inicio && valor <= fin))
		   throw new ErrorEjecucionException("Índice fuera de rango");*/
	}

	public void Llamada(){
		maquina.insertaPC(maquina.getRegistro(JMPascalVM.CP) + 1);
		maquina.insertaPC(maquina.getRegistro(JMPascalVM.BL));
		maquina.setRegistro(JMPascalVM.BL,maquina.getRegistro(JMPascalVM.PC)+1);
		maquina.setRegistro(JMPascalVM.CP,maquina.getCP());
	}
	
	public void Mayor(){
		/* int segundo=maquina.getPC();
		int primero=maquina.getPC();
		if ((primero>segundo)) */
		if ((maquina.getPC()<maquina.getPC()))
			maquina.insertaPC(JMPascalVM.TRUE);
		else
			maquina.insertaPC(JMPascalVM.FALSE);
	}

	public void MayorIgu(){
		if ((maquina.getPC()<=maquina.getPC()))
			maquina.insertaPC(JMPascalVM.TRUE);
		
		else
			maquina.insertaPC(JMPascalVM.FALSE);
	}
	
	public void MayorIguReal(){
	}
	
	public void Menor(){
		/* int segundo=maquina.getPC();
		int primero=maquina.getPC();
		if ((primero<segundo)) */
		if ((maquina.getPC()>maquina.getPC()))
			maquina.insertaPC(JMPascalVM.TRUE);
		else
			maquina.insertaPC(JMPascalVM.FALSE);
	}
	
	public void MenorIgu(){
		/* int segundo=maquina.getPC();
		int primero=maquina.getPC();
		if ((primero<=segundo)) */
		if ((maquina.getPC()>=maquina.getPC()))
			maquina.insertaPC(JMPascalVM.TRUE);
		else
			maquina.insertaPC(JMPascalVM.FALSE);
	}
	
	public void MenorIguReal(){
	}
	
	public void Modulo(){
		int segundo=maquina.getPC();
		int primero=maquina.getPC();
		maquina.insertaPC(primero % segundo);
	}
	
	public void ModuloReal(){
		float operando2 = maquina.creaReal(maquina.getPC(),maquina.getPC());
		float operando1 = maquina.creaReal(maquina.getPC(),maquina.getPC());
//	    float modulo = operando1%operando2;
		maquina.cargaReal(operando1%operando2);
	}
	
	public void Negacion(){
		maquina.insertaPC((maquina.getPC()==1)?0:1);
	}
	
	public void Negativo(){
		maquina.insertaPC(-(maquina.getPC()));
	}
	
	public void OcupaEsp(){
		maquina.setRegistro(JMPascalVM.LS,maquina.getRegistro(JMPascalVM.LS)+maquina.getPC());
	}
	
	public void Producto(){
		maquina.insertaPC(maquina.getPC()*maquina.getPC());
	}

	public void ProductoReal(){
		float producto = maquina.creaReal(maquina.getPC(),maquina.getPC())*maquina.creaReal(maquina.getPC(),maquina.getPC());
		maquina.cargaReal(producto);
	}
	
	public void ReservaEsp(){
		maquina.setRegistro(JMPascalVM.PC,maquina.getRegistro(JMPascalVM.PC)-maquina.getCP());
	}
	
	public void Resta(){
		int segundo=maquina.getPC();
		int primero=maquina.getPC();
		maquina.insertaPC(primero-segundo);
	}

	public void RestaReal(){
		float operando2 = maquina.creaReal(maquina.getPC(),maquina.getPC());
		float operando1 = maquina.creaReal(maquina.getPC(),maquina.getPC());
		maquina.cargaReal(operando1-operando2);
	}

	
	public void Suma(){
		maquina.insertaPC(maquina.getPC()+maquina.getPC());
	}
	
	public void SumaReal(){
		float suma = maquina.creaReal(maquina.getPC(),maquina.getPC())+maquina.creaReal(maquina.getPC(),maquina.getPC());
		maquina.cargaReal(suma);
	}
	
/*	public void TamFuncion(){
		
	}
	
	public void TamGlobal(){
		
	} */
	
	public void setAborta(boolean valor){
		this.aborta=valor;
	}
	
	public void ejecuta() throws ErrorEjecucionException{
		boolean fin = false;
		int instruccion=-1;
		int cp=-1;
// Se realiza la reserva de las pseudo funciones
		
		log.anadirLog("Comienzo de la ejecución....");
		
		while (!fin){
			// interpreteViewer.actualizaMemoria();
			if (maquina.getDebug()){
			   interpreteViewer.actualizaMemoria();
			   maquina.permiteAvanzar(true);
			   semDebug.semWait();
			}
			if (aborta)
				throw new ErrorEjecucionException("Ejecución abortada por usuario");
			cp = maquina.getRegistro(JMPascalVM.CP);
			instruccion = maquina.getCP();
			log.anadirLog("    Ejecutando instruccion: " + instruccion + " direccion: " + maquina.getRegistro(JMPascalVM.CP) + "\n");
			switch (instruccion){
				case Sym.prAINDVALOR:
					this.AIndValor();
					break;
				case Sym.prAREAL:
					this.AReal();
					break;
				case Sym.prARESFUNC:
					this.AResFunc();
					break;
				case Sym.prBIFCOND:
					this.BifCond();
					break;
				case Sym.prBIFINCOND:
					this.BifIncond();
					break;
				case Sym.prCCONSTANTE:
					this.CConstante();
					break;
				case Sym.prCCONSTANTEREAL:
					this.CConstanteReal();
					break;
				case Sym.prCDIRGLOBAL:
					this.CDirGlobal();
					break;
				case Sym.prCDIRINTERM:
					this.CDirInterm();
					break;
				case Sym.prCLITERAL:
					this.CLiteral();
					break;
				case Sym.prCDIRLOCAL:
					this.CDirLocal();
					break;
				case Sym.prCINDVALOR:
					this.CIndValor();
					break;
				case Sym.prCONJUNCION:
					this.Conjuncion();
					break;
				case Sym.prCREGISTRO:
					this.CRegistro();
					break;
				case Sym.prDCAMPO:
					this.DCampo();
					break;
				/*case Sym.prDEFLITERAL:
					this.DefLiteral();
					break;*/
				case Sym.prDELEMENTO:
					this.DElemento();
					break;
				case Sym.prDEVOLUCION:
					this.Devolucion();
					break;
				case Sym.prDISTINTO:
					this.Distinto();
					break;
				case Sym.prDIVISION:
					this.Division();
					break;
				case Sym.prDIVISIONREAL:
					this.DivisionReal();
					break;
				case Sym.prDISYUNCION:
					this.Disyuncion();
					break;
				case Sym.prGRABACION:
					this.Grabacion();
					break;
				case Sym.prGRABACIONLITERAL:
					this.GrabacionLiteral();
					break;
				case Sym.prGRABACIONREAL:
					this.GrabacionReal();
					break;
				case Sym.prIGUAL:
					this.Igual();
					break;
				case Sym.prLECTURA:
					this.Lectura();
					break;
				case Sym.prLECTURAREAL:
					this.LecturaReal();
					break;
				case Sym.prLIMITACION:
					this.Limitacion();
					break;
				case Sym.prLLAMADA:
					this.Llamada();
					break;
				case Sym.prMAYOR:
					this.Mayor();
					break;
				case Sym.prMAYORIGU:
					this.MayorIgu();
					break;
				case Sym.prMAYORIGUREAL:
					this.MayorIguReal();
					break;
				case Sym.prMENOR:
					this.Menor();
					break;
				case Sym.prMENORIGU:
					this.MenorIgu();
					break;
				case Sym.prMENORIGUREAL:
					this.MenorIguReal();
					break;
				case Sym.prMODULO:
					this.Modulo();
					break;
				case Sym.prMODULOREAL:
					this.ModuloReal();
					break;
				case Sym.prNEGACION:
					this.Negacion();
					break;
				case Sym.prNEGATIVO:
					this.Negativo();
					break;
				case Sym.prOCUPAESP:
					this.OcupaEsp();
					break;
				case Sym.prPRODUCTO:
					this.Producto();
					break;
				case Sym.prPRODUCTOREAL:
					this.ProductoReal();
					break;
				case Sym.prRESERVAESP:
					this.ReservaEsp();
					break;
				case Sym.prRESTA:
					this.Resta();
					break;
				case Sym.prRESTAREAL:
					this.RestaReal();
					break;
				case Sym.prSUMA:
					this.Suma();
					break;
				case Sym.prSUMAREAL:
					this.SumaReal();
					break;
				/* case Sym.prTAMFUNCION:
					// this.TamFuncion();
					break;
				case Sym.prTAMGLOBAL:
					// this.TamGlobal();
					break; */
			    case Sym.prTERMINACION:
			    	fin = true;
			    	break;
				default: 
					throw new ErrorEjecucionException("La insrucción no es válida o no está implementada: DIR: " + cp + " Instruccion: " + instruccion);
			}
		}
		maquina.finalizaEjecucion();
	}

	public void run(){
		try{
		   ejecuta();
		}catch (ErrorEjecucionException e){
			log.anadirLog("    Finalizó la ejecucion inesperadamente: "+ e.getMessage()+"\n");
			maquina.finalizaEjecucionError(e.getMessage());
		}
	}
}
