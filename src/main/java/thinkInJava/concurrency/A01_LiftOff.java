//: concurrency/LiftOff.java
// Demonstration of the Runnable interface.



package  thinkInJava.concurrency;


//�߳̿������������������Ҫһ����������ķ�ʽ���������Runnable�ӿ����ṩ��
//��������ֻ��ʵ��Runnable�ӿڲ���дrun������ʹ�ø��������ִ���������

// LiftOff -- ���գ����
//count down -- �������� 

// yield -- ���ã���λ

// countDown-- > 0 ����������÷� �д��о�
// �������ˣ� ���Ǹ� ���ں�   (countDown--) > 0
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
       * ��run()�жԾ�̬����Thread.yield()�ĵ����Ƕ����ε�������һ�ֽ��飬
       * ��Java�̻߳��Ƶ�һ���֣����� ��CPU��һ���߳�ת�Ƹ���һ���̣߳�
       *  �������������Ѿ�ִ���������������� ��Ҫ�Ĳ�����
       */
      
     
    }
  }
} ///:~
