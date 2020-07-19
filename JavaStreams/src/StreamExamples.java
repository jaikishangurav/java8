import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
        //Make a list of source elements along with indices
        List<String> list = List.of("Good", "old", "Stream", "API");
        IndexedValue.withIndices(list).forEach(System.out::println);

        //Zip two lists together
        List<String> javaVersions = List.of("JDK 1.0","J2SE 1.2","J2SE 5.0","Java SE 8","Java SE 11","Java SE 14");
        List<Integer> release = List.of(1996,1998,2004,2014,2018,2020);

        StreamOperations.zip(javaVersions, release, Pair::new)
                .map(pair -> pair.java + " was released in " + pair.release)
                .forEach(System.out::println);

        //Leave only those values that repeat at least N times
        List<String> langs = List.of("Java", "Scala", "Kotlin", "Kotlin", "Groovy", "Java", "Scala", "Clojure", "Scala", "Kotlin", "Groovy", "Scala", "Groovy" );

        langs.stream().filter(StreamOperations.distinct(3)).forEach(System.out::println);

        //using flatmap operation
        List<String> listOfNumbers = Arrays.asList("5.6", "7.4", "4",
                "1", "2.3");

        // Using Stream flatMap(Function mapper)
        listOfNumbers.stream().flatMap(num -> Stream.of(num)).
                forEach(System.out::println);

        //Filter even numbers and sort the numbers and print
        List<Integer> integerList = List.of(45,34,56,38,67,58,45,77);
        integerList.stream().filter(s->s%2==0).sorted().forEach(System.out::println);

    }
}

class Pair{
    String java;
    int release;

    public Pair(String java, int release){
        this.java = java;
        this.release = release;
    }
}