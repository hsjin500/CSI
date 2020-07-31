package pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import model.DBDAO;
import model.DBDTO;

import javax.swing.ImageIcon;

public class request {

   private JFrame frame;
   private JTextField req_ask;
   private JTextField req_date;
   private JTextField req_time;
   private JTextField req_location;
   private JTextField req_id;

   DBDAO dao = new DBDAO();
   
   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               c_search window = new c_search();
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
   public request(DBDTO dto) {
      initialize(dto);
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize(DBDTO dto) {
      frame = new JFrame();
      frame.getContentPane().setFont(new Font("Mapo한아름", Font.PLAIN, 15));
      frame.getContentPane().setBackground(Color.WHITE);
      frame.setBounds(100, 100, 433, 605);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      frame.setTitle("SAVEMYTOWN");
         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
      
      JLabel lblNewLabel = new JLabel("\uC21C\uCC30 \uC694\uCCAD");
      lblNewLabel.setFont(new Font("Mapo한아름", Font.BOLD, 25));
      lblNewLabel.setBounds(139, 10, 113, 30);
      frame.getContentPane().add(lblNewLabel);
      
      req_ask = new JTextField();
      req_ask.setBackground(Color.WHITE);
      req_ask.setColumns(10);
      req_ask.setBounds(46, 314, 342, 162);
      frame.getContentPane().add(req_ask);
      
      JLabel lblNewLabel_1 = new JLabel("\uC21C\uCC30 \uC694\uCCAD \uB0A0\uC9DC");
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1.setFont(new Font("Mapo한아름", Font.PLAIN, 15));
      lblNewLabel_1.setBounds(46, 117, 96, 15);
      frame.getContentPane().add(lblNewLabel_1);
      
      JLabel lblNewLabel_2 = new JLabel("\uC21C\uCC30 \uC694\uCCAD \uC2DC\uAC04");
      lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_2.setFont(new Font("Mapo한아름", Font.PLAIN, 15));
      lblNewLabel_2.setBounds(46, 167, 104, 15);
      frame.getContentPane().add(lblNewLabel_2);
      
      JLabel lblNewLabel_3 = new JLabel("\uC694\uCCAD\uC0AC\uD56D");
      lblNewLabel_3.setFont(new Font("Mapo한아름", Font.PLAIN, 15));
      lblNewLabel_3.setBounds(63, 281, 57, 23);
      frame.getContentPane().add(lblNewLabel_3);
      
      JButton btnNewButton = new JButton("\uC811\uC218");
      btnNewButton.setFont(new Font("Mapo한아름", Font.BOLD, 12));
      btnNewButton.setBackground(Color.WHITE);
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            String id = req_id.getText();
            String time = req_time.getText();
            String date = req_date.getText();
            String location = req_location.getText();
            String ask = req_ask.getText();
            
            int cnt = dao.request(id,time, date, location, ask);
           
            if (cnt!=0) {
               JOptionPane.showMessageDialog(null, " 접수 완료 " );
                 frame.dispose();
                 c_main m = new c_main(dto);
            }else {
               JOptionPane.showMessageDialog(null, "정확하게 입력해 주세요.", "오류", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
           
         }
      });
      btnNewButton.setBounds(88, 500, 97, 23);
      frame.getContentPane().add(btnNewButton);
      
      JButton button = new JButton("\uB3CC\uC544\uAC00\uAE30");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            c_main m = new c_main(dto);
         }
      });
      button.setFont(new Font("Mapo한아름", Font.BOLD, 12));
      button.setBackground(Color.WHITE);
      button.setBounds(239, 500, 97, 23);
      frame.getContentPane().add(button);
      
      JLabel lblNewLabel_4 = new JLabel("(\uC21C\uCC30 \uC0AC\uC720\uC640 \uD2B9\uC774\uC810\uC744 \uC785\uB825 \uD574 \uC8FC\uC138\uC694.)");
      lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_4.setFont(new Font("Mapo한아름", Font.PLAIN, 12));
      lblNewLabel_4.setBounds(160, 297, 228, 15);
      frame.getContentPane().add(lblNewLabel_4);
      
      req_date = new JTextField();
      req_date.setColumns(10);
      req_date.setBackground(Color.WHITE);
      req_date.setBounds(181, 110, 207, 30);
      frame.getContentPane().add(req_date);
      
      req_time = new JTextField();
      req_time.setColumns(10);
      req_time.setBackground(Color.WHITE);
      req_time.setBounds(181, 160, 207, 30);
      frame.getContentPane().add(req_time);
      
      req_location = new JTextField();
      req_location.setColumns(10);
      req_location.setBackground(Color.WHITE);
      req_location.setBounds(181, 211, 207, 30);
      frame.getContentPane().add(req_location);
      
      JLabel label_2 = new JLabel("\uC21C\uCC30 \uC694\uCCAD \uC7A5\uC18C");
      label_2.setHorizontalAlignment(SwingConstants.CENTER);
      label_2.setFont(new Font("Mapo한아름", Font.PLAIN, 15));
      label_2.setBounds(46, 218, 104, 15);
      frame.getContentPane().add(label_2);
      
      JLabel label = new JLabel("\uC544\uC774\uB514");
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setFont(new Font("Dialog", Font.PLAIN, 15));
      label.setBounds(46, 77, 96, 15);
      frame.getContentPane().add(label);
      
      req_id = new JTextField();
      req_id.setColumns(10);
      req_id.setBackground(Color.WHITE);
      req_id.setBounds(181, 70, 207, 30);
      frame.getContentPane().add(req_id);
   }
}