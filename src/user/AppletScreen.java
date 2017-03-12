/*
 * Created on 19-mar-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package user;

import javax.swing.JApplet;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AppletScreen extends JApplet {

	private Screen screen = null;
	
	public AppletScreen(){
		screen = new Screen();
		screen.setVisible(true);
		this.getContentPane().add(screen);
	}
	
	public static void main(String[] args) {
		AppletScreen spascal2mpascal = new AppletScreen();
		spascal2mpascal.setVisible(true);
	}
}
