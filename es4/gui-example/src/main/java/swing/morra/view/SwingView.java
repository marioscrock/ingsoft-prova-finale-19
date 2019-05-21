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
		frame = new JFrame("Morra cinese");
		mainPanel = new JPanel(new BorderLayout(10, 10));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		results = new JPanel();
		results.setLayout(new BorderLayout(10, 10));
		results.setBorder(new EmptyBorder(10, 10, 10, 10));
		results.add(buildDataLayout(), BorderLayout.PAGE_START);
		resultLabel = new JLabel();
		results.add(resultLabel, BorderLayout.PAGE_END);
		mainPanel.add(results, BorderLayout.PAGE_START);
		
		button = new JButton("Nuovo round!");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ChoiceDialog(frame, SwingView.this);				
			}
		});
		mainPanel.add(button, BorderLayout.PAGE_END);
		
		frame.add(mainPanel);
		frame.pack();
	}

	private JPanel buildDataLayout() {
		JPanel result = new JPanel();
		result.setLayout(new GridLayout(2, 2, 10, 10));
		result.add(new JLabel("Tua scelta:"));
		result.add(new JLabel("Scelta computer:"));
		result.add(playerChoice);
		result.add(computerChoice);
		return result;
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
