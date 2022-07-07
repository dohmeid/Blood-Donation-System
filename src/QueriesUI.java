import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

public class QueriesUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueriesUI frame = new QueriesUI();
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
	public QueriesUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(QueriesUI.class.getResource("/images/logo1.jpg")));
		setTitle("Queries");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(102, 51, 51));
		panel.setBounds(0, 0, 1018, 594);
		contentPane.add(panel);

		JButton btn7 = new JButton(
				"Show all blood receivers that received a specific blood type in a specific period of time\r\n\t\t");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed7(e);
			}
		});
		btn7.setForeground(new Color(102, 0, 0));
		btn7.setFont(new Font("Century", Font.BOLD, 11));
		btn7.setBackground(Color.WHITE);
		btn7.setBounds(549, 122, 430, 57);
		panel.add(btn7);

		JButton btn4 = new JButton("Show all donors for each blood group");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jButtonActionPerformed4(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn4.setForeground(new Color(102, 0, 0));
		btn4.setFont(new Font("Century", Font.BOLD, 11));
		btn4.setBackground(Color.WHITE);
		btn4.setBounds(42, 326, 430, 57);
		panel.add(btn4);

		JButton btn1 = new JButton("show the names of all donors that donated a specific blood type");
		btn1.setToolTipText("show the names of all donors that donated a specific blood type");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed1(e);
			}
		});
		btn1.setForeground(new Color(102, 0, 0));
		btn1.setFont(new Font("Century", Font.BOLD, 11));
		btn1.setBackground(Color.WHITE);
		btn1.setBounds(42, 122, 430, 57);
		panel.add(btn1);

		JButton btn3 = new JButton("Show the names of all donors that have donated in a specific date");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed3(e);
			}
		});
		btn3.setForeground(new Color(102, 0, 0));
		btn3.setFont(new Font("Century", Font.BOLD, 11));
		btn3.setBackground(Color.WHITE);
		btn3.setBounds(42, 257, 430, 57);
		panel.add(btn3);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformedBack(e);
			}
		});
		btnBack.setForeground(new Color(102, 0, 0));
		btnBack.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 11));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(549, 462, 430, 57);
		panel.add(btnBack);

		JLabel lblQueries = new JLabel("Queries");
		lblQueries.setHorizontalAlignment(SwingConstants.CENTER);
		lblQueries.setForeground(Color.WHITE);
		lblQueries.setFont(new Font("Century", Font.PLAIN, 25));
		lblQueries.setBounds(42, 37, 937, 38);
		panel.add(lblQueries);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(42, 86, 937, 10);
		panel.add(separator);

		JButton btn10 = new JButton("Show average blood donation rate in a specific period of time");
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed10(e);
			}
		});
		btn10.setForeground(new Color(102, 0, 0));
		btn10.setFont(new Font("Century", Font.BOLD, 11));
		btn10.setBackground(Color.WHITE);
		btn10.setBounds(549, 326, 430, 57);
		panel.add(btn10);

		JButton btn8 = new JButton("show all receivers for each blood group");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jButtonActionPerformed8(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn8.setForeground(new Color(102, 0, 0));
		btn8.setFont(new Font("Century", Font.BOLD, 11));
		btn8.setBackground(Color.WHITE);
		btn8.setBounds(549, 190, 430, 57);
		panel.add(btn8);

		JButton btn2 = new JButton("Show the blood stock (total quantities) of each blood type");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jButtonActionPerformed2(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn2.setForeground(new Color(102, 0, 0));
		btn2.setFont(new Font("Century", Font.BOLD, 11));
		btn2.setBackground(Color.WHITE);
		btn2.setBounds(42, 190, 430, 57);
		panel.add(btn2);

		JButton btn9 = new JButton("Show highest bloodtype received in a certain period of time");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed9(e);
			}
		});
		btn9.setForeground(new Color(102, 0, 0));
		btn9.setFont(new Font("Century", Font.BOLD, 11));
		btn9.setBackground(Color.WHITE);
		btn9.setBounds(549, 257, 430, 57);
		panel.add(btn9);

		JButton btn11 = new JButton("Show average demand on each blood group in certain amont of time");
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jButtonActionPerformed11(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn11.setForeground(new Color(102, 0, 0));
		btn11.setFont(new Font("Century", Font.BOLD, 11));
		btn11.setBackground(Color.WHITE);
		btn11.setBounds(549, 394, 430, 57);
		panel.add(btn11);

		JButton btn5 = new JButton("Show all donors that donated in a specific period of time");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed5(e);
			}
		});
		btn5.setForeground(new Color(102, 0, 0));
		btn5.setFont(new Font("Century", Font.BOLD, 11));
		btn5.setBackground(Color.WHITE);
		btn5.setBounds(42, 394, 430, 57);
		panel.add(btn5);

		JButton btn6 = new JButton("to show highest bloodstock in a certain period of time");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed6(e);
			}
		});
		btn6.setForeground(new Color(102, 0, 0));
		btn6.setFont(new Font("Century", Font.BOLD, 11));
		btn6.setBackground(Color.WHITE);
		btn6.setBounds(42, 462, 430, 57);
		panel.add(btn6);
	}

	private void jButtonActionPerformedBack(java.awt.event.ActionEvent e) {
		UI2 newFrame = new UI2(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		dispose(); // to close the current frame(screen/window)
	}

	private void jButtonActionPerformed1(java.awt.event.ActionEvent e) {
		Que1 newFrame = new Que1(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	private void jButtonActionPerformed2(java.awt.event.ActionEvent e) throws SQLException {
		Que2 newFrame = new Que2(); // to open a new frame(screen/window) when pressing on the
									// button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	private void jButtonActionPerformed3(java.awt.event.ActionEvent e) {
		Que3 newFrame = new Que3(); // to open a new frame(screen/window) when pressing on the
									// button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	private void jButtonActionPerformed4(java.awt.event.ActionEvent e) throws SQLException {
		Que4 newFrame = new Que4(); // to open a new frame(screen/window) when pressing on the
									// button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	private void jButtonActionPerformed5(java.awt.event.ActionEvent e) {
		Que5 newFrame = new Que5(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	private void jButtonActionPerformed6(java.awt.event.ActionEvent e) {
		Que6 newFrame = new Que6(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	private void jButtonActionPerformed7(java.awt.event.ActionEvent e) {
		Que7 newFrame = new Que7(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	private void jButtonActionPerformed8(java.awt.event.ActionEvent e) throws SQLException {
		Que8 newFrame = new Que8(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	private void jButtonActionPerformed9(java.awt.event.ActionEvent e) {
		Que9 newFrame = new Que9(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	private void jButtonActionPerformed10(java.awt.event.ActionEvent e) {
		Que10 newFrame = new Que10(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}

	private void jButtonActionPerformed11(java.awt.event.ActionEvent e) throws SQLException {
		Que11 newFrame = new Que11(); // to open a new frame(screen/window) when pressing on the button
		newFrame.show();
		// dispose(); // to close the current frame(screen/window)
	}
}
