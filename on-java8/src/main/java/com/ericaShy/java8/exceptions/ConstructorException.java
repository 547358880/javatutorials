package com.ericaShy.java8.exceptions;

class CE extends Exception {}

class SecondExcept extends Reporter {
    SecondExcept() throws CE {
        super();
        throw new CE();
    }
}

/**
 * 请注意，不会为 SecondExcept 调用 close()，因为如果构造函数失败，则无法假设你可以安全地对该对象执行任何操作，包括关闭它
 */
public class ConstructorException {
    /**
     * 输出
     * Creating First
     * Creating SecondExcept
     * Closing First
     * Caught: com.ericaShy.java8.exceptions.CE
     */
    public static void main(String[] args) {
        try (
            First f = new First();
            SecondExcept s = new SecondExcept();
            Second s2 = new Second()
        ) {
            System.out.println("In body");
        } catch (CE e) {
            System.out.println("Caught: " + e);
        }
    }
}
