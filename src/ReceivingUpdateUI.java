import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class ReceivingUpdateUI extends JFrame {
	private String btype = "";
	private String d_date = "";
	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	private JDateChooser dateChooser;
	private JComboBox tf3 ;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceivingUpdateUI frame = new ReceivingUpdateUI();
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
	public ReceivingUpdateUI() {
		setTitle("Updating Receiving Operation Informations");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReceivingUpdateUI.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tf1 = new JTextField();
		tf1.setForeground(new Color(102, 0, 0));
		tf1.setFont(new Font("Century", Font.PLAIN, 13));
		tf1.setColumns(10);
		tf1.setBounds(171, 13, 260, 40);
		contentPane.add(tf1);

		JLabel label = new JLabel("ID");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(102, 0, 0));
		label.setFont(new Font("Century", Font.PLAIN, 15));
		label.setBounds(10, 11, 150, 40);
		contentPane.add(label);

		JLabel label_1 = new JLabel("rSSN");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(new Color(102, 0, 0));
		label_1.setFont(new Font("Century", Font.PLAIN, 15));
		label_1.setBounds(10, 62, 150, 40);
		contentPane.add(label_1);

		tf2 = new JTextField();
		tf2.setForeground(new Color(102, 0, 0));
		tf2.setFont(new Font("Century", Font.PLAIN, 13));
		tf2.setColumns(10);
		tf2.setBounds(171, 64, 260, 40);
		contentPane.add(tf2);

		 dateChooser = new JDateChooser();
		dateChooser.setBounds(171, 115, 260, 40);
		contentPane.add(dateChooser);

		JLabel label_2 = new JLabel("Date Of Receiving");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(new Color(102, 0, 0));
		label_2.setFont(new Font("Century", Font.PLAIN, 15));
		label_2.setBounds(10, 115, 150, 40);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Blood Type");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(new Color(102, 0, 0));
		label_3.setFont(new Font("Century", Font.PLAIN, 15));
		label_3.setBounds(10, 166, 150, 40);
		contentPane.add(label_3);

		 tf3 = new JComboBox();
		 tf3.setModel(new DefaultComboBoxModel(new String[] {"none", "A-", "A+", "B-", "B+", "O-", "O+", "AB-", "AB+"}));
		 tf3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ActionPerformed(e);
				}
			});
		tf3.setForeground(new Color(128, 0, 0));
		tf3.setFont(new Font("Century", Font.PLAIN, 13));
		tf3.setBounds(171, 166, 260, 40);
		contentPane.add(tf3);

		tf4 = new JTextField();
		tf4.setForeground(new Color(102, 0, 0));
		tf4.setFont(new Font("Century", Font.PLAIN, 13));
		tf4.setColumns(10);
		tf4.setBounds(171, 217, 260, 40);
		contentPane.add(tf4);

		JLabel label_4 = new JLabel("Blood Quantity");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(new Color(102, 0, 0));
		label_4.setFont(new Font("Century", Font.PLAIN, 15));
		label_4.setBounds(10, 216, 150, 40);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("Hospital");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setForeground(new Color(102, 0, 0));
		label_5.setFont(new Font("Century", Font.PLAIN, 15));
		label_5.setBounds(10, 268, 150, 40);
		contentPane.add(label_5);

		tf5 = new JTextField();
		tf5.setForeground(new Color(102, 0, 0));
		tf5.setFont(new Font("Century", Font.PLAIN, 13));
		tf5.setColumns(10);
		tf5.setBounds(171, 270, 260, 40);
		contentPane.add(tf5);

		tf6 = new JTextField();
		tf6.setForeground(new Color(102, 0, 0));
		tf6.setFont(new Font("Century", Font.PLAIN, 13));
		tf6.setColumns(10);
		tf6.setBounds(171, 321, 260, 40);
		contentPane.add(tf6);

		JLabel label_6 = new JLabel("Doctor");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setForeground(new Color(102, 0, 0));
		label_6.setFont(new Font("Century", Font.PLAIN, 15));
		label_6.setBounds(10, 319, 150, 40);
		contentPane.add(label_6);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(165, 42, 42));
		panel.setBounds(454, 0, 296, 130);
		contentPane.add(panel);

		JLabel lblUpdatingReceivingOperation = new JLabel("Updating Receiving Operation Informations\r\n");
		lblUpdatingReceivingOperation.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdatingReceivingOperation.setForeground(Color.WHITE);
		lblUpdatingReceivingOperation.setFont(new Font("Century", Font.PLAIN, 14));
		lblUpdatingReceivingOperation.setBounds(0, 11, 296, 108);
		panel.add(lblUpdatingReceivingOperation);

		JTextArea txtrImportantNoteyou = new JTextArea();
		txtrImportantNoteyou.setText(
				"IMPORTANT NOTE:\r\n-you must fill the id for the Receiving operation \r\n-only fill the values that you want to change\r\n-and leave the others empty");
		txtrImportantNoteyou.setTabSize(10);
		txtrImportantNoteyou.setLineWrap(true);
		txtrImportantNoteyou.setForeground(new Color(102, 0, 0));
		txtrImportantNoteyou.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtrImportantNoteyou.setEditable(false);
		txtrImportantNoteyou.setBounds(475, 166, 265, 177);
		contentPane.add(txtrImportantNoteyou);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(128, 0, 0));
		separator.setBackground(new Color(128, 0, 0));
		separator.setBounds(454, 11, 11, 449);
		contentPane.add(separator);

		JButton btn = new JButton("Update");
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
					}}
		});
		btn.setForeground(new Color(253, 245, 230));
		btn.setFont(new Font("Century", Font.PLAIN, 11));
		btn.setBackground(new Color(165, 42, 42));
		btn.setBounds(171, 420, 260, 40);
		contentPane.add(btn);
		
		lbl = new JLabel("all fields must be filled");
		lbl.setBounds(171, 402, 260, 14);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl.setVisible(false);
		contentPane.add(lbl);
	}

	// blood type selection
	private void ActionPerformed(java.awt.event.ActionEvent e) {
		if (tf3.getSelectedIndex() == 0)
			btype = "";
		else if (tf3.getSelectedIndex() == 1)
			btype = "A-";
		else if (tf3.getSelectedIndex() ==2)
			btype = "A+";
		else if (tf3.getSelectedIndex() == 3)
			btype = "B-";
		else if (tf3.getSelectedIndex() == 4)
			btype = "B+";
		else if (tf3.getSelectedIndex() == 5)
			btype = "O-";
		else if (tf3.getSelectedIndex() == 6)
			btype = "O+";
		else if (tf3.getSelectedIndex() == 7)
			btype = "AB-";
		else if (tf3.getSelectedIndex() == 8)
			btype = "AB+";
	}

	// to get the date selection
	private void getDateFromUI() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (dateChooser.getDate() == null)
			d_date = "";
		else
			d_date = df.format(dateChooser.getDate());
	}

	private void jButtonActionPerformed(java.awt.event.ActionEvent e) throws SQLException, ParseException {
		DataBaseDriver dr = new DataBaseDriver();
		if(tf1.getText().compareTo("")==0) {
			lbl.setVisible(true);
		}
	
		else if(tf1.getText().matches("-?\\d+(\\.\\d+)?")==false || ( tf2.getText().compareTo("") != 0 && tf2.getText().matches("-?\\d+(\\.\\d+)?")==false )
				|| (tf4.getText().matches("-?\\d+(\\.\\d+)?")==false) && tf4.getText().compareTo("") != 0 ){
			lbl.setText("id,ssn and blood quantity must be numbers");
			lbl.setVisible(true);
			//phone.getText().matches("-?\\d+(\\.\\d+)?")==false 
		}
		else if( (tf5.getText().matches("[a-zA-Z]+")==false && tf5.getText().compareTo("") != 0)|| (tf6.getText().matches("[a-zA-Z]+")==false && tf6.getText().compareTo("") != 0)) {
			
			lbl.setText("hospital and doctor names must be strings");
			lbl.setVisible(true);
		}
		
		else if(dr.search(Integer.valueOf(tf1.getText()), 4) == 0){
			lbl.setText("this id doesn't exist");
			lbl.setVisible(true);
		}
		else if(tf2.getText().compareTo("") != 0 && dr.search(Integer.valueOf(tf2.getText()), 2) == 0){
			lbl.setText("this receiver ssn doesn't exist");
			lbl.setVisible(true);
		}
		
		
		
		
		else {
			lbl.setVisible(false);
		
		ArrayList<String> updatedColumns = new ArrayList<String>();
		ArrayList<String> updatedValues = new ArrayList<String>();
		

		if (tf2.getText().compareTo("") != 0) {
			updatedColumns.add("rSSN");
			updatedValues.add(tf2.getText());
		}
		if (dateChooser.getDate() != null) {
			getDateFromUI();
			updatedColumns.add("DateofReceiving");
			updatedValues.add(d_date);
		}
		if (btype.compareTo("") != 0) {
			updatedColumns.add("BloodType");
			updatedValues.add(btype);
		}
		if (tf4.getText().compareTo("") != 0) {
			updatedColumns.add("BloodTypeQuantity");
			updatedValues.add(tf4.getText());
		}
		if (tf5.getText().compareTo("") != 0) {
			updatedColumns.add("Hospital");
			updatedValues.add(tf5.getText());
		}
		if (tf6.getText().compareTo("") != 0) {
			updatedColumns.add("Doctor");
			updatedValues.add(tf6.getText());
		}

		int id = Integer.valueOf(tf1.getText());
		if((!updatedColumns.isEmpty()) && !updatedValues.isEmpty()) 
			dr.update(4, id, updatedColumns, updatedValues);

		}
	}
}
