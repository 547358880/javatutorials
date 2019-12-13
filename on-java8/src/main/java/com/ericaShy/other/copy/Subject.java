package com.ericaShy.other.copy;

/**
 * 深拷贝， 浅拷贝
 */
public class Subject {

    private String name;

    public Subject(String s) {
        name = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
