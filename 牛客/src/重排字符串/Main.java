package 重排字符串;
/**
 * 7
 * aabbccc
 *
 * yes
 * cabcabc
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String str= sc.nextLine();
        StringBuilder sb = new StringBuilder("1");
        vis=new boolean[str.length()];

        dfs(str,sb,0);
        System.out.println(ans);
    }
    static boolean[] vis;
    static String ans="no";
    static Map<String,String> map=new HashMap<>();
    static void dfs(String str,StringBuilder sb,int count){
        if(!ans.equals("no")){
            return;
        }
        if(count==str.length()){
            System.out.println("yes");
            ans= sb.substring(1,sb.length());
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if(!vis[i]&&sb.charAt(sb.length()-1)!=str.charAt(i)){
                if(map.containsKey(sb+""+str.charAt(i))){
                    continue;
                }
                vis[i]=true;
                sb.append(str.charAt(i));
                map.put(sb.toString(),"");

                dfs(str, sb,count+1);
                vis[i]=false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}

/**
 * import java.util.Scanner;
 *
 * public class Main {
 *     public static void main(String[] args) {
 *         Scanner sc = new Scanner(System.in);
 *         sc.nextLine();
 *         String str= sc.nextLine();
 *         StringBuilder sb = new StringBuilder("1");
 *         vis=new boolean[str.length()];
 *
 *         dfs(str,sb,0);
 *         System.out.println(ans);
 *     }
 *     static boolean[] vis;
 *     static String ans="no";
 *     static void dfs(String str,StringBuilder sb,int count){
 *         if(!ans.equals("no")){
 *             return;
 *         }
 *         if(count==str.length()){
 *             System.out.println("yes");
 *             ans= sb.substring(1,sb.length());
 *             return;
 *         }
 *         for (int i = 0; i < str.length(); i++) {
 *         if(!ans.equals("no")){
 *             return;
 *         }
 *             if(!vis[i]&&sb.charAt(sb.length()-1)!=str.charAt(i)){
 *                 vis[i]=true;
 *                 sb.append(str.charAt(i));
 *                 dfs(str, sb,count+1);
 *                 vis[i]=false;
 *                 sb.deleteCharAt(sb.length()-1);
 *             }
 *         }
 *     }
 * }
 */