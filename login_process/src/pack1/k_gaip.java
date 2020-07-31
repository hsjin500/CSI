package pack1;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.DBDAO;
import model.DBDTO;
import model.mia_DTO;
import model.temp_DTO;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class k_gaip {

	private JFrame frame;
	private JTable table;
	private String abc_id;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					k_gaip window = new k_gaip();
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
	public k_gaip(DBDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(DBDTO dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 696, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setTitle("방범대원 신청자 명단");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("방범대원 신청자 명단");
		lblNewLabel.setFont(new Font("Mapo한아름", Font.BOLD, 25));
		lblNewLabel.setBounds(217, 20, 246, 51);
		frame.getContentPane().add(lblNewLabel);

		JButton back_btn = new JButton("\uB3CC\uC544\uAC00\uAE30");
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				g_main g_main = new g_main(dto);
			}
		});
		back_btn.setFont(new Font("Mapo한아름", Font.BOLD, 14));
		back_btn.setBounds(12, 426, 112, 38);
		frame.getContentPane().add(back_btn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 69, 656, 332);
		frame.getContentPane().add(scrollPane);

		String[] colName = { "아이디", "주민번호", "희망지역구", "진행상태" };
		DBDAO dao = new DBDAO();
		ArrayList<temp_DTO> arr = dao.gaipAll();
		Object[][] data = new Object[arr.size()][8];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = arr.get(i).getId();
			data[i][1] = arr.get(i).getSsnum();
			data[i][2] = arr.get(i).getGuard();
			if(arr.get(i).getHistory().equals("0")) {
				data[i][3] = "대기중";
			}else if(arr.get(i).getHistory().equals("1")) {
				data[i][3] = "거절";
			}
		}

		table = new JTable(data, colName);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				abc_id = table.getValueAt(table.getSelectedRow(), 0).toString();
			}
		});
		scrollPane.setViewportView(table);
		
		
		

		JButton approve_btn = new JButton("승인");
		approve_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DBDAO dao = new DBDAO();
				int cnt = 0;
				String guard = "";
				
				guard = DBDAO.tempGuard(abc_id);
				System.out.println("가드값 : "+guard);
				
				dao.guard_update(abc_id, guard);//가드 지원한대로(temp에 저장했던 희망 지역을 가져와서)client의 guard에 적용
				cnt = dao.deleteFromTemp(abc_id);//temp에서 행 삭제
				if (cnt!=0) {
	                  JOptionPane.showMessageDialog(null, "가입 승인되었습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
		approve_btn.setFont(new Font("Dialog", Font.BOLD, 14));
		approve_btn.setBounds(432, 426, 112, 38);
		frame.getContentPane().add(approve_btn);

		JButton decline_btn = new JButton("거절");
		decline_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBDAO dao = new DBDAO();
				int cnt = 0;
				cnt = dao.h_modify(abc_id);//temp에 히스토리 1로 수정
				if (cnt!=0) {
	                  JOptionPane.showMessageDialog(null, "가입 거절되었습니다.", "정보", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		decline_btn.setFont(new Font("Dialog", Font.BOLD, 14));
		decline_btn.setBounds(556, 426, 112, 38);
		frame.getContentPane().add(decline_btn);

	}
}
