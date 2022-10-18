package 剑指Offer46.把数字翻译成字符串;

/**
 * x1x2x3x4
 * 动态规划：f(4)=
 *                f(3)+f(2)  当x4和x3能一起解密
 *                f(3)       当x4和x3不能一起解密
 * 12258
 * 时间：O(n)
 * 空间：O(n) 辅助数组s
 */
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        if(s.length()==1){
            return 1;
        }
        int a=1,b=1,cur=1;
        if(canConn(s,0,1)){
            // 1和2可以合起来
            b=2;
        }
        for (int i = 2; i < s.length(); i++) {
            if(canConn(s,i-1,i)){
                cur=a+b;
            }else {
                cur=b;
            }
            a=b;
            b=cur;
        }
        return b;
    }
    boolean canConn(String s,int i,int j){
        if(s.charAt(i)=='0'){
            return false;
        }
        if(s.charAt(j)-'0'+(s.charAt(i)-'0')*10<=25){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.translateNum(25));
    }
}