package 集合.流操作.遍历过滤;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// https://blog.csdn.net/qq_43410878/article/details/123716629
public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);

        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(System.out::print); // 798
        // 匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();
        Optional<Integer> findAny1 = list.stream().filter(x -> x > 6).findAny();
        // 匹配任意（适用于并行流）
        Optional<Integer> findAny2 = list.parallelStream().filter(x -> x > 6).findAny();
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x > 6);
        System.out.println("匹配第一个值：" + findFirst.get()); // 匹配第一个值：7
        System.out.println("匹配任意一个值：" + findAny1.get()); // 匹配任意一个值：7
        System.out.println("匹配任意一个值：" + findAny2.get()); // 匹配任意一个值：8
        System.out.println("是否存在大于6的值：" + anyMatch); // 是否存在大于6的值：true
    }
}