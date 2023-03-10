package 剑指Offer46.把数字翻译成字符串;

/**
 * 转换成跳楼梯，跳一步或两部
 *   1 2 2 5 8
 * 1 1 2 3 4 5
 * 0 1 2 3 5 5
 * a b cur
 *
 * cur=max(b+1,a+1)
 *
 * 时间：O(n)
 * 空间：O(1)
 *
 *   2 6
 * 0 1 2
 * 0 1
 * a b
 */
public class Solution2 {
    public int translateNum(int num) {
        String numStr=String.valueOf(num);

        if(numStr.length()==1){
            return 1;
        }
        int a=1,b=1,cur=0;
        for (int i = 2; i <= numStr.length(); i++) {
            cur=b; // 只有一个数值一定满足【0-25】,等于上一个的个数
            char left = numStr.charAt(i - 2),right=numStr.charAt(i-1);
            if(left!='0'&&(left-'0')*10+(right-'0')<=25){
                // 加上取两个的种数
                cur+=a;
            }
            a=b;
            b=cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().translateNum(25));
    }
}
