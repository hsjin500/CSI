package pack1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.DBDAO;
import model.DBDTO;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

public class modifyinfo {

   private JFrame frame;
   private JPasswordField mdf_pw;
   private JPasswordField mdf_pw2;
   private JTextField mdf_id;

   DBDAO dao = new DBDAO();
   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               modifyinfo window = new modifyinfo();
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
   public modifyinfo(DBDTO dto) {
      initialize(dto);
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize(DBDTO dto) {
      frame = new JFrame();
      frame.setTitle("\uB9C8\uC774\uD398\uC774\uC9C0 \uC815\uBCF4 \uBCC0\uACBD");
      frame.setBounds(100, 100, 335, 334);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);

      frame.setTitle("회원 정보 수정");
      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
      frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

      JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514 \uC785\uB825");
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setBounds(118, 79, 82, 15);
      frame.getContentPane().add(lblNewLabel);

      JLabel lblNewLabel_1 = new JLabel("\uBCC0\uACBD\uD558\uC2E4 \uBE44\uBC00\uBC88\uD638");
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1.setBounds(97, 135, 125, 15);
      frame.getContentPane().add(lblNewLabel_1);

      mdf_pw = new JPasswordField();
      mdf_pw.setBounds(81, 160, 156, 21);
      frame.getContentPane().add(mdf_pw);

      JButton yes_Btn = new JButton("\uD655\uC778");
      yes_Btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String id = mdf_id.getText();
            String pw = mdf_pw.getText();
            String pw2 = mdf_pw2.getText();

            if (pw.equals(pw2)) {
               int cnt = dao.modify(id, pw);
               if (cnt != 0) {
                  JOptionPane.showMessageDialog(null, "변경완료! \n다시로그인 해주세요", "정보수정", JOptionPane.INFORMATION_MESSAGE);
                  frame.dispose();
                  UISignup uiSignup = new UISignup();
                  uiSignup.setVisible(true);
               } else if (cnt == 0) {
                  JOptionPane.showMessageDialog(null, "없는 아이디입니다.", "오류", JOptionPane.INFORMATION_MESSAGE);
               }

            } else if (!pw.equals(pw2)) {
               JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.", "오류", JOptionPane.INFORMATION_MESSAGE);

            }

         }
      });
      yes_Btn.setBounds(36, 259, 106, 23);
      frame.getContentPane().add(yes_Btn);

      JButton cancel_Btn = new JButton("\uCDE8\uC18C");
      cancel_Btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            myPage mp = new myPage(dto);
         }
      });
      cancel_Btn.setBounds(183, 259, 106, 23);
      frame.getContentPane().add(cancel_Btn);

      JLabel lblNewLabel_4 = new JLabel("\uC7AC\uC785\uB825");
      lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_4.setBounds(130, 191, 58, 15);
      frame.getContentPane().add(lblNewLabel_4);

      mdf_pw2 = new JPasswordField();
      mdf_pw2.setBounds(81, 216, 156, 21);
      frame.getContentPane().add(mdf_pw2);

      JLabel lblNewLabel_5 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD");
      lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 20));
      lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_5.setBounds(12, 10, 295, 52);
      frame.getContentPane().add(lblNewLabel_5);

      mdf_id = new JTextField();
      mdf_id.setBounds(81, 104, 156, 21);
      frame.getContentPane().add(mdf_id);
      mdf_id.setColumns(10);
   }
}