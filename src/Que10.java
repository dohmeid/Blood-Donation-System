import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class Que10 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JDateChooser dateChooser1;
	private JDateChooser dateChooser2;
	private String date1 = "";
	private String date2 = "";
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Que10 frame = new Que10();
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
	public Que10() {
		setTitle("Show average blood donation rate in a specific period of time");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Que10.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		 dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(197, 22, 240, 40);
		contentPane.add(dateChooser1);

		JLabel label = new JLabel("Enter start date");
		label.setForeground(new Color(128, 0, 0));
		label.setFont(new Font("Century", Font.PLAIN, 15));
		label.setBackground(new Color(128, 0, 0));
		label.setBounds(61, 22, 126, 40);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Enter end date");
		label_1.setForeground(new Color(128, 0, 0));
		label_1.setFont(new Font("Century", Font.PLAIN, 15));
		label_1.setBackground(new Color(128, 0, 0));
		label_1.setBounds(61, 78, 126, 40);
		contentPane.add(label_1);

		 dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(197, 78, 240, 40);
		contentPane.add(dateChooser2);

		JButton button = new JButton("FIND");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jButtonActionPerformed(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setForeground(new Color(255, 250, 240));
		button.setFont(new Font("Century", Font.PLAIN, 15));
		button.setBackground(new Color(128, 0, 0));
		button.setBounds(61, 162, 376, 45);
		contentPane.add(button);

		JLabel lblAverageBloodDonation = new JLabel("Average blood donation rate");
		lblAverageBloodDonation.setForeground(new Color(128, 0, 0));
		lblAverageBloodDonation.setFont(new Font("Century", Font.PLAIN, 15));
		lblAverageBloodDonation.setBackground(new Color(128, 0, 0));
		lblAverageBloodDonation.setBounds(61, 218, 200, 40);
		contentPane.add(lblAverageBloodDonation);

		textField = new JTextField();
		textField.setBounds(296, 220, 141, 40);
		contentPane.add(textField);
		//textField.setText("0");
		textField.setColumns(10);

		lbl = new JLabel("you must choose dates!");
		lbl.setFont(new Font("Century", Font.PLAIN, 10));
		lbl.setBounds(190, 120, 134, 14);
		lbl.setVisible(false);
		contentPane.add(lbl);
	}

	// to get the date selection
	private void getDateFromUI() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		date1 = df.format(dateChooser1.getDate());
		date2 = df.format(dateChooser2.getDate());
	}

	private void jButtonActionPerformed(java.awt.event.ActionEvent e) throws SQLException {
		if (dateChooser1.getDate() == null || dateChooser2.getDate() == null) {
			lbl.setVisible(true);
		} else {
			lbl.setVisible(false);
			getDateFromUI();
			DataBaseDriver dr = new DataBaseDriver();
			ArrayList<String> n = new ArrayList<String>();
			n = dr.q10(date1, date2);
			textField.setText(n.get(0));
		}
	}
}
