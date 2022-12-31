package ch3;

public class item10_equals {

    public static void main(String[] args) {
        Person p1 = new Person("sseop");
        Person p2 = new Person("sseop");
        Person p3 = new Person("son");

        System.out.println("p1 == p2 : "+p1.equals(p2));
        System.out.println("p1 == p3 : "+p1.equals(p3));
        System.out.println("p2 == p3 : "+p2.equals(p3));
    }
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            return p.name == name;
        }

        return false;
    }
}
