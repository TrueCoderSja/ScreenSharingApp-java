package ml.truecoder.screensharer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WelcomeScreen extends JPanel {
	private static final long serialVersionUID = 1L;

	WelcomeScreen() {
		setLayout(new BorderLayout());
		JLabel wlcm_lbl=new JLabel("Welcome");
		add(wlcm_lbl, "North");
		
		JPanel fields_panel=new JPanel(new GridLayout(2, 2));
		fields_panel.add(new JLabel("IP(Not required when sharing): "));
		JTextField ip_field=new JTextField();
		fields_panel.add(ip_field);
		
		fields_panel.add(new JLabel("Port: "));
		JTextField port_field=new JTextField();
		fields_panel.add(port_field);
		add(fields_panel);
		
		JPanel btn_panel=new JPanel(new GridLayout(2, 1));
		JButton shareBtn=new JButton("Share Screen");
		shareBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int port=Integer.parseInt(port_field.getText());
				new Thread(new ClientListener(port)).start();
				Window.switchPane(new SharingPrompt());
			}			
		});
		btn_panel.add(shareBtn);
		JButton recieveBtn=new JButton("Recieve Screen");
		recieveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ip=ip_field.getText();
				int port=Integer.parseInt(port_field.getText());
				Window.switchPane(new ScreenReciever(ip, port));
			}
			
		});
		btn_panel.add(recieveBtn);
		add(btn_panel, "South");
		
	}
}
