package thinkInJava.concurrency;
//: concurrency/CachedThreadPool.java
import java.util.concurrent.*;

// 关于  ExecutorService 的使用 

//非常常见的情况是，单个的Executor被用来创建和管理系统中所有的任务。

/*
 * 
 * 对shutdown()方法的调用可以防止新任务被提交给这个Executor,
 * 当前线程（在本例中，即驱动main的线程）
 * 将继续运行在shutdown()被调用之前提交的所有任务。
 * 这个程序将在 Executor中的所有任务完成之后尽快退出。
 */
public class A05_CachedThreadPool {
  public static void main(String[] args) {
	  

    ExecutorService exec = Executors.newCachedThreadPool();
    for(int i = 0; i < 5; i++)
      exec.execute(new A01_LiftOff());
      // 还是不太理解这个地方，容后研究
      exec.shutdown();
    }
}

/* Output: (Sample)
#0(9), #0(8), #1(9), #2(9), #3(9), #4(9), #0(7), #1(8), #2(8), #3(8), #4(8), #0(6), #1(7), #2(7), #3(7), #4(7), #0(5), #1(6), #2(6), #3(6), #4(6), #0(4), #1(5), #2(5), #3(5), #4(5), #0(3), #1(4), #2(4), #3(4), #4(4), #0(2), #1(3), #2(3), #3(3), #4(3), #0(1), #1(2), #2(2), #3(2), #4(2), #0(Liftoff!), #1(1), #2(1), #3(1), #4(1), #1(Liftoff!), #2(Liftoff!), #3(Liftoff!), #4(Liftoff!),
*///:~
