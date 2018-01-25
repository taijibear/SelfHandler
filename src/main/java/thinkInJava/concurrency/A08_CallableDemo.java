package thinkInJava.concurrency;
//: concurrency/CallableDemo.java
import java.util.concurrent.*;
import java.util.*;


//չʾ�� ��� ʹ��һ�� ���з���ֵ�� �߳� 
//Ӧ��ʹ��  Callable  ������ Runnable 
class TaskWithResult implements Callable<String> {
  private int id;
  public TaskWithResult(int id) {
    this.id = id;
  }
  public String call() {
    return "result of TaskWithResult " + id;
  }
}

public class A08_CallableDemo {
  public static void main(String[] args) {
    ExecutorService exec = Executors.newCachedThreadPool();
    
    // - Future δ����
    ArrayList<Future<String>> results =
      new ArrayList<Future<String>>();
   
    for(int i = 0; i < 10; i++)
      results.add(exec.submit(new TaskWithResult(i)));
    /*
     *submit()���������Future����
     *����Callable���ؽ�����ض����ͽ����˲�������
     *�������isDon()��������ѯFuture�Ƿ��Ѿ����.
     *���������ʱ��������һ�����������Ե���get() ��������ȡ�ý����
     *��Ҳ���Բ���isDone()���м�˾�ֱ�ӵ���get(),����������£�
     *get()���� ����ֱ�����׼��������
     *�㻹��������ͼ����get()����ȡ���֮ǰ���ȵ��þ��г�ʱ��get(), 
     *���ߵ���isDoneO���˿������Ƿ���ɡ� 
     */
    

    
    
    for(Future<String> fs : results)
      try {
        // get() blocks until completion:
        System.out.println(fs.get());
      } catch(InterruptedException e) {
        System.out.println(e);
        return;
      } catch(ExecutionException e) {
        System.out.println(e);
      } finally {
        exec.shutdown();
      }
 
  
  }
} /* Output:
result of TaskWithResult 0
result of TaskWithResult 1
result of TaskWithResult 2
result of TaskWithResult 3
result of TaskWithResult 4
result of TaskWithResult 5
result of TaskWithResult 6
result of TaskWithResult 7
result of TaskWithResult 8
result of TaskWithResult 9
*///:~
