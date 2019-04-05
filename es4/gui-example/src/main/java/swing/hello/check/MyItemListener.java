package swing.hello.check;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyItemListener implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED)
            System.out.print("selected ");
        else
            System.out.print("de-selected ");

        if (e.getItem() instanceof JCheckBox)
            System.out.print(((JCheckBox) e.getItem()).getText() + "\n");
    }
}
