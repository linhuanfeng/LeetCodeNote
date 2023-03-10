package 代码阅读;

public class Test1 {
    static int func(int value,int aa){
        return (value+aa-1)&~(aa-1);
    }

    public static void main(String[] args) {
        System.out.println(func(11,2)); // 12
        System.out.println(func(2,2)); // 2
        System.out.println(func(2,1)); // 2
        System.out.println(func(1,2)); // 2
        System.out.println(func(3,2)); // 4
        System.out.println(func(3,1)); // 3
        System.out.println(func(3,8)); // 8
        System.out.println(func(3,3)); // 5
        System.out.println(func(4,4)); // 4
        System.out.println(func(9,6)); // 10
        System.out.println(func(28,3)); // 28
        System.out.println(func(35,37)); // 67
        System.out.println(func(63,636)); // 128
    }
}
