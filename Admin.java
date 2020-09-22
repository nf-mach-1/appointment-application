import javax.swing.*;
import java.io.*;
import java.util.*;

public class Admin extends JFrame{
	private JTextArea view;
	private JLabel elbl = new JLabel(); 
	public Admin() {
		setSize(750,500); // setting the size of the window
		setTitle("View Bookings"); 
		
		JPanel mainpanel = new JPanel();
		view = new JTextArea(100,70);
		try {
			Scanner sc = new Scanner(new File("booking.txt"));
			String line;
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				view.setText(line+"\n");
			}
		}catch(Exception e) {
			elbl.setText(e.getMessage());
		}
		mainpanel.add(view);
		mainpanel.add(elbl);
		add(mainpanel);
	}
}
