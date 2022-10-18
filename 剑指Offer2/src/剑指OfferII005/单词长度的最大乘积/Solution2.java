package 剑指OfferII005.单词长度的最大乘积;

/**
 * 对于验证两个单词长度的最大乘积，首先需要每两个单词都比较一遍，这个就没办法避免了……
 *
 * 考虑加快判断两个字符串是否包含相同的字符：
 *
 * 首先，需要一个单词中的每一个字符都保存起来
 * 之后，比较依次比较两个单词中每一个字符，确定或者都没出现过，或者只有一个单词中出现过
 * 考虑二进制值 与 的特性， 0 & 0 = 0, 0 & 1 = 1 & 0 = 0, 1 & 1 =1 ，刚好符合要求
 * 用一个数字二进制表示中的每一位记录一个字母是否出现，例如，字符串 ac 可以用 00000000 00000000 00000000 00000101 = 3 表示
 * 将每一个字符串中字母是否出现均用一个数字表示表示出来，当比较两个字符串是否存在相同字母时，使用 num1 & num2 == 0 就可以轻易判断出来了(๑╹◡╹)ﾉ"""
 * 时间复杂度：O(n2) 两重循环
 * 空间复杂度：字符数组的开销
 */
public class Solution2 {
    public int maxProduct(String[] words) {
        // 将字符串转换为对应的数字
        int[] intWords = initWord(words);
        int res=0;
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                // 每个二进制位都不同 按位与=0
                if((intWords[i]&intWords[j])==0){
                    res=Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }

    /**
     * 0000000  每一位表示一个字母是否出现过
     *      比如 ac ==> 000101
     * 将字符串转化为对应的数字
     * @param str
     * @return
     */
    private int[] initWord(String[] str) {
        int[] res=new int[str.length];
        for (int i=0;i<str.length;i++) {
            for (char c : str[i].toCharArray()) {
                int n=c-'a';
                res[i]=res[i]|(1<<n);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
    }
}
