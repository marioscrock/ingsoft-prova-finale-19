package swing.morra.controller;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import swing.morra.model.Choice;
import swing.morra.model.Model;
import swing.morra.model.Outcome;
import swing.morra.view.View;

public class Controller implements Observer{
	
	private Model model;
	
	private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	
	private Choice computeChoice(){
		return Choice.getRandomChoice(new Random());
	}
	
	/*
	 * Questo metodo rappresenta la vera e propria logica applicativa
	 * In realtà perte di questa è stata messa nella classe Choice nel metodo resultAgainst
	 * È possibile posizionare tutta la logica all'interno del controller.
	 */
	private void manageRound(){
		Choice computerChoice = computeChoice();
		model.setComputerChoice(computerChoice);
		Outcome outcome = model.getPlayerChoice().resultAgainst(computerChoice);
		model.setOutcome(outcome);		
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o != view || !(arg instanceof Choice)){
			throw new IllegalArgumentException();
		}	
		model.setPlayerChoice((Choice) arg);
		manageRound();
	}
	
	

}
