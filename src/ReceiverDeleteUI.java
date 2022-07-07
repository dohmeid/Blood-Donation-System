import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ReceiverDeleteUI extends JFrame {

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
					ReceiverDeleteUI frame = new ReceiverDeleteUI();
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
	public ReceiverDeleteUI() {
		setTitle("Receiver Deletion");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReceiverDeleteUI.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(165, 42, 42));
		panel.setBounds(0, 0, 510, 57);
		contentPane.add(panel);
		
		JLabel lblDeletingAReceiver = new JLabel("Deleting A Receiver \r\n");
		lblDeletingAReceiver.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeletingAReceiver.setForeground(Color.WHITE);
		lblDeletingAReceiver.setFont(new Font("Century", Font.PLAIN, 20));
		lblDeletingAReceiver.setBounds(10, 11, 480, 35);
		panel.add(lblDeletingAReceiver);
		
		JLabel lblEnterTheSsn = new JLabel("Enter the ssn for the receiver to delete");
		lblEnterTheSsn.setForeground(new Color(128, 0, 0));
		lblEnterTheSsn.setFont(new Font("Century", Font.PLAIN, 13));
		lblEnterTheSsn.setBounds(33, 100, 237, 40);
		contentPane.add(lblEnterTheSsn);
		
		tf = new JTextField();
		tf.setFont(new Font("Century", Font.PLAIN, 13));
		tf.setColumns(10);
		tf.setBounds(280, 100, 200, 40);
		contentPane.add(tf);
		
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
		btn.setBounds(280, 168, 200, 40);
		contentPane.add(btn);
		lbl = new JLabel("ssn must be filled");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl.setBounds(276, 143, 190, 14);
		lbl.setVisible(false);
		contentPane.add(lbl);
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
		else if(dr.search(Integer.valueOf(tf.getText()), 2) == 0){
			lbl.setText("this receiver ssn does not exist");
			lbl.setVisible(true);
		}
		else {
			lbl.setVisible(false);
		int ssn=Integer.valueOf(tf.getText());
		
		
		dr.delete(2, ssn); //flag=2 : delete from receiver table
		System.out.println("deleting done");
		}
	}

}
