import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Main() {
		setSize(400,300); 
		setTitle("Appointments Booking Application"); 
		JPanel mainpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel welc = new JLabel();
		welc.setText("Welcome to the booking application.");
		mainpanel.add(welc);
		
		//user details prompt
		JLabel username = new JLabel("Username :");
		JTextField txtuser = new JTextField(20);
		JPanel field = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel password = new JLabel("Password :");
		JTextField txtpass = new JTextField(20);
		JPanel field2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		field.add(username);
		field.add(txtuser);
		field2.add(password);
		field2.add(txtpass);
		mainpanel.add(field);
		mainpanel.add(field2);
		
		JPanel btn = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton login = new JButton("Login");
		btn.add(login);
		
		login.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(txtuser.getText().equals("admin@work.com") && txtpass.getText().equals("admin")) {
					Admin admin = new Admin();
					admin.setVisible(true);
					mWin.setVisible(false);
				}else if(txtuser.getText().equals("test@work.com") && txtpass.getText().equals("test")) {
					Booking window1 = new Booking();
					window1.setVisible(true);
					mWin.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(rootPane, "ERROR!! Enter valid login details.");
				}
			}
		});
		
		JButton exit = new JButton("Exit");
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btn.add(exit);
		
		mainpanel.add(btn);
		add(mainpanel);
	}
	
	
	private static Main mWin = new Main();
	public static void main(String[] args) {
		
		mWin.setVisible(true);
	}
}
