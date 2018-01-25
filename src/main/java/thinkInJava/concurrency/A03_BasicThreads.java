package  thinkInJava.concurrency;
//: concurrency/BasicThreads.java
// The most basic use of the Thread class.

//������ת��Ϊ��������Ĵ�ͳ��ʽ�ǰ����ύ��һ��Thread������
class A03_BasicThreads {
  public static void main(String[] args) {
    Thread t = new Thread(new A01_LiftOff());
    t.start();
    System.out.println("Waiting for LiftOff");
  }
} 
/* Output: (90% match)
Waiting for LiftOff
#0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1), #0(Liftoff!),
*///:~
