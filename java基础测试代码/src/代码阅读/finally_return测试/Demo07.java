package 代码阅读.finally_return测试;
/*
try中的代码块
finally中的代码块
a>10,a=20
100 (finally中的return会覆盖try的return)

（1）如果try中有return语句，finally中也有return语句，最终执行的是finally中的return语句
（2）如果finally代码块中写了return语句，那么finally之后的return语句就变成不可到达的语句，
    需要注释掉，否则编译不过
 */
public class Demo07 {
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
                System.out.println("a>10,"+"a="+a);
            }
            return 100;
        }
    }
}

