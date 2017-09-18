package com.igorsinchuk.javapro.Module1.TextConteiner;

import java.lang.annotation.*;

@Inherited
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@interface SaveTo {
    String path() default "/Users/igorsinchuk/documents/TextContainer.txt";
}