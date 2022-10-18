package 剑指Offer67.把字符串转换成整数;

import com.sun.deploy.util.StringUtils;

/**
 * 时间:O(n)
 * 空间：O(1)常数各变量
 */
class Solution {
    public int strToInt(String str) {
        if(str==null||str.length()==0){
            return 0;
        }
        int i=0;
        while (i<str.length()&&str.charAt(i)==' '){
            i++;
        }
        if(i>=str.length()){
            return 0;
        }
        if(str.charAt(i)=='+'||str.charAt(i)=='-'||
                (str.charAt(i)>='0'&&str.charAt(i)<='9')){}
        else return 0;
        // 说明开始符合条件
        long ans=0,tag=1;
        if(str.charAt(i)=='+'){
            i++;
        }else if(str.charAt(i)=='-'){
            tag=-1;
            i++;
        }
        while (i<str.length()&&str.charAt(i)!=' '&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            ans=ans*10+str.charAt(i)-'0';
            i++;
            if(ans-1>=Integer.MAX_VALUE){
                // 防止long型越界，并且超过整数的访问就可以结束了
                return tag==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
        }
        return (int)(ans*tag);
    }

    public static void main(String[] args) {
        /**
         * 各元素的Ascii码：
         * 0-9 48-57
         * A-Z 65 90
         * a-z 97 122
         * + 43
         * - 45
          */
//        Solution solution = new Solution();
//        System.out.println(solution.strToInt(" "));
        System.out.println(Long.MAX_VALUE);
    }
}