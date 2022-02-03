
import java.awt.Font;

public class Format_Functions {
	GUI screen;
	Font arial, comicSans, timesNewRoman;
	String font_name;
	
	public Format_Functions(GUI screen) {
		this.screen = screen;
	}
	

	
	
	public void createFont(int fsize) {
		arial = new Font("Arial",Font.PLAIN,fsize);
		comicSans = new Font("Comic Sans MS",Font.PLAIN, fsize);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN,fsize);
		
		setFont(font_name);
	}
	public void setFont(String font) {
		font_name = font;
		
		switch(font_name) {
		case "Arial":
			screen.textarea.setFont(arial);
			break;
		case "Comic Sans MS":
			screen.textarea.setFont(comicSans);
			break;
		case "Times New Roman":
			screen.textarea.setFont(timesNewRoman);
			break;
		}
	}

}
