/*
 * Created on 16-may-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package user;

import interprete.JMPascalVM;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

import compilador.ErrorLexicoException;
import compilador.ErrorSemanticoException;
import compilador.ErrorSintacticoException;
import compilador.Lexer;
import compilador.Traductor;

/**
 * @author txetxu
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Screen extends JFrame {

	private Toolkit toolkit = Toolkit.getDefaultToolkit();

	private static final String DIRIMAGES = "images";
	private JPanel mainPane = null;
	private JMenuBar menuBar = null;
	private JMenu menuArchivo = null;
	private JMenu menuEditar = null;
	private JMenu menuAccciones = null;
	private JMenu menuAyuda = null;
	private JMenuItem menuNuevo = null;
	private JMenuItem menuAbrir = null;
	private JMenuItem menuCerrar = null;
	private JMenuItem menuCerrarTodos = null;
	private JMenuItem menuGuardar = null;
	private JMenuItem menuGuardarTodos = null;
	private JMenuItem menuGuardarComo = null;
	private JMenuItem menuExit = null;
	private JMenuItem menuCopiar = null;
	private JMenuItem menuCortar = null;
	private JMenuItem menuPegar = null;
	private JMenuItem menuSeleccionar = null;
	private JMenuItem menuCompilar = null;
	private JMenuItem menuLexer = null; /* ********* */
	private JMenuItem menuAbout = null; /* ********* */

	private JToolBar toolBar = null;
	
	private JButton bNuevo = null;
	private JButton bAbrir = null;
	private JButton bGuardar = null;
	private JButton bGuardarTodos = null;
	private JButton bCerrar = null;
	// private JButton bCloseAll = null;
	private JButton bCopiar = null;
	private JButton bPegar = null;
	private JButton bCortar = null;
	private JButton bCompilar = null;
	private JButton bPlay = null;
	private JButton bStop = null;
	private JToggleButton bDebug = null;
	private JButton bAvanza = null;
	
	private Log logPane = null;
//	private Status statusPane = null;
	
	private JSplitPane editorSplitPane = null;
	private JSplitPane splitPaneVertical = null;

	private VisorInterprete interprete = null;
	private JMPascalVM maquina = null;
	
	private ConjuntoEditores desktop = null;
	private JFileChooser fileChooser = null;
	private int numeroFichero = 0;

	private boolean enEjecucion = false;
	
	private void crearMenu(){
		menuArchivo = new JMenu("Archivo");
		menuArchivo.setMnemonic('A');
		menuEditar = new JMenu("Edición");
		menuEditar.setMnemonic('E');
		menuAccciones = new JMenu("Herramientas");
		menuAccciones.setMnemonic('H');
		menuAyuda = new JMenu("Ayuda");
		menuAccciones.setMnemonic('y');
		menuNuevo = new JMenuItem("Nuevo");
		menuNuevo.setMnemonic('N');
		menuNuevo.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {    
				nuevo();
			}
		});
		menuAbrir = new JMenuItem("Abrir");
		menuAbrir.setMnemonic('A');
		menuAbrir.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				openFile();
			}
		});
		menuCerrar = new JMenuItem("Cerrar");
		menuCerrar.setMnemonic('C');
		menuCerrar.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				cerrar();
			}
		});
		menuCerrarTodos = new JMenuItem("Cerrar todos");
		menuCerrarTodos.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				cerrarTodos();
			}
		});
		menuGuardar = new JMenuItem("Guardar");
		menuGuardar.setMnemonic('G');
		menuGuardar.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				guardar();
			}
		});
		menuGuardarTodos = new JMenuItem("Guardar todos");
		menuGuardarTodos.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				guardarTodos();
			}
		});
		menuGuardarComo = new JMenuItem("Guardar como");
		menuGuardarComo.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				guardarComo();
			}
		});
		menuExit = new JMenuItem("Salir");
		menuExit.setMnemonic('S');
		menuExit.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {    
				salirPrograma();
			}
		});
		menuCopiar = new JMenuItem("Copiar");
//		menuCopy.setMnemonic('C');
		menuCopiar.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				copiar();
			}
		});
		menuCortar = new JMenuItem("Cortar");
		menuCortar.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				cortar();
			}
		});
		menuPegar = new JMenuItem("Pegar");
		menuPegar.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				pegar();
			}
		});
		menuSeleccionar = new JMenuItem("Seleccionar todo");
		menuSeleccionar.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {
				seleccionarTodo();
			}
		});
		menuCompilar = new JMenuItem("Compilar");
		menuCompilar.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {    
				compilar();
			}
		});
		menuLexer = new JMenuItem("Análisis Léxico");
		menuLexer.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {    
				pruebaLexer();
			}
		});
		menuAbout = new JMenuItem("About");
		menuAbout.addActionListener(new java.awt.event.ActionListener() { 
			public void actionPerformed(java.awt.event.ActionEvent e) {    
				// about();
			}
		});

		menuArchivo.add(menuNuevo);
		menuArchivo.add(menuAbrir);
		menuArchivo.add(menuCerrar);
		menuArchivo.add(menuCerrarTodos);
		menuArchivo.addSeparator();
		menuArchivo.add(menuGuardar);
		menuArchivo.add(menuGuardarTodos);
		menuArchivo.add(menuGuardarComo);
		menuArchivo.addSeparator();
		menuArchivo.add(menuExit);
		menuEditar.add(menuCopiar);
		menuEditar.add(menuCortar);
		menuEditar.add(menuPegar);
		menuEditar.add(menuSeleccionar);
		menuAccciones.add(menuCompilar);
		menuAccciones.add(menuLexer);
		menuAyuda.add(menuAbout);
		menuBar.add(menuArchivo);
		menuBar.add(menuEditar);
		menuBar.add(menuAccciones);
		menuBar.add(menuAyuda);
	}

	private JMenuBar getMyMenuBar(){
		if (menuBar == null){
			menuBar = new JMenuBar();
		}
		crearMenu();
		sinFicheros();
		menuBar.setVisible(true);
		return menuBar;
	}

	private JButton getBPlay() {
		if (bPlay == null) {
			bPlay = new JButton();
			bPlay.setIcon(new ImageIcon(DIRIMAGES + "/execute.gif"));
			bPlay.setToolTipText("Ejecutar");
			bPlay.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) { 
				      	ejecuta();
				      	
				}
			});
		}
		return bPlay;
	}

	private JButton getBStop() {
		if (bStop == null) {
			bStop = new JButton();
			bStop.setIcon(new ImageIcon(DIRIMAGES + "/stop.gif"));
			bStop.setToolTipText("Parar");
			bStop.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) { 
				      	parar();
				      	
				}
			});
		}
		return bStop;
	}

	private JToggleButton getBDebug() {
		if (bDebug == null) {
			bDebug = new JToggleButton();
			bDebug.setIcon(new ImageIcon(DIRIMAGES + "/debug.gif"));
			bDebug.setToolTipText("Paso a Paso");
			bDebug.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) { 
				      	maquina.flipDebug();

				}
			});
		}
		return bDebug;
	}

	private JButton getBAvanza() {
		if (bAvanza == null) {
			bAvanza = new JButton();
			bAvanza.setIcon(new ImageIcon(DIRIMAGES + "/step.gif"));
			bAvanza.setToolTipText("Avance");
			bAvanza.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) { 
				    maquina.avanza();
				}
			});
		}
		return bAvanza;
	}
	
	private JButton getBAbrir() {
		if (bAbrir == null) {
			bAbrir = new JButton();
			bAbrir.setIcon(new ImageIcon(DIRIMAGES + "/open.gif"));
			bAbrir.setToolTipText("Abrir");
			bAbrir.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) { 
				      	openFile();
				      	
				}
			});
		}
		return bAbrir;
	}
	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBGuardar() {
		if (bGuardar == null) {
			bGuardar = new JButton();
			bGuardar.setIcon(new ImageIcon(DIRIMAGES + "/save.gif"));
			bGuardar.setToolTipText("Guardar");
			bGuardar.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
					guardar();
				}
			});
		}
		return bGuardar;
	}
	
	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBCompilar() {
		if (bCompilar == null) {
			bCompilar = new JButton();
			bCompilar.setIcon(new ImageIcon(DIRIMAGES + "/compile.gif"));
			bCompilar.setToolTipText("Compilar");
			bCompilar.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e){
					compilar();
				}
			});
		}
		return bCompilar;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBNuevo() {
		if (bNuevo == null) {
			bNuevo = new JButton();
			bNuevo.setIcon(new ImageIcon(DIRIMAGES + "/new.gif"));
			bNuevo.setToolTipText("Nuevo");
			bNuevo.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
					nuevo();
				}
			});
		}
		return bNuevo;
	}

	private JButton getBCerrar() {
		if (bCerrar == null) {
			bCerrar = new JButton();
			bCerrar.setIcon(new ImageIcon(DIRIMAGES + "/close.gif"));
			bCerrar.setToolTipText("Cerrar");
			bCerrar.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					cerrar();
				}
			});
		}
		return bCerrar;
	}
	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBCopiar() {
		if (bCopiar == null) {
			bCopiar = new JButton();
			bCopiar.setIcon(new ImageIcon(DIRIMAGES + "/copy.gif"));
			bCopiar.setToolTipText("Copiar");
			bCopiar.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					copiar();
				}
			});
		}
		return bCopiar;
	}
	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBPegar() {
		if (bPegar == null) {
			bPegar = new JButton();
			bPegar.setIcon(new ImageIcon(DIRIMAGES + "/paste.gif"));
			bPegar.setToolTipText("Pegar");
			bPegar.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					pegar();
				}
			});
		}
		return bPegar;
	}
	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	private JButton getBCortar() {
		if (bCortar == null) {
			bCortar = new JButton();
			bCortar.setIcon(new ImageIcon(DIRIMAGES + "/cut.gif"));
			bCortar.setToolTipText("Cortar");
			bCortar.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cortar();
				}
			});
		}
		return bCortar;
	}

	private JButton getBGuardarTodos() {
		if (bGuardarTodos == null) {
			bGuardarTodos = new JButton();
			bGuardarTodos.setIcon(new ImageIcon(DIRIMAGES + "/saveall.gif"));
			bGuardarTodos.setToolTipText("Guardar todos");
			bGuardarTodos.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					guardarTodos();
				}
			});
		}
		return bGuardarTodos;
	}
	
	/**
	 * This method initializes bCloseAll	
	 * 	
	 * @return javax.swing.JButton	
	 */    
	/* private JButton getBCloseAll() {
		if (bCloseAll == null) {
			bCloseAll = new JButton();
			bCloseAll.setIcon(new ImageIcon(DIRIMAGES + "/close.jpg"));
			bCloseAll.setToolTipText("Cerrar todos");
			bCloseAll.addActionListener(new java.awt.event.ActionListener() { 
				public void actionPerformed(java.awt.event.ActionEvent e) {    
					closeAll();
				}
			});
		}
		return bCloseAll;
	} */

	private JToolBar getToolBar() {
		if (toolBar == null) {
			toolBar = new JToolBar();
//			toolBar.setLocation(0, 0);
			toolBar.setFloatable(false);
			toolBar.addSeparator();
			toolBar.add(getBNuevo());
			toolBar.add(getBAbrir());
			toolBar.add(getBGuardar());
			toolBar.add(getBGuardarTodos());
			toolBar.add(getBCerrar());
			// toolBar.add(getBCloseAll());
			toolBar.addSeparator();
			toolBar.add(getBCortar());
			toolBar.add(getBCopiar());
			toolBar.add(getBPegar());
			toolBar.addSeparator();
			toolBar.add(getBCompilar());
			toolBar.addSeparator();
			toolBar.add(getBPlay());
			toolBar.add(getBStop());
			toolBar.add(getBDebug());
			toolBar.add(getBAvanza());
		}
		return toolBar;
	}

	private Log getLogPane(){
		if (logPane==null){
			logPane=new Log();
			logPane.writeLog("Inicializando Programa....");
		}
		return logPane;
	}
	
	private ConjuntoEditores getDesktop(){
		if (desktop ==null){
			desktop = new ConjuntoEditores(this);
		}
		return desktop;
	}
	
	private JSplitPane getEditorSplitPane() {
		if (editorSplitPane == null) {
			editorSplitPane = new JSplitPane();
			editorSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
			editorSplitPane.setDividerSize(5);
			editorSplitPane.setTopComponent(getDesktop());
			editorSplitPane.setDividerLocation(500);
			editorSplitPane.setBottomComponent(getLogPane());
		}
		return editorSplitPane;
	}

	private JSplitPane getSplitPaneVertical() {
		if (splitPaneVertical == null) {
			splitPaneVertical = new JSplitPane();
			splitPaneVertical.setBounds(3, 38, 787, 513);
			splitPaneVertical.setDividerSize(5);
			splitPaneVertical.setDividerLocation(595);
			splitPaneVertical.setLeftComponent(getEditorSplitPane());
			splitPaneVertical.setRightComponent(getInterpreteViewer());
		}
		return splitPaneVertical;
	}

	private JMPascalVM getMaquina(){
		if (maquina==null){
			maquina = new JMPascalVM(interprete, this);
		}
		return maquina;
	}
	
	private VisorInterprete getInterpreteViewer(){
		if (interprete==null){
			interprete = new VisorInterprete(/*maquina*/);
			interprete.acaba();
		}
		return interprete;
	}
	
	/**
	 * This is the default constructor
	 */
	public Screen() {
		super();
		initialize();
		logPane.anadirLog("  Inicializado\n");
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH); // No es muy estándar así que se quita
		this.setBounds(0,0,1024,768);
		this.setContentPane(getMainPane());
		this.setTitle("JSPascalator");
		this.setMaximizedBounds(new Rectangle(0,0,1024,768));
		fileChooser = new JFileChooser();
		FileFilter bs2FileFilter = new FileFilter(){
            public boolean accept(File f) {
            	if (f.isDirectory())
 				   return true;
                String name = f.getName();
                return (name.endsWith(".pas")
                		|| name.endsWith(".paS")
						|| name.endsWith(".pAs")
						|| name.endsWith(".pAS")
                		|| name.endsWith(".Pas")
						|| name.endsWith(".PaS")
						|| name.endsWith(".PAs")
						|| name.endsWith(".PAS"));
            }
            public String getDescription() {
            	return "Ficheros fuentes sPascal";
            }
        };			
        
		FileFilter asmFileFilter = new FileFilter(){
            public boolean accept(File f) {
            	if (f.isDirectory())
				   return true;
                String name = f.getName();
                return ( name.endsWith(".mps")
						 || name.endsWith(".mpS") 
						 || name.endsWith(".mPs") 
						 || name.endsWith(".mPS")
						 || name.endsWith(".Mps")
						 || name.endsWith(".MpS")
						 || name.endsWith(".MPs")
						 || name.endsWith(".MPS"));
            }
            public String getDescription() {
            	return "Ficheros JMPascal";
            }
        };			
        fileChooser.addChoosableFileFilter(asmFileFilter);
        fileChooser.addChoosableFileFilter(bs2FileFilter);
        fileChooser.setFileHidingEnabled(false);
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setCurrentDirectory(new File("./programas/"));
        
        this.interprete.setMaquina(getMaquina());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getMainPane() {
		if (mainPane == null) {
			mainPane = new JPanel();
			mainPane.setLayout(new java.awt.BorderLayout());
			mainPane.add(getToolBar(), BorderLayout.NORTH);
//			mainPane.add(getStatusPane(), BorderLayout.SOUTH);
			mainPane.add(getSplitPaneVertical(), BorderLayout.CENTER);
			this.setJMenuBar(getMyMenuBar());
		}
		return mainPane;
	}

	public void openFile(){
	   int retVal = fileChooser.showOpenDialog(this);
	   if (retVal == JFileChooser.APPROVE_OPTION){
	   	  try{
	   	  	logPane.anadirLog("Abriendo: " + fileChooser.getSelectedFile().getPath()+"\n");
	   	  	desktop.abrir(fileChooser.getSelectedFile().toURL());
	   	  	logPane.anadirLog("Abierto: " +fileChooser.getSelectedFile().getPath()+"\n");
	   	  }catch (IOException x){
			logPane.anadirLog("\nError abriendo: " + fileChooser.getSelectedFile().getPath());
	   	  }catch (PropertyVetoException x){
	   	  	this.muestraMsg("Ha habido un error al mostrar el documento");
		  }catch (NullPointerException x){
			System.out.println("Error Nullpointer: " + x.getMessage());
		  }
	   }
	}

	private void conFicheros(){
	   bGuardar.setEnabled(true);
	   bGuardarTodos.setEnabled(true);
	   bCerrar.setEnabled(true);
	   // bCloseAll.setEnabled(true);
	   bCopiar.setEnabled(true);
	   bPegar.setEnabled(true);
	   bCortar.setEnabled(true);
	}
	
	private void sinFicheros(){
	   bGuardar.setEnabled(false);
	   bGuardarTodos.setEnabled(false);
	   bCerrar.setEnabled(false);
	   // bCloseAll.setEnabled(false);
	   bCopiar.setEnabled(false);
	   bPegar.setEnabled(false);
	   bCortar.setEnabled(false);
	   bCompilar.setEnabled(false);
	   bPlay.setEnabled(false);
	   bAvanza.setEnabled(false);
	   bStop.setEnabled(false);
	}

	public void ficheroPas(){
	   conFicheros();
	   bCompilar.setEnabled(true);
	   bPlay.setEnabled(false);
	}
		
	public void ficheroMps(){
	   conFicheros();
	   bCompilar.setEnabled(false);
	   bPlay.setEnabled(true);
	}
	
	public void otroFichero(){
	   conFicheros();
	   bCompilar.setEnabled(false);
	   bPlay.setEnabled(false);
	}
		
	public void compilar(){
		String fileName = desktop.getURL().getFile();
		if (fileName.endsWith(".pas") || fileName.endsWith(".paS") || fileName.endsWith(".pAS") || fileName.endsWith(".pAS") || fileName.endsWith(".Pas") || fileName.endsWith(".PaS") || fileName.endsWith(".PAs") || fileName.endsWith(".PAS")){
		   Traductor traductor = new Traductor(fileName);
		   try{
		      traductor.traducir(this.logPane);
		      try{
			     desktop.abrir((new File(fileName.substring(0,fileName.lastIndexOf(".")) + ".mps").toURL()));
   	          }catch (IOException x){
			     logPane.anadirLog("\nError abriendo: " + fileChooser.getSelectedFile().getPath());
		      }catch (PropertyVetoException x){
   	  		   this.muestraMsg("Ha habido un error al mostrar el documento");
		      }
		   }catch (ErrorLexicoException e){
				logPane.anadirLog("  Análisis incorrecto\n\n¡¡¡¡¡ " + e.getMessage() + " !!!\n");
		   }catch (ErrorSintacticoException e){
				logPane.anadirLog("  Análisis incorrecto\n\n¡¡¡¡¡ " + e.getMessage() + " !!!\n");
		   //}catch (InsercionIlegalException e){
				
		   }catch (IOException e){
		   		logPane.anadirLog("  Análisis incorrecto\n\n¡¡¡¡¡ Ha habido un error al procesar el fichero: " + e.getMessage() + " !!!\n");
		   }catch (ErrorSemanticoException e){
				logPane.anadirLog("  Análisis incorrecto\n\n¡¡¡¡¡ " + e.getMessage() + " !!!\n");
		   }catch(Exception e){
				logPane.anadirLog("  Análisis incorrecto\n\n¡¡¡¡¡ El fichero contiene errores indeterminados: " + e.getMessage() + " !!!\n");
				e.printStackTrace();
		   }
		}
		else{
			this.muestraMsg("El fichero no es un fichero .pas");
		}
	}

	public void nuevo(){
		try{
			desktop.nuevo(new File(System.getProperty("user.dir") + "\\New" + numeroFichero + ".bs2").toURL());
			numeroFichero++;
		}catch (PropertyVetoException e){
			muestraMsg("Ha habido un error al mostrar el fichero");
		}catch (IOException x){
			System.out.print("Error IO: ");
			x.printStackTrace();
		}
	}
			
	public boolean cerrar(){
		boolean ret = true;
		if (desktop.countComponents() > 0){
			if (!desktop.isGuardado()){
				switch (pregunta("El fichero no ha sido guardado\nGuardar "+desktop.getTitle()+"?", "Guardar?")){
					case JOptionPane.YES_OPTION: 
						ret = guardar();
					case JOptionPane.NO_OPTION: 
						if (ret){
							desktop.cerrar();
							desktop.repaint();
							break;
						}
					case JOptionPane.CANCEL_OPTION:
						return false;
				}
			}
			else{
				desktop.cerrar();
				desktop.repaint();
			}
		}
		if (desktop.countComponents()==0){
			bGuardar.setEnabled(false);
			bGuardarTodos.setEnabled(false);
			bCerrar.setEnabled(false);
			// bCloseAll.setEnabled(false);
		}
		sinFicheros();
		return true;
	}
			
	public boolean cerrarTodos(){
		boolean ok = true;
		while (ok && desktop.countComponents() > 0)
			ok = cerrar();
		return ok;
	}
			
	private boolean guardar(){
		boolean ret = true;
		try {
	    	if (desktop.isNuevo())
	    		ret = guardarComo();
			else
				if (!desktop.isGuardado())
					desktop.guardar();
					ret = true;
		}catch (IOException x){
			muestraMsg("Ha habido algún error al guardar el fichero");
			return false;
		}
		return ret;
	}
			
	private boolean guardarComo(){
		boolean ret=true;
		int retVal = fileChooser.showSaveDialog(this);
		if (retVal == JFileChooser.APPROVE_OPTION)
			if (fileChooser.getSelectedFile().exists())
				// El fichero ya existe
				switch (pregunta("El fichero existe.\n¿Desea sobreescribir el fichero?", "Fichero existe")){
					case JOptionPane.YES_OPTION:
						try{
							desktop.guardar(fileChooser.getSelectedFile().toURL());
							ret = true;
						}catch (IOException e){
							muestraMsg("Ha habido algún error al guardar el fichero");
							ret = false;
						}
						break;
					case JOptionPane.NO_OPTION:
						ret = guardarComo();
						break;
					case JOptionPane.CANCEL_OPTION:
						ret = false;
						break;
				}
			else
				try{
					desktop.guardar(fileChooser.getSelectedFile().toURL());
					ret = true;
				}catch(IOException e){
					this.muestraMsg("Ha habido algún error al guardar el fichero");
					ret = false;
				}
		else
			ret = false;
		String nombre=fileChooser.getSelectedFile().getName(); 
		if (nombre.endsWith(".pas")
        		|| nombre.endsWith(".paS")
				|| nombre.endsWith(".pAs")
				|| nombre.endsWith(".pAS")
        		|| nombre.endsWith(".Pas")
				|| nombre.endsWith(".PaS")
				|| nombre.endsWith(".PAs")
				|| nombre.endsWith(".PAS"))
		   ficheroPas();
		else
		   if ( nombre.endsWith(".mps")
				 || nombre.endsWith(".mpS") 
				 || nombre.endsWith(".mPs") 
				 || nombre.endsWith(".mPS")
				 || nombre.endsWith(".Mps")
				 || nombre.endsWith(".MpS")
				 || nombre.endsWith(".MPs")
				 || nombre.endsWith(".MPS"))
		      ficheroMps();
		return ret;
	}
	
	private void guardarTodos(){
/*		int previous = editorPane.getSelectedIndex();
		for(int i=0;i<editorVector.size();i++){
			Editor editor = (Editor) editorVector.elementAt(i);
			if (!editor.getSaved()){
				editorPane.setSelectedIndex(i);
				saveFile();
			}
		}
		editorPane.setSelectedIndex(previous);*/
	}
			
	private void cortar(){
		desktop.cortar();
	}

	private void copiar(){
		desktop.copiar();
	}

	private void pegar(){
		desktop.pegar();
	}

	private void seleccionarTodo(){
		desktop.seleccionarTodo();
	}
			
	private int pregunta(String question, String title){
		JOptionPane optionPane=new JOptionPane();
		Object[] options={"Yes","No","Cancel"};
		int ret = optionPane.showOptionDialog(this, question, title,JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
		return ret;
	}
			
	private void muestraMsg(String message){
		JOptionPane optionPane=new JOptionPane();
		optionPane.showMessageDialog(this, message);
	}
			
	private void salirPrograma (){
		if (cerrarTodos())
			System.exit(0);
	}
	
	public void permiteAvanzar(boolean valor){
		this.bAvanza.setEnabled(valor);
	}
	
	private void parar(){
		maquina.aborta();
	}
	
	public void finalizaEjecucion(){
		this.bPlay.setEnabled(true);
		this.bStop.setEnabled(false);
		this.menuArchivo.setEnabled(true);
		this.bAbrir.setEnabled(true);
		this.bNuevo.setEnabled(true);
	}
	
	public void inicializaEjecucion(){
		this.menuArchivo.setEnabled(false);
		this.bAbrir.setEnabled(false);
		this.bNuevo.setEnabled(false);
		if (maquina.getDebug())
			this.bAvanza.setEnabled(false);
		this.bPlay.setEnabled(false);
		this.bStop.setEnabled(true);
	}
	
	private void ejecuta(){
		String fileName = desktop.getURL().getFile();
		if (fileName.endsWith(".mps") || fileName.endsWith(".mpS") || fileName.endsWith(".mPs") || fileName.endsWith(".mPS") || fileName.endsWith(".Mps") || fileName.endsWith(".MpS") || fileName.endsWith(".MPs") || fileName.endsWith(".MPS")){
		   this.inicializaEjecucion();
		   logPane.anadirLog("\nComienza la ejecución de " + fileName + " con el paso a paso "+ ((maquina.getDebug())?"activado":"desactivdo")+"\n");
		   try{
		      maquina.cargaPrograma(logPane,fileName);
		      try{
			     maquina.ejecuta(this.logPane);
		      }catch (Exception e){
//			     e.printStackTrace();
			     interprete.imprime(e.getMessage());
		      }
		   }catch (IOException e){
		      logPane.anadirLog("  Análisis incorrecto\n\n¡¡¡¡¡ Ha habido un error al procesar el fichero: " + e.getMessage() + " !!!\n");
		      this.finalizaEjecucion();
		   }catch (ErrorSintacticoException e){
			  logPane.anadirLog("  Análisis incorrecto\n\n¡¡¡¡¡ " + e.getMessage() + " !!!\n");
		      this.finalizaEjecucion();
		   }catch(Exception e){
			  logPane.anadirLog("  Análisis incorrecto\n\n¡¡¡¡¡ El fichero contiene errores:  " + e.getMessage() + " !!!\n");
		      this.finalizaEjecucion();
		   }
		}
		else{
			this.muestraMsg("El fichero no es un fichero .mps");
		}
	} 
	
 	public static void main(String[] args) {
		Screen spascal2mpascal = new Screen();
		spascal2mpascal.setVisible(true);
	}

/*   *****************    PARA PROBAR EL LEXER  ***/
 	public void pruebaLexer(){
 		try{
 			Lexer lexer = new Lexer(new FileReader(desktop.getURL().getFile()));
 			java_cup.runtime.Symbol symbol = null;
 			logPane.cleanLog();
 			for(symbol = lexer.next_token();symbol.sym!=0;symbol = lexer.next_token()){
 				logPane.anadirLog("\nEncontrado símbolo: " + lexer.yytext() + " (" + symbol.sym + ")" +
 									" en la línea: " + lexer.getLine() +
									" en la columna: " + lexer.getColumn());
 			}
 		}catch (ErrorLexicoException e){
 			logPane.anadirLog("\n" + e.getMessage());
 		}catch (IOException e){
 			logPane.anadirLog("\nSe ha producido un error de entrada salida. Análisis abortado");
 		}catch (Exception e){
 			logPane.anadirLog("\nSe ha producido algún error incontrolado. Análisis abortado");
 		}
 	}
 	/*		Prueba para el tipo enumerado
 	 * ObjetoTipoEnumerado objeto = new ObjetoTipoEnumerado("dias","Tipo Enumerado");
	objeto.insertaEtiqueta("lunes");
	objeto.insertaEtiqueta("martes");
	objeto.insertaEtiqueta("miercoles");
	logPane.appendLog("\nLunes: " + objeto.getValor("lunes"));
	logPane.appendLog("\nMartes: " + objeto.getValor("martes"));
	logPane.appendLog("\nMartes: " + objeto.getValor("martes"));
	logPane.appendLog("\nMiércoles: " + objeto.getValor("miercoles"));
	logPane.appendLog("\nLunes: " + objeto.getValor("lUnEs".toLowerCase())); */
/* *********************************************** */
}  //  @jve:decl-index=0:visual-constraint="10,10"