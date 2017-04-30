package Lambda_Expression;

import static Utility.Utility.*;
import java.io.*;
import java.util.*;
import java.util.function.Consumer;

public class demo_lambda_methodReference {

    public static void main(String[] args) {

        anonymous_file_filter();
        lambda_expression_file_filter();
        anonymous_runnable();
        lambda_runnable();
        anonymous_comparator();
        lambda_comparator();
        lambda_print();
        method_reference_print();
        lambda_add_print();
    }

    public static void method_reference_add_print() {
        show("Start method_reference_add_print method");

        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        List<String> result = new ArrayList<>();

        Consumer<String> consumerPrint = System.out::println;
        Consumer<String> consumerAdd = result::add;
        strings.forEach(consumerAdd.andThen(consumerPrint));

        show("Start method_reference_add_print method", "\n");
    }

    public static void lambda_add_print() {
        show("Start lambda_add_print method");

        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        List<String> result = new ArrayList<>();

        Consumer<String> consumerPrint = input -> System.out.println(input);
        Consumer<String> consumerAdd = input -> result.add(input);
        strings.forEach(consumerAdd);
        strings.forEach(consumerPrint);

        show("Start lambda_add_print method", "\n");
    }

    public static void method_reference_print() {
        show("Start method_reference_print method");

        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        Consumer<String> consumer = System.out::println;
        strings.forEach(consumer);

        show("Start method_reference_print method", "\n");
    }

    public static void lambda_print() {
        show("Start lambda_print method");

        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        Consumer<String> consumer = input -> System.out.println(input);
        strings.forEach(consumer);

        show("Start lambda_print method", "\n");
    }

    public static void lambda_comparator() {
        show("Start lambda_comparator method");

        Comparator<String> comparator = (String s1, String s2)
                -> Integer.compare(s1.length(), s2.length());

        Comparator<String> comparator2 = (s1, s2)
                -> Integer.compare(s1.length(), s2.length());

        List<String> list = Arrays.asList("***", "*", "*****", "**", "****");
        Collections.sort(list, comparator2);

        for (String s : list) {
            System.out.println(s);
        }

        show("end lambda_comparator method", "\n");
    }

    public static void anonymous_comparator() {
        show("Start anonymous_comparactor method");

        Comparator<String> comparator
                = (String s1, String s2)
                -> Integer.compare(s1.length(), s2.length());

        List<String> list = Arrays.asList("***", "*", "*****", "**", "****");
        Collections.sort(list, comparator);

        for (String s : list) {
            System.out.println(s);
        }

        show("end anonymous_comparactor method", "\n");
    }

    public static void lambda_runnable() {
        show("Start lambda_runnable method");
        Runnable runnable = () -> {
            for (int i = 0; i < 3; i++) {
                echo("Hello world from thread [" + Thread.currentThread().getName() + "]");
            }
        };

        Thread t = new Thread(runnable);
        t.start();
        try {
            t.join();
        } catch (InterruptedException ex) {
            echo("InterruptedException occurred in anonymous_runnable method");
        }

        show("end lambda_runnable method", "\n");
    }

    public static void anonymous_runnable() {
        show("Start anonymous_runnable method");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    echo("Hello world from thread [" + Thread.currentThread().getName() + "]");
                }
            }
        };

        Thread t = new Thread(runnable);
        t.start();
        try {
            t.join();
        } catch (InterruptedException ex) {
            echo("InterruptedException occurred in anonymous_runnable method");
        }

        show("End anonymous_runnable method", "\n");
    }

    public static void anonymous_file_filter() {
        show("Start anonymous_file_filter method");
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".java");
            }
        };

        File dir = new File("./src/main/java/files");
        File[] javaFiles = dir.listFiles(fileFilter);

        for (File f : javaFiles) {
            System.out.println(f);
        }
        show("End anonymous_file_filter method", "\n");
    }

    public static void lambda_expression_file_filter() {
        show("Start lambda_expression_file_filter method");
        FileFilter fileFilter = (File file) -> file.getName().endsWith(".java");
        File dir = new File("./src/main/java/files");
        File[] javaFiles = dir.listFiles(fileFilter);
        for (File f : javaFiles) {
            System.out.println(f);
        }
        show("end lambda_expression_file_filter method", "\n");
        newline();
    }

}
