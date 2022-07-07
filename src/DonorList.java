import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class DonorList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonorList frame = new DonorList();
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
	public DonorList() throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DonorList.class.getResource("/images/logo1.jpg")));
		setTitle("Donor List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(102, 0, 0)));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 80, 893, 320);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"dSSN", "dname", "phone number", "address", "date of birth", "gender", "blood type", "blood hgb", "Eligible to donate"
			}
		));
		table.setBackground(new Color(255, 239, 213));
		
		lblNewLabel = new JLabel("Donor's Table\r\n");
		lblNewLabel.setBackground(new Color(128, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBounds(10, 29, 893, 40);
		contentPane.add(lblNewLabel);
		
		fillTable();
	}

	private void fillTable() throws SQLException {

		DataBaseDriver dr = new DataBaseDriver();
		ArrayList<String> data = new ArrayList<String>();
		data = dr.listTable(1);

		// add to table
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		for(int k = 0; k<dr.count_rows; k++) { 
			int i=0;
			if (k!=0)
				i = (k)*8 +k;
			  model.addRow(new Object[] {
					  data.get(0+i),  data.get(1+i), data.get(2+i), data.get(3+i), data.get(4+i),
						data.get(5+i), data.get(6+i), data.get(7+i), data.get(8+i)
		   }); 
		   
		  } 
		
		System.out.println("ggg12gggggggggg");
		
	
	}
		 
	
}
