package ch3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class item10_equals {

    public static void main(String[] args) {
        Person p1 = new Person("sseop");
        Person p2 = new Person("sseop");
        Person p3 = new Person("son");

        System.out.println("p1.equals(p2) : "+p1.equals(p2));
        System.out.println("p1.equals(p3) : "+p1.equals(p3));
        System.out.println("p2.equals(p3) : "+p2.equals(p3));
//        NotEqualsPerson p4 = new NotEqualsPerson("son");
//        NotEqualsPerson p5 = new NotEqualsPerson("son");
//        System.out.println("\np4.equals(p5) : "+p4.equals(p5)); // assertion error

        CaseInsensitiveString s1 = new CaseInsensitiveString("Hello");
        String s2 = "Hello";
        System.out.println("\ns1.equals(s2) : "+s1.equals(s2));
        System.out.println("s2.equals(s2) : "+s2.equals(s1));

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(s1);
        System.out.println("list.contains(s1) : "+list.contains(s1));
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
            return ((Person) o).name == name;
        }

        return false;
    }
}

class NotEqualsPerson {

    String name;

    public NotEqualsPerson(String name) {
        this.name = name;
    }
}

class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }
        if (o instanceof String) {
            return s.equalsIgnoreCase((String) o);
        }
        return false;
    }
}