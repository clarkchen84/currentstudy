package sizhe.chen;

public class SynchronizeException implements  Runnable {
    @Override
    public void run() {
        if("Thread-0".endsWith(Thread.currentThread().getName())){
            method1();
        }else{
            method2();
        }

    }

    public static void main(String[] args) {
        SynchronizeException lockClass1 = new SynchronizeException();
        //SynchronizeException lockClass2 = new SynchronizeException();


        Thread thread1 = new Thread(lockClass1);
        Thread thread2 = new Thread(lockClass1);
        thread1.start();
        thread2.start();

        while(thread1.isAlive() || thread2.isAlive()){


        }
        System.out.println("finish ");
    }
    public  synchronized  void method1(){
        System.out.println("method1，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
            throw new RuntimeException();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("mehtod1运行结束，我叫" + Thread.currentThread().getName());

    } public  synchronized  void method2(){
        System.out.println("method2，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("method2运行结束，我叫" + Thread.currentThread().getName());

    }
}
