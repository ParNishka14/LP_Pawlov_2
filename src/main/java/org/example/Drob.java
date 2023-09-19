package org.example;

import java.util.Date;

/**
 * класс Drob
 * @author Kutuzov Andrey
 * @version 1.0
 * @since 1.0
 */

abstract public class Drob {
    /**
     * m - поле для хранения числителя
     */
    private int m;
    /**
     * n -  поле для хранения знаменателя
     */
    private int n;

    /**
     * конструктор дроби
     * @param m  числитель
     * @param n  знаменатель
     * @throws IllegalArgumentException знаменатель не может быть 0
     */
    public Drob(int m, int n) {
        if (n == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть 0!!");
        }
        this.m = m;
        this.n = n;
        simplify();
    }


    /**
     * создаёт целое число дробью
     * @param wholeNumber  целое число
     */
    public Drob(int wholeNumber) {
        this.m = wholeNumber;
        this.n = 1;
    }

    /**
     *
     * @return возвращает переменную m
     */
    public int getM() {
        return m;
    }
    /**
     *
     * @return возвращает переменную n
     */
    public int getN() {
        return n;
    }

    /**
     * метод сложения дробей
     * @param other другая дробь
     * @return возвращает реультат сложения дробей в виде новой дроби
     */
    public Drob add(Drob other) {
        int newNumerator = this.m * other.n + other.m * this.n;
        int newDenominator = this.n * other.n;
        return new Drob2(newDenominator, newNumerator);
    }

    /**
     * метод вычитания дробей
     * @param other другая дробь
     * @return возвращает реультат вычитания дробей в виде новой дроби
     */
    public Drob subtract(Drob other) {
        int newNumerator = this.m * other.n - other.m * this.n;
        int newDenominator = this.n * other.n;
        return new Drob2(newDenominator, newNumerator);
    }

    /**
     * метод умножения дробей
     * @param other другая дробь
     * @return возвращает реультат умножения дробей в виде новой дроби
     */
    public Drob multiply(Drob other) {
        int newNumerator = this.m * other.m;
        int newDenominator = this.n * other.n;
        return new Drob2(newDenominator, newNumerator);
    }

    /**
     * метод деления дробей
     * @param other другая дробь
     * @return возвращает реультат деления дробей в виде новой дроби
     */
    public Drob divide(Drob other) {
        if (other.m == 0) {
            throw new IllegalArgumentException("Нельзя делить на 0");
        }
        int newNumerator = this.m * other.n;
        int newDenominator = this.n * other.m;
        return new Drob2(newDenominator, newNumerator);
    }

    /**
     * метод упрощения дроби
     */
    private void simplify() {
        int gcd = greatestCommonDivisor(Math.abs(m), Math.abs(n));
        m /= gcd;
        n /= gcd;
    }

    /**
     * вычисление наименьшего общего делителя
     * @param a - параметр числителя
     * @param b - параметр знаменателя
     * @return возвращает нод
     */
    private int greatestCommonDivisor(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * преобразование дроби в строку
     * @return возвращает дробь в виде строки
     */
    @Override
    public String toString() {
        if (n == 1) {
            return Integer.toString(m);
        }
        return m + "/" + n;
    }
}
