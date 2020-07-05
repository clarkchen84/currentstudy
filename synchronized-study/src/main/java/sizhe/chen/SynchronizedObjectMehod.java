package sizhe.chen;

public class SynchronizedObjectMehod  implements  Runnable{
    Object lock1 = new Object();
    Object lock2 = new Object();

    public static void main(String[] args) {
        SynchronizedObjectMehod synchronizedObjectMehod = new SynchronizedObjectMehod() ;
        Thread t1 = new Thread(synchronizedObjectMehod);
        Thread t2 = new Thread(synchronizedObjectMehod);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");

    }
    @Override
    public void run() {
        synMehod();
    }

    public synchronized void synMehod(){
        System.out.println("我是对lock1，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("lock2运行结束，我叫" + Thread.currentThread().getName());
    }
}
