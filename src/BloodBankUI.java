import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Toolkit;

public class BloodBankUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodBankUI frame = new BloodBankUI();
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
	public BloodBankUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BloodBankUI.class.getResource("/images/logo1.jpg")));
		setTitle("Blood Bank Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(102, 51, 51));
		panel.setBounds(0, 0, 750, 512);
		contentPane.add(panel);

		JButton btn2 = new JButton("Add a Blood Receiving Operation\r\n");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed2(e);
			}
		});
		btn2.setForeground(new Color(102, 0, 0));
		btn2.setFont(new Font("Century", Font.PLAIN, 14));
		btn2.setBackground(Color.WHITE);
		btn2.setBounds(412, 122, 300, 57);
		panel.add(btn2);

		JButton btn7 = new JButton("List all Blood Donation Operations\r\n");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jButtonActionPerformed7(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn7.setForeground(new Color(102, 0, 0));
		btn7.setFont(new Font("Century", Font.PLAIN, 14));
		btn7.setBackground(Color.WHITE);
		btn7.setBounds(42, 326, 300, 57);
		panel.add(btn7);

		JButton btn1 = new JButton("Add a Blood Donation Operation\r\n");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed1(e);
			}
		});
		btn1.setForeground(new Color(102, 0, 0));
		btn1.setFont(new Font("Century", Font.PLAIN, 14));
		btn1.setBackground(Color.WHITE);
		btn1.setBounds(42, 122, 300, 57);
		panel.add(btn1);

		JButton btn5 = new JButton("Delete a Blood Donation Operation\r\n");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed5(e);
			}
		});
		btn5.setForeground(new Color(102, 0, 0));
		btn5.setFont(new Font("Century", Font.PLAIN, 14));
		btn5.setBackground(Color.WHITE);
		btn5.setBounds(42, 257, 300, 57);
		panel.add(btn5);

		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformedBack(e);
			}
		});
		btnback.setForeground(new Color(102, 0, 0));
		btnback.setFont(new Font("Century", Font.PLAIN, 14));
		btnback.setBackground(Color.WHITE);
		btnback.setBounds(225, 415, 300, 57);
		panel.add(btnback);

		JLabel lblBloodBankManagement = new JLabel("Blood Bank Management");
		lblBloodBankManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblBloodBankManagement.setForeground(Color.WHITE);
		lblBloodBankManagement.setFont(new Font("Century", Font.PLAIN, 25));
		lblBloodBankManagement.setBounds(42, 37, 670, 38);
		panel.add(lblBloodBankManagement);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(42, 86, 670, 10);
		panel.add(separator);

		JButton btn8 = new JButton("List all Blood Receiving Operations\r\n");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jButtonActionPerformed8(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn8.setForeground(new Color(102, 0, 0));
		btn8.setFont(new Font("Century", Font.PLAIN, 14));
		btn8.setBackground(Color.WHITE);
		btn8.setBounds(412, 326, 300, 57);
		panel.add(btn8);

		JButton btn4 = new JButton("Update a Blood Receiving Operation\r\n");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed4(e);
			}
		});
		btn4.setForeground(new Color(102, 0, 0));
		btn4.setFont(new Font("Century", Font.PLAIN, 14));
		btn4.setBackground(Color.WHITE);
		btn4.setBounds(412, 190, 300, 57);
		panel.add(btn4);

		JButton btn3 = new JButton("Update a Blood Donation Operation\r\n");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed3(e);
			}
		});
		btn3.setForeground(new Color(102, 0, 0));
		btn3.setFont(new Font("Century", Font.PLAIN, 14));
		btn3.setBackground(Color.WHITE);
		btn3.setBounds(42, 190, 300, 57);
		panel.add(btn3);

		JButton btn6 = new JButton("Delete a Blood Receiving Operation\r\n");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed6(e);
			}
		});
		btn6.setForeground(new Color(102, 0, 0));
		btn6.setFont(new Font("Century", Font.PLAIN, 14));
		btn6.setBackground(Color.WHITE);
		btn6.setBounds(412, 257, 300, 57);
		panel.add(btn6);
	}

	private void jButtonActionPerformedBack(java.awt.event.ActionEvent e) {
		UI2 newFrame = new UI2(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		dispose(); // to close the current frame(screen/window)
	}

	// add donation operation
	private void jButtonActionPerformed1(java.awt.event.ActionEvent e) {
		DonationAddUI newFrame = new DonationAddUI(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	// add receiving operation
	private void jButtonActionPerformed2(java.awt.event.ActionEvent e) {
		ReceivingAddUI newFrame = new ReceivingAddUI(); // to open a new frame(screen/window) when pressing on the
														// button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	// update donation operation
	private void jButtonActionPerformed3(java.awt.event.ActionEvent e) {
		DonationUpdateUI newFrame = new DonationUpdateUI(); // to open a new frame(screen/window) when pressing on the
															// button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	// update receiving operation
	private void jButtonActionPerformed4(java.awt.event.ActionEvent e) {
		ReceivingUpdateUI newFrame = new ReceivingUpdateUI(); // to open a new frame(screen/window) when pressing on the
																// button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	// delete donation operation
	private void jButtonActionPerformed5(java.awt.event.ActionEvent e) {
		DonationDeleteUI newFrame = new DonationDeleteUI(); // to open a new frame(screen/window) when pressing on the
															// button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	// delete receiving operation
	private void jButtonActionPerformed6(java.awt.event.ActionEvent e) {
		ReceivingDeleteUI newFrame = new ReceivingDeleteUI(); // to open a new frame(screen/window) when pressing on the
																// button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	// list all donation operations
	private void jButtonActionPerformed7(java.awt.event.ActionEvent e) throws SQLException {
		DonationListUI newFrame = new DonationListUI(); // to open a new frame(screen/window) when pressing on the
														// button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	// list all receiving operation
	private void jButtonActionPerformed8(java.awt.event.ActionEvent e) throws SQLException {
		ReceivingListUI newFrame = new ReceivingListUI(); // to open a new frame(screen/window) when pressing on the
															// button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}
}
