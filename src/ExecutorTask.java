import java.util.concurrent.BlockingQueue;

public class ExecutorTask extends Thread {

    private boolean isStopped = false;
    private BlockingQueue<Runnable> blockQueue;
    private static int nextId = 0;
    private int id;

    public ExecutorTask(BlockingQueue blockQueue) {
        this.blockQueue = blockQueue;
        id = nextId++;
        System.out.println("Конструктур ExecutorTask");

    }

    public ExecutorTask() {
        blockQueue = null;
    }

    @Override
    public void run() {
        while (!isStopped) {
            System.out.println("RUN");
            Runnable task;
            synchronized (blockQueue) {
                while (blockQueue.isEmpty()) {
//                    try {
//                        System.out.println(this.getIdThread() + " WAIT");
//                        blockQueue.wait();
//                    } catch (InterruptedException e ) {
//                        System.err.println(e);
//                        System.exit(-1);
                    System.err.println('z');
//                    }
                }
                System.err.println("ExecutorTask.run()");
                task = (Runnable) blockQueue.poll();
            }
            try {
                System.out.println("Какая-то задача запускается");
                task.run();
            } catch (Exception e) {
                System.err.println(e);
                System.exit(-1);
            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;
        this.interrupt();
    }

    public int getIdThread() {
        return id;
    }
}
