//: concurrency/MainThread.java

package  thinkInJava.concurrency;

public class A02_MainThread {
  public static void main(String[] args) {
    
	  // LiftOff 继承自 Runnable 
	  // runable 用以描述任务，但并不具备 线程能力？
	  
	  A01_LiftOff launch = new A01_LiftOff();
    
       launch.run();
  }
} /* Output:
#0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1), #0(Liftoff!),
*///:~
