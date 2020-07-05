package sizhe.chen;

/**
 * @ClassName : SynchronizedObjectCodeBlock
 * @Description : 对象示例，同步代码块
 * @Author : Clark Chen
 * @Date: 2020-07-05 11:18
 */
public class SynchronizedObjectCodeBlock  implements  Runnable{
    Object lock1 = new Object();
    Object lock2 = new Object();

    public static void main(String[] args) {
        SynchronizedObjectCodeBlock synchronizedObjectCodeBlock = new SynchronizedObjectCodeBlock() ;
        Thread t1 = new Thread(synchronizedObjectCodeBlock);
        Thread t2 = new Thread(synchronizedObjectCodeBlock);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");

    }
    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("我是对lock1，我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock2运行结束，我叫" + Thread.currentThread().getName());
        }

        synchronized (lock2) {
            System.out.println("我是对lock2，我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lock2运行结束，我叫" + Thread.currentThread().getName());
        }
    }
}
