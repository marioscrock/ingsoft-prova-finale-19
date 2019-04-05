package swing.morra.model;

/*
 * Si noti come la maggior parte delle funzionalità dell'enum Outcome sono state spostate nella view
 */
public enum Outcome {
	WINNER, LOSER, DRAW;
		
	public static Outcome winsIfTrue(boolean condition){
		return (condition)?Outcome.WINNER:Outcome.LOSER;
	}

}
