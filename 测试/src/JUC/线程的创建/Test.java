package JUC.线程的创建;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
class CallerTask implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "hello";
    }
}