/*
 * Created on 16-may-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package user;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URL;

import javax.swing.JDesktopPane;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ConjuntoEditores extends JDesktopPane {

	private int i = 0;
	private int x = 0;
	private int y = 0;
	
	private Screen screen = null;
	
	/**
	 * This is the default constructor
	 */
	public ConjuntoEditores(Screen screen) {
		super();
		initialize();
		this.screen = screen;
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private  void initialize() {
//		this.setSize(300,200);
	}
	
	public void nuevo(URL url) throws IOException, PropertyVetoException{
		Editor editor = new Editor("New" + i++ + ".pas",true,false,true,true, url, true, x, y, screen);
		this.add(editor);
		editor.setSelected(true);
		x+=20;
		y+=20;
	}
	
	public void abrir(URL url) throws IOException, PropertyVetoException{
		Editor editor = new Editor(url.getFile(),true,false,true,true, url, false, x, y, screen);
		this.add(editor);
		editor.setSelected(true);
		x+=20;
		y+=20;
	}
	
	public String getTitle(){
		return this.getSelectedFrame().getTitle();
	}
	
	public boolean isGuardado(){
		Editor editor = (Editor)this.getSelectedFrame();
		return (editor.getSaved());
	}

	public boolean isNuevo(){
		Editor editor = (Editor)this.getSelectedFrame();
		return (editor.getNew());
	}

	public void cerrar(){
		this.getSelectedFrame().dispose();
		if (this.countComponents() > 0)
			this.setSelectedFrame(this.getAllFrames()[0]);
		else{ 
			this.setSelectedFrame(null);
			x=0;
			y=0;
		}
	}
	
	public void guardar(URL u) throws IOException{
		Editor editor = (Editor) this.getSelectedFrame();
		editor.saveFile(u);
	}

	public void guardar() throws IOException{
		Editor editor = (Editor) this.getSelectedFrame();
		editor.saveFile();
	}

	public void copiar(){
		Editor editor = (Editor) this.getSelectedFrame();
		editor.copy();
	}

	public void cortar(){
		Editor editor = (Editor) this.getSelectedFrame();
		editor.cut();
	}

	public void pegar(){
		Editor editor = (Editor) this.getSelectedFrame();
		editor.paste();
	}
	
	public void seleccionarTodo(){
		Editor editor = (Editor) this.getSelectedFrame();
		editor.selectAll();
	}

	public URL getURL(){
		Editor editor = (Editor) this.getSelectedFrame();
		return editor.getURL();
	}
}
