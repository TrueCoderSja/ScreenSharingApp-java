package ml.truecoder.screensharer;

import java.awt.AWTException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientListener implements Runnable {
	int port;
	
	ClientListener(int port) {
		this.port=port;
	}
	public void run() {
		ServerSocket server;
		try {
			server = new ServerSocket(port);
			while(true) {
				Socket socket=server.accept();
				Thread screenSharerThread=new Thread(new ScreenSharer(socket));
				screenSharerThread.start();
			}
		} catch (IOException | AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
