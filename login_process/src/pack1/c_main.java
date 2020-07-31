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

import model.DBDAO;
import model.DBDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

public class c_main {

   private JFrame frame;
	
   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               c_main window = new c_main();
//               window.frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }

   /**
    * Create the application.
    */
   public c_main(DBDTO dto) {
      initialize(dto);
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize(DBDTO dto) {
      frame = new JFrame();
      frame.getContentPane().setBackground(Color.WHITE);
      frame.setBounds(100, 100, 353, 477);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      
      frame.setTitle("일반사용자 메인화면");
         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
      
      JPanel panel = new JPanel();
      panel.setBackground(Color.WHITE);
      panel.setBounds(12, 63, 309, 309);
      frame.getContentPane().add(panel);
      panel.setLayout(null);
      
      JButton btnnn = new JButton("\uBC29\uBC94\uB300 \uC704\uCE58 \uD655\uC778");
      btnnn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 frame.dispose();
        	 Maps maps = new Maps(dto);
         }
      });
      btnnn.setBackground(Color.WHITE);
      btnnn.setForeground(Color.DARK_GRAY);
      btnnn.setFont(new Font("굴림", Font.BOLD, 13));
      btnnn.setBounds(40, 18, 236, 55);
      panel.add(btnnn);
      
      JButton button_1 = new JButton("\uC21C\uCC30 \uC694\uCCAD");
      button_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 frame.dispose();
        	request rq = new request(dto);
         }
      });
      button_1.setBackground(Color.WHITE);
      button_1.setForeground(Color.DARK_GRAY);
      button_1.setFont(new Font("굴림", Font.BOLD, 13));
      button_1.setBounds(40, 91, 236, 55);
      panel.add(button_1);
      
      JButton button_2 = new JButton("\uBBF8\uC544 \uC2E0\uACE0");
      button_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 frame.dispose();
        	 mia mia = new mia(dto);
         }
      });
      button_2.setBackground(Color.WHITE);
      button_2.setForeground(Color.DARK_GRAY);
      button_2.setFont(new Font("굴림", Font.BOLD, 13));
      button_2.setBounds(40, 164, 236, 55);
      panel.add(button_2);
      
      JButton btnNewButton_1 = new JButton("\uBC29\uBC94\uB300 \uC9C0\uC6D0\uD558\uAE30");
      btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	  String id = dto.getId();
             
             DBDAO dao = new DBDAO();
//              0은 대기, 1은 거절  // 승인하면 temp에서 행 삭제
             
             if(dao.tempHistory(id).equals("0")) {
                  JOptionPane.showMessageDialog(null, "승인대기 중입니다.", "정보", JOptionPane.INFORMATION_MESSAGE);

                
             }else if(dao.tempHistory(id).equals("1")) {
                  JOptionPane.showMessageDialog(null, "이미 거절되었습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);

             }else {
                frame.dispose();
                 ApplyPatrol applypatrol = new ApplyPatrol(dto);
             }
         }
      });
      btnNewButton_1.setBackground(Color.WHITE);
      btnNewButton_1.setForeground(Color.DARK_GRAY);
      btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 13));
      btnNewButton_1.setBounds(40, 237, 236, 55);
      panel.add(btnNewButton_1);
      
     
      
      
      JLabel lblNewLabel = new JLabel("Main");
      lblNewLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 30));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setBounds(116, 14, 97, 43);
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
      btnNewButton_2.setBounds(116, 389, 97, 23);
      frame.getContentPane().add(btnNewButton_2);
      
      JButton btnNewButton_3 = new JButton("MY PAGE");
      btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
        	 
     			frame.dispose();
     			myPage mp = new myPage(dto);
     		
         }
      });
      btnNewButton_3.setBackground(Color.WHITE);
      btnNewButton_3.setForeground(Color.DARK_GRAY);
      btnNewButton_3.setFont(new Font("Book Antiqua", Font.BOLD, 12));
      btnNewButton_3.setBounds(225, 29, 96, 23);
      frame.getContentPane().add(btnNewButton_3);
   }
   
   
}