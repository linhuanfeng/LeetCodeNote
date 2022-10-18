package a89.格雷编码;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 每次把i>>1^i即可改变一个二进制位
 */
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList<>((int)Math.pow(2,n));
        for (int i = 0; i < 1<<n; i++) {
            res.add(i>>1^i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.grayCode(2));
    }
}