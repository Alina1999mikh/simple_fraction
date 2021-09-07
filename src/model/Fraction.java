package model;

import exeption.ConstructorException;

import java.util.Objects;

public abstract class Fraction {
    protected int a;
    protected int b;

    public Fraction(int a, int b) throws ConstructorException {
        checkDeterminate(b);
        this.a = a;
        this.b = b;
        doSign();
        simplify();
    }

    public void doSign() {
        if (b < 0) {
            a = a * (-1);
            b = b * (-1);
        }
    }

    private void checkDeterminate(int b) throws ConstructorException {
        if (b == 0) {
            throw new ConstructorException("Denominator cannot be 0");
        }
    }

    public Fraction(String f) throws ConstructorException {
        String[] fraction = f.split("/");
        if (fraction.length > 2) {
            System.out.println("ERROR");
        } else {
            this.a = Integer.parseInt(fraction[0]);
            this.b = Integer.parseInt(fraction[1]);
            checkDeterminate(b);
            doSign();
            simplify();
        }
    }

    private void simplify() {
        long limit = Math.min(this.a, this.b);

        for (long i = 2; i <= limit; i++) {
            if (this.a % i == 0 && this.b % i == 0) {
                this.a /= i;
                this.b /= i;
            }
        }
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public String getStringA() {
        return ((Integer) a).toString();
    }

    public String getStringFraction() {
        return a + "/" + b;
    }

    public String getStringB() {
        return ((Integer) b).toString();
    }

    public int[] getAB() {
        return new int[]{a, b};
    }

    public Fraction getFraction() {
        return this;
    }

    public void print() {
        System.out.println(a + " / " + b + "\n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return a == fraction.a && b == fraction.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public Fraction copy() {
        return this;
    }

    public boolean compare(Fraction f) {
        boolean flag;
        int a = this.a, a2 = f.a;
        int b = this.b, b2 = f.b;
        if (b == b2) {
            flag = a > a2;
        } else {
            flag = a * b2 > a2 * b;
        }
        return flag;
    }

    public abstract Fraction addition(Fraction f) throws ConstructorException;

    public abstract Fraction subtraction(Fraction f) throws ConstructorException;

    public abstract Fraction multiplication(Fraction f) throws ConstructorException;

    public abstract Fraction division(Fraction f) throws ConstructorException;

    public abstract Fraction square() throws ConstructorException;

    public abstract Fraction inverse() throws ConstructorException;

    public abstract Fraction minus() throws ConstructorException;
}
