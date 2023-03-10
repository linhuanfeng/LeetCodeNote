package java8接口.lamda接口回调.case1;

public class CommonTest {
    public static String cal(Callback callback){
        return callback.call("hello");
    }

    public static void main(String[] args) {
        System.out.println(CommonTest.cal(a -> a + a)); // hellohello
    }
}
