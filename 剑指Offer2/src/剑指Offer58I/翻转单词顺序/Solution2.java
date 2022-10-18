package 剑指Offer58I.翻转单词顺序;

/**
 * 使用双指针
 * 时间：O(N)遍历一遍
 * 空间：O(N) stringBuider的长度
 */
class Solution2 {
    public String reverseWords(String s) {
        int i=s.length()-1,j=i;
        StringBuilder ans=new StringBuilder();
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
            ans.append(" "+s.substring(i+1,j+1));
        }
        return ans.toString().trim();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String s="a good   example";
        System.out.println(solution.reverseWords(s));
    }
}