package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Example1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> numbers = Arrays.asList(3, 2, 4, 6, 7, 3, 5, 10);

        System.out.println("Print 10 random numbers using forEach");
        Random random = new Random(100);
        random.ints().limit(10).forEach(n -> {
            System.out.print(n + " ");
        });
        System.out.println();

        System.out.println("Print square distinct numbers using map");
        List<Integer> squareList = numbers.stream().map(num -> num * num).distinct().collect(Collectors.toList());
        squareList.forEach(num -> System.out.print(num + " "));
        System.out.println();

        System.out.println("Print even numbers using filter");
        numbers.stream().filter(num -> num % 2 == 0).forEach(num -> System.out.print(num + " "));
        System.out.println();

        System.out.println("Print numbers in ascending order using sorted");
        numbers.stream().sorted().forEach(num -> System.out.print(num + " "));
        System.out.println();

        System.out.println("Print sum of squares of distinct numbers using collect");
        int squareString = numbers.stream().map(num -> num * num).distinct().collect(Collectors.summingInt(num -> num.intValue()));
        System.out.println(squareString);
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

    }

}
