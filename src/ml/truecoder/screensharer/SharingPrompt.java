package ml.truecoder.screensharer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SharingPrompt extends JPanel {
	private static final long serialVersionUID = 1L;

	SharingPrompt() {
		setLayout(new FlowLayout());
		JLabel lbl=new JLabel("Sharing Screen...");
		add(lbl);
		
		JButton stopBtn=new JButton("Stop");
		stopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(stopBtn);
	}
}
