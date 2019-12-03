package com.ericaShy.java8.typeinfo.toys;

public class GenericToyTest {

    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class;
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        Object object = up.newInstance();
    }

}
