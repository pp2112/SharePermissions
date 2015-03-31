package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Permissions {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Permissions window = new Permissions();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Permissions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Create Folder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					// Replace "\\\\PAVAN-PC\\Users\\Pavan\\Documents\\LOLReplay" with your own path
					// Mounts the shared folder to a network drive p:
					Runtime.getRuntime().exec("net use p: \\\\PAVAN-PC\\Users\\Pavan\\Documents\\LOLReplay");
					// Sets the new folder inside the drive
					File test_folder = new File("p:\\Test_Folder");
					Thread.sleep(1000);
					// Creates a new folder called Test_Folder
					test_folder.mkdir();
					// Sets the permission of that folder so that no one can read it
					Runtime.getRuntime().exec("icacls p:\\Test_Folder /deny Everyone:R");
				} catch (Exception e) {
					
				}
				
				
			}
		});
		btnNewButton.setBounds(121, 168, 185, 44);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(37, 57, 375, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
