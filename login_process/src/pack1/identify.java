package pack1;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.DBDAO;
import model.DBDTO;

public class identify {

	private JFrame frame;
	private JTextField idf_id;
	private JPasswordField idf_pw;
	DBDAO dao = new DBDAO();
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					identify window = new identify(dto);
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
	public identify(DBDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(DBDTO dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 264);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("관리자 확인");
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				if(dto != null) {
					if(dto.getId().equals("admin")) {
						frame.dispose();
						k_gaip k_gaip = new k_gaip(dto);
					}else {
						JOptionPane.showMessageDialog(null, "관리자만 접근가능합니다.");
						frame.dispose();
						g_main g_main = new g_main(dto);
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "관리자만 접근가능합니다.");
					frame.dispose();
					g_main g_main = new g_main(dto);
				}
			}
		});
		btnNewButton.setBounds(84, 162, 97, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("\uCDE8\uC18C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				g_main g_main = new g_main(dto);
				
			}
		});
		button.setBounds(257, 162, 97, 41);
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("\uAD00\uB9AC\uC790 \uD655\uC778");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(109, 10, 215, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(69, 68, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(69, 109, 57, 15);
		frame.getContentPane().add(label);
		
		idf_id = new JTextField();
		idf_id.setBounds(142, 65, 149, 21);
		frame.getContentPane().add(idf_id);
		idf_id.setColumns(10);
		
		idf_pw = new JPasswordField();
		idf_pw.setBounds(142, 106, 149, 21);
		frame.getContentPane().add(idf_pw);
	}
}
