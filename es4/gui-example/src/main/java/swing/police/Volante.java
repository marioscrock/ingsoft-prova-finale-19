package swing.police;

public class Volante {
	
	private static int currentId=0;
	private final int id;
	private final int zona;
	
	public Volante(int zona) {
		id = currentId;
		currentId++;
		this.zona = zona;		
	}
	
	public int getZona(){
		return zona;
	}

	@Override
	public String toString() {
		return "VP" + id;
	}
	
	public String notifica(){
		return "Volante " + this + " notificata!";
	}	

}
