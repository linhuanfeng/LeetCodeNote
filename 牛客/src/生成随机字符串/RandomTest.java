package 生成随机字符串;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        System.out.print("Math.random()生成0-1的double随机数：  ");
        System.out.println(Math.random()); // 生成0.00000到1.0000的任意double值

        System.out.print("random.next**,【0-bound)左闭右开:  ");
        Random random1 = new Random(10); // 注意只是种子，不是边界
        System.out.println(random1.nextInt(10)); // 生成【0-10）左闭右开的随机数
    }
}
