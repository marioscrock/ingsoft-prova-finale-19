package swing.bancarella;

public class Prodotto {
	
	enum Tipo{POMODORO, BASILICO, PATATA};
	
	private Tipo tipo;
	
	public Prodotto(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public Tipo getTipo(){
		return tipo;
	}

}
