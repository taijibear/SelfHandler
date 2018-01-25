//: concurrency/LiftOff.java
// Demonstration of the Runnable interface.



package  thinkInJava.concurrency;


//线程可以驱动任务，因此你需要一种描述任务的方式，这可以由Runnable接口来提供。
//定义任务，只需实现Runnable接口并编写run方法，使得该任务可以执行你的命令

// LiftOff -- 升空，起飞
//count down -- 倒数读秒 

// yield -- 退让，退位

// countDown-- > 0 这个东西的用法 有待研究
// 看明白了， 那是个 大于号   (countDown--) > 0
public class A01_LiftOff implements Runnable {
 
	protected int countDown = 10; // Default
  private static int taskCount = 0;
  private final int id = taskCount++;
  
  public A01_LiftOff() {}
  
  public A01_LiftOff(int countDown) {
	
    this.countDown = countDown;
  }
  
  public String status() {
    return "#" + id + "(" +
      (countDown > 0 ? countDown : "Liftoff!") + "), ";
  }
  public void run() {
	 
	  
    while(countDown-- > 0) {
      System.out.println(status());
      Thread.yield();
      
      /*
       * 在run()中对静态方法Thread.yield()的调用是对线裎调度器的一种建议，
       * （Java线程机制的一部分，可以 将CPU从一个线程转移给另一个线程）
       *  它在声明：我已经执行完生命周期中最 重要的部分了
       */
      
     
    }
  }
} ///:~
