package pack1;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ApplyPatrol {
	
	DBDAO dao = new DBDAO();
	private JFrame frame;
	private JPanel contentPane;
	private JTextField donotusethisTextField;
	private JTextField id_textField;
	private String location;
	int cnt = 0 ;
	int text_try = 0;
    
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
					if(text_try == 0) {
						numberTextField.setText("");
					}
			}
			public void focusLost(FocusEvent e) {
				if(numberTextField.getText().equals("")) {
					numberTextField.setText("YYMMDD - XXXXXXX");
				}
				text_try += 1;
			}
		});
		numberTextField.setBounds(164, 79, 240, 35);
		contentPane.add(numberTextField);
		numberTextField.setColumns(10);
		numberTextField.setText("YYMMDD - XXXXXXX");

		JLabel ss_number_label = new JLabel("\uC8FC\uBBFC\uBC88\uD638 \uC785\uB825");
		ss_number_label.setHorizontalAlignment(SwingConstants.CENTER);
		ss_number_label.setBounds(29, 79, 112, 35);
		contentPane.add(ss_number_label);

		JButton confirmBtn = new JButton("\uD655\uC778");
		confirmBtn.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
		            String id =id_textField.getText();
		            String ssnum = numberTextField.getText();
		            String guard = location;
		            
		      
		            if(!guard.equals("0")) {
		            	cnt = dao.apply(id,ssnum,guard);
		            	if ( cnt == 0) {
		            		JOptionPane.showMessageDialog(null, "신청이 잘못되었습니다.", "방범대 지원", JOptionPane.INFORMATION_MESSAGE);
		            	}else {
		            		JOptionPane.showMessageDialog(null, "신청완료! \n승인은 3일정도 소요됩니다.", "방범대 지원", JOptionPane.INFORMATION_MESSAGE);
		            		frame.dispose();
		            		c_main main = new c_main(dto);
		            	}
		            }else {
		            	JOptionPane.showMessageDialog(null, "지역구 선택을 해주세요.");
		            }
		            
		            
		         }
		});
		confirmBtn.setBounds(71, 193, 112, 46);
		contentPane.add(confirmBtn);

		JButton BackBtn = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		BackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				c_main m_main = new c_main(dto);
				
			}
		});
		BackBtn.setBounds(259, 193, 112, 46);
		contentPane.add(BackBtn);
		
		JLabel location_label = new JLabel("\uC544\uC774\uB514 \uC785\uB825");
		location_label.setHorizontalAlignment(SwingConstants.CENTER);
		location_label.setBounds(29, 22, 112, 35);
		contentPane.add(location_label);
		
		id_textField = new JTextField();
		id_textField.setEditable(false);
		id_textField.setColumns(10);
		id_textField.setBounds(164, 22, 240, 35);
		contentPane.add(id_textField);
		id_textField.setText(dto.getId());
		
		JLabel label = new JLabel("\uC9C0\uC5ED\uAD6C \uC785\uB825");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(29, 136, 112, 35);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"구", "광산구", "남구", "동구", "북구", "서구"}));
		comboBox.setBounds(164, 136, 240, 35);
		contentPane.add(comboBox);
		
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if("남구".equals(comboBox.getSelectedItem())) {
		    		location = "남구";
		    	}else if("서구".equals(comboBox.getSelectedItem())) {
		    		location = "서구";
		    	}else if("북구".equals(comboBox.getSelectedItem())) {
		    		location = "북구";
		    	}else if("광산구".equals(comboBox.getSelectedItem())) {
		    		location = "광산구";
		    	}else if("동구".equals(comboBox.getSelectedItem())) {
		    		location = "동구";
		    	}else if("구".equals(comboBox.getSelectedItem())) {
		    		location = "0";
		    	}
		    }
		});
	}
}