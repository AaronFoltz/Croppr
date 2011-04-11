import javax.swing.*;
/**
 * <<Class summary>>
 *
 * @author Aaron Foltz
 * @version 1
 */
public final class RootLauncher {
	
	
	public static void main(String[] args) {
		
		try {
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Croppr");
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch ( ClassNotFoundException e) { 
			e.printStackTrace();
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();	
		}
		
		new RootGUI();
	}

}
