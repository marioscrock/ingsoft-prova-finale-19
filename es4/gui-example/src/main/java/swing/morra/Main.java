package swing.morra;

import swing.morra.controller.Controller;
import swing.morra.model.Model;
import swing.morra.model.ModelView;
import swing.morra.view.ConsoleView;
import swing.morra.view.SwingView;
import swing.morra.view.View;

public class Main {
	
	private Model model;
	
	private ModelView modelView;
	
	private View view;
	
	private Controller controller;
	
	public Main() {		
		model = new Model();
		modelView = new ModelView();

		//view = new ConsoleView(System.in, System.out);
		view = new SwingView();

		controller = new Controller(model, view);
		view.addObserver(controller);
		model.addObserver(modelView);
		modelView.addObserver(view);		
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();		
	}

	private void run() {		
		view.run();		
	}	

}
