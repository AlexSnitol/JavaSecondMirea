package decorator;

public class Main {
    public static void main(String[] args) {
        MenuItem mashedPotatoes = new StandartGarnish();
        MenuItem bear = new Bear(mashedPotatoes);
        MenuItem chicken = new Chicken(bear);

        float sumPrice = chicken.getPrice();
    }
}
