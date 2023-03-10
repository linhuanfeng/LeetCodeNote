package 代码阅读.finally_return测试;
/*
try中的代码块
catch中的代码块
finally中的代码块
a > 20,a =35
35

try语句块中发生异常，try语句异常后的内容不会执行，return语句也不会执行，
执行的是捕获到的catch语句块和finally语句块
 */
public class Demo10 {
    public static void main(String[] args) {
        System.out.println(func());
    }

    public static int func(){
        int a = 10;
        try{
            System.out.println("try中的代码块");
            a = a/0;
            return a += 50;
        }catch (Exception e){
            a += 15;
            System.out.println("catch中的代码块");
        }finally {
            System.out.println("finally中的代码块");
            if(a > 20){
                System.out.println("a > 20,a ="+a);
            }
            a += 10;
        }
        return a;
    }
}

