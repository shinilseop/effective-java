package ch3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class item14_compareTo {

    public static void main(String[] args) {
        Set<BigDecimal> hashSet = new HashSet<>(); // same instance ? use equals
        Set<BigDecimal> treeSet = new TreeSet<>(); // same instance ? use compare

        hashSet.add(new BigDecimal("1.0"));
        hashSet.add(new BigDecimal("1.00"));
        treeSet.add(new BigDecimal("1.0"));
        treeSet.add(new BigDecimal("1.00"));

        System.out.println("hashSet size : "+hashSet.size()); // 2
        System.out.println("treeSet size : "+treeSet.size()); // 1
    }
}
