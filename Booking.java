import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Booking extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextArea msgbox;
	private static JTextField cName;
	private static JTextField cNumber;
	String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	JComboBox dbox = new JComboBox(days);
	String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	JComboBox mbox = new JComboBox(months);
	JTextField year = new JTextField(5);
	String[] slots = {"08:00-09:00","09:00-10:00","10:00-11:00","11:00-12:00","12:00-13:00","14:00-15:00","15:00-16:00"};
	JComboBox slot = new JComboBox(slots);
	
	//control buttons
	JButton book = new JButton("Book");
	
	public Booking() {
		setSize(750,500); // setting the size of the window
		setTitle("Appointments Booking Application"); 
		JPanel mainpanel = new JPanel();
		
		JPanel clientname = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblcname = new JLabel("Name and Surname: ");
		clientname.add(lblcname);
		cName = new JTextField(30);
		clientname.add(cName);
		
		JPanel clientnumber = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel lblcnumber = new JLabel("Contact number: ");
		clientnumber.add(lblcnumber);
		cNumber = new JTextField(10);
		clientnumber.add(cNumber);
		
		//calendar
		//days
		JPanel calendar = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel daylbl = new JLabel("Day");
		calendar.add(daylbl);
		calendar.add(dbox);
		JLabel mlbl = new JLabel("Month");
		calendar.add(mlbl);
		calendar.add(mbox);
		JLabel yrlbl = new JLabel("Year");
		calendar.add(yrlbl);
		calendar.add(year);
		JLabel slbl = new JLabel("Slot: ");
		calendar.add(slbl);
		calendar.add(slot);
		
		JPanel msgarea = new JPanel(new FlowLayout(FlowLayout.LEFT));
		msgbox = new JTextArea(10,20);
		msgarea.add(msgbox);
		//Buttons panel
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!cName.getText().isEmpty() && !cNumber.getText().isEmpty() && !year.getText().isEmpty()) {
						PrintWriter f;
						try {
							f = new PrintWriter(new FileOutputStream("booking.txt",true));									
							f.println(cName.getText().trim()+"\t"+cNumber.getText().trim()+"\t"+
									dbox.getSelectedItem().toString()+"\t"+mbox.getSelectedItem().toString()+"\t"+
									year.getText().trim()+"\t"+slot.getSelectedItem().toString());
							f.close();
						}catch(Exception ex) {
							System.out.println("File not found for writing!");
						}
						msgbox.setText(cName.getText()+"\n"+cNumber.getText()+"\n"+dbox.getSelectedItem().toString()+" "+
								mbox.getSelectedItem().toString()+" "+year.getText()+"\n"+slot.getSelectedItem().toString()+"\n"+
								"Booking complete.");
					
				}else {
					msgbox.setText("Please fill in all the details!");
				}
			}
		});
		buttons.add(book);
		JButton clear = new JButton("Clear");
		clear.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				cName.setText("");
				cNumber.setText("");
				year.setText("");
				msgbox.setText("");
				dbox.setSelectedIndex(0);
				mbox.setSelectedIndex(0);
				slot.setSelectedIndex(0);
			}
		});
		buttons.add(clear);
		JButton exit = new JButton("Exit");
		buttons.add(exit);
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		//adding all the panels to the mainpanel then add the mainpanel to the window
		mainpanel.add(clientname);
		mainpanel.add(clientnumber);
		mainpanel.add(calendar);
		mainpanel.add(msgarea);
		mainpanel.add(buttons);
		add(mainpanel);
	}
	
	public static void main(String[] args) {
		Booking window = new Booking();
		window.setVisible(true);		
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}
}
