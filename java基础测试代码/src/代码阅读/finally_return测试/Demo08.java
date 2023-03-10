package 代码阅读.finally_return测试;
/*
try中的代码块
finally中的代码块
a > 10,a=50
30 (基本数据类型不会修改try中return的返回值)

对于基本数据类型来说，finally中对返回值的修改不会影响try中的返回变量的值
 */
public class Demo08 {
    public static void main(String[] args) {
        System.out.println(func());
    }

    public static int func(){
        int a = 10;
        try{
            System.out.println("try中的代码块");
            return a += 20; // 30
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("catch中的代码块");
        }finally {
            System.out.println("finally中的代码块");
            a  += 20;
            if(a > 10){
                System.out.println("a > 10,a="+a);
            }
            a += 20;
        }
        return 200;
    }
}

