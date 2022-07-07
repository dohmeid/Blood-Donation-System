import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class Que7 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JDateChooser dateChooser2;
	private JDateChooser dateChooser1;
	private JComboBox cb1;
	private String btype = "A-";
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
					Que7 frame = new Que7();
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
	public Que7() {
		setTitle("Show all blood receivers that received a specific blood type in a specific period of time\r\n\t\t");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Que7.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 527);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		 dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(229, 72, 255, 40);
		contentPane.add(dateChooser1);

		JLabel label = new JLabel("Enter start date");
		label.setForeground(new Color(128, 0, 0));
		label.setFont(new Font("Century", Font.PLAIN, 15));
		label.setBackground(new Color(128, 0, 0));
		label.setBounds(59, 78, 130, 34);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Enter end date");
		label_1.setForeground(new Color(128, 0, 0));
		label_1.setFont(new Font("Century", Font.PLAIN, 15));
		label_1.setBackground(new Color(128, 0, 0));
		label_1.setBounds(59, 134, 130, 34);
		contentPane.add(label_1);

		 dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(229, 128, 255, 40);
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
		button.setBounds(59, 221, 425, 45);
		contentPane.add(button);

		JLabel label_2 = new JLabel("Choose blood type");
		label_2.setForeground(new Color(128, 0, 0));
		label_2.setFont(new Font("Century", Font.PLAIN, 15));
		label_2.setBackground(new Color(128, 0, 0));
		label_2.setBounds(59, 27, 130, 40);
		contentPane.add(label_2);

		 cb1 = new JComboBox();
		cb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPerformed(e);
			}
		});
		cb1.setModel(new DefaultComboBoxModel(new String[] { "A-", "A+", "B-", "B+", "O-", "O+", "AB-", "AB+" }));
		cb1.setForeground(new Color(128, 0, 0));
		cb1.setFont(new Font("Century", Font.PLAIN, 15));
		cb1.setEditable(true);
		cb1.setBounds(229, 21, 255, 40);
		contentPane.add(cb1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 277, 425, 193);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Donors" }));
		scrollPane.setViewportView(table);
		
		 lbl = new JLabel("you must choose dates!");
			lbl.setFont(new Font("Century", Font.PLAIN, 10));
			lbl.setBounds(229, 179, 134, 14);
			lbl.setVisible(false);
			contentPane.add(lbl);
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

	// to get the date selection
		private void getDateFromUI() {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			date1 = df.format(dateChooser1.getDate());
			date2 = df.format(dateChooser2.getDate());
		}
	
	private void jButtonActionPerformed(java.awt.event.ActionEvent e) throws SQLException {

		// clear table
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		int rowCount = dm.getRowCount();
		// Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
			dm.removeRow(i);
		}
		
		if (dateChooser1.getDate() == null || dateChooser2.getDate() == null) {
			lbl.setVisible(true);
		} else {
			lbl.setVisible(false);
		getDateFromUI();
		DataBaseDriver dr = new DataBaseDriver();
		ArrayList<String> n = new ArrayList<String>();
		n = dr.q7(btype,date1,date2);
		// add to table
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int k = 0; k < n.size(); k++) {
			model.addRow(new Object[] { n.get(k) });

		}
	}
	}
}
