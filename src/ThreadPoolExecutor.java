import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPoolExecutor {

    private BlockingQueue<Runnable> blockQueue;
    public List<ExecutorTask> threads = new ArrayList<ExecutorTask>();
    private boolean isStopped =  false;

    public ThreadPoolExecutor(int numberOfThreads, int maxSizeOfBlockQueue) {
        blockQueue = new LinkedBlockingQueue<Runnable>(maxSizeOfBlockQueue);
        for (int i = 0; i < numberOfThreads; ++i) {
            threads.add(new ExecutorTask(blockQueue));
        }
        int i = 0;
        for (ExecutorTask thread : threads) {
            System.out.println("Старт потока: " + threads.get(i).getIdThread());
            thread.start();
            i++;
        }
    }

    public synchronized void execute (Runnable task) throws Exception {
        if (isStopped) throw new IllegalStateException("ThreadPool has been stopped");
        blockQueue.add(task);
        System.out.println("сработал execute Для blockQueue. Размер очереди: " + blockQueue.size());
    }

    public synchronized void stop() {
        isStopped= true;
        for (ExecutorTask thread : threads) {
            thread.doStop();
        }
    }

}
