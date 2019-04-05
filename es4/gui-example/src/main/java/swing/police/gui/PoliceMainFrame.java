package swing.police.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PoliceMainFrame extends JFrame {
	
	class MyButton extends JButton{

		private static final long serialVersionUID = -152620801516839251L;
		private int zona;
		
		public MyButton(int zona){
			super(String.valueOf(zona));
			this.zona = zona;
		}

		public int getZona() {
			return zona;
		}
	}

	private static final long serialVersionUID = 5378733971532235705L;
	
	private MyButton[] buttons = new MyButton[6];
	private JPanel panels[] = new JPanel[3];
	private JTextArea textArea = new JTextArea();
	
	public void initGUI(AlarmHandler h){
		//TODO
	}

	public void setText(String res) {
		textArea.setText(res);		
	}

}
