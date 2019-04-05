package swing.bancarella;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProduttoreListener implements ActionListener {
	
	private Bancarella bancarella;

	public ProduttoreListener(Bancarella bancarella) {
		this.bancarella = bancarella;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Prodotto.Tipo tipo = ((ProductButton)e.getSource()).getTipo();
		bancarella.addProdotto(new Prodotto(tipo));
	}

}
