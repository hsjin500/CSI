package pack1;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;

import model.DBDAO;
import model.DBDTO;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class delete {

	private JFrame frame;
	private JPasswordField pwTextField;
	private JTextField idTextField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					delete window = new delete();
////					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public delete(DBDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(DBDTO dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 238, 305);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("회원 탈퇴");
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0 \uD0C8\uD1F4");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 198, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC138\uC694");
		lblNewLabel_2.setBounds(12, 54, 113, 24);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694");
		label.setBounds(12, 122, 139, 24);
		frame.getContentPane().add(label);
		
		pwTextField = new JPasswordField();
		pwTextField.setBounds(12, 156, 175, 24);
		frame.getContentPane().add(pwTextField);
		
		JButton confirmBtn = new JButton("\uD0C8\uD1F4");
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CheckLogin cl = new CheckLogin();
				DBDAO.init();
				if(cl.checkIdPw(idTextField.getText(), pwTextField.getText())) {
					DBDAO.delete(idTextField.getText());
					frame.dispose();
					JOptionPane.showMessageDialog(null, "회원정보가 삭제되었습니다.");
				}else {
					JOptionPane.showMessageDialog(null, "해당 회원정보가 없습니다.");
				}
			
			}
		});
		confirmBtn.setBounds(12, 216, 86, 40);
		frame.getContentPane().add(confirmBtn);
		
		JButton cancelBtn = new JButton("\uCDE8\uC18C");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
			myPage mp = new myPage(dto);
			
				
			}
		});
		cancelBtn.setBounds(124, 216, 86, 40);
		frame.getContentPane().add(cancelBtn);
		
		idTextField = new JTextField();
		idTextField.setBounds(12, 80, 175, 21);
		frame.getContentPane().add(idTextField);
		idTextField.setColumns(10);
	}
}
