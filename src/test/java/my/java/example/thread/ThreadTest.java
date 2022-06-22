package my.java.example.thread;

/**
 * Creator: luojingyan
 * Date:2022/5/25 0:12
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread subT = new Thread(() -> {
            while (true) {
          /*      try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 这个异常的抛出会使得线程的中断状态被清除！
                    System.err.println("休眠被中断！");
                }*/
                if (Thread.currentThread().isInterrupted()) {
//                    System.out.println("收到了线程中断的请求，但我就是不结束！");
                    System.out.println("收到了线程中断的请求，我响应一下：");
                    /**
                     * 如果是wait、sleep以及jion三个方法引起的阻塞，那么会将线程的中断标志重新设置为false，并抛出一个InterruptedException；
                     * 如果是java.nio.channels.InterruptibleChannel进行的io操作引起的阻塞，则会对线程抛出一个ClosedByInterruptedException；（待验证）
                     * 如果是轮询（java.nio.channels.Selectors）引起的线程阻塞，则立即返回，不会抛出异常。（待验证）
                     */
                    Thread.currentThread().interrupt();
                    System.out.println("收到了线程中断的请求，响应完了");
                } else {
                    System.out.println("zzzzz");
                }
            }
        });
        // 就算主线程结束了非守卫线程也不会退出 jvm
        subT.setDaemon(false);

        subT.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.println("休眠被中断！");
        }
        // 请求子线程中断
        subT.interrupt();
    }
}
