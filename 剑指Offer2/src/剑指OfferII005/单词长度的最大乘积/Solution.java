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
 */
public class Solution {
    public int maxProduct(String[] words) {
        int res=0;
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i+1; j < words.length; j++) {
                // 效率低，字符串进行了重复转换，我可以先一次性转换完，再进行转换
                if(isDiff(words[i],words[j])){
                    res=Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }

    private boolean isDiff(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        long a=0,b=0;
        for (char c : chars1) {
            int n=c-'a';
            a=a|(1<<n); // 将对应位置的数转为1
        }
        for (char c : chars2) {
            int n=c-'a';
            b=b|(1<<n); // 将对应位置的数转为1
        }
        return (a&b)==0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean diff = solution.isDiff("aa", "ab");
        System.out.println(diff);
    }
}
