import java.util.*;
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
	//combo box values
	String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	JComboBox dbox = new JComboBox(days);
	String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	JComboBox mbox = new JComboBox(months);
	JTextField year = new JTextField(5);
	
	public Booking() {
		setSize(850,500); // setting the size of the window
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
		
		JPanel msgarea = new JPanel(new FlowLayout(FlowLayout.CENTER));
		msgbox = new JTextArea(10,20);
		msgarea.add(msgbox);
		
		//calendar
		//days
		JPanel calendar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		dbox.addActionListener(this);
		calendar.add(dbox);
		mbox.addActionListener(this);
		calendar.add(mbox);
		JLabel yrlbl = new JLabel("Year");
		calendar.add(yrlbl);
		calendar.add(year);
		
		//slots buttons
		JPanel slots = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSlot = new JLabel("Slots: ");
		slots.add(lblSlot);
		JButton btn1 = new JButton("08:00 - 09:00");
		slots.add(btn1);
		JButton btn2 = new JButton("09:00 - 10:00");
		slots.add(btn2);
		JButton btn3 = new JButton("10:00 - 11:00");
		slots.add(btn3);
		JButton btn4 = new JButton("11:00 - 12:00");
		slots.add(btn4);
		JButton btn5 = new JButton("14:00 - 15:00");
		slots.add(btn5);
		JButton btn6 = new JButton("15:00 - 16:00");
		slots.add(btn6);
		JButton btn7 = new JButton("16:00 - 17:00");
		slots.add(btn7);
		
		//Buttons panel
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton book = new JButton("Book");
		buttons.add(book);
		JButton delete = new JButton("Delete");
		buttons.add(delete);
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
		mainpanel.add(slots);
		mainpanel.add(msgarea);
		mainpanel.add(buttons);
		add(mainpanel);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		Booking window = new Booking();
		window.setVisible(true);		
	}
}
