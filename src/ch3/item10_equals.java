package ch3;

import java.awt.Color;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class item10_equals {

    public static void main(String[] args) {
        Person p1 = new Person("sseop");
        Developer d = new Developer("sseop", "BE");
        System.out.println("p1.equals(d) : "+p1.equals(d));
        System.out.println("d.equals(p1) : "+d.equals(p1));

        Person p2 = new Person("sseop");
        Person p3 = new Person("son");

        System.out.println("\np1.equals(p2) : " + p1.equals(p2));
        System.out.println("p1.equals(p3) : " + p1.equals(p3));
        System.out.println("p2.equals(p3) : " + p2.equals(p3));
//        NotEqualsPerson p4 = new NotEqualsPerson("son");
//        NotEqualsPerson p5 = new NotEqualsPerson("son");
//        System.out.println("\np4.equals(p5) : "+p4.equals(p5)); // assertion error

        CaseInsensitiveString s1 = new CaseInsensitiveString("Hello");
        String s2 = "Hello";
        System.out.println("\ns1.equals(s2) : " + s1.equals(s2));
        System.out.println("s2.equals(s2) : " + s2.equals(s1));

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(s1);
        System.out.println("\nlist.contains(s1) : " + list.contains(s1));

        Point point = new Point(1, 2);
        ColorPoint colorPoint = new ColorPoint(1, 2, Color.RED);
        System.out.println("\npoint.equals(colorPoint) : " + point.equals(colorPoint));
        System.out.println("colorPoint.equals(point) : " + colorPoint.equals(point));
        System.out.println("point class      : " + point.getClass());
        System.out.println("colorPoint class : " + colorPoint.getClass());
        System.out.println("point class == colorPoint class : " + (point.getClass() == colorPoint.getClass()));


        ColorPoint colorPoint1 = new ColorPoint(1, 2, Color.BLUE);
        System.out.println("\npoint.equals(colorPoint) : " + point.equals(colorPoint));
        System.out.println("colorPoint.equals(colorPoint1) : " + colorPoint.equals(colorPoint1));
        System.out.println("colorPoint1.equals(point) : " + colorPoint1.equals(point));
    }
}

class Person {

    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Person) {
            return ((Person) o).name == name;
        }

        return false;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Person person = (Person) o;
//        return Objects.equals(name, person.name);
//    }
}

class Developer extends Person {

    String job;

    public Developer(String name, String job) {
        super(name);
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Developer)) {
            return super.equals(o);
        }

        Developer d = (Developer) o;
        return name == d.name && job == d.job;
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

class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
}

class ColorPoint extends Point {

    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }

        if (!(o instanceof ColorPoint)) {
            return o.equals(this);
        }

        return super.equals(o) && ((ColorPoint) o).color == color;
    }
}