package thinkInJava.concurrency;
//: concurrency/CallableDemo.java
import java.util.concurrent.*;
import java.util.*;


//展示了 如何 使用一个 带有返回值的 线程 
//应当使用  Callable  而不是 Runnable 
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
    
    // - Future 未来？
    ArrayList<Future<String>> results =
      new ArrayList<Future<String>>();
   
    for(int i = 0; i < 10; i++)
      results.add(exec.submit(new TaskWithResult(i)));
    /*
     *submit()方法会产生Future对象，
     *它用Callable返回结果的特定类型进行了参数化。
     *你可以用isDon()方法来査询Future是否已经完成.
     *当任务完成时，它具有一个结果，你可以调用get() 方法来获取该结果。
     *你也可以不用isDone()进行检査就直接调用get(),在这种情况下，
     *get()将阻 塞，直至结果准备就绪。
     *你还可以在试图调用get()来获取结果之前，先调用具有超时的get(), 
     *或者调用isDoneO来査看任务是否完成。 
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
