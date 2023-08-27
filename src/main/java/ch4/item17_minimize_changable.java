package ch4;

import java.math.BigInteger;

public class item17_minimize_changable {
    public static void main(String[] args) {
        BigInteger bi = new BigInteger("1000");
        BigInteger bi2 = bi.add(new BigInteger("0"));
        BigInteger bi3 = bi.add(new BigInteger("1000"));

        System.out.println(bi.equals(bi2));
        System.out.println(bi.equals(bi3));
    }
}
