package a128.最长连续序列;

import java.util.HashSet;
import java.util.Set;

/**
 * set
 * 使用hashSet存储所有元素，累计x+1,x+2...是否存在
 * 这样时间还是O(n^2),
 * 可在外层进行优化，如果存在x-1，直接跳过
 * <p>
 * 时间：O（n）理论上所有元素只会遍历一遍
 * 空间：O(n)
 */
public class Solution2 {
    public int longestConsecutive(int[] nums) {
        int res=0;
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if(set.contains(num-1)){
                continue;
            }
            int i=1;
            while (set.contains(num+i)){
                i++;
            }
            res=Math.max(res,i);
        }
        return res;
    }
}
