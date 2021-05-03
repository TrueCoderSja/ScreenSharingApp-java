package ml.truecoder.screensharer;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

public class ScreenSharer implements Runnable {
	Socket socket;
	Robot robot;
	ScreenSharer(Socket s) throws AWTException {
		socket=s;
		robot=new Robot();
	}
	public void run() {
		Rectangle rect=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage screenshot=robot.createScreenCapture(rect);
		
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		try {
			ImageIO.write(screenshot, "png", baos);
			byte[] image=baos.toByteArray();
			BufferedOutputStream output=new BufferedOutputStream(socket.getOutputStream());
			output.write(image);
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
