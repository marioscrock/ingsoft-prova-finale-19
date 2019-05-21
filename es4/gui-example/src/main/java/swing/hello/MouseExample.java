package swing.hello;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

import javax.swing.*;

public class MouseExample {
	
	private JButton button = new JButton("Click me!");
	
	private JFrame frame;
	
	public MouseExample() {

		 frame = new JFrame("Mouse Example");
		 frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		 frame.setLayout(null);

		 //Attention -> This is the entire window size! Margins included
		 //https://stackoverflow.com/questions/13474795/get-the-real-size-of-a-jframe-content
		 frame.setSize(640, 480);
		 System.out.println(frame.getContentPane().getWidth());
		 System.out.println(frame.getContentPane().getHeight());

		 button.setBounds(245, 210, 150, 40);
		 button.addActionListener(new ActionListener() {
				  @Override
				  public void actionPerformed(ActionEvent e) {
					  button.setBackground(Color.RED);
				  }
			  });

		button.addMouseMotionListener(new MouseHandler());

		frame.add(button);
		frame.setVisible(true);

		 //TODO
		 //Try to remove comment on this
		 frame.pack();
	}

	public static void main(String[] args) {
		new MouseExample();		
	}

	private class MouseHandler extends MouseAdapter{

		@Override
		public void mouseMoved(MouseEvent e) {

			int incx = 0, incy = 0;
			Random r = new Random();

			if (r.nextBoolean())
				if (r.nextBoolean()) incx = button.getWidth();
				else incx = -button.getWidth();

			if (r.nextBoolean())
				if (r.nextBoolean()) incy = button.getHeight();
				else incy = -button.getHeight();

			int x = button.getX() + incx;
			int y = button.getY() + incy;

			x = (x >= frame.getContentPane().getWidth() || x < -button.getWidth())
					? (frame.getContentPane().getWidth() - button.getWidth())/2 : x;
			y = (y >= frame.getContentPane().getHeight() || y < -button.getHeight())
					? (frame.getContentPane().getHeight() - button.getHeight())/2 : y;

			button.setBounds(x, y, button.getWidth(), button.getHeight());

		}

	}
	
}