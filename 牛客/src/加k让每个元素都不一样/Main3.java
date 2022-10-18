package 加k让每个元素都不一样;

import java.util.Arrays;
import java.util.Scanner;

/*
5 2
2 3 1 3 4

我相当于创建了k个桶，每个num去它所在的桶里，寻找它可以达到的最小值，贪心地计算即可。
 */
// ac
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        long res = fun(nums, k);
        System.out.println(res);
    }

    private static long fun(int[] nums, int k) {
        Arrays.sort(nums);
        int[] memo = new int[k]; // memo[i] 下一个可以使用的最大元素
        for (int i = 0; i < k; i++) {
            memo[i] = i; // 创建k个桶，余数相同的放到同个桶，到时他们也是相差n个k,只需要找到每个桶的最小可以取的值即可
        }
        long res = 0;
        for (int num : nums) {
            int index = num % k;
            // 当前最大数 memo[index] 自己: num
            // memo[index] >= num res += (memo[index] - num) / k;
            //             <      memo[index] = num + k // 向后取
            if (memo[index] >= num) {
                res += (memo[index] - num) / k; // 当前值自增n个k,找到最近的可取值，累计k的次数
                memo[index] += k; // 桶对应可取值递增k
            } else { // memo[index] < num
                memo[index] = num + k; // 当前值num不变，桶的最近可取值等于num+k
            }
        }
        return res;
    }
}
