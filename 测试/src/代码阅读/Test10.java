package 代码阅读;

public class Test10 {
    public static void main(String[] args) {
        grow(1); // 12344321
    }
    static void grow(int n){
        System.out.print(n);
        if(n<4){
            grow(n+1);
        }
        System.out.print(n);
    }
}
