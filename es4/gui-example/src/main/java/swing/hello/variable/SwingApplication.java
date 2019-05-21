package swing.hello.variable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingApplication implements ActionListener {

    private static final String LABEL_PREFIX = "Number of button clicks: ";
    private int numClicks = 0;
    private JLabel label = new JLabel(LABEL_PREFIX + "0	");

    public Component createComponents() {

        JButton button = new JButton("I'm a Swing button!");
        button.addActionListener(this);

        label.setLabelFor(button);
        JPanel pane = new JPanel(new GridLayout(1, 1));

        pane.add(button);
        pane.add(label);

        //REMOVE ME
        pane.setBorder(BorderFactory
                .createEmptyBorder(30, 30, 10, 30));

        return pane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        numClicks++;
        label.setText(LABEL_PREFIX + numClicks);
    }


    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("SwingApplication");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SwingApplication app = new SwingApplication();
        Component contents = app.createComponents();

        frame.getContentPane().add(contents, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
