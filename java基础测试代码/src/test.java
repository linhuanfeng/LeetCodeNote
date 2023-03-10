import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
  private static int i=10;

  public static void main(String[] args) throws InterruptedException {
    //    Math.sqrt()
    int scanf;
//    float case; // 关键字
    double random = Math.random(); // 0.0-0.9999
    Random random1 = new Random();
    random1.nextInt(10); //0-9
    random1.nextDouble(); // 0.0-1.0
    String line = "aaabab";//更改了需要匹配规则的字符，确保可以找find到两次规则a*b
    String pattern = "a*b";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(line);
    System.out.println(m.find()); // true
    System.out.println(m.start()); // 0
    System.out.println(m.end());// 4(右边界不包括) 验证第一次匹配结束的位置
    System.out.println(m.find()); // true
    System.out.println(m.start());// 4 验证第二次匹配开始的位置
    System.out.println(m.end()); // 6
    m.reset();
    System.out.println(m.find()); // 3 验证由于进行了reset，第三次find重新开始

    System.out.println("abc".substring(1, 2)); // b 右边界同样不包括

//    HashMap
//    ConcurrentHashMap
//    CopyOnWriteArrayList
//    ArrayBlockingQueue
//    ReentrantLock lock = new ReentrantLock();
//    Condition condition = lock.newCondition();
//    condition.await();
//    ExecutorService pool = Executors.newCachedThreadPool();
//    pool.
//    int i=0;
//    long j=0;
//    System.out.println(i==j); // true
//    new StringBuffer()
//    int num = 15;
//    while(num>0)
//    {
//      System.out.print(num++ %5 + "\t");
//      num /=5;
//    }
//    BigDecimal bigDecimal = new BigDecimal("1.1");
//    bigDecimal.add(BigDecimal.ONE);
//    try {
//      Class<?> claz = Class.forName("test");
//      System.out.println(claz);
//    } catch (ClassNotFoundException e) {
//      throw new RuntimeException(e);
//    }
    new Vector<Integer>();
//    Map
  }
}
