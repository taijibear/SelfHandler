//: concurrency/MainThread.java

package  thinkInJava.concurrency;

public class A02_MainThread {
  public static void main(String[] args) {
    
	  // LiftOff �̳��� Runnable 
	  // runable �����������񣬵������߱� �߳�������
	  
	  A01_LiftOff launch = new A01_LiftOff();
    
       launch.run();
  }
} /* Output:
#0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1), #0(Liftoff!),
*///:~
