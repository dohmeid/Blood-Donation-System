import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class Que11 extends JFrame {

	private JPanel contentPane;
	private JTable table;
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
					Que11 frame = new Que11();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public Que11() throws SQLException {
		setTitle("Show average demand on each blood group in certain amount of time");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Que11.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Enter start date");
		label.setHorizontalAlignment(SwingConstants.LEADING);
		label.setForeground(new Color(128, 0, 0));
		label.setFont(new Font("Century", Font.PLAIN, 15));
		label.setBackground(new Color(128, 0, 0));
		label.setBounds(71, 35, 126, 40);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Enter end date");
		label_1.setHorizontalAlignment(SwingConstants.LEADING);
		label_1.setForeground(new Color(128, 0, 0));
		label_1.setFont(new Font("Century", Font.PLAIN, 15));
		label_1.setBackground(new Color(128, 0, 0));
		label_1.setBounds(71, 91, 126, 40);
		contentPane.add(label_1);

		dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(207, 91, 296, 40);
		contentPane.add(dateChooser2);

		dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(207, 35, 296, 40);
		contentPane.add(dateChooser1);

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
		button.setBounds(71, 171, 432, 45);
		contentPane.add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 227, 432, 117);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setForeground(new Color(128, 0, 0));
		table.setFont(new Font("Century", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "AVG", "Blood Type" }));
		scrollPane.setViewportView(table);
		
		 lbl = new JLabel("you must choose dates!");
			lbl.setFont(new Font("Century", Font.PLAIN, 10));
			lbl.setBounds(207, 130, 134, 14);
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
			ArrayList<String> data = new ArrayList<String>();
			data = dr.q11(date1, date2);
			// add to table
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for (int k = 0; k < data.size(); k += 2) {
				model.addRow(new Object[] { data.get(k), data.get(k + 1) });

			}

		}
	}

}
