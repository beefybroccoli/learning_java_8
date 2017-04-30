package stream_and_collectors;

import static Utility.Utility.echo;
import static Utility.Utility.show;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class demo_stream_collectors {

    public static void main(String[] args) {
        stream_print();
        stream_filter_print();
        stream_chain_print();
        stream_intermediary_operation();    //return nothing
        stream_final_operation();
    }

    public static void stream_final_operation() {
        show("Start stream_final_operation method");

        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
        List<String> list = new ArrayList<>();

        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");

        stream
                // .forEach(s -> System.out.println(s)
                .peek(System.out::println)
                .filter(p1.or(p2))
                .forEach(list::add);
        echo("size of list is " + list.size());

        show("Start stream_final_operation method", "\n");
    }

    public static void stream_intermediary_operation() {
        show("Start stream_intermediary_operation method");

        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
        List<String> list = new ArrayList<>();

        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");

        stream
                // .forEach(s -> System.out.println(s)
                .peek(System.out::println)
                .filter(p1.or(p2))
                .peek(list::add);
        
        echo("since the intermediary does nothing, nothing happened");
        echo("size of list is " + list.size());

        show("Start stream_intermediary_operation method", "\n");
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
