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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class Que5 extends JFrame {

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
					Que5 frame = new Que5();
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
	public Que5() {
		setTitle("Show all donors that donated in a specific period of time");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Que5.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(208, 26, 230, 40);
		contentPane.add(dateChooser1);

		JLabel lblEnterStartDate = new JLabel("Enter start date");
		lblEnterStartDate.setForeground(new Color(128, 0, 0));
		lblEnterStartDate.setFont(new Font("Century", Font.PLAIN, 15));
		lblEnterStartDate.setBackground(new Color(128, 0, 0));
		lblEnterStartDate.setBounds(56, 26, 126, 40);
		contentPane.add(lblEnterStartDate);

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
		button.setBounds(56, 160, 382, 45);
		contentPane.add(button);

		dateChooser2 = new JDateChooser();
		dateChooser2.setBounds(208, 82, 230, 40);
		contentPane.add(dateChooser2);

		JLabel lblEnterFinishDate = new JLabel("Enter end date");
		lblEnterFinishDate.setForeground(new Color(128, 0, 0));
		lblEnterFinishDate.setFont(new Font("Century", Font.PLAIN, 15));
		lblEnterFinishDate.setBackground(new Color(128, 0, 0));
		lblEnterFinishDate.setBounds(56, 82, 126, 40);
		contentPane.add(lblEnterFinishDate);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 216, 382, 176);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Donors" }));
		scrollPane.setViewportView(table);

		 lbl = new JLabel("you must choose dates!");
		lbl.setFont(new Font("Century", Font.PLAIN, 10));
		lbl.setBounds(208, 133, 126, 14);
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
			ArrayList<String> n = new ArrayList<String>();
			n = dr.q5(date1, date2);

			// add to table
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for (int k = 0; k < n.size(); k++) {
				model.addRow(new Object[] { n.get(k) });

			}
		}
	}
}
