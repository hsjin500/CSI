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
      frame.setTitle("�� �� �� Ʈ");
       Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
       frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
       
      
      JLabel lblNewLabel = new JLabel("\uB8E8\uD2B8 \uC815\uBCF4");
      lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
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
      comboBox.setModel(new DefaultComboBoxModel(new String[] {"��", "���걸", "����", "����", "�ϱ�", "����"}));
      comboBox.setToolTipText("");
      comboBox.setBounds(12, 71, 76, 21);
      frame.getContentPane().add(comboBox);
      
      JComboBox comboBox_1 = new JComboBox();
      comboBox_1.setBackground(Color.WHITE);
      comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\uB3D9"}));
      comboBox_1.setBounds(88, 71, 82, 21);
      frame.getContentPane().add(comboBox_1);
      
      final DefaultComboBoxModel gu = new DefaultComboBoxModel(new String[]{"��"});
      final DefaultComboBoxModel namgu = new DefaultComboBoxModel(new String[]{"��","������", "�縲��", "���굿","�ֿ���"});
      final DefaultComboBoxModel seogu = new DefaultComboBoxModel(new String[]{"��","�󼺵�", "�絿"});
      final DefaultComboBoxModel donggu = new DefaultComboBoxModel(new String[]{"��","����","�踲1��","������"});
      final DefaultComboBoxModel bukgu = new DefaultComboBoxModel(new String[]{"��","�踲��", "��ϵ�"});
      final DefaultComboBoxModel gwangsangu = new DefaultComboBoxModel(new String[]{"��","�Ű���","���"});
      
      JLabel map_picture = new JLabel("");
      map_picture.setIcon(new ImageIcon("map_img\\��\\basic.png"));
      map_picture.setBackground(Color.LIGHT_GRAY);
      map_picture.setBounds(12, 113, 452, 436);
      frame.getContentPane().add(map_picture);

      comboBox.addActionListener (new ActionListener () {
          public void actionPerformed(ActionEvent e) {
             comboBox_1.setSelectedIndex(0);
             map_picture.setIcon(new ImageIcon("map_img\\map\\basic.png"));
              if ("����".equals(comboBox.getSelectedItem())){
                  comboBox_1.setModel(namgu);    
              } else if("����".equals(comboBox.getSelectedItem())){
                  comboBox_1.setModel(seogu);    
              } else if("�ϱ�".equals(comboBox.getSelectedItem())) {
                 comboBox_1.setModel(bukgu);
              } else if("���걸".equals(comboBox.getSelectedItem())) {
                 comboBox_1.setModel(gwangsangu);
              } else if("����".equals(comboBox.getSelectedItem())) {
                 comboBox_1.setModel(donggu);
              } else if("��".equals(comboBox.getSelectedItem())) {
                 comboBox_1.setModel(gu);
              }
          
          }
      });
      
      comboBox_1.addActionListener (new ActionListener () {
          public void actionPerformed(ActionEvent e) {
              if ("������".equals(comboBox_1.getSelectedItem())){
                 map_picture.setIcon(new ImageIcon("map_img\\map\\12345.png"));   
              } else if("��".equals(comboBox_1.getSelectedItem())) {
                 map_picture.setIcon(new ImageIcon("map_img\\map\\basic.png"));
              }
          }
      });
      
   }
}