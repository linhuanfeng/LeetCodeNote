package 剑指Offer58I.翻转单词顺序;

/**
 * 使用双指针
 */
class Solution {
    public String reverseWords(String s) {
        int i=s.length()-1,j=i;
        String ans="";
        int tag=0;
        while (i>=0){
            while (i>=0&&s.charAt(i)==' '){
                i--;
            }
            if(i==-1){
                // 遍历完成
                break;
            }
            // 找到了单位的尾字母
            j=i;
            // 找到单词的结尾
            while (i>=0&&s.charAt(i)!=' '){
                i--;
            }
            if(tag==0){
                ans=s.substring(i+1,j+1);
            }else {
                ans=ans+" "+s.substring(i+1,j+1);
            }
            tag++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="a good   example";
        System.out.println(solution.reverseWords(s));
    }
}