import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class DonorUpdateUI extends JFrame {

	private String dgender = "";
	private String d_btype = "";
	private String d_etd = "";
	private String d_date = "";

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf8;
	private JComboBox tf6;
	private JComboBox tf7;
	private JComboBox tf9;
	private JDateChooser dateChooser;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonorUpdateUI frame = new DonorUpdateUI();
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
	public DonorUpdateUI() {
		setTitle("Donor Updating");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DonorUpdateUI.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbl = new JLabel("ssn must be filled");
		lbl.setBounds(180, 497, 276, 13);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl.setVisible(false);
		contentPane.add(lbl);

		tf1 = new JTextField();
		tf1.setFont(new Font("Century", Font.PLAIN, 12));
		tf1.setForeground(new Color(102, 0, 0));
		tf1.setColumns(10);
		tf1.setBounds(180, 27, 260, 40);
		contentPane.add(tf1);

		tf2 = new JTextField();
		tf2.setFont(new Font("Century", Font.PLAIN, 12));
		tf2.setForeground(new Color(102, 0, 0));
		tf2.setColumns(10);
		tf2.setBounds(180, 78, 260, 40);
		contentPane.add(tf2);

		tf3 = new JTextField();
		tf3.setFont(new Font("Century", Font.PLAIN, 12));
		tf3.setForeground(new Color(102, 0, 0));
		tf3.setColumns(10);
		tf3.setBounds(180, 129, 260, 40);
		contentPane.add(tf3);

		tf4 = new JTextField();
		tf4.setFont(new Font("Century", Font.PLAIN, 12));
		tf4.setForeground(new Color(102, 0, 0));
		tf4.setColumns(10);
		tf4.setBounds(180, 180, 260, 40);
		contentPane.add(tf4);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(180, 231, 260, 40);
		contentPane.add(dateChooser);

		tf6 = new JComboBox();
		tf6.setForeground(new Color(102, 0, 0));
		tf6.setFont(new Font("Century", Font.PLAIN, 12));
		tf6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPerformed1(e);
			}
		});
		tf6.setModel(new DefaultComboBoxModel(new String[] { "none", "female", "male" }));
		tf6.setBounds(180, 282, 260, 40);
		contentPane.add(tf6);

		tf7 = new JComboBox();
		tf7.setForeground(new Color(102, 0, 0));
		tf7.setFont(new Font("Century", Font.PLAIN, 12));
		tf7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPerformed2(e);
			}
		});
		tf7.setModel(
				new DefaultComboBoxModel(new String[] { "none", "A-", "A+", "B-", "B+", "O-", "O+", "AB-", "AB+" }));
		tf7.setBounds(180, 333, 260, 40);
		contentPane.add(tf7);

		tf8 = new JTextField();
		tf8.setFont(new Font("Century", Font.PLAIN, 12));
		tf8.setForeground(new Color(102, 0, 0));
		tf8.setColumns(10);
		tf8.setBounds(180, 384, 260, 40);
		contentPane.add(tf8);

		tf9 = new JComboBox();
		tf9.setForeground(new Color(102, 0, 0));
		tf9.setFont(new Font("Century", Font.PLAIN, 12));
		tf9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPerformed3(e);
			}
		});
		tf9.setModel(new DefaultComboBoxModel(new String[] { "none ", "yes", "no" }));
		tf9.setBounds(180, 435, 260, 40);
		contentPane.add(tf9);

		JLabel label = new JLabel("Eligible to donate");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setForeground(new Color(102, 0, 0));
		label.setFont(new Font("Century", Font.BOLD, 15));
		label.setBounds(20, 434, 150, 40);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Blood HGB");
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setForeground(new Color(102, 0, 0));
		label_1.setFont(new Font("Century", Font.BOLD, 15));
		label_1.setBounds(70, 382, 100, 40);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Blood Type");
		label_2.setHorizontalAlignment(SwingConstants.TRAILING);
		label_2.setForeground(new Color(102, 0, 0));
		label_2.setFont(new Font("Century", Font.BOLD, 15));
		label_2.setBounds(70, 332, 100, 40);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Gender");
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setForeground(new Color(102, 0, 0));
		label_3.setFont(new Font("Century", Font.BOLD, 15));
		label_3.setBounds(90, 281, 80, 40);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Date Of Birth");
		label_4.setHorizontalAlignment(SwingConstants.TRAILING);
		label_4.setForeground(new Color(102, 0, 0));
		label_4.setFont(new Font("Century", Font.BOLD, 15));
		label_4.setBounds(45, 231, 125, 40);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("Address");
		label_5.setHorizontalAlignment(SwingConstants.TRAILING);
		label_5.setForeground(new Color(102, 0, 0));
		label_5.setFont(new Font("Century", Font.BOLD, 15));
		label_5.setBounds(90, 178, 80, 40);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("Phone Number");
		label_6.setHorizontalAlignment(SwingConstants.TRAILING);
		label_6.setForeground(new Color(102, 0, 0));
		label_6.setFont(new Font("Century", Font.BOLD, 15));
		label_6.setBounds(45, 127, 125, 40);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("Name");
		label_7.setHorizontalAlignment(SwingConstants.TRAILING);
		label_7.setForeground(new Color(102, 0, 0));
		label_7.setFont(new Font("Century", Font.BOLD, 15));
		label_7.setBounds(90, 76, 80, 40);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("SSN");
		label_8.setHorizontalAlignment(SwingConstants.TRAILING);
		label_8.setForeground(new Color(102, 0, 0));
		label_8.setFont(new Font("Century", Font.BOLD, 15));
		label_8.setBounds(90, 25, 80, 40);
		contentPane.add(label_8);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(128, 0, 0));
		separator_1.setBackground(new Color(128, 0, 0));
		separator_1.setBounds(477, 11, 11, 569);
		contentPane.add(separator_1);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(new Color(153, 0, 51));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setFont(new Font("Century", Font.PLAIN, 12));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jButtonActionPerformed(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(180, 513, 260, 40);
		contentPane.add(btnUpdate);

		JTextArea txtrUpdatingDonorsInformation = new JTextArea();
		txtrUpdatingDonorsInformation.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtrUpdatingDonorsInformation.setForeground(new Color(102, 0, 0));
		txtrUpdatingDonorsInformation.setTabSize(10);
		txtrUpdatingDonorsInformation.setEditable(false);
		txtrUpdatingDonorsInformation.setLineWrap(true);
		txtrUpdatingDonorsInformation.setText(
				"IMPORTANT NOTE:\r\n-you must fill the ssn for the donor \r\n-only fill the values that you want to change\r\n-and leave the others empty");
		txtrUpdatingDonorsInformation.setBounds(498, 166, 265, 177);
		contentPane.add(txtrUpdatingDonorsInformation);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(165, 42, 42));
		panel.setBounds(477, 0, 296, 130);
		contentPane.add(panel);

		JLabel lblUpdatingDonorInformations = new JLabel("Updating Donor Informations\r\n");
		lblUpdatingDonorInformations.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdatingDonorInformations.setForeground(Color.WHITE);
		lblUpdatingDonorInformations.setFont(new Font("Century", Font.PLAIN, 20));
		lblUpdatingDonorInformations.setBounds(10, 11, 286, 108);
		panel.add(lblUpdatingDonorInformations);
	}

	// gender selection
	private void ActionPerformed1(java.awt.event.ActionEvent e) {
		if (tf6.getSelectedIndex() == 0)
			dgender = "";
		else if (tf6.getSelectedIndex() == 1)
			dgender = "female";
		else if (tf6.getSelectedIndex() == 2)
			dgender = "male";
	}

	// blood type selection
	private void ActionPerformed2(java.awt.event.ActionEvent e) {
		if (tf7.getSelectedIndex() == 0)
			d_btype = "";
		else if (tf7.getSelectedIndex() == 1)
			d_btype = "A-";
		else if (tf7.getSelectedIndex() == 2)
			d_btype = "A+";
		else if (tf7.getSelectedIndex() == 3)
			d_btype = "B-";
		else if (tf7.getSelectedIndex() == 4)
			d_btype = "B+";
		else if (tf7.getSelectedIndex() == 5)
			d_btype = "O-";
		else if (tf7.getSelectedIndex() == 6)
			d_btype = "O+";
		else if (tf7.getSelectedIndex() == 7)
			d_btype = "AB-";
		else if (tf7.getSelectedIndex() == 8)
			d_btype = "AB+";
	}

	// to get the date selection
	private void getDateFromUI() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (dateChooser.getDate() == null)
			d_date = "";
		else
			d_date = df.format(dateChooser.getDate());
	}

	// Eligable To Donate selection
	private void ActionPerformed3(java.awt.event.ActionEvent e) {
		if (tf9.getSelectedIndex() == 0)
			d_etd = "";
		else if (tf9.getSelectedIndex() == 1)
			d_etd = "yes";
		else if (tf9.getSelectedIndex() == 2)
			d_etd = "no";
	}

	private void jButtonActionPerformed(java.awt.event.ActionEvent e) throws SQLException, ParseException {
		DataBaseDriver dr = new DataBaseDriver();

		if (tf1.getText().compareTo("") == 0) {
			lbl.setVisible(true);
		}

		else if (tf1.getText().matches("-?\\d+(\\.\\d+)?") == false
				|| (tf8.getText().compareTo("") != 0 && tf8.getText().matches("-?\\d+(\\.\\d+)?") == false)
				|| (tf3.getText().compareTo("") != 0 && tf3.getText().matches("-?\\d+(\\.\\d+)?") == false)) {
			lbl.setText("ssn, hbg and phone number must be numbers");
			lbl.setVisible(true);
		} else if ((tf2.getText().compareTo("") != 0 && tf2.getText().matches("[a-zA-Z]+") == false)
				|| (tf4.getText().compareTo("") != 0 && tf4.getText().matches("[a-zA-Z]+") == false)) {
			lbl.setText("name and address must be a string");
			lbl.setVisible(true);
		} else if (dr.search(Integer.valueOf(tf1.getText()), 1) == 0) {
			lbl.setText("this donor ssn doesn't exist");
			lbl.setVisible(true);
		} else {
			lbl.setVisible(false);

			ArrayList<String> updatedColumns = new ArrayList<String>();
			ArrayList<String> updatedValues = new ArrayList<String>();

			if (tf2.getText().compareTo("") != 0) {
				updatedColumns.add("dname");
				updatedValues.add(tf2.getText());
			}
			if (tf3.getText().compareTo("") != 0) {
				updatedColumns.add("PhoneNumber");
				updatedValues.add(tf3.getText());
			}
			if (tf4.getText().compareTo("") != 0) {
				updatedColumns.add("Address");
				updatedValues.add(tf4.getText());
			}
			if (dateChooser.getDate() != null) {
				getDateFromUI();
				updatedColumns.add("DateofBirth");
				updatedValues.add(d_date);
			}
			if (dgender.compareTo("") != 0) {
				updatedColumns.add("Gender");
				updatedValues.add(dgender);
			}
			if (d_btype.compareTo("") != 0) {
				updatedColumns.add("BloodType");
				updatedValues.add(d_btype);
			}
			if (tf8.getText().compareTo("") != 0) {
				updatedColumns.add("BloodHGB");
				updatedValues.add(tf8.getText());
			}
			if (d_etd.compareTo("") != 0) {
				updatedColumns.add("Eligibletodonate");
				updatedValues.add(d_etd);
			}

			int ssn = Integer.valueOf(tf1.getText());

			if ((!updatedColumns.isEmpty()) && !updatedValues.isEmpty())
				dr.update(1, ssn, updatedColumns, updatedValues);

		}
	}
}
