package stream_and_collectors;

import static Utility.Utility.show;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class demo_stream_collectors {

    public static void main(String[] args) {
        stream_print();
        stream_filter_print();
        stream_chain_print();
    }

    public static void stream_chain_print() {
        show("Start stream_chain_print method");

        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");

        stream
                .filter(p1.or(p2))
                // .forEach(s -> System.out.println(s);
                .forEach(System.out::println);

        show("Start stream_chain_print method", "\n");
    }

    public static void stream_filter_print() {
        show("Start stream_filter_print method");

        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

        Predicate<String> p1 = s -> s.length() > 3;

        stream
                .filter(p1)
                // .forEach(s -> System.out.println(s);
                .forEach(System.out::println);

        show("Start stream_filter_print method", "\n");
    }

    public static void stream_print() {
        show("Start stream_print method");

        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

        Predicate<String> p1 = s -> s.length() > 3;

        stream
                // .forEach(s -> System.out.println(s);
                .forEach(System.out::println);

        show("Start stream_print method", "\n");
    }

}
