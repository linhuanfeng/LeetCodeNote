package 百度_构成排列的区间数;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 2
 * 5
 * 1 2 3 4 5
 * 5
 * 2 1 5 3 4
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        int t;
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t= Integer.parseInt(br.readLine());
//        t= sc.nextInt();
        for (int k = 0; k < t; k++) {
//            int a=sc.nextInt();
            int a = Integer.parseInt(br.readLine());
            String[] arr =br.readLine().split(" ");
//            int[] arr =new int[a];
//            for (int i = 0; i < a; i++) {
////                arr[i]=Integer.valueOf(split[i]);
//                arr[i]=sc.nextInt();
//            }


            long res = 0;
            for (int i = 0; i < arr.length; i++) {
                Set<Integer> set = new HashSet<>();
                int max=-1;
                for (int j = i; j < arr.length; j++) {
                    int temp=Integer.valueOf(arr[j]);
                    if (set.contains(temp)) {
                        break;
                    }
                    set.add(temp);
                    max=Math.max(max,temp);
                    if ( max<= j - i+1&&set.size() == j - i + 1 && temp <= j - i+1) {
                        res++;
                    }
                }
            }
            bw.write(res+"");
            bw.flush();
//            System.out.println(res);
        }
    }
}
