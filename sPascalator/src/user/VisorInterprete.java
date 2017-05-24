/*
 * Created on 18-dic-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package user;

import interprete.JMPascalVM;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import interprete.ErrorEjecucionException;

// import utils.Semaphore;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class VisorInterprete extends JPanel {

	private Consola console = null;
	private VisorVM viewer = null;
	
	private JMPascalVM maquina = null;
	
	private JScrollPane scroll = null;
	
	public VisorInterprete(/*JMPascalVM maquina*/){
		super();
		initialize();
		//this.maquina = maquina;
	}
	
	private Consola getConsole() {
		if (console == null) {
			console = new Consola(/*maquina*/);
		//	scroll = new JScrollPane(console);
		}
		return console;
	}
	
	public void setMaquina(JMPascalVM maquina){
		this.maquina = maquina;
		console.setMaquina(maquina);
	}

	public static void main(String[] args) {
	}

   	/**
	 * This is the default constructor
	 */
/*	public VisorInterprete() {
		super();
		initialize();
	} */

	public String lee () throws ErrorEjecucionException{
		return console.lee();
	}
	
	public void comienza(JMPascalVM maquina){
		console.comienza();
		viewer.comienza(maquina);
	}
	
	public void acaba(){
		console.acaba();
		viewer.acaba();
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private  void initialize() {
		this.setLayout(new BorderLayout());
		//this.setSize(262, 350);
//		this.add(getConsole(), java.awt.BorderLayout.SOUTH);
		this.add(getConsole(), java.awt.BorderLayout.CENTER);
		this.add(getViewer(), java.awt.BorderLayout.NORTH);
		//this.setComponentZOrder(console,1);
		//this.setComponentZOrder(viewer,0);
		/* this.add(getConsole(), java.awt.BorderLayout.NORTH);
		this.add(getViewer(), java.awt.BorderLayout.SOUTH); */
	}
	
	public void actualizaMemoria(){
		viewer.actualiza();
	}
	
	public VisorVM getViewer(){
		if (viewer == null) {
			viewer = new VisorVM();
		}
		return viewer;
	}
	
	public void imprime(String cadena){
		console.escribe(cadena);
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
