import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import java.awt.Toolkit;

public class Que3 extends JFrame {

	private JPanel contentPane;
	private JDateChooser dateChooser;
	private String date = "";
	private JTable table;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Que3 frame = new Que3();
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
	public Que3() {
		setTitle("Show all donors that donated in a specific date.");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Que3.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterDate = new JLabel("Enter date");
		lblEnterDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEnterDate.setForeground(new Color(128, 0, 0));
		lblEnterDate.setFont(new Font("Century", Font.PLAIN, 15));
		lblEnterDate.setBackground(new Color(128, 0, 0));
		lblEnterDate.setBounds(70, 19, 76, 45);
		contentPane.add(lblEnterDate);

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
		button.setBounds(70, 95, 331, 45);
		contentPane.add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(128, 0, 0)));
		scrollPane.setBounds(70, 151, 331, 185);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 250, 240));
		table.setForeground(new Color(128, 0, 0));
		table.setFont(new Font("Century", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "donor name" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(76);
		scrollPane.setViewportView(table);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(156, 19, 245, 40);
		contentPane.add(dateChooser);

		lbl = new JLabel("you must choose a date!");
		lbl.setFont(new Font("Century", Font.PLAIN, 10));
		lbl.setBounds(156, 59, 149, 14);
		lbl.setVisible(false);
		contentPane.add(lbl);
	}

	// to get the date selection
	private void getDateFromUI() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		date = df.format(dateChooser.getDate());

	}

	private void jButtonActionPerformed(java.awt.event.ActionEvent e) throws SQLException {
		
		// clear table
				DefaultTableModel dm = (DefaultTableModel) table.getModel();
				int rowCount = dm.getRowCount();
				// Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
					dm.removeRow(i);
				}
		
		
		if (dateChooser.getDate() == null) {
			lbl.setVisible(true);
		} else {
			lbl.setVisible(false);
			getDateFromUI();
			DataBaseDriver dr = new DataBaseDriver();
			ArrayList<String> n = new ArrayList<String>();
			n = dr.q3(date);

			// add to table
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for (int k = 0; k < n.size(); k++) {
				model.addRow(new Object[] { n.get(k) });

			}
		}
	}
}
