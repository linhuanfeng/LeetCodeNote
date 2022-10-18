package 剑指Offer38.字符串的排列;

import java.util.HashMap;
import java.util.Map;

/**
 * 此方法没有剪枝
 * 对于abb  ab只需要一次就行
 */
class Solution {
    int len=0;
    boolean[] vis=null;
    int[] ans=null;
    Map<String,String> map=null;
    public String[] permutation(String s) {
        len=s.length();
        vis=new boolean[len];
        ans=new int[len];
        map=new HashMap<>(len);
        dfs(s,0);
        String[] ans=new String[map.size()];
        int k=0;
        for (String value : map.values()) {
            ans[k++]=value;
        }
        return ans;
    }
    void dfs(String s,int cur){
        if(cur==len){
            //
            StringBuilder builder = new StringBuilder();
            for (int an : ans) {
                builder.append(s.charAt(an));
            }
            String s1 = builder.toString();
            if(map.get(s1)==null){
                map.put(s1,s1);
            }
            return;
        }
        for (int i = 0; i < len; i++) {
            if(!vis[i]){
                vis[i]=true;
                ans[cur]=i;
                dfs(s,cur+1);
                vis[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="abc";
        String[] permutation = solution.permutation(s);
        for (String s1 : permutation) {
            System.out.print(s1+" ");
        }
    }
}