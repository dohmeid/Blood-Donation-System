import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class DonorDeleteUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtf;
	private JPanel panel;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonorDeleteUI frame = new DonorDeleteUI();
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
	public DonorDeleteUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DonorDeleteUI.class.getResource("/images/logo1.jpg")));
		setTitle("Donor Deletion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the ssn for the donor to delete");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 13));
		lblNewLabel.setBounds(33, 100, 233, 40);
		contentPane.add(lblNewLabel);
		
		txtf = new JTextField();
		txtf.setFont(new Font("Century", Font.PLAIN, 13));
		txtf.setBounds(276, 102, 200, 40);
		contentPane.add(txtf);
		txtf.setColumns(10);
		
		JButton btn = new JButton("DELETE");
		btn.setFont(new Font("Century", Font.PLAIN, 13));
		btn.setForeground(new Color(255, 255, 255));
		btn.setBackground(new Color(165, 42, 42));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						jButtonActionPerformed(e);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
		});
		btn.setBounds(276, 168, 200, 40);
		contentPane.add(btn);
		
		panel = new JPanel();
		panel.setBackground(new Color(165, 42, 42));
		panel.setBounds(0, 0, 510, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDeletingADonor = new JLabel("Deleting A Donor\r\n");
		lblDeletingADonor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeletingADonor.setForeground(Color.WHITE);
		lblDeletingADonor.setFont(new Font("Century", Font.PLAIN, 20));
		lblDeletingADonor.setBounds(10, 11, 480, 35);
		panel.add(lblDeletingADonor);
		
		lbl = new JLabel("ssn must be filled");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl.setBounds(276, 143, 200, 14);
		lbl.setVisible(false);
		contentPane.add(lbl);
	}

	private void jButtonActionPerformed(java.awt.event.ActionEvent e) throws SQLException  {
		DataBaseDriver dr = new DataBaseDriver();
		if(txtf.getText().compareTo("")==0) {
			lbl.setVisible(true);
		}
		else if(txtf.getText().matches("-?\\d+(\\.\\d+)?")==false) {
			lbl.setText("ssn must be a number");
			lbl.setVisible(true);
		}
		else if(dr.search(Integer.valueOf(txtf.getText()), 1) == 0){
			lbl.setText("this donor ssn does not exist");
			lbl.setVisible(true);
		}
		else {
			lbl.setVisible(false);
		int ssn=Integer.valueOf(txtf.getText());
		
		
		dr.delete(1, ssn); //flag=1 : delete from donor table
		System.out.println("deleting done");
		
	}}
}
