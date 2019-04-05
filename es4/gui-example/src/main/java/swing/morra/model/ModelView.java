package swing.morra.model;

import java.util.Observable;
import java.util.Observer;


/*
 * Questa classe viene introdotta per disaccoppiare il model dalla view
 * e quindi impedire eventuali modifiche non permesse al model.
 */
public class ModelView extends Observable implements Observer {
	
	private Model modelCopy;

	@Override
	public void update(java.util.Observable o, Object arg) {
		if(!(o instanceof Model)){
			throw new IllegalArgumentException();
		}
		modelCopy = ((Model) o).clone();
		setChanged();
		notifyObservers();	
	}
	
	public Choice getPlayerChoice() {
		return modelCopy.getPlayerChoice();
	}
	
	public Choice getComputerChoice(){
		return modelCopy.getComputerChoice();
	}
	
	public Outcome getOutcome(){
		return modelCopy.getOutcome();
	}

}
