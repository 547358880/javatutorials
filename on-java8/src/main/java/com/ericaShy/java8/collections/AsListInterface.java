package com.ericaShy.java8.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow {}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}
class Crusty extends Snow {}
class Slush extends Snow {}

public class AsListInterface {

    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());
        // - snow1.add(new Heavy());  java.lang.UnsupportedOperationException底层代码不支持

        List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());

        List<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3, new Light(), new Heavy(), new Powder());
        snow3.add(new Crusty());

        // 显示参数类型说明(explicit type argument specification)
        List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy(), new Slush());
        // -snow4.add(new Powder());  // Exception
    }
}
