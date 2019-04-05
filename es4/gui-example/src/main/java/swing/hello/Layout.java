package swing.hello;

import javax.swing.*;
import java.awt.*;

public class Layout {

    private static void createAndShowFlowLayout() {
        JFrame frame = new JFrame("Flow");
        frame.setLayout(new FlowLayout());
        frame.add(new JButton("Button1"));
        frame.add(new JButton("Button2"));
        frame.add(new JButton("Button3"));
        frame.add(new JButton("Button4"));
        frame.add(new JButton("Button5"));
        frame.pack();
        frame.setVisible(true);
    }

    private static void createAndShowBorderLayout() {
        JFrame frame = new JFrame("Border");
        frame.setLayout(new BorderLayout());

        frame.add(new JButton("North"), BorderLayout.NORTH);
        frame.add(new JButton("South"), BorderLayout.SOUTH);
        frame.add(new JButton("Center"), BorderLayout.CENTER);
        frame.add(new JButton("East"), BorderLayout.EAST);
        frame.add(new JButton("West"), BorderLayout.WEST);

        frame.pack();
        frame.setVisible(true);
    }

    private static void createAndShowGridLayout() {
        JFrame frame = new JFrame("Grid");
        frame.setLayout(new GridLayout(3,4));

        for (int x=1; x<13; x++)
            frame.add(new JButton("" + x));

        frame.pack();
        frame.setVisible(true);
    }

    private static void createAndShowNested() {
        JFrame f = new JFrame("Example");
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        f.setLayout(new BorderLayout());
        p2.setLayout(new FlowLayout());
        p4.setLayout(new BorderLayout());

        p1.add(new JLabel("Panel 1"));
        p4.add(new JButton("Button1"), BorderLayout.EAST);
        p4.add(new JButton("Button2"), BorderLayout.WEST);  p2.add(p3);
        p2.add(p4);
        p3.add(new JLabel("Panel 3"));
        f.add(p1, BorderLayout.NORTH);
        f.add(p2, BorderLayout.SOUTH);

        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args){
        //createAndShowFlowLayout();
        //createAndShowBorderLayout();
        //createAndShowGridLayout();

        createAndShowNested();
    }

}
