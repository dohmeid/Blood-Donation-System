import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;

public class DonorAddUI extends JFrame {

	private String dgender = "female";
	private String d_btype = "A-";
	private String d_etd = "yes";
	private String d_date = "";
	private JPanel contentPane;
	private JTextField ssn;
	private JTextField name;
	private JTextField phone;
	private JTextField address;
	private JTextField hbg;
	private JComboBox gender;
	private JComboBox btype;
	private JComboBox etd;
	private JDateChooser dateChooser ;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonorAddUI frame = new DonorAddUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DonorAddUI() {
		setTitle("Donor Addition ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DonorAddUI.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 660);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl = new JLabel("all fields must be filled");
		lbl.setBounds(192, 544, 294, 13);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl.setVisible(false);
		contentPane.add(lbl);
		
		JLabel lblAddingANew = new JLabel("Adding A New Donor\r\n");
		lblAddingANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddingANew.setForeground(new Color(255, 255, 255));
		lblAddingANew.setFont(new Font("Century", Font.PLAIN, 20));
		lblAddingANew.setBounds(18, 13, 480, 35);
		contentPane.add(lblAddingANew);
		
		ssn = new JTextField();
		ssn.setFont(new Font("Century", Font.PLAIN, 13));
		ssn.setForeground(new Color(102, 0, 0));
		ssn.setColumns(10);
		ssn.setBounds(192, 85, 260, 40);
		contentPane.add(ssn);
		
		JLabel lblName = new JLabel("SSN");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setForeground(new Color(102, 0, 0));
		lblName.setFont(new Font("Century", Font.PLAIN, 15));
		lblName.setBounds(31, 83, 150, 40);
		contentPane.add(lblName);
		
		JLabel label = new JLabel("Name");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(102, 0, 0));
		label.setFont(new Font("Century", Font.PLAIN, 15));
		label.setBounds(31, 134, 150, 40);
		contentPane.add(label);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber.setForeground(new Color(102, 0, 0));
		lblPhoneNumber.setFont(new Font("Century", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(31, 185, 150, 40);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setForeground(new Color(102, 0, 0));
		lblAddress.setFont(new Font("Century", Font.PLAIN, 15));
		lblAddress.setBounds(31, 236, 150, 40);
		contentPane.add(lblAddress);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfBirth.setForeground(new Color(102, 0, 0));
		lblDateOfBirth.setFont(new Font("Century", Font.PLAIN, 15));
		lblDateOfBirth.setBounds(31, 287, 150, 40);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setForeground(new Color(102, 0, 0));
		lblGender.setFont(new Font("Century", Font.PLAIN, 15));
		lblGender.setBounds(31, 338, 150, 40);
		contentPane.add(lblGender);
		
		JLabel lblEligibleToDonate = new JLabel("Eligible to donate");
		lblEligibleToDonate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEligibleToDonate.setForeground(new Color(102, 0, 0));
		lblEligibleToDonate.setFont(new Font("Century", Font.PLAIN, 15));
		lblEligibleToDonate.setBounds(31, 493, 150, 40);
		contentPane.add(lblEligibleToDonate);
		
		JLabel lblBloodHgb = new JLabel("Blood HGB");
		lblBloodHgb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBloodHgb.setForeground(new Color(102, 0, 0));
		lblBloodHgb.setFont(new Font("Century", Font.PLAIN, 15));
		lblBloodHgb.setBounds(31, 442, 150, 40);
		contentPane.add(lblBloodHgb);
		
		JLabel lblBloodType = new JLabel("Blood Type");
		lblBloodType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBloodType.setForeground(new Color(102, 0, 0));
		lblBloodType.setFont(new Font("Century", Font.PLAIN, 15));
		lblBloodType.setBounds(31, 389, 150, 40);
		contentPane.add(lblBloodType);
		
		name = new JTextField();
		name.setFont(new Font("Century", Font.PLAIN, 13));
		name.setForeground(new Color(102, 0, 0));
		name.setColumns(10);
		name.setBounds(192, 136, 260, 40);
		contentPane.add(name);
		
		phone = new JTextField();
		phone.setFont(new Font("Century", Font.PLAIN, 13));
		phone.setForeground(new Color(102, 0, 0));
		phone.setColumns(10);
		phone.setBounds(192, 187, 260, 40);
		contentPane.add(phone);
		
		address = new JTextField();
		address.setFont(new Font("Century", Font.PLAIN, 13));
		address.setForeground(new Color(102, 0, 0));
		address.setColumns(10);
		address.setBounds(192, 238, 260, 40);
		contentPane.add(address);
		
		hbg = new JTextField();
		hbg.setFont(new Font("Century", Font.PLAIN, 13));
		hbg.setForeground(new Color(102, 0, 0));
		hbg.setColumns(10);
		hbg.setBounds(192, 442, 260, 40);
		contentPane.add(hbg);
		
		 gender = new JComboBox();
		 gender.setFont(new Font("Century", Font.PLAIN, 13));
		 gender.setForeground(new Color(128, 0, 0));
		 gender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPerformed1(e);
			}
		});
		gender.setModel(new DefaultComboBoxModel(new String[] {"female", "male"}));
		gender.setBounds(192, 340, 260, 40);
		contentPane.add(gender);
		
		btype = new JComboBox();
		btype.setFont(new Font("Century", Font.PLAIN, 13));
		btype.setForeground(new Color(128, 0, 0));
		btype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPerformed2(e);
			}
		});
		btype.setModel(new DefaultComboBoxModel(new String[] {"A-", "A+", "B-", "B+", "O-", "O+", "AB-", "AB+"}));
		btype.setBounds(192, 391, 260, 40);
		contentPane.add(btype);
		
		JButton btnadd = new JButton("ADD");
		btnadd.setForeground(new Color(253, 245, 230));
		btnadd.setBackground(new Color(165, 42, 42));
		btnadd.setFont(new Font("Century", Font.PLAIN, 11));
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jButtonActionPerformedADD(e);
				} catch (SQLException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnadd.setBounds(192, 561, 260, 40);
		contentPane.add(btnadd);
		
		etd = new JComboBox();
		etd.setFont(new Font("Century", Font.PLAIN, 13));
		etd.setForeground(new Color(128, 0, 0));
		etd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPerformed3(e);
			}
		});
		etd.setModel(new DefaultComboBoxModel(new String[] {"yes", "no"}));
		etd.setBounds(192, 493, 260, 40);
		contentPane.add(etd);
		 
		 JPanel panel = new JPanel();
		 panel.setBackground(new Color(165, 42, 42));
		 panel.setBounds(0, 0, 516, 57);
		 contentPane.add(panel);
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(192, 289, 260, 40);
		contentPane.add(dateChooser);
	}
	
	//gender selection
	private void ActionPerformed1(java.awt.event.ActionEvent e) {
		if (gender.getSelectedIndex() == 0)
			dgender = "female";
		else if (gender.getSelectedIndex() == 1)
			dgender = "male";
	}
	
	// blood type selection
	private void ActionPerformed2(java.awt.event.ActionEvent e) {
		if (btype.getSelectedIndex() == 0)
			d_btype = "A-";
		else if (btype.getSelectedIndex() == 1)
			d_btype = "A+";
		else if (btype.getSelectedIndex() == 2)
			d_btype = "B-";
		else if (btype.getSelectedIndex() == 3)
			d_btype = "B+";
		else if (btype.getSelectedIndex() == 4)
			d_btype  = "O-";
		else if (btype.getSelectedIndex() == 5)
			d_btype  = "O+";
		else if (btype.getSelectedIndex() == 6)
			d_btype  = "AB-";
		else if (btype.getSelectedIndex() == 7)
			d_btype  = "AB+";
	}

	//to get the date selection
	private void getDateFromUI() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		d_date = df.format(dateChooser.getDate());	
	}
	
	
	// Eligable To Donate selection
	private void ActionPerformed3(java.awt.event.ActionEvent e) {
		if (etd.getSelectedIndex() == 0)
			d_etd = "yes";
		else if (etd.getSelectedIndex() == 1)
			d_etd = "no";
	}
	
	
	private void jButtonActionPerformedADD(java.awt.event.ActionEvent e) throws SQLException, ParseException {
		DataBaseDriver dr = new DataBaseDriver();
		if(ssn.getText().compareTo("")==0 || name.getText().compareTo("")==0 || phone.getText().compareTo("")==0 || address.getText().compareTo("")==0
				|| hbg.getText().compareTo("")==0 || dateChooser.getDate() == null) {
			lbl.setVisible(true);
		}
		else if(ssn.getText().matches("-?\\d+(\\.\\d+)?")==false || hbg.getText().matches("-?\\d+(\\.\\d+)?")==false
			||	phone.getText().matches("-?\\d+(\\.\\d+)?")==false) {
			lbl.setText("ssn, hbg and phone number must be numbers");
			lbl.setVisible(true);
			//phone.getText().matches("-?\\d+(\\.\\d+)?")==false 
		}
		else if(name.getText().matches("[a-zA-Z]+")==false || address.getText().matches("[a-zA-Z]+")==false) {
			lbl.setText("name and address must be a string");
			lbl.setVisible(true);
		}
		else if(dr.search(Integer.valueOf(ssn.getText()), 1) == 1){
			lbl.setText("this donor ssn already exists");
			lbl.setVisible(true);
		}
		else {
			lbl.setVisible(false);
		
		getDateFromUI();
		Donor d = new Donor();
		d.setDssn(Integer.valueOf(ssn.getText()));
		d.setDname(name.getText());
		d.setPhoneNumber(Integer.valueOf(phone.getText()));
		d.setAddress(address.getText());
		d.setDateOfBirth(d_date);
		d.setGender(dgender);
		d.setBloodType(d_btype);
		d.setBloodHgb(Integer.valueOf(hbg.getText()));
		d.setEligableToDonate(d_etd);
		System.out.println(d.toString());
		
		
		dr.addDonor(d);
		System.out.println("adding done");
		
	}}
}
