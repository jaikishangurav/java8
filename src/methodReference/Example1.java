package methodReference;

import java.util.ArrayList;
import java.util.List;

public class Example1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> names = new ArrayList<>();
        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");
        names.forEach(System.out::println); // System.out::println method is passed as a static
                                            // method reference

    }

}
