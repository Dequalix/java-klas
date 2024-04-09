package org.example.Labs.h12;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

public class AnnotationReflector {

    public static <T> void inspectClassAnnotations(Class<T> clazz) {
        // Check class-level annotations
        Annotation[] classAnnotations = clazz.getAnnotations();
        for (Annotation annotation : classAnnotations) {
            System.out.println("Klasse " + clazz.getSimpleName() + " is geannoteerd met: " + annotation);
        }

        // Check field-level annotations
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] fieldAnnotations = field.getAnnotations();
            for (Annotation annotation : fieldAnnotations) {
                System.out.println("Veld " + field.getName() + " is geannoteerd met: " + annotation);
            }
        }

        // Check method-level annotations
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] methodAnnotations = method.getAnnotations();
            for (Annotation annotation : methodAnnotations) {
                System.out.println("Methode " + method.getName() + " is geannoteerd met: " + annotation);
            }
        }
    }

}
