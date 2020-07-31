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

		frame.setTitle("������ ��û�� ���");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("������ ��û�� ���");
		lblNewLabel.setFont(new Font("Mapo�ѾƸ�", Font.BOLD, 25));
		lblNewLabel.setBounds(217, 20, 246, 51);
		frame.getContentPane().add(lblNewLabel);

		JButton back_btn = new JButton("\uB3CC\uC544\uAC00\uAE30");
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				g_main g_main = new g_main(dto);
			}
		});
		back_btn.setFont(new Font("Mapo�ѾƸ�", Font.BOLD, 14));
		back_btn.setBounds(12, 426, 112, 38);
		frame.getContentPane().add(back_btn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 69, 656, 332);
		frame.getContentPane().add(scrollPane);

		String[] colName = { "���̵�", "�ֹι�ȣ", "���������", "�������" };
		DBDAO dao = new DBDAO();
		ArrayList<temp_DTO> arr = dao.gaipAll();
		Object[][] data = new Object[arr.size()][8];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = arr.get(i).getId();
			data[i][1] = arr.get(i).getSsnum();
			data[i][2] = arr.get(i).getGuard();
			if(arr.get(i).getHistory().equals("0")) {
				data[i][3] = "�����";
			}else if(arr.get(i).getHistory().equals("1")) {
				data[i][3] = "����";
			}
		}

		table = new JTable(data, colName);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				abc_id = table.getValueAt(table.getSelectedRow(), 0).toString();
			}
		});
		scrollPane.setViewportView(table);
		
		
		

		JButton approve_btn = new JButton("����");
		approve_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DBDAO dao = new DBDAO();
				int cnt = 0;
				String guard = "";
				
				guard = DBDAO.tempGuard(abc_id);
				System.out.println("���尪 : "+guard);
				
				dao.guard_update(abc_id, guard);//���� �����Ѵ��(temp�� �����ߴ� ��� ������ �����ͼ�)client�� guard�� ����
				cnt = dao.deleteFromTemp(abc_id);//temp���� �� ����
				if (cnt!=0) {
	                  JOptionPane.showMessageDialog(null, "���� ���εǾ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
		approve_btn.setFont(new Font("Dialog", Font.BOLD, 14));
		approve_btn.setBounds(432, 426, 112, 38);
		frame.getContentPane().add(approve_btn);

		JButton decline_btn = new JButton("����");
		decline_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBDAO dao = new DBDAO();
				int cnt = 0;
				cnt = dao.h_modify(abc_id);//temp�� �����丮 1�� ����
				if (cnt!=0) {
	                  JOptionPane.showMessageDialog(null, "���� �����Ǿ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		decline_btn.setFont(new Font("Dialog", Font.BOLD, 14));
		decline_btn.setBounds(556, 426, 112, 38);
		frame.getContentPane().add(decline_btn);

	}
}
