package methodReference;

public class Person {

    String name;

    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static int compareByAge(Person a, Person b) {
        return a.getAge() == b.getAge() ? 0 : a.getAge() < b.getAge() ? -1 : 1;
    }

    public String toString() {
        return "Name:" + name + "|| Age:" + age;
    }
}
