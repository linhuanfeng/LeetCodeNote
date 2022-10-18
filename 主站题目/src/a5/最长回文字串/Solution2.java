package a5.最长回文字串;

/**
 * 中心扩展法
 * 对于每个i，j，判断[i-1,j+1]、[i-2,j+2]是否是回文.
 * 同时判断[i,i]，[i,i+1]这两种情况,就能考虑了aa和aba这种情况
 *
 * 时间：O(n^2)
 * 空间：O(1)
 */
class Solution2 {
    public String longestPalindrome(String s) {
        int n=s.length();
        int left=0,right=0;

        for (int i = 0; i < n; i++) {
            int l1 = centerExpand(s, i, i);
            int l2 = centerExpand(s, i, i+1);
            if(l1>right-left+1){
                left=i-l1/2;
                right=i+l1/2;
            }
            if(l2>right-left+1){
                left=i-(l2/2-1);
                right=i+l2/2;
            }
        }
        return s.substring(left,right+1);
    }
    int centerExpand(String s,int i,int j){
        int count=0;
        while (i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            count=j-i+1;
            i--;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().longestPalindrome("cbbd"));
    }
}