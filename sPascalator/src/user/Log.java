/*
 * Created on 12-may-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package user;

import java.awt.BorderLayout;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Log extends JPanel {

	private JScrollPane scrollPane = null;
	private JTextPane logText = null;
	
	private JToolBar toolBar = null;
	private JButton bDelete = null;
	private JButton bAppend = null;
	private JButton bSave = null;

	private static final String DIRIMAGES = "images";

	/**
	 * This is the default constructor
	 */
	public Log() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private  void initialize() {
		this.setLayout(new BorderLayout());
		this.setSize(530, 112);
		this.add(getScrollPane(), BorderLayout.CENTER);
		this.add(getToolBar(), BorderLayout.WEST);
	}
	
	private JToolBar getToolBar(){
		if (toolBar==null){
			toolBar = new JToolBar();
			toolBar.setOrientation(JToolBar.VERTICAL);
			toolBar.setFloatable(false);
			toolBar.add(getBDelete());
			toolBar.add(getBAppend());
			toolBar.add(getBSave());
		}
		return toolBar;
	}

	private JButton getBSave() {
		if (bSave == null) {
			bSave = new JButton();
			bSave.setIcon(new ImageIcon(DIRIMAGES + "/save.gif"));
			bSave.setToolTipText("Save Log");
			bSave.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						long tiempo = System.currentTimeMillis();
						FileWriter writer = new FileWriter("log/log"+tiempo);
						writer.write(logText.getText());
						writer.close();
						anadirLog("\n\nEscrito log en el fichero log/log" + tiempo + "\n\n");
					}catch (IOException x){
						System.out.println("Error" + x.getMessage());
					}
					
				}
			});
		}
		return bSave;
	}

	private JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton();
			bDelete.setIcon(new ImageIcon(DIRIMAGES + "/delete.gif"));
			bDelete.setToolTipText("Delete Log");
			bDelete.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cleanLog();
				}
			});
		}
		return bDelete;
	}

	private JButton getBAppend() {
		if (bAppend == null) {
			bAppend = new JButton();
			bAppend.setIcon(new ImageIcon(DIRIMAGES + "/edit.gif"));
			bAppend.setToolTipText("Append Log");
			bAppend.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//saveFile();
				}
			});
		}
		return bAppend;
	}

	private JScrollPane getScrollPane(){
		if (scrollPane==null){
			scrollPane = new JScrollPane();
			scrollPane.setVisible(true);
			scrollPane.getViewport().add(getLogText());
		}
		return scrollPane;
	}

	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */    
	private JTextPane getLogText() {
		if (logText == null) {
			logText = new JTextPane();
			logText.setEditable(false);
			logText.setName("logText");
		}
		return logText;
	}
	
	public void cleanLog(){
		logText.setText("");
	}
	
	public void writeLog(String text){
		cleanLog();
		logText.setText(text);
	}
	
	public void anadirLog(String text){
		logText.setText(logText.getText() + text);
	}
	
	public String getLog(){
		return logText.getText();
	}
	
  }  //  @jve:decl-index=0:visual-constraint="10,10"
