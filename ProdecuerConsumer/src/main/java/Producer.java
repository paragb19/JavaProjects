import org.apache.log4j.Logger;

import java.util.Queue;

public class Producer extends Thread {
    private static final Logger logger = Logger.getLogger(Producer.class);
    private final Queue  sharedQ;

    public Producer(Queue sharedQ) {
        super("Producer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (sharedQ){
                while(!sharedQ.isEmpty()){
                    logger.debug("Queue is full, waiting");
                    try {
                        sharedQ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                logger.debug("producing : " + i);
                sharedQ.add(i);
                sharedQ.notify();

            }

        }
    }
}
