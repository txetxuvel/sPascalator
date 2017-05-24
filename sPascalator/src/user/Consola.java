/*
 * Created on 26-dic-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package user;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import utils.Semaphore;

import interprete.JMPascalVM;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class Consola extends JPanel {

	
	private JTextField lector = null;
	private JTextArea console = null;
	
	private JScrollPane scroll = null;
	
	private ArrayList colaLectura = null;
	
	/* private Semaphore semaforo = null; */
	private JMPascalVM maquina = null;
	
	/**
	 * This method initializes 
	 * 
	 */
	public Consola(/*JMPascalVM maquina/*, utils.Semaphore semaforo*/) {
		super();
		initialize();
		/* this.semaforo = semaforo; */
		/* this.maquina = maquina; */
	}
	
	public void setMaquina(JMPascalVM maquina){
		this.maquina = maquina;
	}
	
	/* public Semaphore getSemaforo(){
		return semaforo;
	}*/
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		colaLectura=new ArrayList();
        this.setLayout(new BorderLayout());
        // this.setSize(700,700);
        this.add(getLector(), java.awt.BorderLayout.SOUTH);
        this.add(getConsole(), java.awt.BorderLayout.CENTER);
			
	}
	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */    
	private JTextField getLector() {
		if (lector == null) {
			lector = new JTextField();
			lector.setBackground(java.awt.Color.black);
			lector.setForeground(java.awt.Color.white);
			lector.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 10));
			lector.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					leeConsola();
					//lector.set(false);
				}
			});
		}
		return lector;
	}
	
	/**
	 * This method initializes jTextArea1	
	 * 	
	 * @return javax.swing.JTextArea	
	 */    
	private JScrollPane getConsole() {
		if (console == null) {
			console = new JTextArea();
			console.setAutoscrolls(true);
			console.setBackground(java.awt.Color.black);
			console.setForeground(java.awt.Color.white);
			console.setRows(29);
			console.setEditable(false);
			console.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 10));
			scroll = new JScrollPane(console);
		}
		return scroll;
	}
	
	private void encola(String cadena){
		String[] valores = cadena.split("[ \t\n\r]+");
		for(int i=0;i<valores.length;i++){
			// console.setText(console.getText()+"\n" + valores[i]+"\n");
			colaLectura.add(valores[i]);
			maquina.semSignal();
		}
	}
	
	public String leeConsola(){
		String leido = lector.getText(); 
		console.setText(console.getText()+leido+"\n");
		lector.setText("");
		encola(leido);
		return leido;
	}
	
	public String lee(){
/*		if (colaLectura.size()==0){
		try{ */
		maquina.semIOWait();
		/*}catch (InterruptedException e){
		}
		//} */
		String aux = (String) colaLectura.get(0);
		colaLectura.remove(0);
		return aux;
	}
	
	public void escribe(String cadena){
		console.setText(console.getText()+cadena);
//****		this.scroll.setViewport(new JView);
	}
	
	public void comienza(){
		lector.setEnabled(true);
	}

	public void acaba(){
		lector.setEnabled(false);
		colaLectura.clear();
	}
	
  }  //  @jve:decl-index=0:visual-constraint="10,10"
