import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class ReceiverUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiverUI frame = new ReceiverUI();
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
	public ReceiverUI() {
		setTitle("Receiver menu");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReceiverUI.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 547);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("Add a new blood receiver\r\n");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed2(e);
			}
		});
		btnAdd.setForeground(new Color(102, 0, 0));
		btnAdd.setFont(new Font("Century", Font.PLAIN, 14));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(38, 125, 300, 57);
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update a blood receiver informations\r\n");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed3(e);
			}
		});
		btnUpdate.setForeground(new Color(102, 0, 0));
		btnUpdate.setFont(new Font("Century", Font.PLAIN, 14));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(38, 193, 300, 57);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete a blood receiver informations\r\n");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed4(e);
			}
		});
		btnDelete.setForeground(new Color(102, 0, 0));
		btnDelete.setFont(new Font("Century", Font.PLAIN, 14));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBounds(38, 261, 300, 57);
		contentPane.add(btnDelete);
		
		JButton btnListAll = new JButton("List all blood receivers\r\n");
		btnListAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jButtonActionPerformed5(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnListAll.setForeground(new Color(102, 0, 0));
		btnListAll.setFont(new Font("Century", Font.PLAIN, 14));
		btnListAll.setBackground(Color.WHITE);
		btnListAll.setBounds(38, 330, 300, 57);
		contentPane.add(btnListAll);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed1(e);
			}
		});
		btnback.setForeground(new Color(102, 0, 0));
		btnback.setFont(new Font("Century", Font.PLAIN, 14));
		btnback.setBackground(Color.WHITE);
		btnback.setBounds(38, 398, 300, 57);
		contentPane.add(btnback);
		
		JLabel lblReceiver = new JLabel("RECEIVER");
		lblReceiver.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceiver.setForeground(Color.WHITE);
		lblReceiver.setFont(new Font("Century", Font.PLAIN, 25));
		lblReceiver.setBounds(38, 38, 300, 38);
		contentPane.add(lblReceiver);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(10, 85, 360, 7);
		contentPane.add(separator);
	}

	private void jButtonActionPerformed1(java.awt.event.ActionEvent e) {
		UI2 newFrame = new UI2(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		dispose(); // to close the current frame(screen/window)
	}

	// add
	private void jButtonActionPerformed2(java.awt.event.ActionEvent e) {
		ReceiverAddUI newFrame = new ReceiverAddUI(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	// update
	private void jButtonActionPerformed3(java.awt.event.ActionEvent e) {
		ReceiverUpdateUI newFrame = new ReceiverUpdateUI(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	// delete
	private void jButtonActionPerformed4(java.awt.event.ActionEvent e) {
		ReceiverDeleteUI newFrame = new ReceiverDeleteUI(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	// list
	private void jButtonActionPerformed5(java.awt.event.ActionEvent e) throws SQLException {
		ReceiverList newFrame = new ReceiverList(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}
}
