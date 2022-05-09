package strategy;

public class ConcreteStrategyOne implements Strategy {
    @Override
    public void init() {
        System.out.println("StrategyOne");
    }
}
