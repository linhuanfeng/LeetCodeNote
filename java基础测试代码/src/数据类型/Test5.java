package 数据类型;

public class Test5 {
    public static void main(String[] args) {
        short s=1;
//        s=s+(short) 1; // 编译失败，自动转为int了

        s+=1; // 正常，隐含强制转换 s+=1相当于 s = (s的数据类型)(s + 1)；+=会进行内部的处理，隐含了一个强制类型转换的过程。
        s++; // 同上
//        s=s+1; // 编译失败，自动转为int了
    }
}
