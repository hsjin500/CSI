package pack1;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.DBDAO;
import model.DBDTO;
import model.mia_DTO;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;



public class g_mia {

   private JFrame frame;
   private JTable table;
   private JTextField past_id;
   private String id;

   /**
    * Launch the application.
    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               pasthistory window = new pasthistory();
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
   public g_mia(DBDTO dto) {
      initialize(dto);
      frame.setVisible(true);
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize(DBDTO dto) {
      frame = new JFrame();
      frame.setBounds(100, 100, 1181, 530);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frame.setTitle("미아 접수 내역");
       Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
       frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
       frame.getContentPane().setLayout(null);
       
       past_id = new JTextField();
       past_id.setBounds(201, 449, 183, 21);
       frame.getContentPane().add(past_id);
       past_id.setColumns(10);
       
       JScrollPane scrollPane = new JScrollPane();
       scrollPane.setBounds(12, 54, 1141, 373);
       frame.getContentPane().add(scrollPane);
       
      
       
       JButton btnNewButton = new JButton("\uC870\uD68C");
       btnNewButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
             id = past_id.getText();
             
              
              String[] colName = {"아이디","위치","시간","날짜","인상착의","사진","신청날짜","진행상황"};
                DBDAO dao = new DBDAO();
             ArrayList<mia_DTO> arr = dao.miaHistory(id);
             Object[][] data = new Object[arr.size()][8];
             for(int i = 0 ; i <data.length; i++) {
                data[i][0]=arr.get(i).getId();
                data[i][1]=arr.get(i).getLocation();
                data[i][2]=arr.get(i).getTime();
                data[i][3]=arr.get(i).getDate();
                data[i][4]=arr.get(i).getInfo();
                data[i][5]=arr.get(i).getPhoto();
                data[i][6]=arr.get(i).getUpload_date();
                data[i][7]=arr.get(i).getCondition();
                
             }
             table = new JTable(data,colName);
              scrollPane.setViewportView(table);
          }
       });
       btnNewButton.setBounds(883, 437, 126, 44);
       frame.getContentPane().add(btnNewButton);
       
     
       
      
       
   
       
       JLabel lblNewLabel = new JLabel("접수자 아이디를 입력하세요.");
       lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
       lblNewLabel.setBounds(12, 452, 177, 15);
       frame.getContentPane().add(lblNewLabel);
       

       
       JButton button = new JButton("\uC774\uC804");
       button.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
             frame.dispose();
             g_plz gp = new g_plz(dto);
          }
       });
       button.setBounds(1027, 437, 126, 44);
       frame.getContentPane().add(button);
       
       JButton btnNewButton_1 = new JButton("\uC804\uCCB4 \uC870\uD68C");
       btnNewButton_1.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
            
            
            String[] colName = {"아이디","위치","시간","날짜","인상착의","사진","신청날짜","진행상황"};
              DBDAO dao = new DBDAO();
           ArrayList<mia_DTO> arr = dao.miaAll();
           Object[][] data = new Object[arr.size()][8];
           for(int i = 0 ; i <data.length; i++) {
              data[i][0]=arr.get(i).getId();
              data[i][1]=arr.get(i).getLocation();
              data[i][2]=arr.get(i).getTime();
              data[i][3]=arr.get(i).getDate();
              data[i][4]=arr.get(i).getInfo();
              data[i][5]=arr.get(i).getPhoto();
              data[i][6]=arr.get(i).getUpload_date();
              data[i][7]=arr.get(i).getCondition();
              
           }
           table = new JTable(data,colName);
            scrollPane.setViewportView(table);
        }
       	
       });
       btnNewButton_1.setBounds(1003, 10, 150, 34);
       frame.getContentPane().add(btnNewButton_1);


   }
}