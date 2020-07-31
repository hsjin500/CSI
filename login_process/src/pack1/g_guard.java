package pack1;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.DBDAO;
import model.DBDTO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class g_guard {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					g_find window = new g_find();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public g_guard(DBDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(DBDTO dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 645, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setTitle("방범대원 조회");
	      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	      frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	      frame.getContentPane().setLayout(null);
	      
	      JLabel lblNewLabel = new JLabel("\uBC29\uBC94\uB300\uC6D0 \uC870\uD68C");
	      lblNewLabel.setFont(new Font("Mapo한아름", Font.BOLD, 25));
	      lblNewLabel.setBounds(234, 23, 160, 40);
	      frame.getContentPane().add(lblNewLabel);
	      
	      table = new JTable();
	      table.setBounds(12, 505, 471, -416);
	      frame.getContentPane().add(table);
	      
	      JButton btnNewButton = new JButton("\uB3CC\uC544\uAC00\uAE30");
	      btnNewButton.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		frame.dispose();
	      		g_main gm = new g_main(dto);
	      	}
	      });
	      btnNewButton.setFont(new Font("Mapo한아름", Font.BOLD, 14));
	      btnNewButton.setBounds(266, 519, 97, 23);
	      frame.getContentPane().add(btnNewButton);
	      
	      scrollPane = new JScrollPane();
	      scrollPane.setBounds(12, 77, 605, 426);
	      frame.getContentPane().add(scrollPane);
	      
	      String[] colName = {"이름", "전화번호", "이메일", "아이디"};
			DBDAO dao = new DBDAO();
			ArrayList<DBDTO> guardList = dao.memberInfoSelect();
			Object[][] data = new Object[guardList.size()][4];
			for (int i = 0; i < data.length; i++) {
				data[i][0] = guardList.get(i).getName();
				data[i][1] = guardList.get(i).getPhone();
				data[i][2] = guardList.get(i).getEmail();
				data[i][3] = guardList.get(i).getId();
			}
	      
	      table_1 = new JTable(data, colName);
	      scrollPane.setViewportView(table_1);
		
	}
}
