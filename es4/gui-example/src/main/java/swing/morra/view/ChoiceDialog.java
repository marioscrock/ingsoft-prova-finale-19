package swing.morra.view;

import swing.morra.model.Choice;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChoiceDialog extends JDialog {


	private static final long serialVersionUID = 8144235769266058719L;
	
	private JPanel mainPanel;
	private JComboBox<Choice> choices;
	private JButton confirmButton;
	
	private View view;
	
	private class ConfirmListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.processChoice((Choice) choices.getSelectedItem());
				ChoiceDialog.this.dispose();
			}		
	}
	
	public ChoiceDialog(JFrame frame, View view) {
		super(frame, "Scelta giocatore");
		
		this.view = view;
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(10, 10));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		choices = new JComboBox<Choice>(Choice.values());
		
		confirmButton = new JButton("Conferma");
		confirmButton.addActionListener(new ConfirmListener());
		mainPanel.add(choices, BorderLayout.PAGE_START);
		mainPanel.add(confirmButton, BorderLayout.PAGE_END);
		add(mainPanel);
		pack();
		setMinimumSize(new Dimension(300, 30));
		setVisible(true);
	}

}
