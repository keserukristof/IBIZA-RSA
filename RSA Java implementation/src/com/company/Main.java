package com.company;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger p, q, n, fin, e, d, m;

        System.out.println("Adj meg egy nagy prím számot!");
        p = sc.nextBigInteger(); //p prím

        System.out.println("Adj meg mégegy nagy prím számot!");
        q = sc.nextBigInteger(); //q prím

        n = p.multiply(q); // n = p * q

        fin = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)); // f(n) = (p - 1) * (q - 1)

        e = BigInteger.valueOf(3);
        while (!fin.gcd(e).equals(BigInteger.ONE)) {
            e = e.add(BigInteger.valueOf(2));
        }
        
        d = getTheD(e, fin);

        System.out.println("Add meg az üzenetet amit titkosítani szeretnél!");
        m = sc.nextBigInteger(); // m

        System.out.println("Az első megadott prím szám: " + p);
        System.out.println("A második megadott prím szám: " + q);
        System.out.println("Az n értéke: " + n);
        System.out.println("A fi(n) értéke: " + fin);
        System.out.println("Nyílvános kulcs: " + e);
        System.out.println("Privát kulcs: " + d);

        System.out.println("Az üzenet: " + m);
        m = m.modPow(e, n);
        System.out.println("Kodolt üzente: " + m);
        m = m.modPow(d, n);
        System.out.println("Dekódolt üzenet: " + m);
    }

    public static BigInteger getTheD(BigInteger e, BigInteger fin) {
        BigInteger d;
        d = e.modInverse(fin); //e^(-1)(mod(fi(n))
        return d;
    }
}