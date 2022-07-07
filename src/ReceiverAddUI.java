import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class ReceiverAddUI extends JFrame {

	private String rgender = "female";
	private String r_btype = "A-";
	private String r_date = "";

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JDateChooser dateChooser;
	private JComboBox tf6;
	private JComboBox tf7;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiverAddUI frame = new ReceiverAddUI();
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
	public ReceiverAddUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReceiverAddUI.class.getResource("/images/logo1.jpg")));
		setTitle("Receiver Addition ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbl = new JLabel("all fields must be filled");
		lbl.setBounds(192, 442, 260, 13);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl.setVisible(false);
		contentPane.add(lbl);

		JLabel lblAddingANew = new JLabel("Adding A New Receiver \r\n");
		lblAddingANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddingANew.setForeground(Color.WHITE);
		lblAddingANew.setFont(new Font("Century", Font.PLAIN, 20));
		lblAddingANew.setBounds(18, 13, 480, 35);
		contentPane.add(lblAddingANew);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(165, 42, 42));
		panel.setBounds(0, 0, 516, 57);
		contentPane.add(panel);

		tf1 = new JTextField();
		tf1.setForeground(new Color(102, 0, 0));
		tf1.setFont(new Font("Century", Font.PLAIN, 13));
		tf1.setColumns(10);
		tf1.setBounds(192, 85, 260, 40);
		contentPane.add(tf1);

		JLabel label_1 = new JLabel("SSN");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(new Color(102, 0, 0));
		label_1.setFont(new Font("Century", Font.PLAIN, 15));
		label_1.setBounds(31, 83, 150, 40);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Name");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(new Color(102, 0, 0));
		label_2.setFont(new Font("Century", Font.PLAIN, 15));
		label_2.setBounds(31, 134, 150, 40);
		contentPane.add(label_2);

		tf2 = new JTextField();
		tf2.setForeground(new Color(102, 0, 0));
		tf2.setFont(new Font("Century", Font.PLAIN, 13));
		tf2.setColumns(10);
		tf2.setBounds(192, 136, 260, 40);
		contentPane.add(tf2);

		tf3 = new JTextField();
		tf3.setForeground(new Color(102, 0, 0));
		tf3.setFont(new Font("Century", Font.PLAIN, 13));
		tf3.setColumns(10);
		tf3.setBounds(192, 187, 260, 40);
		contentPane.add(tf3);

		JLabel label_3 = new JLabel("Phone Number");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(new Color(102, 0, 0));
		label_3.setFont(new Font("Century", Font.PLAIN, 15));
		label_3.setBounds(31, 185, 150, 40);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Address");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(new Color(102, 0, 0));
		label_4.setFont(new Font("Century", Font.PLAIN, 15));
		label_4.setBounds(31, 236, 150, 40);
		contentPane.add(label_4);

		tf4 = new JTextField();
		tf4.setForeground(new Color(102, 0, 0));
		tf4.setFont(new Font("Century", Font.PLAIN, 13));
		tf4.setColumns(10);
		tf4.setBounds(192, 238, 260, 40);
		contentPane.add(tf4);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(192, 289, 260, 40);
		contentPane.add(dateChooser);

		JLabel label_5 = new JLabel("Date Of Birth");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setForeground(new Color(102, 0, 0));
		label_5.setFont(new Font("Century", Font.PLAIN, 15));
		label_5.setBounds(31, 287, 150, 40);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("Gender");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setForeground(new Color(102, 0, 0));
		label_6.setFont(new Font("Century", Font.PLAIN, 15));
		label_6.setBounds(31, 338, 150, 40);
		contentPane.add(label_6);

		tf6 = new JComboBox();
		tf6.setModel(new DefaultComboBoxModel(new String[] { "female", "male" }));
		tf6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPerformed1(e);
			}
		});
		tf6.setForeground(new Color(128, 0, 0));
		tf6.setFont(new Font("Century", Font.PLAIN, 13));
		tf6.setBounds(192, 340, 260, 40);
		contentPane.add(tf6);

		tf7 = new JComboBox();
		tf7.setModel(new DefaultComboBoxModel(new String[] {"A-", "A+", "B-", "B+", "O-", "O+", "AB-", "AB+"}));
		tf7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPerformed2(e);
			}
		});
		tf7.setForeground(new Color(128, 0, 0));
		tf7.setFont(new Font("Century", Font.PLAIN, 13));
		tf7.setBounds(192, 391, 260, 40);
		contentPane.add(tf7);

		JLabel label_7 = new JLabel("Blood Type");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(new Color(102, 0, 0));
		label_7.setFont(new Font("Century", Font.PLAIN, 15));
		label_7.setBounds(31, 389, 150, 40);
		contentPane.add(label_7);

		JButton btn = new JButton("ADD");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jButtonActionPerformedADD(e);
				} catch (SQLException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn.setForeground(new Color(253, 245, 230));
		btn.setFont(new Font("Century", Font.PLAIN, 11));
		btn.setBackground(new Color(165, 42, 42));
		btn.setBounds(192, 462, 260, 40);
		contentPane.add(btn);
	}

	// gender selection
	private void ActionPerformed1(java.awt.event.ActionEvent e) {
		if (tf6.getSelectedIndex() == 0)
			rgender = "female";
		else if (tf6.getSelectedIndex() == 1)
			rgender = "male";
	}

	// blood type selection
	private void ActionPerformed2(java.awt.event.ActionEvent e) {
		if (tf7.getSelectedIndex() == 0)
			r_btype = "A-";
		else if (tf7.getSelectedIndex() == 1)
			r_btype = "A+";
		else if (tf7.getSelectedIndex() == 2)
			r_btype = "B-";
		else if (tf7.getSelectedIndex() == 3)
			r_btype = "B+";
		else if (tf7.getSelectedIndex() == 4)
			r_btype = "O-";
		else if (tf7.getSelectedIndex() == 5)
			r_btype = "O+";
		else if (tf7.getSelectedIndex() == 6)
			r_btype = "AB-";
		else if (tf7.getSelectedIndex() == 7)
			r_btype = "AB+";
	}

	// to get the date selection
	private void getDateFromUI() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		r_date = df.format(dateChooser.getDate());
	}

	private void jButtonActionPerformedADD(java.awt.event.ActionEvent e) throws SQLException, ParseException {
		DataBaseDriver dr = new DataBaseDriver();
		if (tf1.getText().compareTo("") == 0 || tf2.getText().compareTo("") == 0 || tf3.getText().compareTo("") == 0
				|| tf4.getText().compareTo("") == 0 || dateChooser.getDate() == null) {
			lbl.setVisible(true);
		} 
		
		else if (tf1.getText().matches("-?\\d+(\\.\\d+)?") == false || tf3.getText().matches("-?\\d+(\\.\\d+)?")==false) {
			lbl.setText("ssn and phone number must be number");
			lbl.setVisible(true);
			
		} 
		
		else if (tf2.getText().matches("[a-zA-Z]+") == false || tf4.getText().matches("[a-zA-Z]+")==false) {
			lbl.setText("name and address must be a string");
			lbl.setVisible(true);
		} 
		
		else if(dr.search(Integer.valueOf(tf1.getText()), 2) == 1){
			lbl.setText("this receiver ssn already exists");
			lbl.setVisible(true);
		}
		else {
			lbl.setVisible(false);
			getDateFromUI();
			Receiver r = new Receiver();

			r.setRssn(Integer.valueOf(tf1.getText()));
			r.setRname(tf2.getText());
			r.setPhoneNumber(Integer.valueOf(tf3.getText()));
			r.setAddress(tf4.getText());
			r.setDateOfBirth(r_date);
			r.setGender(rgender);
			r.setBloodType(r_btype);

			System.out.println(r.toString());
			dr.addReceiver(r);

		}
	}
}
