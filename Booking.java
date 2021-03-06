import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

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
		setTitle("Make A Booking"); 
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
		JLabel num = new JLabel("e.g 0892234756");
		clientnumber.add(cNumber);
		clientnumber.add(num);
		
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
		msgbox.setEditable(false);
		msgarea.add(msgbox);
		//Buttons panel
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		book.addActionListener(this);
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

	public boolean isBooked(String d,String m,String y,String s) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("booking.txt"));
		String line,tempD,tempM,tempY,tempS;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			String[] sline = line.split("\t");
			tempD = sline[2];
			tempM = sline[3];
			tempY = sline[4];
			tempS = sline[5];
			if(tempD.equalsIgnoreCase(d) && tempM.equalsIgnoreCase(m) && tempY.equalsIgnoreCase(y) && tempS.equalsIgnoreCase(s)) {
				return true;
			}
		}
		sc.close();
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(!cName.getText().isEmpty() && !cNumber.getText().isEmpty() && !year.getText().isEmpty()) {
			PrintWriter f;
			String tempd = dbox.getSelectedItem().toString();
			String tempm = mbox.getSelectedItem().toString();
			String tempy = year.getText().trim();
			String temps = slot.getSelectedItem().toString();
			Calendar da = Calendar.getInstance();
			int mon = da.get(Calendar.MONTH);
			int days = da.get(Calendar.DAY_OF_MONTH);
			int mmm = -1;
			for(int i=0;i<12;i++) {
				if(months[i].equalsIgnoreCase(tempm)) {
					mmm = i;
				}
			}
			int cday = Integer.parseInt(tempd);
			int syear = Integer.parseInt(tempy);
			int sp = cName.getText().indexOf(" ");
			String n1 = cName.getText().substring(0,sp).trim().toLowerCase();
			String n2 = cName.getText().substring(sp+1).trim().toLowerCase();
			
			boolean bool1 = false;
			boolean bool2 = false;
			
			for(int i=0;i<n1.length();i++) {
				if(n1.charAt(i) >= 'a' && n1.charAt(i) <= 'z') {bool1 = true;}
				else {bool1 = false;break;}
			}
			
			for(int i=0;i<n2.length();i++) {
				if(n2.charAt(i) >= 'a' && n2.charAt(i) <= 'z') {bool2 = true;}
				else {bool2 = false;break;}
			}
			
			boolean bool3 = false;
			String cNum = cNumber.getText().toString();
			for(int i=0;i<cNum.length();i++) {
				if(cNum.charAt(i) >= '0' && cNum.charAt(i) <= '9') {bool3 = true;}
				else {bool3 = false;break;}
			}
			
			if(bool1 && bool2) {
				if((bool3) && (cNum.length() == 10)) {
					if(syear >= da.get(Calendar.YEAR) && (tempy.length() == 4)) {
						if(mmm >= mon || syear > da.get(Calendar.YEAR)) {  
							GregorianCalendar gc = new GregorianCalendar(syear,mmm,cday);
							gc.set(syear, mmm, cday);
							gc.getActualMaximum(Calendar.DATE);
							if(cday >= days || ((syear > da.get(Calendar.YEAR)) && (cday >= gc.getActualMinimum(Calendar.DATE) && cday <= gc.getActualMaximum(Calendar.DATE)))) {
								try {
									if(isBooked(tempd,tempm,tempy,temps)) {
										msgbox.setText("The slot has been taken. Please choose another slot.");
									}else {
				
										Scanner sc = new Scanner(new File("booking.txt"));
										f = new PrintWriter(new FileOutputStream("booking.txt",true));									
										f.println(cName.getText().trim()+"\t"+cNumber.getText().trim()+"\t"+tempd+"\t"+tempm+"\t"+tempy+"\t"+temps);
										f.close();
										sc.close();
										msgbox.setText(cName.getText()+"\n"+cNumber.getText()+"\n"+tempd+" "+tempm+" "+tempy+"\n"+temps+"\n"+"Booking complete.");
									}
								}catch(Exception ex) {
									msgbox.setText("File not found for writing!");
								}
							}else {
								msgbox.setText("We have passed that day. Enter current or valid day.");
							}
						}else {
							msgbox.setText("We have passed that month. Enter current or valid month.");
						}
					}else {
						msgbox.setText("We have passed that year. Enter current or valid year.");
					}
				}else {
					msgbox.setText("Invalid contact number!");
				}
			}else {
				msgbox.setText("Enter a valid name containing no characters!");
			}
		}else {
			msgbox.setText("Please fill in all the details!");
		}
	}
}
