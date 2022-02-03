
public class Edits_Functions {
	GUI screen;
	public Edits_Functions(GUI screen) {
		this.screen = screen;
	}

	public void undo() {
		screen.um.undo();
	}
	public void redo() {
		screen.um.redo();
	}

}


