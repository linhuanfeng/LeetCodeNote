package 代码阅读.类型转换;

public class Test {
    public static void main(String[] args) {
        short s=23; s+=12; // +=会隐式类型转换
        float f = (float) (23+25.23); // 默认提升为float
        byte a=1,b=3; byte c = (byte) (a+b); // 默认提升为int
        short sh =22;sh= (short) (sh+12); // 默认提升为int
    }
}
