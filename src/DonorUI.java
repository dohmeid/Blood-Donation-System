import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class DonorUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonorUI frame = new DonorUI();
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
	public DonorUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DonorUI.class.getResource("/images/logo1.jpg")));
		setTitle("Donor Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 547);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAdd = new JButton("Add a new blood donor\r\n");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed2(e);
			}
		});
		btnAdd.setForeground(new Color(102, 0, 0));
		btnAdd.setFont(new Font("Century", Font.PLAIN, 14));
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setBounds(42, 121, 300, 57);
		contentPane.add(btnAdd);

		JButton btnList = new JButton("List all blood donors\r\n");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jButtonActionPerformed5(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnList.setForeground(new Color(102, 0, 0));
		btnList.setFont(new Font("Century", Font.PLAIN, 14));
		btnList.setBackground(Color.WHITE);
		btnList.setBounds(42, 326, 300, 57);
		contentPane.add(btnList);

		JButton btnUpdate = new JButton("Update a blood donor informations\r\n");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed3(e);
			}
		});
		btnUpdate.setForeground(new Color(102, 0, 0));
		btnUpdate.setFont(new Font("Century", Font.PLAIN, 14));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(42, 189, 300, 57);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete a blood donor informations\r\n");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed4(e);
			}
		});
		btnDelete.setForeground(new Color(102, 0, 0));
		btnDelete.setFont(new Font("Century", Font.PLAIN, 14));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(42, 257, 300, 57);
		contentPane.add(btnDelete);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed1(e);
			}
		});
		btnBack.setForeground(new Color(102, 0, 0));
		btnBack.setFont(new Font("Century", Font.PLAIN, 14));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(42, 394, 300, 57);
		contentPane.add(btnBack);

		JLabel lblNewLabel = new JLabel("DONOR");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 25));
		lblNewLabel.setBounds(42, 37, 300, 38);
		contentPane.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(10, 86, 357, 7);
		contentPane.add(separator);
	}

	private void jButtonActionPerformed1(java.awt.event.ActionEvent e) {
		UI2 newFrame = new UI2(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		dispose(); // to close the current frame(screen/window)
	}

	// add
	private void jButtonActionPerformed2(java.awt.event.ActionEvent e) {
		DonorAddUI newFrame = new DonorAddUI(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	// update
	private void jButtonActionPerformed3(java.awt.event.ActionEvent e) {
		DonorUpdateUI newFrame = new DonorUpdateUI(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	// delete
	private void jButtonActionPerformed4(java.awt.event.ActionEvent e) {
		DonorDeleteUI newFrame = new DonorDeleteUI(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	// list
	private void jButtonActionPerformed5(java.awt.event.ActionEvent e) throws SQLException {
		DonorList newFrame = new DonorList(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

}
