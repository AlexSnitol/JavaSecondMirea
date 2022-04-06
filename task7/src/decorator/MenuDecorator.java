package decorator;

public class MenuDecorator implements MenuItem {
    private MenuItem menuItem;
    private float price;

    public MenuDecorator(MenuItem menuItem, float price) {
        this.menuItem = menuItem;
        this.price = price;
    }

    @Override
    public float getPrice() {
        return this.price + menuItem.getPrice();
    }
}
