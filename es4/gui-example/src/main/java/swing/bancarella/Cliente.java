package swing.bancarella;

import java.util.Random;

public class Cliente {
	
	public void compra(Bancarella bancarella){
		Random random = new Random();
		int num = random.nextInt(Prodotto.Tipo.values().length);
		bancarella.compraProdotto(Prodotto.Tipo.values()[num]);
	}

}
