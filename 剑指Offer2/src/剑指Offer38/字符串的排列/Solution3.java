package 剑指Offer38.字符串的排列;

import java.util.HashSet;
import java.util.Set;

/**
 * 尝试使用set去重
 * 时间复杂度：O(n*n!) n为字符串长度，全排列需要n!，每个字符串都需要O(n)时间去生成
 * 空间复杂度：O(n) 需要O(n)去回溯，注意返回值大小不占用空间复杂度
 *
 */
public class Solution3 {
    public String[] permutation(String s) {
        dfs(s,new StringBuilder(),new boolean[s.length()]);
        return set.toArray(new String[0]);
    }
    Set<String> set=new HashSet<>();
    void dfs(String s,StringBuilder sb,boolean[] vis){
        if(sb.length()==s.length()){
            String str = sb.toString();
            if(!set.contains(str)){
                set.add(str);
            }
            return;
        }
        for (int j = 0; j < s.length(); j++) {
            if(!vis[j]){
                vis[j]=true;
                sb.append(s.charAt(j));
                dfs(s, sb, vis);
                sb.deleteCharAt(sb.length()-1);
                vis[j]=false;
            }
        }
    }
}
