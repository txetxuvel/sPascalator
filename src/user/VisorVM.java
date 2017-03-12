/*
 * Created on 04-ene-2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package user;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import interprete.JMPascalVM;


/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class VisorVM extends JPanel{
	
	private VisorMemoria memoryViewer = null;
//	private StackViewer stackViewer = null;
	private VisorRegistros recordViewer = null;

	/**
	 * This method initializes 
	 * 
	 */
	public VisorVM() {
		super();
		initialize();
	}

	public void acaba(){
		memoryViewer.acaba();
		recordViewer.acaba();
	}
	
	public void comienza(JMPascalVM maquina){
		memoryViewer.comienza(maquina);
		recordViewer.comienza(maquina);
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
        this.setLayout(new BorderLayout());
        //this.setSize(192, 187);
        this.add(getRecordViewer(), java.awt.BorderLayout.SOUTH);
		this.add(getMemoryViewer(), java.awt.BorderLayout.NORTH);
//		this.add(getStackViewer(), java.awt.BorderLayout.CENTER);
	}

	/* private StackViewer getStackViewer() {
		if (stackViewer == null) {
			stackViewer = new StackViewer();
		}
		return stackViewer;
	} */

	private VisorRegistros getRecordViewer() {
		if (recordViewer == null) {
			recordViewer = new VisorRegistros();
		}
		return recordViewer;
	}

	private VisorMemoria getMemoryViewer() {
		if (memoryViewer == null) {
			memoryViewer = new VisorMemoria();
		}
		return memoryViewer;
	}

	public void actualiza(){
		memoryViewer.muestra();
		recordViewer.muestra();
	}
}
