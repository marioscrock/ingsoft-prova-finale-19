package swing.bancarella;

import swing.bancarella.Prodotto.Tipo;

import java.util.ArrayList;
import java.util.Observable;

public class Bancarella {
	
	private ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
	
	public void addProdotto(Prodotto p){
		prodotti.add(p);
		//TODO
	}
	
	public void compraProdotto(Tipo tipo){
		for(Prodotto p: prodotti){
			if(p.getTipo() == tipo){
				prodotti.remove(p);
				break;
			}
		}
		//TODO
	}
	
	public int getNumero(Tipo tipo){
		int result = 0;
		for(Prodotto prodotto : prodotti){
			if(prodotto.getTipo() == tipo){
				result++;
			}
		}
		return result;
	}
}
