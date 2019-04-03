import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Sample {

    public static void main( String[] args ){

        List<Integer> values = Arrays.asList(1,2,3,4,5,6);

        for(int i=0; i<values.size(); i++)
            System.out.println(values.get(i));
        for(int i:values){
            System.out.println(i);
        }

        values.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer t){
                System.out.println(t);
            } 
        });

        values.forEach((Integer t) -> System.out.println(t));
        //non è necessario specificare il tipo di t
        values.forEach((t) -> System.out.println(t));
        //ma posso anche scrivere solo
        values.forEach(System.out :: println);

        //Raddoppiamo ogni valore della lista, poi facciamo la somma e la stampiamo
        int total=0;
        for(int e : values)
            total += e*2;
        System.out.println(total);

        //0 nel reduce è il valore iniziale che assegno alla somma
        //dalla map risulta uno stream -> posso applicare più map in "fila"
        //Ordine elementi nello stream NON è ordinato
        int total2 = values.stream().map(e -> e*2).reduce(0, (a, b) -> a + b);
        System.out.println(total2);
    } 
    
}