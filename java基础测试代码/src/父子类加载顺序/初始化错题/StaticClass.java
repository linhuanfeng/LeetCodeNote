package 父子类加载顺序.初始化错题;

public class StaticClass {
    static int count1=1;
    /**
     * 这里比较特殊，因为staticClass是静态成员，也要初始化，而初始化调用的是构造方法，
     * 导致构造方法优先于了下面执行：count2=2,count3=3,和静态代码块
     * 所以总的初始化顺序是：
     *
     * count1=1
     *
     * 构造方法执行,count:1,0,0  默认初始化零值
     * count1=2
     * count2=2
     * count3=3
     *
     * 静态代码块,count:2,2,3
     * count3=4
     *
     * 所以最终结果是2，2，4
      */
    private static StaticClass staticClass=new StaticClass();
    static int count2=2;
    static int count3=3;
    static {
        System.out.println("静态代码块,count:"+count1+","+count2+","+count3); // 2 2 3
        count3++; // 4
    }
    private StaticClass(){
        System.out.println("构造方法执行,count:"+count1+","+count2+","+count3); // 1 0 0 count23只进行了默认初始化零值
        count1++; // 2
        count2++; // 1
        count3++; // 1
    }
    static StaticClass getInstance(){
        return staticClass;
    }

    public static void main(String[] args) { // 执行main方法触发类加载
        StaticClass staticClass1 = StaticClass.getInstance();
        System.out.println(StaticClass.count1); // 2
        System.out.println(StaticClass.count2); // 2
        System.out.println(StaticClass.count3); // 4
    }
}
