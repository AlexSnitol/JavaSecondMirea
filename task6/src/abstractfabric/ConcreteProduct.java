package abstractfabric;

public class ConcreteProduct implements AbstractProduct {
    private String info = null;

    ConcreteProduct() {}
    ConcreteProduct(String info) {
        this.info = info;
    }
}
