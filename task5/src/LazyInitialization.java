public class LazyInitialization {
    private static LazyInitialization instance;

    private LazyInitialization() {}

    public static synchronized LazyInitialization getInstance() {
        if (instance == null) {
            instance = new LazyInitialization();
            return instance;
        }
        return instance;
    }
}
