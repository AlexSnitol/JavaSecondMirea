package impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class MyExecutorService implements ExecutorService {

    private int nThreads;
    List<Thread> listThreads;

    public MyExecutorService (int nThreads) {
        this.nThreads = nThreads;

        this.listThreads = new ArrayList<>(nThreads);
        for (int i = 0; i < this.nThreads; i++) {
            this.listThreads.add(new Thread());
        }
    }

    @Override
    public void shutdown() {

    }

    @Override
    public List<Runnable> shutdownNow() {
        return null;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public boolean isTerminated() {
        return false;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return null;
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return null;
    }

    @Override
    public Future<?> submit(Runnable task) {

        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        List<Future<T>> results = new ArrayList<>();
        boolean started = false;

        for (Callable<T> task : tasks) {
            try {
                FutureTask<T> future = new FutureTask<>(task);
                results.add(future);

                Thread thread;

                started = false;
                while (!started) {
                    for (int i = 0; i < this.nThreads; i++) {
                        thread = this.listThreads.get(i);
                        if (thread.getState() == Thread.State.RUNNABLE) {
                            continue;
                        } else {
                            thread = new Thread(future);
                            this.listThreads.set(i, thread);
                            thread.start();
                            started = true;

                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        boolean allCompleted = false;
        while (!allCompleted) {
            allCompleted = true;
            for (Future<T> future : results) {
                if (!future.isDone()) {
                    allCompleted = false;
                    break;
                }
            }
        }

        return results;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override
    public void execute(Runnable command) {

    }
}
