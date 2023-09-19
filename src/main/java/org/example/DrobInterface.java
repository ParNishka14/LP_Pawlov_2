package org.example;

public interface DrobInterface {
    static Drob createDrob(int a, int b){
        return new Drob2(a,b);
    }
}
