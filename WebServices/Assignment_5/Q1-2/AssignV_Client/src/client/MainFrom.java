package client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrom extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField inputWords;
	private JTextArea outputWords;

	/**
	 * Create the frame.
	 */
	public MainFrom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton enToFi = new JButton("En to Fi");
		enToFi.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					outputWords.setText(Client.enToFi(inputWords.getText()));
				} catch (Exception e) {
					outputWords.setText(e.getMessage());
				}
			}
		});
		enToFi.setBounds(41, 61, 117, 29);
		panel.add(enToFi);

		JButton FiToEn = new JButton("Fi to En");
		FiToEn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				try {
					outputWords.setText(Client.fiToEn(inputWords.getText()));
				} catch (Exception e) {
					outputWords.setText(e.getMessage());
				}
			}
		});
		FiToEn.setBounds(281, 61, 117, 29);
		panel.add(FiToEn);

		inputWords = new JTextField();
		inputWords.setBounds(6, 21, 438, 28);
		panel.add(inputWords);
		inputWords.setColumns(10);

		outputWords = new JTextArea();
		outputWords.setEditable(false);
		outputWords.setBounds(95, 102, 256, 154);
		outputWords.setLineWrap(true);
		outputWords.setWrapStyleWord(true);
		panel.add(outputWords);
	}
}
