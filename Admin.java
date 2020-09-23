import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.*;

public class Admin extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea view;
	private JLabel elbl = new JLabel(); 
	JTable table;
	public Admin() {
		setSize(650,400); // setting the size of the window
		setTitle("View Bookings"); 
		JPanel mainpanel = new JPanel();
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));;
		view = new JTextArea(100,10);
		try {
			Scanner sc = new Scanner(new File("booking.txt"));
			String line;
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				view.append(line+"\n");
			}
			sc.close();
		}catch(Exception e) {
			elbl.setText(e.getMessage());
		}
		panel.add(view);
		panel.add(elbl);
		
		JPanel bpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton exit = new JButton("Exit");
		bpanel.add(exit);
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		mainpanel.add(bpanel);
		mainpanel.add(panel);
		add(mainpanel);
	}
}
