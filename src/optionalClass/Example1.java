package optionalClass;

import java.util.Optional;

public class Example1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Example1 exp = new Example1();
        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - allows passed parameter to be null.
        Optional<Integer> op1 = Optional.ofNullable(value1);

        // Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> op2 = Optional.of(value2);
        System.out.println(exp.sum(op1, op2));
    }

    private int sum(Optional<Integer> a, Optional<Integer> b) {
        // Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        // Optional.orElse - returns the value if present otherwise returns
        // the default value passed.
        Integer value1 = a.orElse(new Integer(10));

        // Optional.get - gets the value, value should be present
        Integer value2 = b.get();

        return value1 + value2;
    }

}
