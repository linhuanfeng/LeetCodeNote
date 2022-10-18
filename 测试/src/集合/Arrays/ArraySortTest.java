package 集合.Arrays;

import java.util.Arrays;

public class ArraySortTest {
    public static void main(String[] args) {
        Integer[] nums={3,1,6,2};
        Arrays.sort(nums,(a,b)-> b-a);
        for (Integer num : nums) {
            System.out.println(num);
        }
    }
}
