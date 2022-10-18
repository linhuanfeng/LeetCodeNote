package 加k让每个元素都不一样;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 重复了，往后取n个k，那么如何快速定位到最小的可取值，只有对k余数相同的才需要考虑重复
 那么如何快速确定可取的num+nk这个数，可以考虑用桶的思想，取k个桶，不断更新每个桶最大可取值
 num[index]>=num  res+=(num[index]-num)/k
 num[index]<num 更新当前桶的最小可取值，当前num不需要移动
 */
/*
 ac
 时间：O(n)
 空间：O(k)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.valueOf(split[0]), k = Integer.valueOf(split[1]);
        String[] split1 = br.readLine().split(" ");
        int[] nums =new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=Integer.valueOf(split1[i]);
        }

        Arrays.sort(nums);

        long res = 0;
        int[] bucket = new int[k];
        for (int i = 0; i < k; i++) {
            bucket[i] = i;
        }

        for (int num : nums) {
            int index = num % k;
            if(bucket[index]>=num){
                // 快速增加到最近的可取值
                res+=(bucket[index]-num)/k;
                bucket[index]+=k; // +k,得到当前桶下一个最小的值
            }else {
                bucket[index]=num+k; // 当前数num不需要增加，更新桶的最小可取值
            }
        }

        System.out.println(res);
    }
}
