package ch3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class item14_compareTo {

    public static void main(String[] args) {
        Set<BigDecimal> hashSet = new HashSet<>(); // same instance ? use equals, because not sorted.
        Set<BigDecimal> treeSet = new TreeSet<>(); // same instance ? use compare, because it's sorted.

        BigDecimal bd1 = new BigDecimal("1.0");
        BigDecimal bd2 = new BigDecimal("1.00");

        System.out.println("bd1.compareTo(bd2) : " + bd1.compareTo(bd2)); // 0
        System.out.println("bd1.equals(bd2)    : " + bd1.equals(bd2)); // false

        hashSet.add(bd1);
        hashSet.add(bd2);
        treeSet.add(bd1);
        treeSet.add(bd2);

        System.out.println("hashSet size : " + hashSet.size()); // 2
        System.out.println("treeSet size : " + treeSet.size()); // 1

        Student s1 = new Student(100,100,90, "영희");
        Student s2 = new Student(100,90,90, "민수");
        System.out.println(s1);
        System.out.println(s2);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        System.out.println("un sorting : "+students);

        Collections.sort(students);
        System.out.println("   sorting : "+students);
    }
}

class Student implements Comparable<Student> {
    int kor, eng, math;
    String name;
    double avg;

    public Student(int kor, int eng, int math, String name) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.name = name;

        this.avg = (double) (kor + eng + math) / 3.0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                ", name='" + name + '\'' +
                ", avg=" + avg +
                '}';
    }

    @Override
    public int compareTo(Student o) {
//        return this.avg < o.avg ? -1 : this.avg == o.avg ? 0 : 1; // not recommanded
        return Double.compare(this.avg, o.avg);
    }
}
