package 代码阅读.finally_return测试;
/*
try中的代码块
finally中的代码块
a > 10,a=20
20

a > 10,a=20的结果说明了return a += 10已经执行了，但是没有直接返回，
而是先去执行finally语句的内容，然后再去返回结果
 */
public class Demo06 {
    public static void main(String[] args) {
        System.out.println(func());
    }

    public static int func(){
        int a = 10;
        try{
            System.out.println("try中的代码块");
            return a += 10;
        }catch (Exception e){
            System.out.println("catch中的代码块");
        }finally {
            System.out.println("finally中的代码块");
            if(a > 10){
                System.out.println("a > 10,"+"a="+a);
            }
        }
        return a += 50;
    }
}

