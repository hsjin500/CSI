/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack1;

import java.awt.AWTException;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import AppPackage.AnimationClass;
import pack2.AbsoluteConstraints;

public class UISignup extends javax.swing.JFrame {
	private String id, pw, name, phoneNumber, email;

	public UISignup() {  //main 에서 넘어와서 UIsignup메소드 실행하고 --> //initComponents();들어있음(실행)
		initComponents();
		// Next Two Lines will display the Frame into the middle of the Screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setBackground(new Color(0, 0, 0, 0));
		jPanel1.setBackground(new Color(0, 0, 0, 0));
		EmailTextField.setBackground(new Color(0, 0, 0, 0));
		IDTextField.setBackground(new Color(0, 0, 0, 0));
		PWField.setBackground(new Color(0, 0, 0, 0));
		NameTextField.setBackground(new Color(0, 0, 0, 0));
		PhoneNumberField.setBackground(new Color(0, 0, 0, 0));
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		animation1 = new javax.swing.JLabel();
		animation2 = new javax.swing.JLabel();
		closeFunction = new javax.swing.JLabel();
		SignupBtn = new javax.swing.JButton();
        SigninBtn = new javax.swing.JButton();
		warningMessage5 = new javax.swing.JLabel();
        warningMessage4 = new javax.swing.JLabel();
        warningMessage3 = new javax.swing.JLabel();
        warningMessage2 = new javax.swing.JLabel();
        warningMessage1 = new javax.swing.JLabel();
		Mark1 = new javax.swing.JLabel();
		Mark2 = new javax.swing.JLabel();
		Mark3 = new javax.swing.JLabel();
		Mark4 = new javax.swing.JLabel();
		Mark5 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		confirmBtn = new javax.swing.JButton();
		jSeparator2 = new javax.swing.JSeparator();
		EmailTextField = new javax.swing.JTextField();
		IDTextField = new javax.swing.JTextField();
		PWField = new javax.swing.JPasswordField();
		NameTextField = new javax.swing.JTextField();
		PhoneNumberField = new javax.swing.JTextField();
		jSeparator1 = new javax.swing.JSeparator();
		jSeparator3 = new javax.swing.JSeparator();
		jSeparator4 = new javax.swing.JSeparator();
		jSeparator5 = new javax.swing.JSeparator();
		jSeparator6 = new javax.swing.JSeparator();
		jLabel4 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		ConfirmBtn = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		jPanel1.setLayout(new pack2.AbsoluteLayout());
		
		animation1.setBackground(new java.awt.Color(255, 255, 255));
        animation1.setIcon(new javax.swing.ImageIcon("src\\pack2\\1.png")); // NOI18N
        jPanel1.add(animation1, new pack2.AbsoluteConstraints(650, 380, 320, 262));
		animation1.setVisible(true);
		
		animation2.setBackground(new java.awt.Color(255, 255, 255));
        animation2.setIcon(new javax.swing.ImageIcon("src\\pack2\\robber0.png")); // NOI18N
        jPanel1.add(animation2, new pack2.AbsoluteConstraints(1013, 380, 320, 262));
		animation2.setVisible(true);
        
		closeFunction.setIcon(new javax.swing.ImageIcon("src\\pack2\\close_before.png")); // NOI18N
        jPanel1.add(closeFunction, new pack2.AbsoluteConstraints(1165, 55, 20, 20));
        closeFunction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeFunctionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeFunctionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeFunctionMouseExited(evt);
            }
        });
        
		warningMessage5.setIcon(new javax.swing.ImageIcon("src\\pack2\\warning_email.jpg")); // NOI18N
        jPanel1.add(warningMessage5, new pack2.AbsoluteConstraints(830, 485, 270, 20));
        warningMessage5.setVisible(false);

        warningMessage4.setIcon(new javax.swing.ImageIcon("src\\pack2\\warning_phone.jpg")); // NOI18N
        jPanel1.add(warningMessage4, new pack2.AbsoluteConstraints(830, 405, 270, 20));
        warningMessage4.setVisible(false);

        warningMessage3.setIcon(new javax.swing.ImageIcon("src\\pack2\\warning_name.jpg")); // NOI18N
        jPanel1.add(warningMessage3, new pack2.AbsoluteConstraints(830, 325, 270, 20));
        warningMessage3.setVisible(false);

        warningMessage2.setIcon(new javax.swing.ImageIcon("src\\pack2\\warning_pw.jpg")); // NOI18N
        jPanel1.add(warningMessage2, new pack2.AbsoluteConstraints(830, 246, 270, 20));
        warningMessage2.setVisible(false);

        warningMessage1.setIcon(new javax.swing.ImageIcon("src\\pack2\\warning_id.jpg")); // NOI18N
        jPanel1.add(warningMessage1, new pack2.AbsoluteConstraints(830, 165, 270, 20));
        warningMessage1.setVisible(false);

		Mark1.setIcon(new javax.swing.ImageIcon("src\\pack2\\Exclamation_mark _small.png")); // NOI18N
		jPanel1.add(Mark1, new pack2.AbsoluteConstraints(1140, 200, 30, 30));
		Mark1.setVisible(false);

		Mark2.setIcon(new javax.swing.ImageIcon("src\\pack2\\Exclamation_mark _small.png")); // NOI18N
		jPanel1.add(Mark2, new pack2.AbsoluteConstraints(1140, 280, 30, 30));
		Mark2.setVisible(false);

		Mark3.setIcon(new javax.swing.ImageIcon("src\\pack2\\Exclamation_mark _small.png")); // NOI18N
		jPanel1.add(Mark3, new pack2.AbsoluteConstraints(1140, 360, 30, 30));
		Mark3.setVisible(false);

		Mark4.setIcon(new javax.swing.ImageIcon("src\\pack2\\Exclamation_mark _small.png")); // NOI18N
		jPanel1.add(Mark4, new pack2.AbsoluteConstraints(1140, 440, 30, 30));
		Mark4.setVisible(false);

		Mark5.setIcon(new javax.swing.ImageIcon("src\\pack2\\Exclamation_mark _small.png")); // NOI18N
		jPanel1.add(Mark5, new pack2.AbsoluteConstraints(1140, 520, 30, 30));
		Mark5.setVisible(false);
		
		jLabel3.setIcon(new javax.swing.ImageIcon("src\\pack2\\smhd_logo.png")); // NOI18N
		jPanel1.add(jLabel3, new pack2.AbsoluteConstraints(103, 55, 50, 40));
		jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
        });  
		
		 SignupBtn.setIcon(new javax.swing.ImageIcon("src\\pack2\\Signup_btn.png")); // NOI18N
	        SignupBtn.setContentAreaFilled(false);
	        SignupBtn.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseEntered(java.awt.event.MouseEvent evt) {
	                SignupBtnMouseEntered(evt);
	            }
	            public void mouseExited(java.awt.event.MouseEvent evt) {
	                SignupBtnMouseExited(evt);
	            }
	        });
	        SignupBtn.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                SignupBtnActionPerformed(evt);
	            }
	        });
	        jPanel1.add(SignupBtn, new pack2.AbsoluteConstraints(933, 75, 130, 60));

	        SigninBtn.setIcon(new javax.swing.ImageIcon("src\\pack2\\Signin_btn.png")); // NOI18N
	        SigninBtn.setContentAreaFilled(false);
	        SigninBtn.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseEntered(java.awt.event.MouseEvent evt) {
	                SigninBtnMouseEntered(evt);
	            }
	            public void mouseExited(java.awt.event.MouseEvent evt) {
	                SigninBtnMouseExited(evt);
	            }
	        });
	        SigninBtn.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                SigninBtnActionPerformed(evt);
	            }
	        });
	        jPanel1.add(SigninBtn, new pack2.AbsoluteConstraints(938, 70, 130, 60));
		
		confirmBtn.setIcon(new javax.swing.ImageIcon("src\\pack2\\confirm_before.png")); // NOI18N
		confirmBtn.setContentAreaFilled(false);
		confirmBtn.setRolloverIcon(new javax.swing.ImageIcon("src\\pack2\\confirm_after.png")); // NOI18N
		confirmBtn.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				confirmBtnMouseEntered(evt);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				confirmBtnMouseExited(evt);
			}
		});
		jPanel1.add(confirmBtn, new pack2.AbsoluteConstraints(1030, 640, 130, 60));

//		jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
//		jPanel1.add(jSeparator2, new pack2.AbsoluteConstraints(800, 190, 30, 130));//130<-->370
		
	

		EmailTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
		EmailTextField.setForeground(new java.awt.Color(204, 204, 204));
		EmailTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		EmailTextField.setText("Enter Email");
		EmailTextField.setBorder(null);
		EmailTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				EmailTextFieldFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				EmailTextFieldFocusLost(evt);
			}
		});
		EmailTextField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				EmailTextFieldActionPerformed(evt);
			}
		});
		jPanel1.add(EmailTextField, new pack2.AbsoluteConstraints(810, 510, 310, 50));

		IDTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
		IDTextField.setForeground(new java.awt.Color(204, 204, 204));
		IDTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		IDTextField.setText("Enter ID");
		IDTextField.setBorder(null);
		IDTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				IDTextFieldFocusGained(evt);
				
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				IDTextFieldFocusLost(evt);
			}
		});
		IDTextField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				IDTextFieldActionPerformed(evt);
			}
		});
		jPanel1.add(IDTextField, new pack2.AbsoluteConstraints(810, 190, 310, 50));

		PWField.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
		PWField.setForeground(new java.awt.Color(204, 204, 204));
		PWField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		PWField.setText("Enter Password");
		PWField.setBorder(null);
		PWField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PWFieldFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				PWFieldFocusLost(evt);
			}
		});
		PWField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				PWFieldActionPerformed(evt);
			}
		});
		jPanel1.add(PWField, new pack2.AbsoluteConstraints(810, 270, 310, 50));

		NameTextField.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
		NameTextField.setForeground(new java.awt.Color(204, 204, 204));
		NameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		NameTextField.setText("Enter Name");
		NameTextField.setBorder(null);
		NameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				NameTextFieldFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				NameTextFieldFocusLost(evt);
			}
		});
		NameTextField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				NameTextFieldActionPerformed(evt);
			}
		});
		jPanel1.add(NameTextField, new pack2.AbsoluteConstraints(810, 350, 310, 50));

		PhoneNumberField.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
		PhoneNumberField.setForeground(new java.awt.Color(204, 204, 204));
		PhoneNumberField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		PhoneNumberField.setText("Enter PhoneNumber");
		PhoneNumberField.setBorder(null);
		PhoneNumberField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				PhoneNumberFieldFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				PhoneNumberFieldFocusLost(evt);
			}
		});
		PhoneNumberField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				PhoneNumberFieldActionPerformed(evt);
			}
		});
		jPanel1.add(PhoneNumberField, new pack2.AbsoluteConstraints(810, 430, 310, 50));
		jPanel1.add(jSeparator1, new pack2.AbsoluteConstraints(670, 560, 460, 20));
		jPanel1.add(jSeparator3, new pack2.AbsoluteConstraints(670, 242, 460, 20));
		jPanel1.add(jSeparator4, new pack2.AbsoluteConstraints(670, 320, 460, 20));
		jPanel1.add(jSeparator5, new pack2.AbsoluteConstraints(670, 400, 460, 20));
		jPanel1.add(jSeparator6, new pack2.AbsoluteConstraints(670, 480, 460, 20));	
		
		jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 36)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(0, 51, 204));
		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel4.setText("자율방범대 서비스");
		jPanel1.add(jLabel4, new pack2.AbsoluteConstraints(140, 130, 410, 140));

		jLabel13.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
		jLabel13.setForeground(new java.awt.Color(255, 255, 255));
		jLabel13.setText("Email");
		jPanel1.add(jLabel13, new pack2.AbsoluteConstraints(670, 510, 260, 50));

		jLabel12.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
		jLabel12.setForeground(new java.awt.Color(255, 255, 255));
		jLabel12.setText("PhoneNumber");
		jPanel1.add(jLabel12, new pack2.AbsoluteConstraints(670, 430, 260, 50));

		jLabel11.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
		jLabel11.setForeground(new java.awt.Color(255, 255, 255));
		jLabel11.setText("Name");
		jPanel1.add(jLabel11, new pack2.AbsoluteConstraints(670, 350, 260, 50));

		jLabel9.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
		jLabel9.setForeground(new java.awt.Color(255, 255, 255));
		jLabel9.setText("Password");
		jPanel1.add(jLabel9, new pack2.AbsoluteConstraints(670, 270, 260, 50));

		jLabel10.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
		jLabel10.setForeground(new java.awt.Color(255, 255, 255));
		jLabel10.setText("ID");
		jPanel1.add(jLabel10, new pack2.AbsoluteConstraints(670, 190, 260, 50));
		
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setIcon(new javax.swing.ImageIcon("src\\pack2\\blue_corner_shadow.png")); // NOI18N
		jPanel1.add(jLabel2, new pack2.AbsoluteConstraints(550, 30, 670, 730));

		

		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setIcon(new javax.swing.ImageIcon("src\\pack2\\wave_img_cut.png")); // NOI18N
		jPanel1.add(jLabel1, new pack2.AbsoluteConstraints(80, 40, 610, 690));

		confirmBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				confirmBtnActionPerformed(evt);
			}
		});
		jPanel1.add(ConfirmBtn, new pack2.AbsoluteConstraints(1055, 655, 110, 50));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(4, 4, 4).addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(20, 20, 20)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(9, 9, 9)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
						.addGap(11, 11, 11)));
		
		jSeparator6.setVisible(false);
		jSeparator5.setVisible(false);
		jSeparator1.setVisible(false);

		NameTextField.setVisible(false);
		PhoneNumberField.setVisible(false);
		EmailTextField.setVisible(false);
     	 
		jLabel11.setVisible(false);
		jLabel12.setVisible(false);
		jLabel13.setVisible(false);
			
		Mark1.setVisible(false);
		Mark2.setVisible(false);
		Mark3.setVisible(false);
		Mark4.setVisible(false);
		Mark5.setVisible(false);
		 
         warningMessage1.setVisible(false);
         warningMessage2.setVisible(false);
         warningMessage3.setVisible(false);
         warningMessage4.setVisible(false);
         warningMessage5.setVisible(false);
//         animation1.setVisible(true);
//         animation2.setVisible(true);
		
		GetCaretPositionInJTextField gcp = new GetCaretPositionInJTextField();  // 커서 위치 계산하는 클래스
		gcp.init(IDTextField);
		CaretEvent e = null ;
		gcp.caretUpdate(e);
		

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void EmailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void IDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
		
	}

	private void NameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
		
	}

	private void PhoneNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {
		
	}

	private void PWFieldActionPerformed(java.awt.event.ActionEvent evt) {
		
	}
//------------------------------------아래는 텍스트 필드 포커스(커서여부)---------------------

	PatternChecker pc = new PatternChecker();
	int idTry = 0;

	private void IDTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		if (idTry == 0) {
			IDTextField.setText("");
			idTry += 1;
		}
	}

	private void IDTextFieldFocusLost(java.awt.event.FocusEvent evt) {
		id = IDTextField.getText();
		if (!pc.isId(id) && SignupBtn.getX()==1030) {//아이디 확인하고 && 회원가입 상태일때.
			idTry = 0;
			Mark1.setVisible(true);
			warningMessage1.setVisible(true);
		} else {
			Mark1.setVisible(false);
			warningMessage1.setVisible(false);
		}
	}

	int pwTry = 0;

	private void PWFieldFocusGained(java.awt.event.FocusEvent evt) {
		if (pwTry == 0) {
			PWField.setText("");
			pwTry += 1;
		}
	}

	private void PWFieldFocusLost(java.awt.event.FocusEvent evt) {
		pw = PWField.getText();
		if (!pc.isPw(pw) && SignupBtn.getX()==1030) {
			pwTry = 0;
			Mark2.setVisible(true);
			warningMessage2.setVisible(true);
		} else {
			Mark2.setVisible(false);
			warningMessage2.setVisible(false);
		}
	}

	int nameTry = 0;

	private void NameTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		if (nameTry == 0) {
			NameTextField.setText("");
			nameTry += 1;
		}
	}

	private void NameTextFieldFocusLost(java.awt.event.FocusEvent evt) {
		name = NameTextField.getText();
		if (!pc.isName(name)) {
			nameTry = 0;
			Mark3.setVisible(true);
			warningMessage3.setVisible(true);
		} else {
			Mark3.setVisible(false);
			warningMessage3.setVisible(false);
		}
	}

	int phoneNumTry = 0;

	private void PhoneNumberFieldFocusGained(java.awt.event.FocusEvent evt) {
		if (phoneNumTry == 0) {
			PhoneNumberField.setText("");
			phoneNumTry += 1;
		}
	}

	private void PhoneNumberFieldFocusLost(java.awt.event.FocusEvent evt) {
		phoneNumber = PhoneNumberField.getText();
		if (!pc.isPhoneNumber(phoneNumber)) {
			phoneNumTry = 0;
			Mark4.setVisible(true);
			warningMessage4.setVisible(true);
		} else {
			Mark4.setVisible(false);
			warningMessage4.setVisible(false);
		}
	}

	int emailTry = 0;

	private void EmailTextFieldFocusGained(java.awt.event.FocusEvent evt) {
		if (emailTry == 0) {
			EmailTextField.setText("");
			emailTry += 1;
		}
	}

	private void EmailTextFieldFocusLost(java.awt.event.FocusEvent evt) {
		email = EmailTextField.getText();
		if (!pc.isEmail(email)) {
			emailTry = 0;
			Mark5.setVisible(true);
			warningMessage5.setVisible(true);
		} else {
			Mark5.setVisible(false);
			warningMessage5.setVisible(false);
		}
	}

	private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//-------------------------------------------------------------
		
	if(SignupBtn.getX() == 1030) {//회원가입 상태라면
		Object obj = evt.getSource(); // 회원가입 클릭했을 때, 입력한 정보들을 가져오는 작업.
		if (obj == confirmBtn) { // 회원가입 버튼을 눌렀을 때 아래를 진행하겠다는 의미.(obj랑 버튼에 담긴 데이터는 같을 수 밖에 없으므로)
			boolean check = pc.isId(id) && pc.isPw(pw) && pc.isName(name) && pc.isPhoneNumber(phoneNumber) && pc.isEmail(email) ;
			try {
				DBDAO.init(); // DB연결 !!반드시 먼저 실행 되어야함.
				CheckLogin cl = new CheckLogin();
				if (check && !cl.checkId(id)) {//검색해서 있으면 true 즉, !false --> 검색해서 없는것(중복아님)
					// 맞으면 데이터 insert
					String sql = "insert into clients(client_id, client_pw, client_name, phone_number, client_email, signup_date) "
							+ "values('" + id + "', '" + pw + "', '" + name + "','" + phoneNumber + "' , '" + email	+ "', sysdate)";
					System.out.println(sql);
					DBDAO.executeSqlUpdate(sql);

					DBDAO.executeSqlUpdate("commit");
					JOptionPane.showMessageDialog(null, "회원가입 성공", "회원가입", JOptionPane.INFORMATION_MESSAGE);
					// 생성자(); <-- 다음과정 실행.
				}else if(check && cl.checkId(id)){
					System.out.println("회원가입 실패");
					JOptionPane.showMessageDialog(null, "아이디가 중복됩니다.", "회원가입 오류", JOptionPane.ERROR_MESSAGE);
				}else {
					System.out.println("회원가입 실패");
					JOptionPane.showMessageDialog(null, "회원가입 실패", "회원가입 오류", JOptionPane.ERROR_MESSAGE);
				}
			}
			catch (NullPointerException e1) {
				System.out.println("회원가입 실패1");
				JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.");
			}
			catch (Exception e2) {
				System.out.println("회원가입 실패2");
				JOptionPane.showMessageDialog(null, "회원가입 실패");
			}
		}
	}else if(SignupBtn.getX() == 933) {//sign up 라벨 왼쪽이면 로그인 기능 수행.
		DBDAO.init();
		CheckLogin cl = new CheckLogin();
		boolean check = cl.checkIdPw(id, pw);
		if(check) {
			System.out.println("로그인 성공");
			JOptionPane.showMessageDialog(null, "로그인 성공", "로그인", JOptionPane.INFORMATION_MESSAGE);
			//맞으면 다음 실행 할(메소드)(기능) 실행
			//!@#!#@!@#생성자();
			this.dispose();//로그인 성공했기 때문에 창 지운다.//.visible(false);라는 잠시 안보이게 하는 기능 있으나 로그인 창은 다시 필요 없으니 지운다. 
//setvisible기능은 메모장같이 new로 생성했는데 지웠다가 키면 계속 새로운 객체가 생성이 되니
//setvisible을 사용하여 보였다 안보였다 하는 것도 방법중 하나이다.
		}else {
			System.out.println("로그인 실패");
			JOptionPane.showMessageDialog(null ,"로그인 실패", "로그인", JOptionPane.ERROR_MESSAGE);
			IDTextField.setText("");// id 입력창 깨끗하게
			PWField.setText("");
			IDTextField.requestFocus();// 커서를 id 에 위치시킴
		}
		
	}
		//-----DB연결 해제 -----
	DBDAO.close();
		
	}

	private void confirmBtnMouseEntered(java.awt.event.MouseEvent evt) {
		jLabel4.setForeground(new java.awt.Color(0, 0, 0));
		confirmBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	private void confirmBtnMouseExited(java.awt.event.MouseEvent evt) {
		jLabel4.setForeground(new java.awt.Color(0, 51, 204));
	}
	
	private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {                                     
		jLabel3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
	
	private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {                                     
		try {
		    Desktop.getDesktop().browse(new URL("https://www.smhrd.or.kr/").toURI());
		} catch (Exception e) {}
    } 
	
	private void closeFunctionMouseClicked(java.awt.event.MouseEvent evt) {                                           
		this.dispose();//닫기 클릭하면 창 종료.
    }                                          

    private void closeFunctionMouseEntered(java.awt.event.MouseEvent evt) {                                           
    	closeFunction.setIcon(new javax.swing.ImageIcon("src\\pack2\\close_after.png")); // NOI18N
    	closeFunction.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    
    private void closeFunctionMouseExited(java.awt.event.MouseEvent evt) {                                          
    	closeFunction.setIcon(new javax.swing.ImageIcon("src\\pack2\\close_before.png")); // NOI18N
    }                                   
    
    private void SigninBtnMouseEntered(java.awt.event.MouseEvent evt) {                                       
    	SigninBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }                                      

    private void SigninBtnMouseExited(java.awt.event.MouseEvent evt) {                                      
        
    }                        
    private void SigninBtnActionPerformed(java.awt.event.ActionEvent evt) {
        //클릭하면 로그인 화면으로 넘어가야한다(로그인 클래스 실행)<-로그인 클래스는 새로 만들 것.
//         AnimationClass anim = new AnimationClass();        								//20ms 마다 7px 씩 이동.
//         anim.jButtonXLeft(1030, 933, 20, 5, SignupBtn);	//ctrl+f11 시작하자마자 signin 클릭하고 다른 곳 클릭하면 signup 다시 돌아감....
	
		jSeparator6.setVisible(false);
		jSeparator5.setVisible(false);
		jSeparator1.setVisible(false);

		NameTextField.setVisible(false);
		PhoneNumberField.setVisible(false);
		EmailTextField.setVisible(false);
     	 
		jLabel11.setVisible(false);
		jLabel12.setVisible(false);
		jLabel13.setVisible(false);
			
		Mark1.setVisible(false);
		Mark2.setVisible(false);
		Mark3.setVisible(false);
		Mark4.setVisible(false);
		Mark5.setVisible(false);
		 
         warningMessage1.setVisible(false);
         warningMessage2.setVisible(false);
         warningMessage3.setVisible(false);
         warningMessage4.setVisible(false);
         warningMessage5.setVisible(false);
         animation1.setVisible(true);
         animation2.setVisible(true);
         
         SignupBtn.setLocation(933, 75); //아 예 위치를 이동시켜버려도 같은 문제 생김. // -->맨처음 오픈후 다른 곳 클릭한 다음에 signin 클릭하면 문제 없음. -->해결방향으로 잡음(다른 해결법 못찾겠음) //로그인 화면으로 바꿔야 함.(간단하게 setvisible 기능 사용할 것임)
//     	 jSeparator2.setSize(30, 130); //-->세로선 길이 줄임.// 그냥 안쓰는 것으로 정함.
        
    }                                         
    
    private void SignupBtnMouseEntered(java.awt.event.MouseEvent evt) {                                       
    	SignupBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }                                      

    private void SignupBtnMouseExited(java.awt.event.MouseEvent evt) {                                      
        
    }                                     

    private void SignupBtnActionPerformed(java.awt.event.ActionEvent evt) {
    	SignupBtn.setLocation(1030, 75); 
//      jSeparator2.setSize(30, 370); //-->세로선 길이 늘림.
        NameTextField.setVisible(true);
        PhoneNumberField.setVisible(true);
        EmailTextField.setVisible(true);
        jLabel11.setVisible(true);
        jLabel12.setVisible(true);
        jLabel13.setVisible(true);
        jSeparator5.setVisible(true);
        jSeparator6.setVisible(true);
        jSeparator1.setVisible(true);
        animation1.setVisible(false);
        animation2.setVisible(false);
    }                 
    
	// ---------------------------------------------------

	public String getId() {
		return id;
	}

	public static void main(String args[]) {
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(UISignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(UISignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(UISignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(UISignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new UISignup().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//
	private javax.swing.JTextField IDTextField;
    private javax.swing.JButton SigninBtn;
    private javax.swing.JButton SignupBtn;
    public static javax.swing.JLabel animation1;
    public static javax.swing.JLabel animation2;
	private javax.swing.JLabel closeFunction;
	private javax.swing.JButton ConfirmBtn;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JButton confirmBtn;
	private javax.swing.JLabel Mark1;
	private javax.swing.JLabel Mark2;
	private javax.swing.JLabel Mark3;
	private javax.swing.JLabel Mark4;
	private javax.swing.JLabel Mark5;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPasswordField PWField;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator4;
	private javax.swing.JSeparator jSeparator5;
	private javax.swing.JSeparator jSeparator6;
	private javax.swing.JTextField EmailTextField;
	private javax.swing.JTextField NameTextField;
	private javax.swing.JTextField PhoneNumberField;
	private javax.swing.JLabel warningMessage1;
    private javax.swing.JLabel warningMessage2;
    private javax.swing.JLabel warningMessage3;
    private javax.swing.JLabel warningMessage4;
    private javax.swing.JLabel warningMessage5;
	// End of variables declaration//
}
