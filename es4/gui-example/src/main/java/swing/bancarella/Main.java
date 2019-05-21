package swing.bancarella;

import javax.swing.SwingUtilities;

public class Main {
	
	private Bancarella bancarella;
	private MainJFrame gui;
	private ProduttoreListener listener;
	
	public Main() {
		
		bancarella = new Bancarella();
		gui = new MainJFrame(bancarella);

		listener = new ProduttoreListener(bancarella);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				gui.initGUI(listener);				
			}
		});


		Cliente cliente = new Cliente();
		while(true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cliente.compra(bancarella);

			//TODO 
			//We want GUI update also if initial thread is sleeping!
			//- Remove updateGUI from this thread
			//- Fix update() implementation in MainJFrame Observer
			//  removing comments
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    gui.updateGUI(bancarella.getNumero(Prodotto.Tipo.POMODORO),
                            bancarella.getNumero(Prodotto.Tipo.BASILICO),
                            bancarella.getNumero(Prodotto.Tipo.PATATA));
                }
            });
		}

	}

	public static void main(String[] args) {
		new Main();
	}
	
	

}
