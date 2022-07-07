import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class Que1 extends JFrame {

	private String btype = "A-";
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JComboBox cb1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Que1 frame = new Que1();
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
	public Que1() {
		setTitle("Show all donor's names that donated a specific blood type");
		setBackground(new Color(255, 250, 240));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Que1.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 423);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(240, 255, 255));
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(128, 0, 0)));
		scrollPane.setBounds(85, 161, 365, 185);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(128, 0, 0));
		table.setFont(new Font("Century", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Donor"
			}
		));
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Choose blood type");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBackground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 15));
		lblNewLabel.setBounds(85, 25, 135, 45);
		contentPane.add(lblNewLabel);
		
		JButton btn = new JButton("FIND");
		btn.setForeground(new Color(255, 250, 240));
		btn.setBackground(new Color(128, 0, 0));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jButtonActionPerformed(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn.setFont(new Font("Century", Font.PLAIN, 15));
		btn.setBounds(85, 90, 365, 45);
		contentPane.add(btn);
		
		 cb1 = new JComboBox();
		 cb1.setEditable(true);
		cb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPerformed(e);
			}
		});
		cb1.setModel(new DefaultComboBoxModel(new String[] {"A-", "A+", "B-", "B+", "O-", "O+", "AB-", "AB+"}));
		cb1.setForeground(new Color(128, 0, 0));
		cb1.setFont(new Font("Century", Font.PLAIN, 15));
		cb1.setBounds(259, 25, 191, 45);
		contentPane.add(cb1);
	}
	
	// blood type selection
		private void ActionPerformed(java.awt.event.ActionEvent e) {
			if (cb1.getSelectedIndex() == 0)
				btype = "A-";
			else if (cb1.getSelectedIndex() == 1)
				btype = "A+";
			else if (cb1.getSelectedIndex() == 2)
				btype = "B-";
			else if (cb1.getSelectedIndex() == 3)
				btype = "B+";
			else if (cb1.getSelectedIndex() == 4)
				btype = "O-";
			else if (cb1.getSelectedIndex() == 5)
				btype = "O+";
			else if (cb1.getSelectedIndex() == 6)
				btype = "AB-";
			else if (cb1.getSelectedIndex() == 7)
				btype = "AB+";
		}



		
	
	private void jButtonActionPerformed(java.awt.event.ActionEvent e) throws SQLException  {
	
		
		// clear table
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		int rowCount = dm.getRowCount();
		// Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
			dm.removeRow(i);
		}
		
		DataBaseDriver dr = new DataBaseDriver();
		ArrayList<String> n = new ArrayList<String>();
		n = dr.q1(btype);
		
		// add to table
				DefaultTableModel model = (DefaultTableModel) table.getModel(); 
				for(int k = 0; k<n.size(); k++) { 
					  model.addRow(new Object[] {
							  n.get(k)
				   }); 
		
	}
	}
}
