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
		setSize(400,100); 
		setTitle("View Bookings"); 
		JPanel mainpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel welc = new JLabel();
		welc.setText("Welcome to the booking application.");
		mainpanel.add(welc);
		JPanel btn = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton adm = new JButton("Admin");
		adm.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Admin admin = new Admin();
				admin.setVisible(true);
				mWin.setVisible(false);
			}
		});
		btn.add(adm);
		
		JButton book = new JButton("Booking");
		book.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Booking window1 = new Booking();
				window1.setVisible(true);
				mWin.setVisible(false);
			}
		});
		btn.add(book);
		
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
