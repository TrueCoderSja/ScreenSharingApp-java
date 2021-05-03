package ml.truecoder.screensharer;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JFrame window;
	
	Window() {
		add(new WelcomeScreen());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 200);
	}
	
	public static void main(String args[]) {
		window=new Window();
	}
	
	public static void switchPane(JComponent component) {
		window.setContentPane(component);
		window.revalidate();
	}
}
