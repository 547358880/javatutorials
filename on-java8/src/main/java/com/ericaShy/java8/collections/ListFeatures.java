package com.ericaShy.java8.collections;

import com.ericaShy.java8.typeinfo.pets.*;

import java.util.*;

public class ListFeatures {

    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Pet> pets = Pets.list(7);
        // 1: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug]
        System.out.println("1: " + pets);

        Hamster h = new Hamster();
        pets.add(h); // Automatically resizes
        System.out.println("2: " + pets);
        System.out.println("3: " + pets.contains(h));       // 3: true
        pets.remove(h);

        Pet p = pets.get(2);
        System.out.println("4: " + p + " " + pets.indexOf(p)); // 4: Cymric 2

        Pet cymric = new Cymric();
        System.out.println("5: " + pets.indexOf(cymric));  //5: -1
        System.out.println("6: " + pets.remove(cymric)); //6: false

        // Must be the excat object
        System.out.println("7: " + pets.remove(p)); // 7: true
        // 8: [Rat, Manx, Mutt, Pug, Cymric, Pug]
        System.out.println("8: " + pets);

        pets.add(3, new Mouse());
        //9: [Rat, Manx, Mutt, Mouse, Pug, Cymric, Pug]
        System.out.println("9: " + pets);
        List<Pet> sub = pets.subList(1, 4);
        System.out.println("subList: " + sub);   //subList: [Manx, Mutt, Mouse]
        System.out.println("10: " + pets.containsAll(sub)); // 10: true
        Collections.sort(sub);
        System.out.println("sorted subList: " + sub);   // sorted subList: [Manx, Mouse, Mutt]

        // Order is not important in containsAll
        System.out.println("11: " + pets.containsAll(sub)); // 11: true
        Collections.shuffle(sub, rand);  //Mix it up
        System.out.println("shuffled subList: " + sub); // shuffled subList: [Mouse, Manx, Mutt]  // 改了底层
        System.out.println("12: " + pets.containsAll(sub)); // 12: true

        List<Pet> copy = new ArrayList<>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        //[Rat, Mouse, Manx, Mutt, Pug, Cymric, Pug]
        System.out.println(pets);
        System.out.println("sub: " + sub); // sub: [Mouse, Pug]

        copy.retainAll(sub);
        System.out.println("13: " + copy);      // 13: [Mouse, Pug]
        copy = new ArrayList<>(pets);
        copy.remove(2);
        System.out.println("14: " + copy); // 14: [Rat, Mouse, Mutt, Pug, Cymric, Pug]

        copy.removeAll(sub);
        System.out.println("15: " + copy); //15: [Rat, Mutt, Cymric, Pug]

        copy.set(1, new Mouse());
        System.out.println("16: " + copy); //16: [Rat, Mouse, Cymric, Pug]
        copy.addAll(2, sub);
        System.out.println("17: " + copy);  //17: [Rat, Mouse, Mouse, Pug, Cymric, Pug]

        System.out.println("18: " + pets.isEmpty());    // 18: false
        pets.clear();
        System.out.println("19: " + pets);  // 19: []
        System.out.println("20: " + pets.isEmpty());    // 20: true
        pets.addAll(Pets.list(4));
        System.out.println("21: " + pets);  //21: [Manx, Cymric, Rat, EgyptianMau]

        Object[] o = pets.toArray();
        System.out.println("22: " + o[3]);      // 22: EgyptianMau
        Pet[] pa = pets.toArray(new Pet[0]);
        System.out.println("23: " + pa[3].id());    // 23: 14
    }

}
