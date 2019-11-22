package com.ericaShy.java8.exceptions;

/**
 * Overridden methods can throw only the exceptions specified in
 * their base-class versions, or exceptions derived from the base-class exceptions
 */
class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}

abstract class Inning {
    Inning() throws BaseballException {}

    public void event() throws BaseballException {}

    public abstract void atBat() throws Strike, Foul;
    public void walk() {}
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}
interface Storm {
    void event() throws RainedOut;
    void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {
    public StormyInning() throws RainedOut, BaseballException{}

    public StormyInning(String s) throws BaseballException {}

    // Regular(常规) methods must conform to base class
    //@Override
    // public void walk() throws PopFoul {}  //Compile error

    // Interface cannot add exceptions to existing methods from the base class
//    @Override
//    public void event() throws RainedOut {}       // Compile error

    @Override
    public void rainHard() throws RainedOut {}

    // you can choose to not throw any exceptions, even if the base version does:
    @Override
    public void event() {}

    // Override methods can throw inherited(继承) exceptions
    @Override
    public void atBat() throws PopFoul {}

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}
