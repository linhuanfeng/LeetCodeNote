package 剑指Offer38.字符串的排列;

import java.util.*;

/**
 * 采用交换的方式
 * 对于abb  ab只需要一次就行
 * 时间：全排列O(N!N) 全排列 n!,并且字符串拼接操作N
 * 空间：存储字符串set，n+(n-1)+(n-2)  所以(n+1)n/2
 */
class Solution2 {
    int len=0;
    List<String> ans=null;
    public String[] permutation(String s) {
        len=s.length();
        ans=new ArrayList<>();
        dfs(s.toCharArray(),0);
        return ans.toArray(new String[ans.size()]);
    }
    void dfs(char[] chars,int cur){
        if(cur==len){
            ans.add(new String(chars));
            return;
        }
        Set<Character> set=new HashSet<>();
        // 比如abb 如果当前位置已经放过b 那么下一个b就不能放了，需要剪枝
        for (int i = cur; i < len; i++) {
            if(set.contains(chars[i]))continue; // 剪枝
            set.add(chars[i]);
            swap(chars,i,cur);
            dfs(chars,cur+1);
            swap(chars,i,cur);
        }
    }
    void swap(char[] chars,int i,int j){
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String s="abc";
        String[] permutation = solution.permutation(s);
        for (String s1 : permutation) {
            System.out.print(s1+" ");
        }
    }
}