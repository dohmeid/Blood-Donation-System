import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class UI2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI2 frame = new UI2();
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
	public UI2() {
		setTitle("Blood Donation System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UI2.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 552);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Donor");
		lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(new Color(102, 0, 0));
		lblNewLabel_1.setForeground(new Color(153, 0, 0));
		lblNewLabel_1.setBounds(25, 425, 220, 24);
		contentPane.add(lblNewLabel_1);
		
		JButton btnBloodReceiver = new JButton("");
		btnBloodReceiver.setIcon(new ImageIcon(UI2.class.getResource("/images/img2.jpg")));
		btnBloodReceiver.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img2.jpg")).getImage()
				.getScaledInstance(200, 190, Image.SCALE_SMOOTH)));
		btnBloodReceiver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed2(e);
			}
		});
		btnBloodReceiver.setForeground(new Color(153, 102, 102));
		btnBloodReceiver.setFont(new Font("Century", Font.PLAIN, 14));
		btnBloodReceiver.setBackground(new Color(255, 255, 255));
		btnBloodReceiver.setBounds(255, 214, 220, 200);
		contentPane.add(btnBloodReceiver);
		
		JButton btnBloodSamples = new JButton("");
		btnBloodSamples.setIcon(new ImageIcon(UI2.class.getResource("/images/img3.jpg")));
		btnBloodSamples.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img3.jpg")).getImage()
				.getScaledInstance(200, 190, Image.SCALE_SMOOTH)));
		btnBloodSamples.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed4(e);
			}
		});
		btnBloodSamples.setForeground(new Color(153, 102, 102));
		btnBloodSamples.setFont(new Font("Century", Font.PLAIN, 14));
		btnBloodSamples.setBackground(new Color(255, 255, 255));
		btnBloodSamples.setBounds(715, 214, 220, 200);
		contentPane.add(btnBloodSamples);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 51, 51));
		panel.setBounds(0, 0, 973, 122);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdministratorPortal = new JLabel("Administrator Portal");
		lblAdministratorPortal.setBounds(35, 20, 350, 47);
		panel.add(lblAdministratorPortal);
		lblAdministratorPortal.setForeground(new Color(255, 255, 255));
		lblAdministratorPortal.setFont(new Font("Century", Font.PLAIN, 30));
		
		JLabel lblNewLabel = new JLabel("Welcome to the Palestinian Blood Donation System");
		lblNewLabel.setBounds(35, 75, 312, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 12));
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(20, 68, 400, 2);
		panel.add(separator);
		
		JButton btnDonor = new JButton("");
		btnDonor.setVerticalAlignment(SwingConstants.TOP);
		btnDonor.setIcon(new ImageIcon(UI2.class.getResource("/images/img8.jpg")));
		btnDonor.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img8.jpg")).getImage()
				.getScaledInstance(200, 190, Image.SCALE_SMOOTH)));
		btnDonor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed1(e);
			}
		});
		btnDonor.setForeground(new Color(204, 102, 102));
		btnDonor.setFont(new Font("Century", Font.PLAIN, 14));
		btnDonor.setBackground(new Color(255, 255, 255));
		btnDonor.setBounds(25, 214, 220, 200);
		contentPane.add(btnDonor);
		
		JLabel lblReceiver = new JLabel(" Receiver");
		lblReceiver.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceiver.setForeground(new Color(153, 0, 0));
		lblReceiver.setFont(new Font("Century", Font.PLAIN, 20));
		lblReceiver.setBackground(new Color(102, 0, 0));
		lblReceiver.setBounds(255, 425, 220, 24);
		contentPane.add(lblReceiver);
		
		JLabel lblBloodInventory = new JLabel("Blood Inventory ");
		lblBloodInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblBloodInventory.setForeground(new Color(153, 0, 0));
		lblBloodInventory.setFont(new Font("Century", Font.PLAIN, 20));
		lblBloodInventory.setBackground(new Color(102, 0, 0));
		lblBloodInventory.setBounds(485, 425, 220, 24);
		contentPane.add(lblBloodInventory);
		
		JLabel lblBloodSamples = new JLabel("Queries ");
		lblBloodSamples.setHorizontalAlignment(SwingConstants.CENTER);
		lblBloodSamples.setForeground(new Color(153, 0, 0));
		lblBloodSamples.setFont(new Font("Century", Font.PLAIN, 20));
		lblBloodSamples.setBackground(new Color(102, 0, 0));
		lblBloodSamples.setBounds(715, 425, 220, 24);
		contentPane.add(lblBloodSamples);
		
		JButton btnBloodInventory = new JButton("");
		btnBloodInventory.setIcon(new ImageIcon(UI2.class.getResource("/images/immm.png")));
		btnBloodInventory.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/immm.png")).getImage()
				.getScaledInstance(200, 190, Image.SCALE_SMOOTH)));
	
		btnBloodInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed3(e);
			}
		});
		btnBloodInventory.setForeground(new Color(153, 102, 102));
		btnBloodInventory.setFont(new Font("Century", Font.PLAIN, 14));
		btnBloodInventory.setBackground(Color.WHITE);
		btnBloodInventory.setBounds(485, 214, 220, 200);
		contentPane.add(btnBloodInventory);
		

	}
	
	private void jButtonActionPerformed1(java.awt.event.ActionEvent e) {
		DonorUI newFrame = new DonorUI(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		dispose(); // to close the current frame(screen/window)
	}
	
	private void jButtonActionPerformed2(java.awt.event.ActionEvent e) {
		ReceiverUI newFrame = new ReceiverUI(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		dispose(); // to close the current frame(screen/window)
	}
	
	private void jButtonActionPerformed3(java.awt.event.ActionEvent e) {
		BloodBankUI newFrame = new BloodBankUI(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		dispose(); // to close the current frame(screen/window)
	}
	
	private void jButtonActionPerformed4(java.awt.event.ActionEvent e) {
		QueriesUI newFrame = new QueriesUI(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		//dispose(); // to close the current frame(screen/window)
	}
}
