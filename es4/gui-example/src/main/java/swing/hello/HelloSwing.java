package swing.hello;

import javax.swing.*;

public class HelloSwing {

    private static void createAndShowHelloWorld() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello World!");
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args){
        createAndShowHelloWorld();
    }

}
