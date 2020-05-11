import java.util.LinkedList;
import java.util.Queue;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
public class ProgramRunner {

    public static void main(String args[]){
        BasicConfigurator.configure();
        final Queue sharedQ = new LinkedList();
        Thread c1=new Producer(sharedQ);
        Thread c2=new Consumer(sharedQ);
        c1.start();
        c2.start();
    }
}
