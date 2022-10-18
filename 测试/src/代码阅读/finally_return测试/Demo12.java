package 代码阅读.finally_return测试;
/*
try block
 */
public class Demo12 {
    public static void main(String[] args) {
        int a = 10;
        try{
            System.out.println("try block");
            System.exit(0);
        }catch (Exception e){
            System.out.println("catch block");
        }finally {
            System.out.println("finally block");
        }
    }
}

