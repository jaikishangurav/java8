package methodReference;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class Example2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Person[] persons = new Person[] { new Person("ABC", 20), new Person("QWE", 18), new Person("JKL", 32), new Person("SDF", 28),
                new Person("MNB", 24) };

        System.out.println("***Reference to a static method***");
        // Reference to a static method
        Arrays.sort(persons, Person::compareByAge);
        display(persons);
        // Equivalent lambda expression
        Arrays.sort(persons, (person1, person2) -> Person.compareByAge(person1, person2));
        display(persons);

        System.out.println();

        System.out.println("***Reference to an Instance Method of a Particular Object***");
        ComparisonProvider myComparisonProvider = new ComparisonProvider();
        // Reference to an Instance Method of a Particular Object
        Arrays.sort(persons, myComparisonProvider::compareByName);
        display(persons);
        // Equivalent lambda expression
        Arrays.sort(persons, (person1, person2) -> myComparisonProvider.compareByName(person1, person2));

        System.out.println();

        System.out.println("***Reference to an Instance Method of an Arbitrary Object of a Particular Type***");
        String[] strings = new String[] { "Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda" };
        // Reference to an Instance Method of an Arbitrary Object of a Particular Type
        Arrays.sort(strings, String::compareToIgnoreCase);
        display(strings);
        Arrays.sort(strings, (a, b) -> a.compareToIgnoreCase(b));// Equivalent lambda expression

        System.out.println();

        System.out.println("***Reference to a Constructor***");
        // Reference to a Constructor
        Set<String> stringSet = transferElements(Arrays.asList(strings), HashSet::new);
        stringSet.forEach(s -> System.out.print(s + " "));
        System.out.println();
        // Equivalent lambda expression
        Set<String> stringSet1 = transferElements(Arrays.asList(strings), () -> new HashSet<>());
        stringSet.forEach(s -> System.out.print(s + " "));

    }

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(SOURCE sourceCollection,
            Supplier<DEST> collectionFactory) {
        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }

    public static <T> void display(T[] t) {
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i]);
            if (i != t.length - 1)
                System.out.print(", ");
        }
        System.out.println();
    }

}

class ComparisonProvider {
    public int compareByName(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }

    public int compareByAge(Person a, Person b) {
        return a.getAge() == b.getAge() ? 0 : a.getAge() < b.getAge() ? -1 : 1;
    }
}
