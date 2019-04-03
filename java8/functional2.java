import java.util.Arrays;
import java.util.List;
public class Sample {

    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int result = 0;

        //prende il primo numero pari >3 e restituisce il doppio
        //BUG: se non ho numero pari >3?
        for(int e:values){
            if(e>3 && e%2==0){
                result = e*2;
                break; 
            }
        }

        System.out.println(result);
        values.stream().
            filter(e -> e>3).
            filter(e -> e%2==0).
            map(e -> e*2).
            findFirst().
            orElse(0); //se filter non restituisce risultati

        //Due soluzioni usano lo stesso numero di operazioni
        //per testare usiamo 3 metodi statici
        for(int e:values){
            if(isGT3(e) && isEven(e)){
                result = doubleIt(e);
                break;
            } 
        }

        //Se elimino il findFirst non viene valutato NULLA (lazy evaluation)
        values.stream().
            filter(Sample :: isGT3).
            filter(Sample :: isEven).
            map(Sample :: doubleIt).
            findFirst().
            orElse(0);
    }

    public static boolean isEven(int number){
        System.out.println("is even for "+ number);
        return number%2 == 0;
    }

    public static boolean isGT3(int number){
        System.out.println("is GT3 "+ number);
        return number > 3;
    }

    public static int doubleIt(int number){
        System.out.println("double it for"+ number);
        return number*2;
    } 
}