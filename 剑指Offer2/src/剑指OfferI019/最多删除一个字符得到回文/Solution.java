package 剑指OfferI019.最多删除一个字符得到回文;

/**
 * 碰到不符合的回文串，尝试从左右和右边跳过一个
 *
 * 时间：O(n)
 * 空间：O(1)
 */
class Solution {
    public boolean validPalindrome(String s) {
        return check(s,0,s.length()-1,true);
    }
    boolean check(String s,int i,int j,boolean flag){ // flag标识只有一次机会
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)){
                if(!flag){
                    // 已经去掉一个了，失败
                    return false;
                }
                // 左边去掉
                boolean b1 = check(s, i, j - 1, false);
                // 右边去掉
                boolean b2 = check(s, i+1, j , false);
                return b1||b2; // 有一种成功即可
            }
            i++;
            j--;
        }
        return true;
    }
}