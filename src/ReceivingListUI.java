import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReceivingListUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceivingListUI frame = new ReceivingListUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public ReceivingListUI() throws SQLException {
		setTitle("Receiving Operations Table");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReceivingListUI.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReceivingOperationsTable = new JLabel("Receiving Operation's Table");
		lblReceivingOperationsTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceivingOperationsTable.setForeground(new Color(128, 0, 0));
		lblReceivingOperationsTable.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		lblReceivingOperationsTable.setBackground(new Color(128, 0, 0));
		lblReceivingOperationsTable.setBounds(10, 28, 893, 40);
		contentPane.add(lblReceivingOperationsTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 893, 308);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "rSSN", "DateofReceiving", "BloodType", "BloodTypeQuantity", "Hospital" ,"Doctor"
			}
		));
		table.setBackground(new Color(253, 245, 230));
		scrollPane.setViewportView(table);
		
		fillTable();
	}
	
	private void fillTable() throws SQLException {

		DataBaseDriver dr = new DataBaseDriver();
		ArrayList<String> data = new ArrayList<String>();
		data = dr.listTable(4);

		// add to table
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		for(int k = 0; k<dr.count_rows; k++) { 
			int i=0;
			if (k!=0)
				i = (k)*6 +k;
			  model.addRow(new Object[] {
					  data.get(0+i),  data.get(1+i), data.get(2+i), data.get(3+i), data.get(4+i),
						data.get(5+i), data.get(6+i)
		   }); 
		   
		  } 
		
	
	}
		 
}
