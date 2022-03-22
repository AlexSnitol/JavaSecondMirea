import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import static java.lang.System.out;

public class Main {
    public static void main(String[] argv) throws InterruptedException {
        MyExecutorService myExecutorService = new MyExecutorService(2);
        Callable task1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "test_1";
            }
        };
        Callable task2 = new Callable<String>() {
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
