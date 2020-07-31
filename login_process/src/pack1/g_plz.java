package pack1;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.DBDTO;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class g_plz {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					g_plz window = new g_plz();
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
	public g_plz(DBDTO dto) {
		initialize(dto);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(DBDTO dto) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 479, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setTitle("현황 조회");
	      Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	      frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
	      frame.getContentPane().setLayout(null);
	      
	      JLabel lblNewLabel = new JLabel("\uD604\uD669 \uC870\uD68C");
	      lblNewLabel.setFont(new Font("Mapo한아름", Font.BOLD, 25));
	      lblNewLabel.setBounds(175, 25, 112, 39);
	      frame.getContentPane().add(lblNewLabel);
	      
	      JButton button = new JButton("\uC21C\uCC30");
	      button.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		frame.dispose();
	      		g_sunchal gsu = new g_sunchal(dto);
	      	}
	      });
	      button.setBackground(Color.WHITE);
	      button.setFont(new Font("Mapo한아름", Font.PLAIN, 15));
	      button.setBounds(70, 118, 143, 212);
	      frame.getContentPane().add(button);
	      
	      JButton button_1 = new JButton("\uBBF8\uC544");
	      button_1.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		frame.dispose();
	      		g_mia gmm = new g_mia(dto);
	      	}
	      });
	      button_1.setBackground(Color.WHITE);
	      button_1.setFont(new Font("Mapo한아름", Font.PLAIN, 15));
	      button_1.setBounds(254, 118, 137, 217);
	      frame.getContentPane().add(button_1);
	      
	      JButton button_2 = new JButton("\uB3CC\uC544\uAC00\uAE30");
	      button_2.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		frame.dispose();
	      		g_main gm = new g_main(dto);
	      	}
	      });
	      button_2.setFont(new Font("Mapo한아름", Font.BOLD, 13));
	      button_2.setBackground(Color.WHITE);
	      button_2.setBounds(183, 367, 97, 23);
	      frame.getContentPane().add(button_2);
	}

}
