package ch3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
    }
}
