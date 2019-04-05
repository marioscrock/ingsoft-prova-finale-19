package swing.morra.model;

import java.util.Random;


public enum Choice {
	CARTA, FORBICE, SASSO; 	//TODO: Estendere questa classe includendo i casi aggiuntivi LIZARD e SPOCK
							//NUOVE COMBINAZIONI:
							//	  
							//	Le forbici tagliano la carta
							//	La carta avvolge il sasso
							//	Il sasso rompe le forbici
							//	Le forbici decapitano Lizard
							//	Lizard mangia la carta
							//	La carta invalida Spock
							//	Spock vaporizza il sasso
							//	Il sasso schiaccia Lizard
							//	Lizard avvelena Spock
							//	Spock rompe le forbici
	 
	
	public Outcome resultAgainst(Choice other){
		if(this==other){
			return Outcome.DRAW;
		}
		switch(this){
		case CARTA:
			return Outcome.winsIfTrue(other==Choice.SASSO);		
		case FORBICE:
			return Outcome.winsIfTrue(other==Choice.CARTA);		
		case SASSO:
			return Outcome.winsIfTrue(other==Choice.FORBICE);	
		default:
			throw new RuntimeException("Unexpected case!");		
		}		
	}
	
	/*
	 * Questo metodo può essere spostato in altre parti del sistema a seconda della specifica adottata.
	 */
	public static Choice parseInput(String input){
		return Enum.valueOf(Choice.class, input.toUpperCase());
	}
	
	public static Choice getRandomChoice(Random random){
		Choice[] values = Choice.values();
		return values[random.nextInt(values.length)];
	}
	
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}

}

