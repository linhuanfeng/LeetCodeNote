package a131.分割回文串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * f(i,j)={  True i≥j
 *           f(i+1,j−1)∧(s[i]=s[j]) otherwise
 */
class Solution {
    List<String> temp=new ArrayList<>();
    List<List<String>> ans=new ArrayList<>();
    boolean[][] dp=null;
    int len;
    public List<List<String>> partition(String s) {
        len=s.length();
        dp=new boolean[len][len];
        for (int i = 0; i <len; i++) {
            // 单个字符本身就是字符串,i>j也表示空出串
            Arrays.fill(dp[i],true);
        }
        // 都是依赖左下角，所以左下角开始赋值
        for (int i = len-1; i>=0; i--) {
            // 只计算右上三角，因为当i>j时，说明已经是回文串了
            for (int j = i+1; j <len; j++) {
                // 初始化dp数组，将所有的回文子串标识出来
                dp[i][j]=dp[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
            }
        }
        dfs(s,0);
        return ans;
    }
    void dfs(String s,int i){
        if(i==len){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int j=i; j <len ; j++) {
            if(dp[i][j]){
                temp.add(s.substring(i,j+1));
                dfs(s,j+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="aab";
        List<List<String>> partition = solution.partition(s);
        for (List<String> list : partition) {
            for (String s1 : list) {
                System.out.print(s1+" ");
            }
            System.out.println();
        }
    }
}