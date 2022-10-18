package 子串括号的权值和;

/**
 * 题目描述
 * 定义一个括号串的权值为，它的最长合法括号子序列的长度。
 * 例如，"())())的权值是4，它的最长合法括号子序列为"()()”
 * 现在求一个给定括号串的所有子串权值之和。
 * 输入描述：
 * 一个仅包含'('和')'的字符串，长度不超过2e5。
 * 输出描述：
 * 所有子串的权值和。
 *
 * input:
 * (()())
 *
 * output:
 * 26
 *
 * 解释：
 * 权值为2的子串有2个
 * 权值为4的子串有2个
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 考虑每个括号的贡献值，**（）*，等于（左边的数目+1）*（右边的数目+1）
 * 那么权值为2即（）的字串有6个
 * 即
 * 1、**（）*
 * 2、*（）*
 * 3、（）*
 * 4、**（）
 * 5、*（）
 * 6、（）
 */
// 测试用例也过不了，不知道正确答案是什么
    // moon:
//https://blog.csdn.net/Creep_/article/details/126683997
//https://www.nowcoder.com/discuss/1039184
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Deque<Integer> stack=new LinkedList<>();
        int ans=0;

        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i)=='('){
                stack.addLast(i);
            }else if(!stack.isEmpty()){
                Integer last = stack.removeLast();
                ans+=2*(last+1)*(line.length()-i);
            }
        }
        System.out.println(ans);
    }
}
