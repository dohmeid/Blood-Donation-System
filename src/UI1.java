import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JDesktopPane;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextArea;

public class UI1 extends JFrame {

	private JPanel contentPane;
	private JTextField name1;
	private JPasswordField passField;
	private JTextField txtF1;
	private JTextField txtF3;
	private JTextField txtF2;
	private JTextArea txtF4;
	private Panel panel1;
	private Panel panel2;
	private Panel panel3;
	private JLabel lbl11;
	private JLabel lbl22;
	private JLabel lbl33;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI1 frame = new UI1();
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
	public UI1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(UI1.class.getResource("/images/logo1.jpg")));
		setTitle("Blood Donation System");
		setBounds(100, 100, 952, 612);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel2 = new Panel();
		panel2.setBackground(new Color(165, 42, 42));
		panel2.setBounds(378, 0, 562, 577);
		contentPane.add(panel2);
		panel2.setLayout(null);

		name1 = new JTextField();
		name1.setBounds(100, 209, 360, 55);
		panel2.add(name1);
		name1.setColumns(10);

		passField = new JPasswordField();
		passField.setBounds(100, 331, 360, 55);
		panel2.add(passField);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(100, 296, 127, 35);
		panel2.add(lblPassword);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Century", Font.PLAIN, 15));

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(100, 174, 127, 35);
		panel2.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 15));

		JButton btn1 = new JButton("Log In");
		btn1.setBounds(100, 470, 360, 50);
		btn1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed1(e);
			}
		});
		panel2.add(btn1);
		btn1.setBackground(new Color(255, 240, 245));
		btn1.setForeground(new Color(165, 42, 42));
		btn1.setFont(new Font("Century", Font.PLAIN, 16));

		JLabel lblLogin = new JLabel("Welcome Back!");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Century", Font.PLAIN, 40));
		lblLogin.setBounds(100, 58, 360, 55);
		panel2.add(lblLogin);

		lbl11 = new JLabel("wrong username, TRY AGAIN");
		lbl11.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl11.setForeground(Color.WHITE);
		lbl11.setBounds(100, 264, 179, 21);
		lbl11.setVisible(false);
		panel2.add(lbl11);

		lbl22 = new JLabel("wrong password, TRY AGAIN");
		lbl22.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl22.setForeground(Color.WHITE);
		lbl22.setBounds(100, 386, 179, 21);
		panel2.add(lbl22);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(255, 250, 250));
		separator_1.setBackground(new Color(255, 250, 250));
		separator_1.setBounds(76, 124, 400, 5);
		panel2.add(separator_1);
		lbl22.setVisible(false);
		panel2.setVisible(true);

		panel3 = new Panel();
		panel3.setBackground(new Color(165, 42, 42));
		panel3.setBounds(378, 0, 562, 577);
		contentPane.add(panel3);
		panel3.setLayout(null);

		txtF1 = new JTextField();
		txtF1.setColumns(10);
		txtF1.setBounds(127, 137, 360, 50);
		panel3.add(txtF1);

		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Century", Font.PLAIN, 15));
		lblName.setBounds(47, 137, 70, 35);
		panel3.add(lblName);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Century", Font.PLAIN, 15));
		lblEmail.setBounds(47, 203, 70, 35);
		panel3.add(lblEmail);

		JButton btn2Reset = new JButton("RESET");
		btn2Reset.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed2reset(e);
			}
		});
		btn2Reset.setForeground(new Color(165, 42, 42));
		btn2Reset.setFont(new Font("Century", Font.PLAIN, 15));
		btn2Reset.setBackground(new Color(255, 240, 245));
		btn2Reset.setBounds(307, 497, 180, 44);
		panel3.add(btn2Reset);

		JLabel lblMessage = new JLabel("Message");
		lblMessage.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMessage.setForeground(Color.WHITE);
		lblMessage.setFont(new Font("Century", Font.PLAIN, 15));
		lblMessage.setBounds(47, 337, 70, 35);
		panel3.add(lblMessage);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Century", Font.PLAIN, 15));
		lblPhone.setBounds(47, 269, 70, 35);
		panel3.add(lblPhone);

		txtF3 = new JTextField();
		txtF3.setColumns(10);
		txtF3.setBounds(127, 269, 360, 50);
		panel3.add(txtF3);

		JButton btn2Submit = new JButton("SUBMIT");
		btn2Submit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				jButtonActionPerformed2submit(e);
			}
		});
		btn2Submit.setForeground(new Color(165, 42, 42));
		btn2Submit.setFont(new Font("Century", Font.PLAIN, 15));
		btn2Submit.setBackground(new Color(255, 240, 245));
		btn2Submit.setBounds(127, 497, 180, 44);
		panel3.add(btn2Submit);

		txtF2 = new JTextField();
		txtF2.setColumns(10);
		txtF2.setBounds(127, 203, 360, 50);
		panel3.add(txtF2);

		txtF4 = new JTextArea();
		txtF4.setBounds(127, 334, 360, 110);
		panel3.add(txtF4);

		JLabel lblNewLabel_2 = new JLabel("Get In Touch");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Century", Font.PLAIN, 30));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(127, 39, 360, 44);
		panel3.add(lblNewLabel_2);

		lbl33 = new JLabel("Thanks for your opinion ^_^");
		lbl33.setHorizontalAlignment(SwingConstants.CENTER);
		lbl33.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl33.setForeground(Color.WHITE);
		lbl33.setBounds(127, 542, 360, 14);
		lbl33.setVisible(false);
		panel3.add(lbl33);

		JLabel lblNewLabel_3 = new JLabel("We are here for you! how can we help?");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setForeground(new Color(255, 250, 250));
		lblNewLabel_3.setBounds(127, 94, 360, 14);
		panel3.add(lblNewLabel_3);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 250, 250));
		separator.setBackground(new Color(255, 250, 250));
		separator.setBounds(107, 85, 400, 5);
		panel3.add(separator);

		panel1 = new Panel();
		panel1.setBackground(new Color(255, 255, 255));
		panel1.setBounds(0, 0, 377, 577);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel lblManagementSystem = new JLabel("Management system");
		lblManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagementSystem.setForeground(new Color(128, 0, 0));
		lblManagementSystem.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblManagementSystem.setBounds(34, 293, 320, 35);
		panel1.add(lblManagementSystem);

		JLabel lblNewLabel_4 = new JLabel("Palestinian Blood Donation \r\n");
		lblNewLabel_4.setForeground(new Color(128, 0, 0));
		lblNewLabel_4.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(34, 263, 320, 35);
		panel1.add(lblNewLabel_4);

		JLabel img1 = new JLabel("");
		img1.setBounds(89, 86, 200, 190);
		panel1.add(img1);
		img1.setIcon(new ImageIcon(UI1.class.getResource("/images/n3.jpg")));
		img1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/n3.jpg")).getImage()
				.getScaledInstance(200, 190, Image.SCALE_SMOOTH)));
		Panel tab2 = new Panel();
		tab2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel2.setVisible(false);
				panel3.setVisible(true);

			}
		});
		tab2.setLayout(null);
		tab2.setForeground(new Color(0, 128, 0));
		tab2.setFont(null);
		tab2.setBackground(new Color(245, 245, 245));
		tab2.setBounds(0, 460, 377, 54);
		panel1.add(tab2);

		JLabel lblNewLabel_1 = new JLabel("CONTACT US");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel2.setVisible(false);
				panel3.setVisible(true);
			}
		});
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(110, 11, 160, 31);
		tab2.add(lblNewLabel_1);

		Panel tab1 = new Panel();
		tab1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel2.setVisible(true);
				panel3.setVisible(false);
			}
		});
		tab1.setLayout(null);
		tab1.setForeground(new Color(0, 128, 0));
		tab1.setFont(null);
		tab1.setBackground(new Color(245, 245, 245));
		tab1.setBounds(0, 400, 377, 54);
		panel1.add(tab1);

		JLabel label = new JLabel("LOGIN\r\n");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel2.setVisible(true);
				panel3.setVisible(false);
			}
		});
		label.setForeground(new Color(128, 0, 0));
		label.setToolTipText("");
		label.setFont(new Font("Century", Font.PLAIN, 17));
		label.setBounds(110, 11, 160, 31);
		tab1.add(label);
	}

	// for admin registration: to register to the database system as a data base
	// administrator the
	// username: admin
	// password: 12345
	@SuppressWarnings("deprecation")
	private void jButtonActionPerformed1(java.awt.event.ActionEvent e) {
		int flag1 = 0, flag2 = 0;
		lbl11.setVisible(false);
		lbl22.setVisible(false);

		if (name1.getText().compareTo("admin") == 0) {
			System.out.println("correct username");
			flag1 = 1;
		} else {
			System.out.println("incorrect username");
			lbl11.setVisible(true);
		}

		if (passField.getText().compareTo("12345") == 0) {
			System.out.println("correct password");
			flag2 = 1;
		} else {
			System.out.println("incorrect password");
			lbl22.setVisible(true);
		}

		if (flag1 == 1 && flag2 == 1) {
			System.out.println("Welcome to Blood Donation Management system");
			UI2 newFrame = new UI2(); // to open a new frame(screen/window) when pressing on the button
			newFrame.show();
			dispose(); // to close the current frame(screen/window)
		}

	}

	// for contact us window
	private void jButtonActionPerformed2submit(java.awt.event.ActionEvent e) {
		System.out.println("ggg2");
		lbl33.setVisible(true);

	}

	private void jButtonActionPerformed2reset(java.awt.event.ActionEvent e) {
		System.out.println("ggg3");
		txtF1.setText("");
		txtF2.setText("");
		txtF3.setText("");
		txtF4.setText("");
	}
}
