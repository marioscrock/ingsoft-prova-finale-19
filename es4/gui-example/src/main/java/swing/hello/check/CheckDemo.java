package swing.hello.check;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckDemo {

    JFrame frame = new JFrame("Example");

    public CheckDemo() {
        setupJFrame();
        setCheckBox();
    }

    public void setupJFrame() {
        frame.setSize(400,100);
        frame.getContentPane().setLayout(new FlowLayout());

        //Implement same behaviour of
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //But we can also add custom code (Saving...)
        WindowListener l = new MyWindowAdapter();
        frame.addWindowListener(l);
    }

    private void setCheckBox() {
        JCheckBox jck1 = new JCheckBox("Pepperoni");
        JCheckBox jck2 = new JCheckBox("Mushroom");
        JCheckBox jck3 = new JCheckBox("Black olives");
        JCheckBox jck4 = new JCheckBox("Tomato");

        jck1.addActionListener(new MyActionListener());

        //Item listener allows to inspect the checkbox status
        jck2.addItemListener(new MyItemListener());
        jck3.addItemListener(new MyItemListener());
        jck4.addItemListener(new MyItemListener());

        Container c = frame.getContentPane();
        c.add(jck1);
        c.add(jck2);
        c.add(jck3);
        c.add(jck4);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        CheckDemo demo = new CheckDemo();
    }
}

