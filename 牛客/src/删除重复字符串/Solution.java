package 删除重复字符串;

import java.util.Random;

public class Solution {
    public String trim (String str){
        if(str==null||str.length()<=1){
            return str;
        }
        StringBuilder sb=new StringBuilder();
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i)==str.charAt(i-1)||Math.abs(str.charAt(i)-str.charAt(i-1))=='a'-'A'){
                continue;
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println((int) 'A'); // 65
        System.out.println((int) 'a'); // 97
        System.out.println('a'-'A'); // 32
        System.out.println("=======================");

        Solution solution = new Solution();
//        String str="ABBCCCCCBBAB";
        String str="aAC";
        System.out.println(solution.trim(str));
    }
}
