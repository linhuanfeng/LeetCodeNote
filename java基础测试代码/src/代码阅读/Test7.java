package 代码阅读;

public class Test7 {
    public static void main(String[] args) {
        System.out.println(getNumber(0)); // 1
    }
    public static int getNumber(int n){
        int i=0;
        try {
            return ++i; // return子句会执行，把结构执行
        }catch (Exception e){
            return ++i;// catch有return，则try的return不会执行
        }finally {
           ++i; // finally有return，则catch和try的return不会执行,基本数据类型不会修改上面的返回值
        }
    }
}
