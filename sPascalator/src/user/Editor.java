/*
 * Created on 03-mar-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package user;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;

import utils.NoWrapLineNumberedEditorPane;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Editor extends JInternalFrame {
	
//	private JEditorPane editor=null;
	private NoWrapLineNumberedEditorPane editor=null;
	private JScrollPane scrollPane=null;
	
	private URL url = null;
	private boolean isSaved;
	private boolean isNew;
	private String status = "";
	
	private Screen screen = null;
	
	public Editor(String name, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable, URL u, boolean n, int x, int y, Screen screen) throws IOException{
		super(name,resizable,closable,maximizable,iconifiable);
		this.setLocation(x,y);
		this.url = u;
		this.isSaved=true;
		this.isNew=n;
		initialize();
		this.screen = screen;
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private  void initialize() throws IOException{
		this.setVisible(true);
		this.setSize(400,300);

		this.getContentPane().add(getScrollPane());
		this.setAutoscrolls(true);
		this.addMouseListener(new java.awt.event.MouseAdapter() {   
			public void mouseExited(java.awt.event.MouseEvent e) {    
				// System.out.println("mouseExited()"); // TODO Auto-generated Event stub mouseExited()
				editor.repaint();
			} 
			public void mouseEntered(java.awt.event.MouseEvent e) {    
				// System.out.println("mouseEntered()"); // TODO Auto-generated Event stub mouseEntered()
				editor.repaint();
			}
		});
		this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() { 
			public void internalFrameActivated(javax.swing.event.InternalFrameEvent e) {    
				// System.out.println("internalFrameActivated()"); // TODO Auto-generated Event stub internalFrameActivated()
				actualizaScreen();
			}
		});
	}
	
	private JScrollPane getScrollPane() throws IOException{
		if (scrollPane==null){
			scrollPane = new JScrollPane(getEditor());
			scrollPane.setVisible(true);
			scrollPane.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {   
				public void mouseMoved(java.awt.event.MouseEvent e) {    
//					System.out.println("mouseMoved()"); // TODO Auto-generated Event stub mouseMoved()
					editor.repaint();
				}
			});
		}
		return scrollPane;
	}
	
	private JEditorPane getEditor() throws IOException{
		if(editor == null) {
			editor = new NoWrapLineNumberedEditorPane();
//	        editor.setEditorKit(new NumberedEditorKit());
			if (isNew){
				editor.setText("");
			}
			else{
				editor.setPage(url);
			}
		}
		editor.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {   
			public void mouseDragged(java.awt.event.MouseEvent e) {    
				// System.out.println("mouseDragged()"); // TODO Auto-generated Event stub mouseDragged()
				editor.repaint();
			} 
			public void mouseMoved(java.awt.event.MouseEvent e) {    
				// System.out.println("mouseMoved()"); // TODO Auto-generated Event stub mouseMoved()
				editor.repaint();
			}
		});
/*		editor.addInputMethodListener(new java.awt.event.InputMethodListener() { 
			public void inputMethodTextChanged(java.awt.event.InputMethodEvent e) {    
				System.out.println("inputMethodTextChanged()"); // TODO Auto-generated Event stub inputMethodTextChanged()
				setSaved(false);
			}
			public void caretPositionChanged(java.awt.event.InputMethodEvent e) {} 
		}); */
		editor.addKeyListener(new java.awt.event.KeyAdapter() { 
			public void keyTyped(java.awt.event.KeyEvent e) {    
				setSaved(false);
			}
		});
		return editor;
	}
	
	/**
	 * This method initializes jEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */    

	
	/*	public void setName(String name){
	 this.filename = name;
	 }
	 
	 public String getName(){
	 return this.filename;
	 } */
	
	public void setURL(URL u){
		this.url = u;
	}
	
	public URL getURL(){
		return url;
	} 
	
	private void actualizaScreen(){
		if (getTitle().endsWith(".pas") || getTitle().endsWith(".paS") || getTitle().endsWith(".pAs") || getTitle().endsWith(".pAS") || getTitle().endsWith(".Pas") || getTitle().endsWith(".PaS") || getTitle().endsWith(".PAs") || getTitle().endsWith(".PAS"))
			screen.ficheroPas();
		else
		   if (getTitle().endsWith(".mps") || getTitle().endsWith(".mpS") || getTitle().endsWith(".mPs") || getTitle().endsWith(".mPS") || getTitle().endsWith(".Mps") || getTitle().endsWith(".MpS") || getTitle().endsWith(".MPs") || getTitle().endsWith(".MPS"))
		   	  screen.ficheroMps();
		   else
		   	  screen.otroFichero();
	}
	
	public void setSaved(boolean value){
		this.isSaved = value;
	}
	
	public boolean getSaved(){
		return this.isSaved;
	}
	
	public void setNew(boolean value){
		this.isNew = value;
	}
	
	public boolean getNew(){
		return this.isNew;
	}
	
	public final void copy(){
		this.editor.copy();
	}
	
	public final void cut(){
		this.editor.cut();
	}
	
	public final void paste(){
		this.editor.paste();
	}
	
	public final void selectAll(){
		editor.selectAll();
	}
	
	public final void setSatus(String string){
		this.status = string;
	}
	
	public final String getSatus(){
		return this.status;
	}

	public void saveFile() throws IOException{
		FileWriter writer = new FileWriter(url.getFile());
		writer.write(editor.getText());
		writer.close();
		setSaved(true);
		setNew(false);
	}

	public void saveFile(URL u) throws IOException{
		FileWriter writer = new FileWriter(u.getFile());
		writer.write(editor.getText());
		writer.close();
		setURL(u);
		this.setTitle(u.getFile());
		setSaved(true);
		setNew(false);
	}

}
