package user;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PatrolRequest extends JFrame {

	private JPanel contentPane;
	private JTextField patrolLocation;
	private JLabel label;
	private JTextField patrolAdress;
	private JTextField patrolTime;
	private JTextField detail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatrolRequest frame = new PatrolRequest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PatrolRequest() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("¼øÂû ¿äÃ»");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		patrolLocation = new JTextField();
		patrolLocation.setBounds(151, 10, 271, 31);
		contentPane.add(patrolLocation);
		patrolLocation.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uD76C\uB9DD \uC21C\uCC30\uC9C0 \uC785\uB825");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 119, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC21C\uCC30 \uC8FC\uC18C \uC785\uB825");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 51, 119, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC21C\uCC30 \uC2DC\uAC04 \uC785\uB825");
		lblNewLabel_2.setToolTipText("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 92, 119, 31);
		contentPane.add(lblNewLabel_2);
		
		label = new JLabel("\uC138\uBD80 \uC0AC\uD56D \uC785\uB825");
		label.setToolTipText("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 173, 119, 31);
		contentPane.add(label);
		
		patrolAdress = new JTextField();
		patrolAdress.setColumns(10);
		patrolAdress.setBounds(151, 51, 271, 31);
		contentPane.add(patrolAdress);
		
		patrolTime = new JTextField();
		patrolTime.setColumns(10);
		patrolTime.setBounds(253, 92, 169, 31);
		contentPane.add(patrolTime);
		
		detail = new JTextField();
		detail.setColumns(10);
		detail.setBounds(151, 136, 271, 115);
		contentPane.add(detail);
		
		JComboBox timeCombo = new JComboBox();
		timeCombo.setModel(new DefaultComboBoxModel(new String[] {"\uC624\uC804", "\uC624\uD6C4"}));
		timeCombo.setBounds(151, 92, 90, 31);
		contentPane.add(timeCombo);
	}
}
