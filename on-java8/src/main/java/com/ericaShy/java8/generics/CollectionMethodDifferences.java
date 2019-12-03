package com.ericaShy.java8.generics;

import com.ericaShy.java8.onjava.Sets;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Collection和Map类之间的方法差异
 */
public class CollectionMethodDifferences {

    static Set<String> methodSet(Class<?> type) {
        return Arrays.stream(type.getMethods())
                .map(Method::getName)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    static void interfaces(Class<?> type) {
        System.out.print("Interfaces in " + type.getSimpleName() + ": ");
        System.out.println(
            Arrays.stream(type.getInterfaces())
                .map(Class::getSimpleName)
                .collect(Collectors.toList())
        );
    }

    static void difference(Class<?> superset, Class<?> subset) {
        System.out.print(superset.getSimpleName() + " extends " + subset.getSimpleName() + ", adds: ");
        Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
        comp.removeAll(object);
        System.out.println(comp);
        interfaces(superset);
    }

    static Set<String> object = methodSet(Object.class);

    static {
        object.add("clone");
    }

    public static void main(String[] args) {
        System.out.println("Collection: " + methodSet(Collection.class));
        interfaces(Collection.class);
        difference(Set.class, Collection.class);
        difference(List.class, Collection.class);
    }

}
