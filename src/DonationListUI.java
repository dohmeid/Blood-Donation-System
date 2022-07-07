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

public class DonationListUI extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonationListUI frame = new DonationListUI();
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
	public DonationListUI() throws SQLException {
		setTitle("Donotion Operations Table");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DonationListUI.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(0, 0, 918, 415);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(102, 0, 0)));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 80, 893, 320);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "dSSN", "DateofDonation", "BloodType", "BloodTypeQuantity", "Hospital" ,"Doctor"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblDonotionOperationsTable = new JLabel("Donotion Operations Table\r\n");
		lblDonotionOperationsTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonotionOperationsTable.setForeground(new Color(128, 0, 0));
		lblDonotionOperationsTable.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		lblDonotionOperationsTable.setBackground(new Color(128, 0, 0));
		lblDonotionOperationsTable.setBounds(10, 29, 893, 40);
		panel.add(lblDonotionOperationsTable);
		fillTable();
		}
		
		private void fillTable() throws SQLException {

			DataBaseDriver dr = new DataBaseDriver();
			ArrayList<String> data = new ArrayList<String>();
			data = dr.listTable(3);

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
