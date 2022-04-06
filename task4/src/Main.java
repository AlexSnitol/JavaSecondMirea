import impl.MyExecutorService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static java.lang.System.out;

public class Main {
    public static void main(String[] argv) throws InterruptedException {
        MyExecutorService myExecutorService = new MyExecutorService(2);

        Callable<String> task1 = new Callable<>() {
            @Override
            public String call() throws Exception {
                return "test_1";
            }
        };

        Callable<String> task2 = new Callable<>() {
            @Override
            public String call() throws Exception {
                return "test_2";
            }
        };

        Collection<Callable<String>> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        List<Future<String>> futures = myExecutorService.invokeAll(tasks);
        for(Future<String> future : futures) {
            out.println(future);
            try {
                out.println(future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
