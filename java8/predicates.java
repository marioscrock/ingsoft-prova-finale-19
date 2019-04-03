import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Sample {

    public static int totalValues(List<Integer> numbers){
        int total=0;
        for(int e: numbers){
            total+=e;
        }
        return total;
    }

    public static int totalEvenValues(List<Integer> numbers){
        int total=0;
        for(int e: numbers){
            if(e%2 == 0)
                total+=e;
        }
        return total;
    }

    public static int totalOddValues(List<Integer> numbers){
        int total=0;
        for(int e: numbers){
            if(e%2 != 0)
            total+=e;
        }
        return total;
    }

    public static int totalValues(List<Integer> numbers, Predicate<Integer> selector){
        return numbers.stream().filter(selector).reduce(0, (a,b) -> a + b);
    }

    public static void main(String[] args){
        List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(Sample.totalValues(values));
        System.out.println(Sample.totalEvenValues(values));
        System.out.println(Sample.totalOddValues(values));
        //DUPLICAZIONE codice!!
        //Pattern Strategy
        System.out.println(Sample.totalValues(values, e -> true));
        System.out.println(Sample.totalValues(values, e -> e%2 == 0));
        System.out.println(Sample.totalValues(values, e -> e%2 != 0));
    } 

}