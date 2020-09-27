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
	private String[] column = {"Name and Surname","Contact number","Date","Time"}; 
	JTable table;
	public Admin() {
		setSize(650,400); // setting the size of the window
		setTitle("View Bookings"); 
		JPanel mainpanel = new JPanel();
		JPanel bpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton exit = new JButton("Exit");
		bpanel.add(exit);
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		JPanel tpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		String[][] data = getData("booking.txt");
		table = new JTable(data,column);
		JScrollPane sp = new JScrollPane(table);
		tpanel.add(sp);
		
		mainpanel.add(bpanel);
		mainpanel.add(tpanel);
		add(mainpanel);
	}
	
	public String[][] getData(String n) {
		String[][] lines = null;
		try {
			Scanner sc = new Scanner(new File(n));
			int count = 0;
			String l;
			while(sc.hasNextLine()) {
				l = sc.nextLine();
				count ++;
			}
			sc.close();
			Scanner read =  new Scanner(new File(n));
			String sent;
			String[] line;
			lines = new String[count][4];
			int i = 0;
			while(read.hasNextLine()) {
				sent = read.nextLine();
				line = sent.split("\t");
				String date = line[2]+"/"+line[3]+"/"+line[4];
				lines[i][0] = line[0];
				lines[i][1] = line[1];
				lines[i][2] = date;
				lines[i][3] = line[5];
				i += 1;
			}
			read.close();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lines;
	}
}
