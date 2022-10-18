package a17.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯
 * 时间：O（3^n*4^m）遍历每一种字母的组合，3^n*4^m  n对应输入三个字母的个数，m对应输入四个字母的个数
 * 空间：O(1)常数级别，引用arr
 *
 */
class Solution {
    int len=0;
    List<String> ans=null;
    public List<String> letterCombinations(String digits) {
        char[][] arr=new char[][]{
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}};
        len=digits.length();
        char[][] change=new char[len][]; // change其实引用上面，不占空间
        ans=new ArrayList<>();
        for (int i = 0; i <len ; i++) {
            change[i]=arr[digits.charAt(i)-'2'];
        }
        dfs(change,0,new StringBuilder());
        return ans;
    }
    void dfs(char[][] change,int cur,StringBuilder sb){
        if(cur==len){
            if(sb.length()!=0){
                ans.add(new String(sb));
            }
            return;
        }
        for (int i = 0; i <change[cur].length ; i++) {
            sb.append(change[cur][i]);
            dfs(change, cur+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.letterCombinations("");
        for (String s : list) {
            System.out.print(s+" ");
        }
    }
}