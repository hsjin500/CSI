/*
 Get Current Caret Position in JTextField Example 
 This java example shows how to get current position of caret in JTextField
 using Java Swing JTextField class.
*/
package pack1;

import java.awt.FlowLayout;

import javax.swing.JApplet;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/*
<applet code="GetCaretPositionInJTextFieldExample" width=200 height=200>
</applet>
*/

/*
 * Implement CaretListener in order to listen for caret position
 * change event.
 */
public class GetCaretPositionInJTextField extends JApplet implements CaretListener {

	public void GetCaretPositionInJTextField() {

	}

	public void init(JTextField field) {

		// set flow layout for the applet
// this.getContentPane().setLayout(new FlowLayout());

		// create new JTextField
// JTextField field = new JTextField("JTextField Caret Position Example");
// 
// add(field);

		// add CaretListener in order to listen for caret position changes
		field.addCaretListener(this);
	}

	// override caretUpdate event to capture caret position changes
	public void caretUpdate(CaretEvent e) {

		/*
		 * To get the current position of caret use, int getDot() method of CaretEvent
		 * class.
		 */
		try {
			int position = e.getDot();
//			System.out.println("현재 커서 위치 : "+position);
			if (e.getDot() == 2) {
				
				UISignup.animation1.setIcon(new javax.swing.ImageIcon("src\\pack2\\1.png")); // 타이핑 위치에 따라서 그림 바뀌는거
				UISignup.animation2.setIcon(new javax.swing.ImageIcon("src\\pack2\\robber0.png")); 
				//바로 위 문장 사용하려면 UIsignup에서 맨아래 변수 field 설정을 public static으로 해주면 된다.																		// 테스트 하기 위해 써둠
			} else if (e.getDot() == 4) {
				UISignup.animation1.setIcon(new javax.swing.ImageIcon("src\\pack2\\2.png"));
				UISignup.animation2.setIcon(new javax.swing.ImageIcon("src\\pack2\\robber1.png"));
			} else if (e.getDot() == 7) {
				UISignup.animation1.setIcon(new javax.swing.ImageIcon("src\\pack2\\3.png"));
				UISignup.animation2.setIcon(new javax.swing.ImageIcon("src\\pack2\\robber2.png"));
			}
		} catch (NullPointerException e1) {

		}

		// show current position in the status bar of an applet
// getAppletContext().showStatus("Caret Position :" + position);

	}

}