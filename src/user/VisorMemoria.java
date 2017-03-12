/*
 * Created on 26-dic-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package user;

import interprete.JMPascalVM;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import utils.PrintfFormat;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class VisorMemoria extends JPanel{

	private int inicio = 0;
	
	private JTextArea dirInf = null;
	private JTextArea dirSup = null;
	private JTextArea visor = null;
	private JPanel control = null;
	private JButton anterior = null;
	private JButton siguiente = null;
	private JTextField ir = null;
	private JMPascalVM maquina = null;
	
	private static final int NUMCOLUMNAS = 10;
	private static final int NUMFILAS = 10;

	/**
	 * This method initializes 
	 * 
	 */
	public VisorMemoria() {
		super();
		initialize();
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        this.setLayout(new BorderLayout());
        this.setSize(192, 187);
        this.add(getDirInf(), java.awt.BorderLayout.NORTH);
        this.add(getDirSup(), java.awt.BorderLayout.WEST);
        this.add(getVisor(), java.awt.BorderLayout.CENTER);
        this.add(getControl(), java.awt.BorderLayout.SOUTH);
        muestraDisabled();
	}

	public JTextArea getVisor(){
		if (visor==null){
			visor = new JTextArea();
			visor.setAutoscrolls(false);
			visor.setRows(NUMCOLUMNAS);
			visor.setBackground(new java.awt.Color(237,239,81));
			visor.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 10));
			//visor.setText("8190 0865 0546 9484 8190 0865 0546 9484 0345 2543\n8190 6543 0865 0546 9484 8190 0865 0546 9484 0034\n8190 6543 0865 0546 9484 8190 0865 0546 9484 0034\n8190 6543 0865 0546 9484 8190 0865 0546 9484 0034\n8190 6543 0865 0546 9484 8190 0865 0546 9484 0034\n8190 6543 0865 0546 9484 8190 0865 0546 9484 0034\n8190 6543 0865 0546 9484 8190 0865 0546 9484 0034\n8190 6543 0865 0546 9484 8190 0865 0546 9484 0034\n8190 6543 0865 0546 9484 8190 0865 0546 9484 0034\n8190 6543 0865 0546 9484 8190 0865 0546 9484 0034");
			visor.setEditable(false);
		}
		return visor;
	}
	
	public JPanel getControl(){
		if (control == null){
			control=new JPanel();
	        control.setLayout(new BorderLayout());
	        control.add(getIr(), java.awt.BorderLayout.CENTER);
	        control.add(getSiguiente(), java.awt.BorderLayout.EAST);
	        control.add(getAnterior(), java.awt.BorderLayout.WEST);
		}
		return control;
	}
	
	public JTextArea getDirInf(){
		if (dirInf==null){
			dirInf = new JTextArea();
			dirInf.setAutoscrolls(false);
			dirInf.setText("Dir              0           1           2           3           4           5           6           7           8           9");
			dirInf.setBackground(java.awt.Color.orange);
			dirInf.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 10));
			dirInf.setEditable(false);
		}
		return dirInf;
	}

	public JTextArea getDirSup(){
		if (dirSup==null){
			dirSup = new JTextArea();
			dirSup.setAutoscrolls(false);
			dirSup.setColumns(3);
			dirSup.setText("000\n002\n003\n004\n005\n006\n006\n007\n008\n009");
			dirSup.setBackground(java.awt.Color.orange);
			dirSup.setFont(new java.awt.Font("Dialog", java.awt.Font.BOLD, 10));
			dirSup.setEditable(false);
		}
		return dirSup;
	}
	
	private JTextField getIr(){
		if (ir==null){
			ir = new JTextField("Indique una direccion");
			ir.addFocusListener(new java.awt.event.FocusAdapter() {   
				public void focusLost(java.awt.event.FocusEvent e) {    
					ir.setText("Indique una direccion");
				} 
				public void focusGained(java.awt.event.FocusEvent e) {    
					ir.setText("");
				}
			});
			ir.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					cargaDireccion();
				}
			});
		}
		return ir;
	}
	
	private void cargaDireccion(){
		try{
			// comprobar limites
			int valor=(new Integer(this.ir.getText())).intValue();
			if (valor < 0)
				inicio = 0;
			else
				if ((valor+NUMFILAS * NUMCOLUMNAS)<(JMPascalVM.TAMMEMORIA))
					inicio=valor - valor % 10;
				else{
					inicio=JMPascalVM.TAMMEMORIA - (NUMFILAS*NUMCOLUMNAS);
					inicio=inicio - inicio % 10 + NUMCOLUMNAS;
				}
			ir.setText("Indique una direccion");
			muestra();
		}
		catch(NumberFormatException e){
			System.out.println("No has metido un entero");
		}
	}
	
	private void cargaSiguiente(){
		if ((inicio+NUMFILAS * NUMCOLUMNAS)<(JMPascalVM.TAMMEMORIA)){
		   inicio+=NUMFILAS;
		   muestra();
		}
	}

	private void cargaAnterior(){
		if ((inicio>0)){
			inicio-=NUMFILAS;
			muestra();
		}
	}

	private void muestraDisabled(){
		inicio=0;
		dirSup.setText("");
		visor.setText("");
		int fin=inicio + NUMCOLUMNAS * NUMFILAS;
		for (int i=inicio;i<fin;){
			   dirSup.setText(dirSup.getText()+(new PrintfFormat(" %03d ").sprintf((i+1)/10)));
			   for(int j=0;j<NUMCOLUMNAS;j++,i++){
			   	  visor.setText(visor.getText()+(new PrintfFormat("%06d ").sprintf(0)));
			   }
			   if (i!=fin){
				   dirSup.setText(dirSup.getText()+"\n");
			   	   visor.setText(visor.getText()+"\n");
			   }
			}
	}

	public void muestra(){
		dirSup.setText("");
		visor.setText("");
		int fin=inicio + NUMCOLUMNAS * NUMFILAS;
		for (int i=inicio;i<fin;){
			   dirSup.setText(dirSup.getText()+(new PrintfFormat(" %03d ").sprintf((i+1)/10)));
		   for(int j=0;j<NUMCOLUMNAS;j++,i++){
		   	  if (i < JMPascalVM.TAMMEMORIA && i >= 0 )
			   	  visor.setText(visor.getText()+(new PrintfFormat("%06d ").sprintf(maquina.getPosMemoria(i))));
		   	  else
			   	  visor.setText(visor.getText()+"         --  ");
		   	  // visor.setText(visor.getText()+"1111 ");
		   }
		   if (i!=fin){
			   dirSup.setText(dirSup.getText()+"\n");
		   	   visor.setText(visor.getText()+"\n");
		   }
		}
	}
	
	private JButton getSiguiente(){
		if (siguiente==null){
			siguiente = new JButton("->");
			siguiente.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cargaSiguiente();
				}
			});
		}
		return siguiente;
	}

	private JButton getAnterior(){
		if (anterior==null){
			anterior = new JButton("<-");
			anterior.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					cargaAnterior();
				}
			});
		}
		return anterior;
	}
	
	private void setMaquina(JMPascalVM maquina){
		this.maquina = maquina;
	}
	
	private void unsetMaquina(){
		maquina = null;
	}
	
	public void comienza(JMPascalVM maquina){
		anterior.setEnabled(true);
		siguiente.setEnabled(true);
		ir.setEnabled(true);
		inicio=0;
		setMaquina(maquina);
		muestra();
	}
	
	public void acaba(){
		unsetMaquina();
		anterior.setEnabled(false);
		siguiente.setEnabled(false);
		ir.setEnabled(false);
		muestraDisabled();
	}
	
}
