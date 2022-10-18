package 子串括号的权值和;

import java.util.*;

/**
 *
 */
// 通过0
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        dfs(str, 0, new StringBuilder());
        System.out.println(ans);
    }

    static long ans = 0;
    static Map<String, String> map = new HashMap<>();

    static void dfs(String str, int cur, StringBuilder sb) {
        String s = sb.toString();
        if (s.length() > 0 && !map.containsKey(s) && check(s)) {
            System.out.println(s);
            map.put(s, "");
            ans += sb.length();
        }
        if (cur == str.length()) {
            dfs(s, 0, new StringBuilder());
            return;
        }
        for (int i = cur; i < str.length(); i++) {
            sb.append(str.charAt(i));
            dfs(str, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static boolean check(String str) {
        Deque<Character> que = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                que.addLast('(');
            } else {
                if (que.isEmpty()) {
                    return false;
                }
                que.removeLast();
            }
        }
        if (que.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
