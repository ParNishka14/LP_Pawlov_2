package org.example;

public class Drob2 extends Drob {

    public Drob2(int m, int n) {
        super(m, n);
    }

    public static String wholePart(int a, int b){
        int part = a/b;
        int ostatok = a%b;
        return part + " " + ostatok + "/" + b;
    }
}
