package thinkInJava.concurrency;
//: concurrency/SimpleDaemons.java
// Daemon threads don't prevent the program from ending.
import java.util.concurrent.*;
import static net.mindview.util.Print.*;

public class A11_SimpleDaemons implements Runnable {
	
	/*
	所谓后台（daemon)线程，是指在程序运行的时候在后台提供一种通用服务的线程，
	并且这种线程并不属于程序中不可或缺的部分。
	因此，当所有的非后台线程结束时，程序也就终止 了,
	同时会杀死进程中的所有后台线程。后台线程无法阻止程序的结束。

	反过来说，只要有任何非后台线程还在运行，程序就不会终止。
	比如，执行main 的就是一个非后台线程。

	*/
  public void run() {
    try {
      while(true) {
        TimeUnit.MILLISECONDS.sleep(100);
        print(Thread.currentThread() + " " + this);
      }
    } catch(InterruptedException e) {
      print("sleep() interrupted");
    }
  }
  public static void main(String[] args) throws Exception {
    for(int i = 0; i < 10; i++) {
      Thread daemon = new Thread(new A11_SimpleDaemons());
      daemon.setDaemon(true); // Must call before start()
      
      // 必须在线程启动之前调用 setDaemon() 方法，才能把它设置为后台线程。

      daemon.start();
    }
    print("All daemons started");
    // 如果 主线程 睡眠时间过短，可能 创建的多线程 根本没有执行的机会。
    // TimeUnit.MILLISECONDS.sleep(5);
    
    TimeUnit.MILLISECONDS.sleep(500);
  }
}

/* Output: (Sample)
All daemons started
Thread[Thread-0,5,main] SimpleDaemons@530daa
Thread[Thread-1,5,main] SimpleDaemons@a62fc3
Thread[Thread-2,5,main] SimpleDaemons@89ae9e
Thread[Thread-3,5,main] SimpleDaemons@1270b73
Thread[Thread-4,5,main] SimpleDaemons@60aeb0
Thread[Thread-5,5,main] SimpleDaemons@16caf43
Thread[Thread-6,5,main] SimpleDaemons@66848c
Thread[Thread-7,5,main] SimpleDaemons@8813f2
Thread[Thread-8,5,main] SimpleDaemons@1d58aae
Thread[Thread-9,5,main] SimpleDaemons@83cc67
...
*///:~
