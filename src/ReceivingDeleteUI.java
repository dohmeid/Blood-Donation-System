import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ReceivingDeleteUI extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceivingDeleteUI frame = new ReceivingDeleteUI();
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
	public ReceivingDeleteUI() {
		setTitle("Deleting A Blood Receiving Operation");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReceivingDeleteUI.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 600, 233);
		contentPane.add(panel);
		
		JLabel lblEnterTheId = new JLabel("Enter the id for the receiving operation to delete");
		lblEnterTheId.setForeground(new Color(128, 0, 0));
		lblEnterTheId.setFont(new Font("Century", Font.PLAIN, 13));
		lblEnterTheId.setBounds(33, 100, 334, 40);
		panel.add(lblEnterTheId);
		
		tf = new JTextField();
		tf.setFont(new Font("Century", Font.PLAIN, 13));
		tf.setColumns(10);
		tf.setBounds(346, 100, 200, 40);
		panel.add(tf);
		
		JButton btn = new JButton("DELETE");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						jButtonActionPerformed(e);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
		});
		btn.setForeground(Color.WHITE);
		btn.setFont(new Font("Century", Font.PLAIN, 13));
		btn.setBackground(new Color(165, 42, 42));
		btn.setBounds(346, 165, 200, 40);
		panel.add(btn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(165, 42, 42));
		panel_1.setBounds(0, 0, 597, 57);
		panel.add(panel_1);
		
		JLabel lblDeletingABlood = new JLabel("Deleting A Blood Receiving Operation");
		lblDeletingABlood.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeletingABlood.setForeground(Color.WHITE);
		lblDeletingABlood.setFont(new Font("Century", Font.PLAIN, 20));
		lblDeletingABlood.setBounds(10, 11, 577, 35);
		panel_1.add(lblDeletingABlood);
		
		lbl = new JLabel("ssn must be filled");
		lbl.setBounds(344, 140, 150, 14);
		panel.add(lbl);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl.setVisible(false);
	}
	
	private void jButtonActionPerformed(java.awt.event.ActionEvent e) throws SQLException  {
		DataBaseDriver dr = new DataBaseDriver();
		if(tf.getText().compareTo("")==0) {
			lbl.setVisible(true);
		}
		else if(tf.getText().matches("-?\\d+(\\.\\d+)?")==false) {
			lbl.setText("ssn must be a number");
			lbl.setVisible(true);
		}
		else if(dr.search(Integer.valueOf(tf.getText()), 4) == 0){
			lbl.setText("this id does not exist");
			lbl.setVisible(true);
		}
		else {
			lbl.setVisible(false);
		int id=Integer.valueOf(tf.getText());
		
		
		dr.delete(4, id); 
		System.out.println("deleting done");
		
	}}

}
