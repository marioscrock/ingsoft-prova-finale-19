package swing.police;

import java.util.ArrayList;
import java.util.StringJoiner;

public class VolantiManager {
	
	private ArrayList<Volante> dbVolanti = new ArrayList<Volante>();
	
	public void addVolante(Volante v){
		dbVolanti.add(v);
	}
	
	public String notificaVolanti(int zona) throws NessunaVolanteException{
		StringBuilder builder = new StringBuilder();
		for(Volante volante : dbVolanti){
			if(volante.getZona()==zona){
				builder.append(volante.notifica() + "\n");
			}
		}
		String result = builder.toString();
		if(result.equals("")){
			throw new NessunaVolanteException();
		}
		return result;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("VolantiManager{dbVolanti=");

		StringJoiner sj = new StringJoiner(",", "[", "]");
		for(Volante v : dbVolanti)
			sj.add(v.toString() + " in zona " + v.getZona());
		sb.append(sj.toString() + "}");

		return sb.toString();
	}
}
