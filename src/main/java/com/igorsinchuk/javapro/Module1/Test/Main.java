package com.igorsinchuk.javapro.Module1.Test;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class<?> cls = ClassA.class;
        try {
            Method method = cls.getMethod("method", int.class, int.class);
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation ma = method.getAnnotation(MyAnnotation.class);
                method.invoke(null, ma.a(), ma.b());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
