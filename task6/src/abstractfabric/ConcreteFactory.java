package abstractfabric;

public class ConcreteFactory implements AbstractFactory {

    @Override
    public AbstractProduct createProductA() {
        return new ConcreteProduct("A");
    }

    @Override
    public AbstractProduct createProductB() {
        return new ConcreteProduct("B");
    }
}
