package com.ericaShy.java8.annotations.database;

public @interface Uniqueness {
    Constraints constraints() default @Constraints(unqie = true);
}
