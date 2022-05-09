public class Main {
    public static void main(String[] args) {
        LazyInitialization obj1;
        LazyInitialization obj4;
        EagerInitialization obj2;
        EagerInitialization obj5;
        Enum obj3;
        Enum obj6;
        
        obj1 = LazyInitialization.getInstance();
        obj2 = EagerInitialization.getInstance();
        obj3 = Enum.getInstance();

        obj4 = LazyInitialization.getInstance();
        obj5 = EagerInitialization.getInstance();
        obj6 = Enum.getInstance();
    }
}
