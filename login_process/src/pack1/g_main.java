package pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import model.DBDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

public class g_main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					g_main window = new g_main();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public g_main(DBDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(DBDTO dto) {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Mapo한아름", Font.BOLD, 20));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 422, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		frame.setTitle("방범대_메인");
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		JLabel lblNewLabel = new JLabel("WELCOME GUARD");
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(61, 27, 291, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("LOGOUT");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UISignup uiSignup = new UISignup();
				uiSignup.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_2.setBounds(155, 510, 97, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("MY PAGE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				myPage mp = new myPage(dto);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		btnNewButton.setBounds(297, 80, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD604\uD669 \uC870\uD68C");
		btnNewButton_1.setFont(new Font("Mapo한아름", Font.PLAIN, 20));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, " 접수내역을 확인합니다. " );
				frame.dispose();
				g_plz gp = new g_plz(dto);
			}
			
		});
		btnNewButton_1.setBounds(61, 136, 291, 59);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("\uC21C\uCC30 \uB8E8\uD2B8 \uD655\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				g_route gr =  new g_route(dto);
			}
		});
		button.setFont(new Font("Mapo한아름", Font.PLAIN, 20));
		button.setBackground(Color.WHITE);
		button.setBounds(61, 205, 291, 59);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("방범대원 조회");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				g_guard gf = new g_guard(dto);
;			}
		});
		button_1.setFont(new Font("Mapo한아름", Font.PLAIN, 20));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(61, 274, 291, 59);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\uC77C\uBC18\uD68C\uC6D0 \uBA85\uB2E8");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				g_normal gm = new g_normal(dto);
			}
		});
		button_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(61, 346, 291, 59);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\uAC00\uC785 \uB300\uAE30\uC790");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				identify identify = new identify(dto);
				}
		});
		button_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(61, 422, 291, 59);
		frame.getContentPane().add(button_3);
	}
}