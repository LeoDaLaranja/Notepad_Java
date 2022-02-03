import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Shortcuts implements KeyListener {
	
	GUI screen;
	
	public Shortcuts(GUI screen) {
		this.screen = screen;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//CRTL Methods
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) {
			screen.file.saveFile();
		}
		if(e.isControlDown() && e.isShiftDown() && e.getKeyCode()==KeyEvent.VK_S) {
			screen.file.saveFileAs();
		}
		if(e.isControlDown() && e.isShiftDown() && e.getKeyCode()==KeyEvent.VK_N) {
			screen.file.newFile();
		}
		
		//Alt Methods
		if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_F) {
			screen.menuFile.doClick();
		}
		if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_E) {
			screen.menuEdit.doClick();
		}
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
