/*
 * Created on 04-ene-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package user;

import interprete.JMPascalVM;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class VisorRegistros extends JPanel{
	
	private JMPascalVM maquina = null;
	
	private DefaultTableModel modelo = null;
	private JTable registros = null;
	
	/**
	 * This method initializes 
	 * 
	 */
	public VisorRegistros() {
		super();
		initialize();
	}

	public JTable getRegistros(){
		if (registros==null){
			String[][] datos={{"CP"," --","BG"," --"},{"PC"," --","BL"," --"},{"LS"," --"," --"," --"}};
			String[] cabeceras={"REGISTRO","VALOR","REGISTRO","VALOR"};
			modelo = new DefaultTableModel(datos,cabeceras);
			registros = new JTable (modelo);
			registros.setEnabled(false);
			/* modelo.setColumnIdentifiers(cabeceras);
			modelo.setValueAt("CP",0,0);
			modelo.setValueAt("PC",1,0);
			modelo.setValueAt("BG",0,2);
			modelo.setValueAt("BL",1,2);
			modelo.setValueAt("LS",2,0); */
			// muestraDisabled();
		}
		return registros;
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        this.setLayout(new BorderLayout());
        this.setSize(271, 186);
        this.add(getRegistros(), java.awt.BorderLayout.CENTER);
	}

	private void muestraDisabled(){
		modelo.setValueAt(" -- ",0,1);
		modelo.setValueAt(" -- ",1,1);
		modelo.setValueAt(" -- ",0,3);
		modelo.setValueAt(" -- ",1,3);
		modelo.setValueAt(" -- ",2,1);
		modelo.setValueAt(" -- ",2,2);
		modelo.setValueAt(" -- ",2,3);
	}
	
	public void muestra(){
		modelo.setValueAt("" + maquina.getRegistro(JMPascalVM.CP),0,1);
		modelo.setValueAt("" + maquina.getRegistro(JMPascalVM.PC),1,1);
		modelo.setValueAt("" + maquina.getRegistro(JMPascalVM.BG),0,3);
		modelo.setValueAt("" + maquina.getRegistro(JMPascalVM.BL),1,3);
		modelo.setValueAt("" + maquina.getRegistro(JMPascalVM.LS),2,1);
	}
	
	private void setMaquina(JMPascalVM maquina){
		this.maquina = maquina;
	}
	
	private void unsetMaquina(){
		maquina = null;
	}
	
	public void comienza(JMPascalVM maquina){
		setMaquina(maquina);
		muestra();
	}
	
	public void acaba(){
		unsetMaquina();
		muestraDisabled();
	}

 }  //  @jve:decl-index=0:visual-constraint="10,10"
