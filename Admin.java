import javax.swing.*;

import java.awt.FlowLayout;
import java.io.*;
import java.util.*;

public class Admin extends JFrame{
	private JTextArea view;
	private JLabel elbl = new JLabel(); 
	public Admin() {
		setSize(750,500); // setting the size of the window
		setTitle("View Bookings"); 
		
		JPanel mainpanel = new JPanel();
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		view = new JTextArea(85,5);
		try {
			Scanner sc = new Scanner(new File("booking.txt"));
			String line;
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				view.append(line+"\n");
			}
		}catch(Exception e) {
			elbl.setText(e.getMessage());
		}
		panel.add(view);
		panel.add(elbl);
		mainpanel.add(panel);
		add(mainpanel);
	}
}
