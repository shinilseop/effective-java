package test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ImmutableObjectTest {

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        Student stu1 = new Student(100, 100, 100);
        students.add(stu1);
        System.out.println(stu1 + ", " + stu1.hashCode());
        stu1.renewScore();

        Student stu2 = new Student(100, 100, 100);
        System.out.println("stu1 : " + stu1 + ", " + stu1.hashCode());
        System.out.println("stu2 : " + stu2 + ", " + stu2.hashCode());

        System.out.println(students.contains(stu2));
    }
}

class Student {

    int kor;
    int math;
    int eng;

    public Student(int kor, int math, int eng) {
        this.kor = kor;
        this.math = math;
        this.eng = eng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return kor == student.kor && math == student.math && eng == student.eng;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kor, math, eng);
    }

    @Override
    public String toString() {
        return "Student{" +
            "kor=" + kor +
            ", math=" + math +
            ", eng=" + eng +
            '}';
    }

    public void renewScore() {
        kor = kor / 2;
        math = math / 2;
        eng = eng / 2;
    }
}
