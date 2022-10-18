package 异常;

/**
 * 异常从上到下，一旦被捕获就不会再进入catch块
 * 异常发送后下面的代码就不会再执行了
 * BD
 */
public abstract class Test2 {
    public static void main(String[] args) {
        try {
            test();
            System.out.println("A");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("B");
            return;
        }catch (Exception e){
            System.out.println("C");
        }finally {
            System.out.println("D");
        }
    }

    private static void test() {
        int[] a={1,2,3};
        System.out.println(a[3]);
    }
}
