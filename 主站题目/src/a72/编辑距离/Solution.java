package a72.编辑距离;
/*

使用dp[i][j]表示word1的前i-1个字符和word2的前j-1个字符的最短编辑距离

状态转移：
if(word1[i-1]==word2[j-1])
    那么不需要编辑，dp[i][j]=dp[i-1][j-1]
else
    删除word1一个字符 dp[i][j]=dp[i-1][j]+1 即word1的前i-2个字符编辑距离加一
    删除word2一个字符 dp[i][j]=dp[i][j-1]+1
    增加字符和删除字符等价，增加word1(a)一个字符相当于字符，相当于word2(ab)删除一个字符

    修改字符，等于word1和word2的前i-2个字符的编辑距离加一，因为修改直接修改成一样 dp[i][j]=dp[i-1][j-1]+1

dp[i][j]=dp[i-1][j-1]                               word1[i-1]==word2[j-1]
         min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])+1  word1[i-1]!=word2[j-1]

赋值阶段是从左到右，从上到下

初始化：
    假设i=0表示word1为空字符串，那么dp[0][j]=j,即删除word2的字符数，同理dp[i][0]=i

      a b c
    0 1 2 3
  0 0 1 2 3
b 1 1 1 2 3

时间：O(nm)
空间：O(nm)
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length(),m=word2.length();
        int[][] dp=new int[n+1][m+1];

        // 初始化
        for (int i = 1; i <= n; i++) {
            dp[i][0]=i;
        }
        for (int j = 0; j <=m ; j++) {
            dp[0][j]=j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j])+1;
                }
            }
        }
        return dp[n][m];
    }
}