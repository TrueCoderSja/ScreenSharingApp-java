package ml.truecoder.screensharer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ScreenReciever extends JPanel {
	private static final long serialVersionUID = 1L;
	String ip;
	int port;
	BufferedImage recievedScreenshot;
	ScreenReciever(String ip, int port) {
		this.ip=ip;
		this.port=port;
	}
	
	public void paintComponent(Graphics g) {
		Thread recieverThread=new Thread(new ActualReciever());
		recieverThread.start();
		try {
			recieverThread.join();
			g.drawImage(recievedScreenshot, 0, 0, getWidth(), getHeight(), null);
			repaint();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class ActualReciever implements Runnable {

		public void run() {
			try {
				Socket socket=new Socket(ip, port);
				BufferedImage screenshot=ImageIO.read(socket.getInputStream());
				recievedScreenshot=screenshot;
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
