package sizhe.chen;

public class SyncrhonizedClass implements  Runnable {

    public static void main(String[] args) {
        SyncrhonizedClass lockClass1 = new SyncrhonizedClass();
        SyncrhonizedClass lockClass2 = new SyncrhonizedClass();


        Thread thread1 = new Thread(lockClass1);
        Thread thread2 = new Thread(lockClass2);
        thread1.start();
        thread2.start();

        while(thread1.isAlive() || thread2.isAlive()){


        }
        System.out.println("finish ");
    }
    public static synchronized  void method(){
        System.out.println("我是对lock1，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("lock2运行结束，我叫" + Thread.currentThread().getName());

    }
    @Override
    public void run() {
        method();
    }
}
