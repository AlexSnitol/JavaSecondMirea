package strategy;

public class MyClass {
    public void method() {
        Strategy one = new ConcreteStrategyOne();
        one.init();
        one = new ConcreteStrategyTwo();
        one.init();
    }
}
