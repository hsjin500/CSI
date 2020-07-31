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
import model.Req_DTO;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class g_sunchal {

	private JFrame frame;
	private JTable table;
	private JTextField req_id;
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
	public g_sunchal(DBDTO dto) {
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

		frame.setTitle("순찰 접수 조회");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		frame.getContentPane().setLayout(null);

		req_id = new JTextField();
		req_id.setBounds(156, 449, 183, 21);
		frame.getContentPane().add(req_id);
		req_id.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 1141, 417);
		frame.getContentPane().add(scrollPane);

		JButton btnNewButton = new JButton("\uC870\uD68C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = req_id.getText();

				String[] colName = { "아이디", "위치", "시간", "날짜", "요청내용", "업로드 날짜" };
				DBDAO dao = new DBDAO();
				ArrayList<Req_DTO> ar = dao.reqHistory(id);
				Object[][] data = new Object[ar.size()][6];
				for (int i = 0; i < data.length; i++) {
					data[i][0] = ar.get(i).getId();
					data[i][1] = ar.get(i).getLocatino();
					data[i][2] = ar.get(i).getTime();
					data[i][3] = ar.get(i).getDate();
					data[i][4] = ar.get(i).getAsk();
					data[i][5] = ar.get(i).getUpload_date();
				}

				table = new JTable(data, colName);
				scrollPane.setViewportView(table);
			}
		});
		btnNewButton.setBounds(883, 437, 126, 44);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC138\uC694");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 452, 150, 15);
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

	}
}