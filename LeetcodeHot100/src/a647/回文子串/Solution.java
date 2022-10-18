package a647.回文子串;

/**
 * O（n^3） 外层两层循环n^2，判断回文 li-ri也是 n
 */
class Solution {
    public int countSubstrings(String s) {
        int ans=0;
        for (int i = 0; i <s.length() ; i++) {
            for (int j = i; j <s.length() ; j++) {
                if(isHuiWen(s,i,j)){
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isHuiWen(String s,int i,int j) {
        while (i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("aba"));
    }
}