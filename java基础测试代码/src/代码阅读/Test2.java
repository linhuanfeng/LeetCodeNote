package 代码阅读;

/**
 * 猜测得到2进制5-8位代表的值
 */
public class Test2 {
    public static void main(String[] args) {
        // 19 =1 0011(二进制)
        System.out.println(func(19));
    }

    /**
     * 猜测得到2进制5-8位的值
     * @param i
     * @return
     */
    static int func(int i){
        return (i>>4)&((1<<4)-1);
    }
}
