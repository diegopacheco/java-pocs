package com.github.diegopacheco.javapocs.effectivejava3.immutable;

import java.util.Objects;

public final class Complex {

    private final double real;
    private final double imaginary;

    public Complex(double real,double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }
    public double getImaginary() {
        return imaginary;
    }

    public Complex plus(Complex c){
        return new Complex(real + c.real,imaginary + c.imaginary);
    }

    public Complex minus(Complex c){
        return new Complex(real - c.real,imaginary - c.imaginary);
    }

    public Complex times(Complex c){
        return new Complex(real * c.real - imaginary * c.imaginary,
                      real * c.imaginary + imaginary * c.real
                          );
    }

    public Complex divideBy(Complex c){
        double tmp = c.real * c.real + c.imaginary * c.imaginary;
        return new Complex((real * c.real + imaginary * c.imaginary) / tmp,
                (real * c.imaginary - imaginary * c.real) / tmp
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.getReal(), getReal()) == 0 &&
                Double.compare(complex.getImaginary(), getImaginary()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReal(), getImaginary());
    }

    @Override
    public String toString() {
        return "Complex{" +
                "real=" + real +
                ", imaginary=" + imaginary +
                '}';
    }
}
