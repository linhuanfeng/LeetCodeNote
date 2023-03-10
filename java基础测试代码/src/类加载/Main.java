package 类加载;

import org.junit.Test;

public class Main {
    @Test
    public void Test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> claz = classLoader.loadClass("类加载.A"); // 加载类到JVM但不触发类的初始化
//        claz.newInstance(); // 才会进行初始化
        System.out.print("Test");
        Class.forName("类加载.A"); //触发类加载和初始化clinit<>方法执行
        // 结果：Test A
    }
}

class A {
    static {
        System.out.println("A");
    }
}