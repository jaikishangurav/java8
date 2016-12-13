package lambdaExpression;

interface MathOperation {
    int operation(int a, int b);
}

interface Greeting {
    void greet(String greeting);
}

public class Example1 {

    public static void main(String[] args) {
        Example1 exp = new Example1();
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> a / b;
        System.out.println("10+5=" + exp.tester(10, 5, addition));
        System.out.println("10-5=" + exp.tester(10, 5, subtraction));
        System.out.println("10*5=" + exp.tester(10, 5, multiplication));
        System.out.println("10/5=" + exp.tester(10, 5, division));

        Greeting greeting = message -> System.out.println(message);
        greeting.greet("Hello World");
    }

    private int tester(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

}
