
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
public class GUI implements ActionListener{

	JFrame screen;
	JTextArea textarea;
	JScrollPane scrollpane;
	//Menu
	JMenuBar menubar;
	JMenu menuFile,menuEdit,menuFont,menuFontSize,menuStyle;

	//File items
	JMenuItem iNewFile,iOpenFile,iSave,iSaveAs,iExit,iUndo,iRedo,iDark,iBlue,iRose,iDefault;
	//Edit items
	JMenuItem iFontArial, iFontCMS,iFontTMNR, iFontSize8, iFontSize16,iFontSize32;
	
	File_Functions file = new File_Functions(this);
	Format_Functions format = new Format_Functions(this);
	UndoManager um = new UndoManager();
	Edits_Functions edit_function = new Edits_Functions(this);
	Shortcuts shortcut = new Shortcuts(this);
	Themes_Functions theme = new Themes_Functions(this);
	
	public static void main(String[] args) {
		new GUI();
	}
	
	
	public GUI() {
		createScreen();
		createTextArea();
		createMenuBar();
		iMenuFile();
		iMenuEdit();
		iMenuStyle();
		format.font_name ="Arial";
		format.createFont(14);
		theme.changeTheme("White");
		screen.setVisible(true);
	}
	
	// create the app screen an set a image icon
	public void createScreen() {
		screen = new JFrame("Bloco de notas");
		makeFullScreen();
		ImageIcon image = new ImageIcon("images/notepad_icon.png");
		screen.setIconImage(image.getImage());
		screen.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		screen.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e ) {
				int i = JOptionPane.showConfirmDialog(null ,"Term certeza que deseja sair?", "Sair",JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					
				}
			}
		});
		
		
	}
	//just make the application full screen based on the users screen size
	public void makeFullScreen() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screen.setSize(screenSize.width,screenSize.height);
	}
	//creates the text area with no borders
	public void createTextArea() { 
		
		
		textarea = new JTextArea();
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.addKeyListener(shortcut);
		textarea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit()); 
					}
				});
		scrollpane = new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBorder(BorderFactory.createEmptyBorder());
		screen.add(scrollpane);
	}
	//creates a simple menu bar
	public void createMenuBar() {
		menubar = new JMenuBar();
		screen.setJMenuBar(menubar);
		
		
		//creates the menu section
		//File
		menuFile = new JMenu("Arquivo");
		menubar.add(menuFile);
		//Edit
		menuEdit = new JMenu("Editar");
		menubar.add(menuEdit);
		//style
		menuStyle = new JMenu("Estilo");
		menubar.add(menuStyle);
	}
	
	//insert items into the Arquivo section
	public void iMenuFile() {
		
		iNewFile = new JMenuItem("Novo");
		iNewFile.addActionListener(this);
		iNewFile.setActionCommand("Novo");
		
		menuFile.add(iNewFile);
		
		iOpenFile = new JMenuItem("Abrir");
		iOpenFile.addActionListener(this);
		iOpenFile.setActionCommand("Abrir");
		menuFile.add(iOpenFile);
		
		iSave = new JMenuItem("Salvar");
		iSave.addActionListener(this);
		iSave.setActionCommand("Salvar");
		menuFile.add(iSave);
		
		iSaveAs = new JMenuItem("Salvar Como");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("Salvar Como");
		menuFile.add(iSaveAs);
		
		iExit = new JMenuItem("Sair");
		iExit.addActionListener(this);
		iExit.setActionCommand("Sair");
		menuFile.add(iExit);
		
	}
	//insert items into the Editar section
	public void iMenuEdit() {
		iUndo = new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
		
		menuFont = new JMenu("Fonte");
		menuEdit.add(menuFont);
		
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		iFontCMS = new JMenuItem("Comic Sans");
		iFontCMS.addActionListener(this);
		iFontCMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCMS);
		
		iFontTMNR = new JMenuItem("Times New Roman");
		iFontTMNR.addActionListener(this);
		iFontTMNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTMNR);
		
		
		
		
		
		menuFontSize = new JMenu("Tamanho da Fonte");
		menuEdit.add(menuFontSize);
		
		iFontSize8 = new JMenuItem("14");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("14");
		menuFontSize.add(iFontSize8);
		
		iFontSize16 = new JMenuItem("22");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("22");
		menuFontSize.add(iFontSize16);
		
		iFontSize32 = new JMenuItem("32");
		iFontSize32.addActionListener(this);
		iFontSize32.setActionCommand("32");
		menuFontSize.add(iFontSize32);
		
	}
	//insert items into the Estilos section
	public void iMenuStyle() {
		
		iDefault = new JMenuItem("Tema Normal");
		iDefault.addActionListener(this);
		iDefault.setActionCommand("Tema Normal");
		iDark = new JMenuItem("Tema Escuro");
		iDark.addActionListener(this);
		iDark.setActionCommand("Tema Escuro");
		menuStyle.add(iDark);
		
		
		iBlue = new JMenuItem("Tema Azul");
		iBlue.addActionListener(this);
		iBlue.setActionCommand("Tema Azul");
		menuStyle.add(iBlue);
		
		iRose = new JMenuItem("Tema Rose");
		iRose.addActionListener(this);
		iRose.setActionCommand("Tema Rose");
		menuStyle.add(iRose);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		switch(command) {
		case "Novo":
			file.newFile();
			break;
		case "Abrir":
			file.openFile();
			break;
		case "Salvar":
			file.saveFile();
			break;
		case "Salvar Como":
			file.saveFileAs();
			break;
		case "Sair":
			file.exit();
			break;
		case "Undo":
			edit_function.undo();
			break;
		case "Redo":
			edit_function.redo();
			break;
		case "8":
			format.createFont(14);
			break;
		case "16":
			format.createFont(22);
			break;
		case "32":
			format.createFont(32);
			break;
		case "Arial":
			format.setFont(command);
			break;
		case "Comic Sans MS":
			format.setFont(command);
			break;
		case "Times New Roman":
			format.setFont(command);
			break;
		case "Tema Normal":
			theme.changeTheme("White");
			break;
		case "Tema Escuro":
			theme.changeTheme("Dark");
			break;
		case "Tema Azul":
			theme.changeTheme("Blue");
			break;
		case "Tema Rose":
			theme.changeTheme("Rose");
			break;
		
		}
		
	}
	
	}

