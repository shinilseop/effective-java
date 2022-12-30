package ch1;

import java.time.Duration;
import java.time.LocalTime;
import java.util.regex.Pattern;

public class item6_avoid_useless_instance {

    public static void main(String[] args) {
        final int LOOP = Integer.MAX_VALUE;

        System.out.println("String instance compare");
        String s = "123";
        LocalTime start = LocalTime.now();
        for (int i = 0; i < LOOP; i++) {
            s = "123";
        }
        LocalTime end = LocalTime.now();
        Duration diff = Duration.between(start, end);
        System.out.printf("immutable nano : %d\n", diff.toNanos());

        start = LocalTime.now();
        for (int i = 0; i < LOOP; i++) {
            s = new String("123");
        }
        end = LocalTime.now();
        diff = Duration.between(start, end);
        System.out.printf("mutable nano   : %d", diff.toNanos());

        System.out.println("\n\nString Pattern match compare");
        start = LocalTime.now();
        for (int i = 0; i < LOOP/10000; i++) {
            isRomanNumeralCached("II");
        }
        end = LocalTime.now();
        diff = Duration.between(start, end);
        System.out.printf("pattern cached nano : %d\n", diff.toNanos());

        start = LocalTime.now();
        for (int i = 0; i < LOOP/10000; i++) {
            isRomanNumeralNotCached("II");
        }
        end = LocalTime.now();
        diff = Duration.between(start, end);
        System.out.printf("not cached nano     : %d", diff.toNanos());

        System.out.println("\n\nAuto Boxing Test");
        Long sum = 0L;
        start = LocalTime.now();
        for (long i = 0; i <= LOOP; i++) {
            sum+=i;
        }
        end = LocalTime.now();
        diff = Duration.between(start, end);
        System.out.printf("auto boxing nano     : %d\n", diff.toNanos());

        long sum2 = 0L;
        start = LocalTime.now();
        for (long i = 0; i <= LOOP; i++) {
            sum2+=i;
        }
        end = LocalTime.now();
        diff = Duration.between(start, end);
        System.out.printf("un auto boxing nano  : %d", diff.toNanos());
    }

    private static final Pattern ROMAN = Pattern.compile(
        "^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralCached(String s) {
        return ROMAN.matcher(s).matches();
    }

    static boolean isRomanNumeralNotCached(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }
}
