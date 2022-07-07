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
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;

public class ReceiverUpdateUI extends JFrame {
	private String rgender = "female";
	private String r_btype = "A";
	private String r_date = "";

	private JPanel contentPane;
	private JTextField tf2;
	private JTextField tf1;
	private JTextField tf3;
	private JTextField tf4;
	private JComboBox tf5;
	private JComboBox tf6;
	private JDateChooser dateChooser;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiverUpdateUI frame = new ReceiverUpdateUI();
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
	public ReceiverUpdateUI() {
		setTitle("Receiver Updating");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReceiverUpdateUI.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tf2 = new JTextField();
		tf2.setForeground(new Color(102, 0, 0));
		tf2.setFont(new Font("Century", Font.PLAIN, 12));
		tf2.setColumns(10);
		tf2.setBounds(178, 78, 260, 40);
		contentPane.add(tf2);

		tf1 = new JTextField();
		tf1.setForeground(new Color(102, 0, 0));
		tf1.setFont(new Font("Century", Font.PLAIN, 12));
		tf1.setColumns(10);
		tf1.setBounds(178, 27, 260, 40);
		contentPane.add(tf1);

		JLabel label = new JLabel("SSN");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setForeground(new Color(102, 0, 0));
		label.setFont(new Font("Century", Font.BOLD, 15));
		label.setBounds(88, 25, 80, 40);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Name");
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setForeground(new Color(102, 0, 0));
		label_1.setFont(new Font("Century", Font.BOLD, 15));
		label_1.setBounds(88, 76, 80, 40);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Phone Number");
		label_2.setHorizontalAlignment(SwingConstants.TRAILING);
		label_2.setForeground(new Color(102, 0, 0));
		label_2.setFont(new Font("Century", Font.BOLD, 15));
		label_2.setBounds(43, 127, 125, 40);
		contentPane.add(label_2);

		tf3 = new JTextField();
		tf3.setForeground(new Color(102, 0, 0));
		tf3.setFont(new Font("Century", Font.PLAIN, 12));
		tf3.setColumns(10);
		tf3.setBounds(178, 129, 260, 40);
		contentPane.add(tf3);

		tf4 = new JTextField();
		tf4.setForeground(new Color(102, 0, 0));
		tf4.setFont(new Font("Century", Font.PLAIN, 12));
		tf4.setColumns(10);
		tf4.setBounds(178, 180, 260, 40);
		contentPane.add(tf4);

		JLabel label_3 = new JLabel("Address");
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setForeground(new Color(102, 0, 0));
		label_3.setFont(new Font("Century", Font.BOLD, 15));
		label_3.setBounds(88, 178, 80, 40);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Date Of Birth");
		label_4.setHorizontalAlignment(SwingConstants.TRAILING);
		label_4.setForeground(new Color(102, 0, 0));
		label_4.setFont(new Font("Century", Font.BOLD, 15));
		label_4.setBounds(43, 231, 125, 40);
		contentPane.add(label_4);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(178, 231, 260, 40);
		contentPane.add(dateChooser);

		tf5 = new JComboBox();
		tf5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPerformed1(e);
			}
		});
		tf5.setModel(new DefaultComboBoxModel(new String[] {"none", "female", "male"}));
		tf5.setForeground(new Color(102, 0, 0));
		tf5.setFont(new Font("Century", Font.PLAIN, 12));
		tf5.setBounds(178, 282, 260, 40);
		contentPane.add(tf5);

		JLabel label_5 = new JLabel("Gender");
		label_5.setHorizontalAlignment(SwingConstants.TRAILING);
		label_5.setForeground(new Color(102, 0, 0));
		label_5.setFont(new Font("Century", Font.BOLD, 15));
		label_5.setBounds(88, 281, 80, 40);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("Blood Type");
		label_6.setHorizontalAlignment(SwingConstants.TRAILING);
		label_6.setForeground(new Color(102, 0, 0));
		label_6.setFont(new Font("Century", Font.BOLD, 15));
		label_6.setBounds(68, 332, 100, 40);
		contentPane.add(label_6);

		 tf6 = new JComboBox();
		tf6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPerformed2(e);
			}
		});
		tf6.setModel(new DefaultComboBoxModel(new String[] {"none", "A-", "A+", "B-", "B+", "O-", "O+", "AB-", "AB+"}));
		tf6.setForeground(new Color(102, 0, 0));
		tf6.setFont(new Font("Century", Font.PLAIN, 12));
		tf6.setBounds(178, 333, 260, 40);
		contentPane.add(tf6);

		JButton btn = new JButton("UPDATE");
		btn.addActionListener(new ActionListener() {
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
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("Century", Font.PLAIN, 12));
		btn.setBackground(new Color(153, 0, 51));
		btn.setBounds(178, 432, 260, 40);
		contentPane.add(btn);

		JTextArea txtrImportantNoteyou = new JTextArea();
		txtrImportantNoteyou.setText(
				"IMPORTANT NOTE:\r\n-you must fill the ssn for the receiver \r\n-only fill the values that you want to change\r\n-and leave the others empty");
		txtrImportantNoteyou.setTabSize(10);
		txtrImportantNoteyou.setLineWrap(true);
		txtrImportantNoteyou.setForeground(new Color(102, 0, 0));
		txtrImportantNoteyou.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtrImportantNoteyou.setEditable(false);
		txtrImportantNoteyou.setBounds(496, 166, 265, 177);
		contentPane.add(txtrImportantNoteyou);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(128, 0, 0));
		separator.setBackground(new Color(128, 0, 0));
		separator.setBounds(475, 11, 11, 467);
		contentPane.add(separator);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(165, 42, 42));
		panel.setBounds(475, 0, 296, 130);
		contentPane.add(panel);

		JLabel lblUpdatingReceiverInformations = new JLabel("Updating Receiver Informations\r\n");
		lblUpdatingReceiverInformations.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdatingReceiverInformations.setForeground(Color.WHITE);
		lblUpdatingReceiverInformations.setFont(new Font("Century", Font.PLAIN, 18));
		lblUpdatingReceiverInformations.setBounds(0, 11, 286, 108);
		panel.add(lblUpdatingReceiverInformations);

		lbl = new JLabel("ssn must be filled");
		lbl.setBounds(178, 413, 253, 14);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl.setVisible(false);
		contentPane.add(lbl);
	}

	// gender selection
	private void ActionPerformed1(java.awt.event.ActionEvent e) {
		if (tf5.getSelectedIndex() == 0)
			rgender = "";
		else if (tf5.getSelectedIndex() == 1)
			rgender = "female";
		else if (tf5.getSelectedIndex() == 2)
			rgender = "male";
	}

	// blood type selection
	private void ActionPerformed2(java.awt.event.ActionEvent e) {
		if (tf6.getSelectedIndex() == 0)
			r_btype = "";
		else if (tf6.getSelectedIndex() == 1)
			r_btype = "A-";
		else if (tf6.getSelectedIndex() == 2)
			r_btype = "A+";
		else if (tf6.getSelectedIndex() == 3)
			r_btype = "B-";
		else if (tf6.getSelectedIndex() == 4)
			r_btype = "B+";
		else if (tf6.getSelectedIndex() == 5)
			r_btype = "O-";
		else if (tf6.getSelectedIndex() == 6)
			r_btype = "O+";
		else if (tf6.getSelectedIndex() == 7)
			r_btype = "AB-";
		else if (tf6.getSelectedIndex() == 8)
			r_btype = "AB+";
	}

	// to get the date selection
	private void getDateFromUI() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		r_date = df.format(dateChooser.getDate());
	}

	private void jButtonActionPerformed(java.awt.event.ActionEvent e) throws SQLException, ParseException {
		DataBaseDriver dr = new DataBaseDriver();
		if (tf1.getText().compareTo("") == 0) {
			lbl.setVisible(true);
		} else if (tf1.getText().matches("-?\\d+(\\.\\d+)?") == false
				|| (tf3.getText().compareTo("") != 0 && tf3.getText().matches("-?\\d+(\\.\\d+)?") == false)) {
			lbl.setText("ssn and phone number must be numbers");
			lbl.setVisible(true);
		} else if ((tf2.getText().compareTo("") != 0 && tf2.getText().matches("[a-zA-Z]+") == false)
				|| (tf4.getText().compareTo("") != 0 && tf4.getText().matches("[a-zA-Z]+") == false)) {
			lbl.setText("name and address must be a string");
			lbl.setVisible(true);
		}

		else if (dr.search(Integer.valueOf(tf1.getText()), 2) == 0) {
			lbl.setText("this receiver ssn doesn't exist");
			lbl.setVisible(true);
		} else {
			lbl.setVisible(false);

			ArrayList<String> updatedColumns = new ArrayList<String>();
			ArrayList<String> updatedValues = new ArrayList<String>();

			if (tf2.getText().compareTo("") != 0) {
				updatedColumns.add("rName");
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
				updatedValues.add(r_date);
			}
			if (rgender.compareTo("") != 0) {
				updatedColumns.add("Gender");
				updatedValues.add(rgender);
			}
			if (r_btype.compareTo("") != 0) {
				updatedColumns.add("BloodType");
				updatedValues.add(r_btype);
			}

			int ssn = Integer.valueOf(tf1.getText());

			if ((!updatedColumns.isEmpty()) && !updatedValues.isEmpty())
				dr.update(2, ssn, updatedColumns, updatedValues);

		}
	}
}
