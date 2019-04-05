package swing.bancarella;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class MainJFrame extends JFrame {

	private static final long serialVersionUID = -1946117194064716902L;

	private static final int NUM_PRODOTTI = Prodotto.Tipo.values().length;
	
	private ProductButton buttons[] = {
			new ProductButton(Prodotto.Tipo.POMODORO, "Produci pomodoro"),
			new ProductButton(Prodotto.Tipo.BASILICO, "Produci basilico"),
			new ProductButton(Prodotto.Tipo.PATATA, "Produci patate")};
	
	
	private JTextField textFields[] = new JTextField[NUM_PRODOTTI];
	
	private JPanel panel1 = new JPanel();
	
	private JPanel panel2 = new JPanel();

	public MainJFrame(Bancarella bancarella) {

		//TODO

	}

	public void initGUI(ProduttoreListener listener) {
		panel1.add(new JLabel("Interfaccia produttore, premere i tasti per aggiungere prodotti!"));
		panel2.setLayout(new GridLayout(2, 3));
		
		for(int i=0;i<NUM_PRODOTTI;i++){
			panel2.add(buttons[i]);						
		}
		
		for(int i=0;i<NUM_PRODOTTI;i++){
			textFields[i] = new JTextField();
			panel2.add(textFields[i]);
			textFields[i].setEditable(false);
			textFields[i].setHorizontalAlignment(SwingConstants.CENTER);
			buttons[i].addActionListener(listener);
		}
		
		setLayout(new BorderLayout());
		add(panel1, BorderLayout.PAGE_START);
		add(panel2, BorderLayout.PAGE_END);

		// Try to comment it out
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// https://stackoverflow.com/questions/22982295/what-does-pack-do
		pack();

		setVisible(true);
		
	}
	
	public void updateGUI(int npom, int nbas, int npat){
		textFields[0].setText("Sono presenti " + npom + " pomodori!");
		textFields[1].setText("Sono presenti " + nbas + " foglie di basilico!");
		textFields[2].setText("Sono presenti " + npat + " patate!");
	}

	//TODO

}
