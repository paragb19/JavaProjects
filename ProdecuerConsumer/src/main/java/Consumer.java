import org.apache.log4j.Logger;

import java.util.Queue;

public class Consumer extends Thread {
    private static final Logger logger = Logger.getLogger(Consumer.class);
    private final Queue sharedQ;

    public Consumer(Queue sharedQ) {
        super("Consumer");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        int number;
        while(true){
            synchronized (sharedQ){
                while(sharedQ.isEmpty()){

                    try {
                        logger.debug("Queue is empty, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                 number=(Integer)sharedQ.poll();
                logger.debug("Consuming : " +number);
                sharedQ.notify();

            }
        if(number == 3){break; }
        }
    }
}