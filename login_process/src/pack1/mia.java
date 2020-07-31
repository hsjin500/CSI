package pack1;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.DBDAO;
import model.DBDTO;

import javax.swing.JTextArea;
import javax.swing.DropMode;


public class mia {

   private JFrame frame;
   private JTextField textField;
   private JTextField textField_1;
   private JTextField textField_2;
   private JTextField textField_3;
   private JTextField textField_4;
   private JTextField textField_5;
   DBDAO dao = new DBDAO();
   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               lost window = new lost();
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
   public mia(DBDTO dto) {
      initialize(dto);
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize(DBDTO dto) {
      frame = new JFrame();
      frame.getContentPane().setBackground(new Color(220, 220, 220));
      frame.setBounds(100, 100, 718, 521);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      frame.setTitle("\uC2E4 \uC885 \uC2E0 \uACE0 \uC11C");
         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
      
      JLabel lblNewLabel = new JLabel("\uBBF8\uC544 / \uAC00\uCD9C\uC778 \uB4F1\uB85D");
      lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 18));
      lblNewLabel.setBounds(60, 10, 182, 58);
      frame.getContentPane().add(lblNewLabel);
      
      JLabel lblNewLabel_3 = new JLabel("");
      lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\SMT062\\Desktop\\\uCEA1\uCC98.PNG"));
      lblNewLabel_3.setBackground(new Color(255, 255, 255));
      lblNewLabel_3.setBounds(36, 211, 250, 200);
      frame.getContentPane().add(lblNewLabel_3);
      
      
      JButton btnNewButton = new JButton("\uB4F1\uB85D");
      btnNewButton.setBackground(Color.WHITE);
      btnNewButton.setForeground(Color.BLACK);
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
              JFileChooser chooser = new JFileChooser();
               if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(null)) {
                  lblNewLabel_3.setIcon(new ImageIcon(chooser.getSelectedFile().getAbsolutePath()));
                  String a = chooser.getSelectedFile().getAbsolutePath();
                  textField.setText(a);
            }
         }
      });
      
      btnNewButton.setBounds(279, 152, 69, 29);
      frame.getContentPane().add(btnNewButton);
      
      textField = new JTextField();
      textField.setBounds(36, 153, 229, 28);
      frame.getContentPane().add(textField);
      textField.setColumns(10);
      
      JLabel label = new JLabel("\uC774\uBBF8\uC9C0 \uC5C5\uB85C\uB4DC");
      label.setFont(new Font("±¼¸²", Font.BOLD, 18));
      label.setBounds(44, 100, 182, 43);
      frame.getContentPane().add(label);
      
      JLabel label_1 = new JLabel("\uC778\uC801 \uC0AC\uD56D");
      label_1.setFont(new Font("±¼¸²", Font.BOLD, 18));
      label_1.setBounds(388, 226, 97, 43);
      frame.getContentPane().add(label_1);
      
      JButton button = new JButton("\uC774\uC804");
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            c_main cm = new c_main(dto);
         }
      });
      button.setForeground(Color.BLACK);
      button.setFont(new Font("±¼¸²", Font.BOLD, 13));
      button.setBackground(Color.WHITE);
      button.setBounds(368, 440, 97, 23);
      frame.getContentPane().add(button);
      
      JLabel lblNewLabel_1 = new JLabel("ex)\uC778\uC0C1\uCC29\uC758 \uBC0F \uD2B9\uC774\uC0AC\uD56D \uB4F1");
      lblNewLabel_1.setForeground(new Color(102, 0, 0));
      lblNewLabel_1.setBounds(367, 270, 162, 15);
      frame.getContentPane().add(lblNewLabel_1);
      
      JLabel lblNewLabel_2 = new JLabel("ex)\uB4F1\uB85D\uC744 \uB204\uB974\uACE0 \uC774\uBBF8\uC9C0\uB97C \uCD94\uAC00\uD574\uC8FC\uC138\uC694.");
      lblNewLabel_2.setForeground(new Color(102, 0, 0));
      lblNewLabel_2.setBounds(36, 138, 238, 15);
      frame.getContentPane().add(lblNewLabel_2);
      
      JLabel lblNewLabel_4 = new JLabel("\uD68C\uC6D0 ID");
      lblNewLabel_4.setBounds(407, 68, 49, 29);
      frame.getContentPane().add(lblNewLabel_4);
      
      JLabel label_2 = new JLabel("\uC7A5\uC18C");
      label_2.setBounds(407, 102, 49, 29);
      frame.getContentPane().add(label_2);
      
      textField_1 = new JTextField();
      textField_1.setBounds(473, 72, 116, 21);
      frame.getContentPane().add(textField_1);
      textField_1.setColumns(10);
      textField_1.setText(dto.getId());
      
      textField_2 = new JTextField();
      textField_2.setColumns(10);
      textField_2.setBounds(473, 106, 116, 21);
      frame.getContentPane().add(textField_2);
      
      JLabel label_3 = new JLabel("\uC2E4\uC885\uC2DC\uAC04");
      label_3.setBounds(407, 173, 61, 29);
      frame.getContentPane().add(label_3);
      
      textField_3 = new JTextField();
      textField_3.setColumns(10);
      textField_3.setBounds(473, 139, 116, 21);
      frame.getContentPane().add(textField_3);
      
      JLabel label_4 = new JLabel("\uB0A0\uC9DC");
      label_4.setBounds(407, 138, 61, 29);
      frame.getContentPane().add(label_4);
      
      textField_4 = new JTextField();
      textField_4.setColumns(10);
      textField_4.setBounds(473, 173, 116, 21);
      frame.getContentPane().add(textField_4);
      
      JLabel label_5 = new JLabel("\uD544\uC218 \uC0AC\uD56D");
      label_5.setFont(new Font("±¼¸²", Font.BOLD, 18));
      label_5.setBounds(432, 18, 97, 43);
      frame.getContentPane().add(label_5);
      
      textField_5 = new JTextField();
      textField_5.setBounds(368, 295, 233, 124);
      frame.getContentPane().add(textField_5);
      textField_5.setColumns(10);
      
      JButton button_1 = new JButton("\uD655\uC778");
      button_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
             String id = textField_1.getText();
             String time = textField_4.getText();
             String date = textField_3.getText();
             String location = textField_2.getText();
             String ask = textField_5.getText();
             String photo = textField.getText();
             
             int cnt = dao.mia(id, location, date, time, ask, photo);
            
             if (cnt!=0) {
                JOptionPane.showMessageDialog(null, " Á¢¼ö ¿Ï·á " );
                  frame.dispose();
                  c_main m = new c_main(dto);
             }else {
                JOptionPane.showMessageDialog(null, "Á¤È®ÇÏ°Ô ÀÔ·ÂÇØ ÁÖ¼¼¿ä.", "¿À·ù", JOptionPane.INFORMATION_MESSAGE);
             }
            
         }
      });
      button_1.setForeground(Color.BLACK);
      button_1.setFont(new Font("±¼¸²", Font.BOLD, 13));
      button_1.setBackground(Color.WHITE);
      button_1.setBounds(251, 440, 97, 23);
      frame.getContentPane().add(button_1);
      
   }
}