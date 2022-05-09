package prototype;

public class Client {
    public Prototype copyClientPrototype1() {
        return new ConcretePrototype1();
    }

    public Prototype copyClientPrototype2() {
        return new ConcretePrototype2();
    }
}
