package pack1;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.DBDTO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;

public class myInfo {

   private JFrame frame;
   private JTextField id_text;
   private JTextField name_text;
   private JTextField email_text;
   private JTextField num_text;
   private JTextField sosok;

   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               myInfo window = new myInfo();
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
   public myInfo(DBDTO dto) {
      initialize(dto);
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   
   private void initialize(DBDTO dto) {
      frame = new JFrame();
      frame.getContentPane().setBackground(Color.WHITE);
      frame.setBounds(100, 100, 234, 344);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      frame.setTitle("³» Á¤º¸");
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

      JLabel lblNewLabel = new JLabel("\uB098\uC758 \uC815\uBCF4");
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setBounds(12, 9, 194, 36);
      frame.getContentPane().add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
      lblNewLabel_1.setBounds(28, 59, 40, 30);
      frame.getContentPane().add(lblNewLabel_1);
      
      JLabel label = new JLabel("\uC774\uB984");
      label.setBounds(28, 98, 30, 30);
      frame.getContentPane().add(label);
      
      JLabel label_1 = new JLabel("\uC774\uBA54\uC77C");
      label_1.setBounds(28, 137, 40, 30);
      frame.getContentPane().add(label_1);
      
      JButton btnNewButton = new JButton("\uC774 \uC804");
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            myPage mp = new myPage(dto);
         }
      });
            
      btnNewButton.setBounds(71, 265, 97, 30);
      frame.getContentPane().add(btnNewButton);
      
      JLabel label_2 = new JLabel("\uC804\uD654\uBC88\uD638");
      label_2.setBounds(28, 176, 54, 30);
      frame.getContentPane().add(label_2);
      
      JLabel label_3 = new JLabel("\uC18C \uC18D");
      label_3.setBounds(28, 215, 36, 23);
      frame.getContentPane().add(label_3);
      
      id_text = new JTextField();
      id_text.setEditable(false);
      id_text.setBounds(93, 64, 113, 21);
      frame.getContentPane().add(id_text);
      id_text.setColumns(10);
      
      name_text = new JTextField();
      name_text.setEditable(false);
      name_text.setColumns(10);
      name_text.setBounds(93, 103, 113, 21);
      frame.getContentPane().add(name_text);
      
      email_text = new JTextField();
      email_text.setEditable(false);
      email_text.setColumns(10);
      email_text.setBounds(93, 142, 113, 21);
      frame.getContentPane().add(email_text);
      
      num_text = new JTextField();
      num_text.setEditable(false);
      num_text.setColumns(10);
      num_text.setBounds(94, 181, 113, 21);
      frame.getContentPane().add(num_text);
      
      sosok = new JTextField();
      sosok.setEditable(false);
      sosok.setColumns(10);
      sosok.setBounds(93, 216, 113, 21);
      frame.getContentPane().add(sosok);
      
      if(dto == null) {
			
		}else {
			id_text.setText(dto.getId());
			name_text.setText(dto.getName());
			email_text.setText(dto.getEmail());
			num_text.setText(dto.getPhone());
			sosok.setText(dto.getGuard());
		}
   }
   
}