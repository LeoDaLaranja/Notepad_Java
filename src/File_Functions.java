import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class File_Functions {
	GUI screen;
	String filename;
	String fileaddress;
	
	
	public File_Functions(GUI screen){
		this.screen = screen;
		filename = null;
		fileaddress = null;
	}
	
	
	public void newFile() {
		screen.textarea.setText("");
		screen.screen.setTitle("Novo - Arquivo");
	}
	//open the windows search screen
	public void openFile() {
		FileDialog filedialog = new FileDialog(screen.screen, "Abrir", FileDialog.LOAD);
		filedialog.setVisible(true);
		
		//get the file name
		if(filedialog.getFile() != null) {
			filename = filedialog.getFile();
			fileaddress = filedialog.getDirectory();
			screen.screen.setTitle(filename);	
		}
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(fileaddress+filename));
			
			screen.textarea.setText("");
			String line = null;
			
			while((line = bfr.readLine()) != null) {
				screen.textarea.append(line+"\n");
			}
			bfr.close();
		}catch(Exception e) {
			JOptionPane.showInputDialog("Error", e);
		}
	}
	
	
	
	
	public void saveFile() {
		if(filename == null) {
			saveFileAs();
		}else {
		try {
			FileWriter filewriter = new FileWriter(fileaddress+filename);
			filewriter.write(screen.textarea.getText());
			screen.screen.setTitle(filename);
			filewriter.close();
			
		}catch(Exception e) {
			JOptionPane.showInputDialog("Error: ",e);
		}
		}
	}
	
	
	
	
	public void saveFileAs() {
		FileDialog filedialog = new FileDialog(screen.screen,"Salvar como",FileDialog.SAVE);
		filedialog.setVisible(true);
		
		
		if(filedialog.getFile() != null) {
			filename = filedialog.getFile();
			fileaddress = filedialog.getDirectory();
			screen.screen.setTitle(filename);
		}
		try {
			FileWriter filewriter = new FileWriter(fileaddress+filename+".txt");
			filewriter.write(screen.textarea.getText());
			filewriter.close();
			
		}catch(Exception e) {
			JOptionPane.showInputDialog("Error",e);
		}
	}
	
	
	public void exit() {
		System.exit(0);
		
	}
}
