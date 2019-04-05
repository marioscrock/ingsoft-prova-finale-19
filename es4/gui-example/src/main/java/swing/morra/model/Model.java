package swing.morra.model;

import java.util.Observable;

public class Model extends Observable implements Cloneable{
	
	private Choice player;
	
	private Choice computer;
	
	private Outcome outcome;
	
	@Override
	public Model clone() {
		Model model = new Model();
		model.player = player;
		model.computer = computer;
		model.outcome = outcome;
		return model;
	}
	
	public void copyOf(Model model){
		this.player = model.player;
		this.computer = model.computer;
		this.outcome = model.outcome;			
	}

	public void setPlayerChoice(Choice choice) {
		player = choice;		
	}
	
	public void setComputerChoice(Choice choice){
		computer = choice;
	}

	public Choice getPlayerChoice() {
		return player;
	}

	/*
	 * Si noti che la notifica del cambiamento del model viene inviata solo quando
	 * l'outcome viene settato. Questo fa parte della specifica della applicazione.
	 */
	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
		setChanged();
		notifyObservers();	
	}
	
	public Choice getComputerChoice(){
		return computer;
	}
	
	public Outcome getOutcome(){
		return outcome;
	}

}
