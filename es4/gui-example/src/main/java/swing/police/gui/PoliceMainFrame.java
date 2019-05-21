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
		for(int i=0;i<3;i++) {
			panels[i] = new JPanel();
		}
		panels[0].add(new JLabel("Selezionare una zona:"));
		panels[1].setLayout(new GridLayout(3,3));

		for(int i = 0; i<6; i++) {
			buttons[i] = new MyButton(i + 1);
			panels[1].add(buttons[i]);
			buttons[i].addActionListener(h);
		}

		panels[2].setLayout(new BorderLayout());
		panels[2].add(textArea);

		setLayout(new BorderLayout());
		add(panels[0], BorderLayout.PAGE_START);
		add(panels[1], BorderLayout.CENTER);
		add(panels[2], BorderLayout.PAGE_END);
		pack();
		setVisible(true);
	}

	public void setText(String res) {
		textArea.setText(res);		
	}

}
