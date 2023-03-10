package 父子异常;
// final中return中的返回值会覆盖catch中的返回值
public class FinallyReturnTest {
    public static String f1(){
        try {
            int i=1/0;
        }catch (Exception e){
            return "catch";
        }finally {
            return "final";
        }
    }

    public static void main(String[] args) {
        // final中return中的返回值会覆盖catch中的返回值
        System.out.println(FinallyReturnTest.f1());
    }
}
