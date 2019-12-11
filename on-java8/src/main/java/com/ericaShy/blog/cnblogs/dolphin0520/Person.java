package com.ericaShy.blog.cnblogs.dolphin0520;

import java.util.HashSet;
import java.util.Set;

public class Person {
    private int age;
    private String identityCardID;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentityCardID() {
        return identityCardID;
    }

    public void setIdentityCardID(String identityCardID) {
        this.identityCardID = identityCardID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        Person personObj = (Person) obj;
        return this.age == personObj.getAge() && this.identityCardID.equals(personObj.getIdentityCardID());
    }

    @Override
    public int hashCode() {
        return age * 37 + identityCardID.hashCode();
    }

    public static void main(String[] args) {
        Person jack = new Person();
        jack.setAge(10);
        jack.setIdentityCardID("42118220090315234X");

        Set<Person> personSet = new HashSet<>();
        personSet.add(jack);

        jack.setAge(11);

        System.out.println(personSet.contains(jack)); //false
    }
}
