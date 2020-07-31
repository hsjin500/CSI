package pack1;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.DBDTO;

public class myPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					myPage window = new myPage();
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
	public myPage(DBDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(DBDTO dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 304, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.setTitle("마이 페이지");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		JButton Btn_1 = new JButton("\uB0B4\uC815\uBCF4\uD655\uC778");
		Btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				myInfo myinfo = new myInfo(dto);

			}
		});
		Btn_1.setBounds(12, 32, 264, 36);
		frame.getContentPane().add(Btn_1);

		JButton Btn_3 = new JButton("\uD68C\uC6D0 \uC815\uBCF4 \uC218\uC815");
		Btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				modifyinfo m = new modifyinfo(dto);
			}
		});
		Btn_3.setBounds(12, 100, 264, 36);
		frame.getContentPane().add(Btn_3);

		JButton Btn_4 = new JButton("\uD68C\uC6D0 \uD0C8\uD1F4");
		Btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				delete d = new delete(dto);
			}
		});
		Btn_4.setBounds(12, 168, 264, 36);
		frame.getContentPane().add(Btn_4);

		JButton Btn_5 = new JButton("\uC774\uC804\uC73C\uB85C");
		Btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				if(dto.getGuard().equals("0")) {
				c_main cm = new c_main(dto);
				}else {
				g_main gm = new g_main(dto);
				}
			}
		});
		Btn_5.setBounds(12, 236, 264, 36);
		frame.getContentPane().add(Btn_5);

	}

}
