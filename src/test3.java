import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class test3 {
    public static void main(String[] args) {
        Predicate<Double> predicate = x -> x > 10.0;
        System.out.println(predicate.test(10.01));

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");

        for(String s : list) {
            System.out.println(s);
        }

        list.forEach(x -> System.out.println(x));

        int value1 = Stream.of(3, 10).min(Comparator.comparing(x -> x)).get();
        int value2 = Stream.of(3, 10).max(Comparator.comparing(x -> x)).get();

        System.out.println(value1);
        System.out.println(value2);

        new Thread(() -> System.out.println(1)).run();
    }
}
