package pack1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DBDAO;
import model.DBDTO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplyPatrol {
	
	DBDAO dao = new DBDAO();
	private JFrame frame;
	private JPanel contentPane;
	private JTextField donotusethisTextField;
	private JTextField id_textField;
	private JTextField location_text;
    
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ApplyPatrol window = new ApplyPatrol();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	} 

	/**
	 * Create the frame.
	 */
	
	public ApplyPatrol(DBDTO dto) {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		frame.setTitle("방범대 지원");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		JTextField numberTextField = new JTextField();
		numberTextField.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				numberTextField.setText("YYMMDD - xxxxxxx");
			}
		});
		numberTextField.setBounds(164, 70, 240, 35);
		contentPane.add(numberTextField);
		numberTextField.setColumns(10);

		JLabel ss_number_label = new JLabel("\uC8FC\uBBFC\uBC88\uD638 \uC785\uB825");
		ss_number_label.setHorizontalAlignment(SwingConstants.CENTER);
		ss_number_label.setBounds(29, 70, 112, 35);
		contentPane.add(ss_number_label);

		JButton confirmBtn = new JButton("\uD655\uC778");
		confirmBtn.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
		            String id =id_textField.getText();
		            String ssnum = numberTextField.getText();
		            String guard = location_text.getText();
		            
		            int cnt = dao.apply(id,ssnum,guard);
		            if ( cnt == 0) {
		               JOptionPane.showMessageDialog(null, "신청이 잘못되었습니다.", "방범대 지원", JOptionPane.INFORMATION_MESSAGE);
		            }else {
		               JOptionPane.showMessageDialog(null, "신청완료! \n승인은 3일정도 소요됩니다.", "방범대 지원", JOptionPane.INFORMATION_MESSAGE);
		            }
		            
		            frame.dispose();
		            c_main main = new c_main(dto);
		            
		         }
		});
		confirmBtn.setBounds(71, 185, 112, 46);
		contentPane.add(confirmBtn);

		JButton BackBtn = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		BackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				c_main m_main = new c_main(dto);
				
			}
		});
		BackBtn.setBounds(259, 185, 112, 46);
		contentPane.add(BackBtn);
		
		JLabel location_label = new JLabel("\uC544\uC774\uB514 \uC785\uB825");
		location_label.setHorizontalAlignment(SwingConstants.CENTER);
		location_label.setBounds(29, 25, 112, 35);
		contentPane.add(location_label);
		
		id_textField = new JTextField();
		id_textField.setColumns(10);
		id_textField.setBounds(164, 25, 240, 35);
		contentPane.add(id_textField);
		
		location_text = new JTextField();
		location_text.setColumns(10);
		location_text.setBounds(164, 118, 240, 35);
		contentPane.add(location_text);
		
		JLabel label = new JLabel("\uC9C0\uC5ED\uAD6C \uC785\uB825");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(29, 118, 112, 35);
		contentPane.add(label);
		

	}
}