package org.example.Labs.h12;

import org.example.Labs.h11.models.Person;

import java.lang.reflect.Method;

@MyAnnotation
public class H12 {
    @MyAnnotation
    public int getal = 42;
    @MyAnnotation
    public String peter;
    public static void main(String[] args) {
        checkAnnotations();

        AnnotationReflector.inspectClassAnnotations(H12.class);
        AnnotationReflector.inspectClassAnnotations(Person.class);

    }

    public static void checkAnnotations() {
        MyAnnotation annotation = H12.class.getAnnotation(MyAnnotation.class);

        if (H12.class.isAnnotationPresent(MyAnnotation.class)) {
            System.out.println("Klasse waarde: " +  annotation.value());
        }
        for (Method m : H12.class.getDeclaredMethods()) {
            MyAnnotation2 annotation2 = m.getAnnotation(MyAnnotation2.class);
            if (m.isAnnotationPresent(MyAnnotation.class)) {
                System.out.println("Methode waarde: " + annotation.value());
            } else if (m.isAnnotationPresent(MyAnnotation2.class)) {
                System.out.println("Methode waarde: " + annotation2.value());
            }
        }
    }

    @MyAnnotation
    public void myAnnotation() {

    }

    @MyAnnotation2
    public void myAnnotation2() {

    }
}
