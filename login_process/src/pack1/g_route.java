package pack1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.DBDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class g_route {

   private JFrame frame;

   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               g_route window = new g_route();
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
   public g_route(DBDTO dto) {
      initialize(dto);
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize(DBDTO dto) {
      frame = new JFrame();
      frame.getContentPane().setBackground(Color.WHITE);
      frame.setBounds(100, 100, 492, 598);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      frame.setTitle("순 찰 루 트");
       Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
       frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
       
      
      JLabel lblNewLabel = new JLabel("\uB8E8\uD2B8 \uC815\uBCF4");
      lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setBounds(12, 7, 452, 54);
      frame.getContentPane().add(lblNewLabel);
      
      JButton yesBtn = new JButton("\uB4A4\uB85C\uAC00\uAE30");
      yesBtn.setBackground(new Color(255, 255, 204));
      yesBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         frame.dispose();
         g_main gm = new g_main(dto);
         }
      });
      yesBtn.setBounds(351, 60, 113, 43);
      frame.getContentPane().add(yesBtn);
      System.out.println();
      
      JComboBox comboBox = new JComboBox();
      comboBox.setBackground(Color.WHITE);
      comboBox.setModel(new DefaultComboBoxModel(new String[] {"구", "광산구", "남구", "동구", "북구", "서구"}));
      comboBox.setToolTipText("");
      comboBox.setBounds(12, 71, 76, 21);
      frame.getContentPane().add(comboBox);
      
      JComboBox comboBox_1 = new JComboBox();
      comboBox_1.setBackground(Color.WHITE);
      comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\uB3D9"}));
      comboBox_1.setBounds(88, 71, 82, 21);
      frame.getContentPane().add(comboBox_1);
      
      final DefaultComboBoxModel gu = new DefaultComboBoxModel(new String[]{"동"});
      final DefaultComboBoxModel namgu = new DefaultComboBoxModel(new String[]{"동","봉선동", "양림동", "월산동","주월동"});
      final DefaultComboBoxModel seogu = new DefaultComboBoxModel(new String[]{"동","농성동", "양동"});
      final DefaultComboBoxModel donggu = new DefaultComboBoxModel(new String[]{"동","동명동","계림1동","지원동"});
      final DefaultComboBoxModel bukgu = new DefaultComboBoxModel(new String[]{"동","계림동", "운암동"});
      final DefaultComboBoxModel gwangsangu = new DefaultComboBoxModel(new String[]{"동","신가동","운남동"});
      
      JLabel map_picture = new JLabel("");
      map_picture.setIcon(new ImageIcon("map_img\\맵\\basic.png"));
      map_picture.setBackground(Color.LIGHT_GRAY);
      map_picture.setBounds(12, 113, 452, 436);
      frame.getContentPane().add(map_picture);

      comboBox.addActionListener (new ActionListener () {
          public void actionPerformed(ActionEvent e) {
             comboBox_1.setSelectedIndex(0);
             map_picture.setIcon(new ImageIcon("map_img\\map\\basic.png"));
              if ("남구".equals(comboBox.getSelectedItem())){
                  comboBox_1.setModel(namgu);    
              } else if("서구".equals(comboBox.getSelectedItem())){
                  comboBox_1.setModel(seogu);    
              } else if("북구".equals(comboBox.getSelectedItem())) {
                 comboBox_1.setModel(bukgu);
              } else if("광산구".equals(comboBox.getSelectedItem())) {
                 comboBox_1.setModel(gwangsangu);
              } else if("동구".equals(comboBox.getSelectedItem())) {
                 comboBox_1.setModel(donggu);
              } else if("구".equals(comboBox.getSelectedItem())) {
                 comboBox_1.setModel(gu);
              }
          
          }
      });
      
      comboBox_1.addActionListener (new ActionListener () {
          public void actionPerformed(ActionEvent e) {
              if ("봉선동".equals(comboBox_1.getSelectedItem())){
                 map_picture.setIcon(new ImageIcon("map_img\\map\\12345.png"));   
              } else if("동".equals(comboBox_1.getSelectedItem())) {
                 map_picture.setIcon(new ImageIcon("map_img\\map\\basic.png"));
              }
          }
      });
      
   }
}