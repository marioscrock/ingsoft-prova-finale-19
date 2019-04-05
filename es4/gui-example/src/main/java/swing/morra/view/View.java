package swing.morra.view;

import swing.morra.model.Choice;
import swing.morra.model.ModelView;

import java.util.Observable;
import java.util.Observer;

public abstract class View extends Observable implements Runnable, Observer{
	
	protected void processChoice(Choice choice) {
		setChanged();
		notifyObservers(choice);
	}


	protected abstract void showModel(ModelView model);

	/*
	 * In questo caso la view interagisce direttamente col model, ricevendo direttamente le notifiche dei cambiamenti del model. 
	 * Sarebbe anche possibile gestire le interazione col model esclusivamente attraverso il controller.
	 */
	@Override
	public void update(Observable o, Object arg) {
		if(!(o instanceof ModelView)){
			throw new IllegalArgumentException();			
		}
		showModel((ModelView)o);
	}	

}