package 哔哩哔哩2021校园招聘后端开发方向笔试卷A.找零;

import java.util.Arrays;

/**
 * 面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。现在小Y使用1024元的纸币购买了一件价值为N(0<N≤1024)的商品，请问最少他会收到多少硬币
 *
 * 输入例子1:
 * 200
 *
 * 输出例子1:
 * 17
 *
 * 例子说明1:
 * 12个64元硬币，3个16元硬币，2个4元硬币
 */
public class Solution2 {
    /**
     * 
     * @param N int整型 
     * @return int整型
     */
    public int GetCoinCount (int N) {
        // write code here
        int remain=1024-N;
        return remain/64+(remain%64)/16+(remain%16)/4+remain%4;
    }
}