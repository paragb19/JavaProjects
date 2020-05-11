import java.util.concurrent.locks.Lock;

public class Counter {
    private Lock lock;
    private int count;
    public Counter(Lock myLock){
        this.lock=myLock;
    }

    public int getCount(){
        lock.lock();
        try{
            count=count++;
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return 0;
    }
}
