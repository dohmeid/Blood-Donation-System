import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReceiverList extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiverList frame = new ReceiverList();
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
	public ReceiverList() throws SQLException {
		setTitle("Receiver List");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReceiverList.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 948, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReceiversTable = new JLabel("Receiver's Table\r\n");
		lblReceiversTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceiversTable.setForeground(new Color(128, 0, 0));
		lblReceiversTable.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 20));
		lblReceiversTable.setBackground(new Color(128, 0, 0));
		lblReceiversTable.setBounds(24, 11, 893, 40);
		contentPane.add(lblReceiversTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(102, 0, 0)));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(24, 62, 893, 335);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"rSSN", "rname", "phone number", "address", "date of birth", "gender", "blood type"
			}
		));
		scrollPane.setViewportView(table);
		fillTable();
	}
	
	private void fillTable() throws SQLException {

		DataBaseDriver dr = new DataBaseDriver();
		ArrayList<String> data = new ArrayList<String>();
		data = dr.listTable(2);

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
		
		System.out.println("ggg12gggggggggg");
		
	
	}
}
