package client;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainForm extends JFrame {

	private static final long serialVersionUID = 8233724077285094264L;
	private JPanel contentPane;
	private JList listRemoteFiles;
	private JList listLocalFiles;
	private JButton addLocalFile;
	private JButton removeLocalFile;
	private JButton uploadLocalFile;
	private DefaultListModel listModelLocal;
	private DefaultListModel listModelRemote;
	private Client wsClient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainForm() {

		wsClient = new Client();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		listModelRemote = new DefaultListModel();
		listRemoteFiles = new JList(listModelRemote);
		listRemoteFiles.setBounds(283, 28, 148, 160);
		contentPane.add(listRemoteFiles);

		listModelLocal = new DefaultListModel();
		listLocalFiles = new JList(listModelLocal);
		listLocalFiles.setBounds(32, 28, 148, 160);
		contentPane.add(listLocalFiles);

		addLocalFile = new JButton("+");
		addLocalFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(MainForm.this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					listModelLocal.addElement(new ShowFile(file.getName(), file
							.getPath()));
				}
			}
		});
		addLocalFile.setBounds(180, 80, 50, 30);
		contentPane.add(addLocalFile);

		removeLocalFile = new JButton("-");
		removeLocalFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while (listLocalFiles.getSelectedIndices().length != 0) {
					listModelLocal.remove(listLocalFiles.getSelectedIndices()[0]);
				}
			}
		});
		removeLocalFile.setBounds(180, 111, 50, 30);
		contentPane.add(removeLocalFile);

		uploadLocalFile = new JButton("Upload >>");
		uploadLocalFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] listSelected = listLocalFiles.getSelectedIndices();
				Vector<ShowFile> listFiles = new Vector<ShowFile>();
				for (int i : listSelected)
					listFiles.add((ShowFile) listModelLocal.getElementAt(i));

				wsClient.putFiles(listFiles);
				refreshRemoteFiles();
			}
		});
		uploadLocalFile.setBounds(50, 200, 102, 30);
		contentPane.add(uploadLocalFile);

		JLabel lblLocalFiles = new JLabel("Local Files");
		lblLocalFiles.setBounds(32, 6, 120, 16);
		contentPane.add(lblLocalFiles);

		JButton downloadRemoteFile = new JButton("<< Download");
		downloadRemoteFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] listSelected = listRemoteFiles.getSelectedIndices();
				Vector<ShowFile> listFiles = new Vector<ShowFile>();
				for (int i : listSelected)
					listFiles.add((ShowFile) listModelRemote.getElementAt(i));

				wsClient.pullFiles(listFiles);
				refreshRemoteFiles();
			}
		});
		downloadRemoteFile.setBounds(293, 201, 117, 29);
		contentPane.add(downloadRemoteFile);

		JLabel lblRemoteFiles = new JLabel("Remote Files");
		lblRemoteFiles.setBounds(283, 6, 120, 16);
		contentPane.add(lblRemoteFiles);
		
		JButton btnNewButton = new JButton("\u21BB");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshRemoteFiles();
			}
		});
		btnNewButton.setBounds(436, 5, 16, 21);
		contentPane.add(btnNewButton);

		/*
		 * WebServices
		 */

		refreshRemoteFiles();

	}

	public void refreshRemoteFiles() {
		Vector<String> listRemoteFile = wsClient.getListFile();
		if (!listRemoteFile.isEmpty()
				&& listRemoteFile.get(0) != "Not Modified") {
			listModelRemote.removeAllElements();
			for (String string : listRemoteFile) {
				listModelRemote.addElement(new ShowFile(string, ""));
			}
		}
	}
}
