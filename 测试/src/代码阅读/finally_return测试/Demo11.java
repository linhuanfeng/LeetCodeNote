package 代码阅读.finally_return测试;
/*
try中的代码块
catch中的代码块
finally中的代码块
a > 10, a = 35
75
25

try中发生异常之后，catch中的return语句先执行，确定了返回值之后（保存起来，
finally中的语句对返回值无影响）再去finally语句块，执行完之后再返回a的值，
finally中对a的修改对返回值无效
 */
public class Demo11 {
    public static void main(String[] args) {
        System.out.println(func());
    }

    public static int func(){
        int a = 10;
        try{
            System.out.println("try中的代码块");
            a = a /0;
            return a += 10;
        }catch (Exception e){
            System.out.println("catch中的代码块");
            return a += 15;
        }finally {
            System.out.println("finally中的代码块");
            if (a > 10){
                System.out.println("a > 10, a = "+a);
            }
            a += 50;
            System.out.println(a);
        }
    }
}


