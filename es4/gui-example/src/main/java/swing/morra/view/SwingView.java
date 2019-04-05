package swing.morra.view;

import swing.morra.model.ModelView;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SwingView extends View {
	
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel results;
	private JLabel resultLabel;
	private JButton button;
	private JLabel playerChoice = new JLabel();
	private JLabel computerChoice = new JLabel();
	
	public SwingView() {
		//TODO
	}

	private JPanel buildDataLayout() {
		//TODO
		return null;
	}

	@Override
	public void run() {
		frame.setVisible(true);

	}

	@Override
	protected void showModel(ModelView model) {
		playerChoice.setText(model.getPlayerChoice().toString());
		computerChoice.setText(model.getComputerChoice().toString());
		switch(model.getOutcome()){
		case DRAW:
			resultLabel.setText("Parità");
			break;
		case LOSER:
			resultLabel.setText("Hai perso!");
			break;
		case WINNER:
			resultLabel.setText("Hai vinto!");
			break;
		default:
			throw new IllegalArgumentException("Invalid outcome!");
		}

	}

}
