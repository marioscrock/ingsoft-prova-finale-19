package swing.hello;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class EventExample {

	private JButton button = new JButton("Click me!");

	private JFrame frame;

	public EventExample() {

		frame = new JFrame("Event Example");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		button.setOpaque(true);
		button.setBorderPainted(false);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button.setBackground(Color.RED);
				button.repaint();
			}
		});

		frame.add(button);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new EventExample();
	}

}