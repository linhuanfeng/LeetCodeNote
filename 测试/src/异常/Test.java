package 异常;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Throwable是异常的顶层父类，代表所有的非正常情况。它有两个直接子类，分别是Error、Exception。
 *
 * Error是错误，一般是指与虚拟机相关的问题，如系统崩溃、虚拟机错误、动态链接失败等，这种错误无法恢复或不可能捕获，
 * 将导致应用程序中断。通常应用程序无法处理这些错误，因此应用程序不应该试图使用catch块来捕获Error对象。
 * 在定义方法时，也无须在其throws子句中声明该方法可能抛出Error及其任何子类。
 *
 * Exception是异常，它被分为两大类，分别是Runtime异常和Checked异常。
 * 所有的RuntimeException类及其子类的实例被称为Runtime异常；
 * 不是RuntimeException类及其子类的异常实例则被称为Checked异常。
 *
 *  一、runtimeException子类：不需要显示捕获
 *  ClassCastException
 *  NullPointerException
 *  IndexOutOfBoundsException
 *  ArithmeticException
 *  ArrayStoreException 数据存储类型错误
 *
 *  IllegalMonitorStateException
 *  IllegalStateException
 *
 *  UnsupportedOperationException
 *  ConcurrentModificationException
 *  NoSuchElementException
 *
 *  二、CheckedException子类：需要显示捕获
 * IOException
 * ClassNotFoundException
 * IllegalAccessException
 *
 *
 * Java认为Checked异常都是可以被处理（修复）的异常，所以Java程序必须显式处理Checked异常,否则无法编译通过。
 * Runtime异常则更加灵活，Runtime异常无须显式声明抛出
 */
public class Test {
    public static void main(String[] args) {
//        new ClassCastException() // runtimeExc
//        new ArrayStoreException() // runtimeExc
//        new ClassNotFoundException() // checkExc
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Class.forName("异常.Test");
        } catch (ClassNotFoundException e) { // checkException
            throw new RuntimeException(e);
        }
        try {
            Test.class.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        int a=5;
        System.out.println(a<5?10.9:9); // 9.0
    }
}
class myException1 extends Exception{}
class myException2 extends RuntimeException{}
