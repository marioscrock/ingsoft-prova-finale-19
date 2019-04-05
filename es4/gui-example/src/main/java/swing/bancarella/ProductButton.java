package swing.bancarella;

import javax.swing.JButton;

public class ProductButton extends JButton {

	private static final long serialVersionUID = -4906018373654826921L;
	private Prodotto.Tipo tipo;
	
	public ProductButton(Prodotto.Tipo tipo, String text) {
		super(text);
		this.tipo = tipo;
	}
	
	public Prodotto.Tipo getTipo(){
		return tipo;
	}
	
	
	
}
