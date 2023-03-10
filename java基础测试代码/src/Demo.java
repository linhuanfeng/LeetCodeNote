import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {
    public static native int meo(); // 本地方法不能有方法体
    public static void main(String[] args) {


        String s1="\\x41";
        String s2="\\X41";
        String s3="\\041";
        String s4="\\0X1";

        s1.substring(10);

        int a=0,b=0;
//        System.out.println("*"+a-b); // string不能-
        System.out.println(~0); // -1
        Object[] objects=new Object[2];
        System.out.println(objects[0]); // null

//        new Big
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(1000);
        System.out.println(set.contains(1000)); // true
        System.out.println(UUID.randomUUID().toString());
        Demo demo = new Demo();
//        new AtomicInteger()
        ThreadLocal<Demo> threadLocal=new ThreadLocal<>();

        int a2='a'; // 自动转为对应的ascii值
        System.out.println(a); // 97
        short s=97;
        char c= (char) s; // 这种平级得就得强制转换
        System.out.println(c); // a

        int i=1;
        float f=2,f2=-2;
        System.out.println(i/f); // 0.5 自动转为范围更大得数
        System.out.println(i/f2); // -0.5

        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.getAndIncrement();

        System.out.println(Integer.MAX_VALUE); // 2 147 483 647 21亿

        Map<Thread, StackTraceElement[]> traces = Thread.getAllStackTraces();
        for (Map.Entry<Thread, StackTraceElement[]> threadEntry : traces.entrySet()) {
            System.out.println(threadEntry.getKey());
            Iterator<StackTraceElement> iter = Arrays.stream(threadEntry.getValue()).iterator();
            while (iter.hasNext()){
                System.out.print(iter.next()+",");
            }
        }

        ArrayList<Integer> integers = new ArrayList<>();
        for (Integer integer : integers) {

        }

//        Comparator
    }
    int i;
    void  f1(){
        int j;
//        int i=j; // 报错，显示未初始化
    }
}
