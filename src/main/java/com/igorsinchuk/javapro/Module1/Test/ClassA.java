package com.igorsinchuk.javapro.Module1.Test;

public class ClassA {
    @MyAnnotation(a = 2, b = 1)
    public static void method(int a, int b) {
        System.out.println(a + ", " + b );
    }
}
