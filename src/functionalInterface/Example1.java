package functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Example1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> predicate = n -> true
        // n is passed as parameter to test method of Predicate interface
        // test method will always return true no matter what value n has.
        System.out.println("Print all number");
        eval(list, n -> true);

        System.out.println("Print even numbers");
        eval(list, n -> n % 2 == 0);
    }

    private static void eval(List<Integer> nums, Predicate<Integer> p) {
        nums.forEach(num -> {
            if (p.test(num))
                System.out.print(num + " ");
        });
        System.out.println();
    }
}
