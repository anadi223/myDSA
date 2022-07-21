import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> arr =  new ArrayList<>();
        arr.add(10);
        arr.add(21);
        arr.add(23);
        arr.add(24);
        //Filter example
        // Stream s  = arr.stream().filter(i -> i%2 == 0);
        // s.forEach(x -> System.out.println(x));
        //1 liner filter
        arr.stream().filter(i -> i%2 == 0).forEach(x ->System.out.println(x));

        //MAP
        Stream<Object> s = arr.stream().map(i -> i*i);
        s.forEach(x ->System.out.println(x));

    }
}
