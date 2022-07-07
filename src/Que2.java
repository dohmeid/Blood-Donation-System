import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class Que2 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Que2 frame = new Que2();
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
	public Que2() throws SQLException {
		setTitle(" Show blood stock of each blood type");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Que2.class.getResource("/images/logo1.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 308);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 38, 450, 200);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(new Color(128, 0, 0));
		table.setFont(new Font("Century", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Blood Type", "Stock"
			}
		));
		scrollPane.setViewportView(table);
		fillTable();
	}
	
	private void fillTable() throws SQLException {

		DataBaseDriver dr = new DataBaseDriver();
		ArrayList<String> data = new ArrayList<String>();
		data = dr.q2();
		
		
		// add to table
		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
		for(int k = 0; k<data.size(); k+=2) { 
			  model.addRow(new Object[] {
					  data.get(k),  data.get(k+1)
		   }); 
		   
		  } 
	
	}

}
