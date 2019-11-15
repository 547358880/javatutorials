package com.ericaShy.java8.collections;

import java.util.*;

/**
 * 集合的打印(注意输出的顺序)
 */
public class PrintingCollections {

    static Collection fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }

    public static void main(String[] args) {
        //[rat, cat, dog, dog]
        System.out.println(fill(new ArrayList<>()));
        //[rat, cat, dog, dog]
        System.out.println(fill(new LinkedList<>()));
        //[rat, cat, dog]
        System.out.println(fill(new HashSet<>()));      // 无序的
        // [cat, dog, rat]
        System.out.println(fill(new TreeSet<>()));
        // [rat, cat, dog]
        System.out.println(fill(new LinkedHashSet<>()));
        // {rat=Fuzzy, cat=Rags, dog=Spot}
        System.out.println(fill(new HashMap<>()));  // 无序的
        // {cat=Rags, dog=Spot, rat=Fuzzy}
        System.out.println(fill(new TreeMap<>()));
        // {rat=Fuzzy, cat=Rags, dog=Spot}
        System.out.println(fill(new LinkedHashMap<>()));
    }
}
