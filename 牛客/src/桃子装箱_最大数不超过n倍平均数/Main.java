package 桃子装箱_最大数不超过n倍平均数;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
/**
 * 题目描述：
 * 小昱家的桃园丰收了！小昱采摘下来n个桃子，并对这些桃子称重，其中第i个桃子的重量为ai。小昱想选择一些桃子装成一箱后送给朋友，但是小昱不希望一箱桃子中有一些太大的桃子而影响整体美观。于是他给装箱工人提出了一个要求：一箱桃子中最重的桃子重量不能超过平均重量的k倍。装箱工人想知道在满足小昱要求的情况下，一箱最多能装多少个桃子。
 *
 *
 *
 * 输入描述
 * 第一行输入两个正整数 n, k，表示桃子个数、倍数系数。
 *
 * 接下来一行输入n个正整数a1, a2,...... an，其中ai表示第 i 个桃子的重量。
 *
 *
 * 1 ≤ n, k ≤ 100000, 1≤ ai ≤ 109
 *
 * 输出描述
 * 输出一个整数，表示一箱最多能装桃子数量。
 *
 *
 * 样例输入
 * 5 2
 * 3 10 5 4 2
 * 样例输出
 * 4
 *
 * 提示
 * 可以将第1、3、4、5个桃子装成一箱，桃子平均重量为(3 + 5 + 4 + 2) / 4 = 3.5，最重的桃子重量为5，不超过平均重量的两倍，是一种可行方案。
 *
 * 如果将所有桃子装成一箱，桃子平均重量为(3 + 10 + 5 + 4 + 2) / 5 = 4.8，最重桃子的重量为10，超过平均重量的两倍了，故一箱不能装5个桃子。
 */

/**
 * 暴力枚举所有的情况
 */
// 82
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n=Integer.valueOf(s[0]),k=Integer.valueOf(s[1]);
        int[] arr=new int[n];
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.valueOf(s[i]);
        }
        dfs(arr,0,new LinkedList<>(),k);
        System.out.println(max);
    }
    static int max=0;
    static void dfs(int[] arr,int cur,List<Integer> list,int k){
        if(cur==arr.length){
//            System.out.println(list);
            if(list.size()>max&&check(list,k)){
                max=list.size();
            }
            return;
        }
        for (int i = cur; i < arr.length; i++) {
            if(arr.length-i+ list.size()<=max){
                break;
            }
            list.add(arr[i]);
            dfs(arr, i+1, list,k);
            list.remove(list.size()-1);
        }
    }
    static boolean check(List<Integer> list, int k){
        int max=0;
        double avg=0;
        for (Integer integer : list) {
            max=Math.max(integer,max);
            avg+=(integer*1.0/ list.size());
        }
        if(max>avg*k){
            return false;
        }else {
            return true;
        }
    }
}
