import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;

public class DonationAddUI extends JFrame {

	private String btype = "A-";
	private String d_date = "";
	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JComboBox tf3;
	private JTextField tf4;
	private JTextField tf6;
	private JTextField tf5;
	private JDateChooser dateChooser;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonationAddUI frame = new DonationAddUI();
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
	public DonationAddUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DonationAddUI.class.getResource("/images/logo1.jpg")));
		setTitle("Adding A  Donation\r");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddingADonation = new JLabel("Adding A  Donation\r\n");
		lblAddingADonation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddingADonation.setForeground(Color.WHITE);
		lblAddingADonation.setFont(new Font("Century", Font.PLAIN, 20));
		lblAddingADonation.setBounds(18, 13, 480, 35);
		contentPane.add(lblAddingADonation);

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

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setForeground(new Color(102, 0, 0));
		lblId.setFont(new Font("Century", Font.PLAIN, 15));
		lblId.setBounds(31, 83, 150, 40);
		contentPane.add(lblId);

		JLabel lblDssn = new JLabel("dSSN");
		lblDssn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDssn.setForeground(new Color(102, 0, 0));
		lblDssn.setFont(new Font("Century", Font.PLAIN, 15));
		lblDssn.setBounds(31, 134, 150, 40);
		contentPane.add(lblDssn);

		tf2 = new JTextField();
		tf2.setForeground(new Color(102, 0, 0));
		tf2.setFont(new Font("Century", Font.PLAIN, 13));
		tf2.setColumns(10);
		tf2.setBounds(192, 136, 260, 40);
		contentPane.add(tf2);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(192, 187, 260, 40);
		contentPane.add(dateChooser);

		JLabel lblDateOfDonation = new JLabel("Date Of Donation");
		lblDateOfDonation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfDonation.setForeground(new Color(102, 0, 0));
		lblDateOfDonation.setFont(new Font("Century", Font.PLAIN, 15));
		lblDateOfDonation.setBounds(31, 187, 150, 40);
		contentPane.add(lblDateOfDonation);

		tf3 = new JComboBox();
		tf3.setModel(new DefaultComboBoxModel(new String[] { "A-", "A+", "B-", "B+", "O-", "O+", "AB-", "AB+" }));
		tf3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPerformed(e);
			}
		});
		tf3.setForeground(new Color(128, 0, 0));
		tf3.setFont(new Font("Century", Font.PLAIN, 13));
		tf3.setBounds(192, 238, 260, 40);
		contentPane.add(tf3);

		JLabel label_4 = new JLabel("Blood Type");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(new Color(102, 0, 0));
		label_4.setFont(new Font("Century", Font.PLAIN, 15));
		label_4.setBounds(31, 238, 150, 40);
		contentPane.add(label_4);

		tf4 = new JTextField();
		tf4.setForeground(new Color(102, 0, 0));
		tf4.setFont(new Font("Century", Font.PLAIN, 13));
		tf4.setColumns(10);
		tf4.setBounds(192, 289, 260, 40);
		contentPane.add(tf4);

		JLabel lblBloodQuantity = new JLabel("Blood Quantity");
		lblBloodQuantity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBloodQuantity.setForeground(new Color(102, 0, 0));
		lblBloodQuantity.setFont(new Font("Century", Font.PLAIN, 15));
		lblBloodQuantity.setBounds(31, 288, 150, 40);
		contentPane.add(lblBloodQuantity);

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
		btn.setBounds(192, 471, 260, 40);
		contentPane.add(btn);

		tf6 = new JTextField();
		tf6.setForeground(new Color(102, 0, 0));
		tf6.setFont(new Font("Century", Font.PLAIN, 13));
		tf6.setColumns(10);
		tf6.setBounds(192, 393, 260, 40);
		contentPane.add(tf6);

		tf5 = new JTextField();
		tf5.setForeground(new Color(102, 0, 0));
		tf5.setFont(new Font("Century", Font.PLAIN, 13));
		tf5.setColumns(10);
		tf5.setBounds(192, 342, 260, 40);
		contentPane.add(tf5);

		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDoctor.setForeground(new Color(102, 0, 0));
		lblDoctor.setFont(new Font("Century", Font.PLAIN, 15));
		lblDoctor.setBounds(31, 391, 150, 40);
		contentPane.add(lblDoctor);

		JLabel lblHospital = new JLabel("Hospital");
		lblHospital.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHospital.setForeground(new Color(102, 0, 0));
		lblHospital.setFont(new Font("Century", Font.PLAIN, 15));
		lblHospital.setBounds(31, 340, 150, 40);
		contentPane.add(lblHospital);

		lbl = new JLabel("all fields must be filled");
		lbl.setBounds(192, 459, 260, 14);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl.setVisible(false);
		contentPane.add(lbl);
	}

	// blood type selection
	private void ActionPerformed(java.awt.event.ActionEvent e) {
		if (tf3.getSelectedIndex() == 0)
			btype = "A-";
		else if (tf3.getSelectedIndex() == 1)
			btype = "A+";
		else if (tf3.getSelectedIndex() == 2)
			btype = "B-";
		else if (tf3.getSelectedIndex() == 3)
			btype = "B+";
		else if (tf3.getSelectedIndex() == 4)
			btype = "O-";
		else if (tf3.getSelectedIndex() == 5)
			btype = "O+";
		else if (tf3.getSelectedIndex() == 6)
			btype = "AB-";
		else if (tf3.getSelectedIndex() == 7)
			btype = "AB+";

	}

	// to get the date selection
	private void getDateFromUI() {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		d_date = df.format(dateChooser.getDate());
	}

	private void jButtonActionPerformedADD(java.awt.event.ActionEvent e) throws SQLException, ParseException {
		DataBaseDriver dr = new DataBaseDriver();

		if (tf1.getText().compareTo("") == 0 || tf2.getText().compareTo("") == 0 || tf4.getText().compareTo("") == 0
				|| tf5.getText().compareTo("") == 0 || tf6.getText().compareTo("") == 0
				|| dateChooser.getDate() == null) {
			lbl.setVisible(true);
		} else if (tf1.getText().matches("-?\\d+(\\.\\d+)?") == false
				|| tf2.getText().matches("-?\\d+(\\.\\d+)?") == false
				|| tf4.getText().matches("-?\\d+(\\.\\d+)?") == false) {
			lbl.setText("id,ssn and blood quantity must be numbers");
			lbl.setVisible(true);

		} else if (tf5.getText().matches("[a-zA-Z]+") == false || tf6.getText().matches("[a-zA-Z]+") == false) {
			lbl.setText("hospital and doctor names must be strings");
			lbl.setVisible(true);
		}

		else if (dr.search(Integer.valueOf(tf1.getText()), 3) == 1) {
			lbl.setText("id already exists");
			lbl.setVisible(true);
		} else if (dr.search(Integer.valueOf(tf2.getText()), 1) == 0) {
			lbl.setText("this donor ssn doesn't exist");
			lbl.setVisible(true);
		} else {
			lbl.setVisible(false);

			getDateFromUI();
			Donation d = new Donation();
			d.setBloodSampleId(Integer.valueOf(tf1.getText()));
			d.setDssn(Integer.valueOf(tf2.getText()));
			d.setDateOfDonation(d_date);
			d.setBloodType(btype);
			d.setBloodUnits(Integer.valueOf(tf4.getText()));
			d.setHospital(tf5.getText());
			d.setDoctor(tf6.getText());
			System.out.println(d.toString());

			dr.addDonation(d);
			System.out.println("adding done");

		}
	}
}
