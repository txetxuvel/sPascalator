/*
 * Created on 12-may-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package user;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Status extends JPanel {

	private JLabel statusLabel = null;
	/**
	 * This is the default constructor
	 */
	public Status() {
		super();
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private  void initialize() {
		statusLabel = new JLabel();
		this.setLayout(new CardLayout());
		this.setSize(525, 24);
		statusLabel.setText("   Inicializando....");
//		statusLabel.setBounds(4, 4, 517, 16);
		statusLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
		statusLabel.setName("statusLabel");
		this.add(statusLabel, statusLabel.getName());
	}
	
	public void setStatus(String status){
		statusLabel.setText("   " + status);
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
