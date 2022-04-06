public class Main {
    public static void main(String[] args) {
        LazyInitialization obj1;
        EagerInitialization obj2;
        Enum obj3;
        
        obj1 = LazyInitialization.getInstance();
        obj2 = EagerInitialization.getInstance();
        obj3 = Enum.getInstance();
    }
}
