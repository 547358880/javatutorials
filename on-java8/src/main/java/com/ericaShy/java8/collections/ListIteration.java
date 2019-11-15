package com.ericaShy.java8.collections;

import com.ericaShy.java8.typeinfo.pets.Pet;
import com.ericaShy.java8.typeinfo.pets.Pets;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.List;
import java.util.ListIterator;

public class ListIteration {

    public static void main(String[] args) {
        List<Pet> pets = Pets.list(8);
        System.out.println(pets);
        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + ";");
        }
        System.out.println();

        while (it.hasPrevious()) {
            System.out.print(it.previous() + ", " + it.nextIndex() + ", " + it.previousIndex() + ";");
        }

        System.out.println();
        it = pets.listIterator(3);
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p + ", ");
            it.set(Pets.get());
        }
        System.out.println();
        System.out.println(pets);
    }
}
