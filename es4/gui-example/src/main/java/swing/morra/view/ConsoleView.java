package swing.morra.view;

import swing.morra.model.Choice;
import swing.morra.model.ModelView;
import swing.morra.model.Outcome;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleView extends View{
	
	private Scanner scanner;
	private PrintStream output;
	
	public ConsoleView(InputStream inputStream, OutputStream output) {
		this.scanner = new Scanner(inputStream);
		this.output = new PrintStream(output);
	}	
	
	@Override
	public void run() {
		while(true){
			output.println("Indicare una scelta:");
			String text = scanner.next();
			try{				
				Choice choice = Choice.parseInput(text);
				processChoice(choice);				
			}catch(IllegalArgumentException e){
				output.println("Errore di input!");
			}
		}		
	}
	
	private void print(String message) {
		output.println(message);		
	}


	private void printComputerChoice(Choice computerChoice) {
		output.println("Ho scelto " + computerChoice + ".");		
	}


	private void printPlayerChoice(Choice playerChoice) {
		output.println("Hai scelto " + playerChoice + ".");		
	}
	
	protected void showModel(ModelView model) {
		printPlayerChoice(model.getPlayerChoice());
		printComputerChoice(model.getComputerChoice());
		printOutcome(model.getOutcome());
	}
	
	private void printOutcome(Outcome outcome) {
		switch(outcome){
		case DRAW:
			print("Parità!");
			break;
		case LOSER:
			print("Hai perso!");
			break;
		case WINNER:
			print("Hai vinto!");
			break;
		default:
			throw new IllegalArgumentException();		
		}
	}

}
