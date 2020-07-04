package sizhe.chen;

/**
 * @ClassName : DisappearRequest1
 * @Description : 消失的请求数
 * @Author : Clark Chen
 * @Date: 2020-07-04 14:28
 */
public class DisappearRequest1  implements Runnable{
    static DisappearRequest1 disappearRequest1 = new DisappearRequest1();
    int i = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(disappearRequest1);
        Thread t2 = new Thread(disappearRequest1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(disappearRequest1.i);
    }

    @Override
    public void run() {

        for(int j=0; j <100000; j++){
            i++;
        }

    }
}
