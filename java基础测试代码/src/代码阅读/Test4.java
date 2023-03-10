package 代码阅读;

public class Test4 {
    public static void main(String[] args) {
        int i=1;
        int j=i++;
        if((j>++j)&&(i++==j)){ // 短路运算
            j+=i; // 不会执行
        }
        System.out.println(j); // 2
    }
}
