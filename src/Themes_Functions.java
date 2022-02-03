import java.awt.Color;

public class Themes_Functions {
	GUI screen;
	Themes_Functions(GUI screen){
		this.screen = screen;
	}
	
	public void changeTheme(String color) {
		switch(color) {
		case "White":
			screen.screen.getContentPane().setBackground(Color.white);
			screen.textarea.setBackground(Color.white);
			screen.textarea.setForeground(Color.black);
			break;
		case "Dark":
			screen.screen.getContentPane().setBackground(Color.black);
			screen.textarea.setBackground(Color.black);
			screen.textarea.setForeground(Color.white);
			break;
		case "Blue":
			screen.screen.getContentPane().setBackground(Color.blue);
			screen.textarea.setBackground(Color.blue);
			screen.textarea.setForeground(Color.white);
			break;
		case "Rose":
			screen.screen.getContentPane().setBackground(Color.pink);
			screen.textarea.setBackground(Color.pink);
			screen.textarea.setForeground(Color.white);
			break;
		}
		
	}
}
