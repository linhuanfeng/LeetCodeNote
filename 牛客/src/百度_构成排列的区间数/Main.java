package 百度_构成排列的区间数;

import java.io.IOException;
import java.util.*;

/**
 * 2
 * 5
 * 1 2 3 4 5
 * 5
 * 2 1 5 3 4
 *
 * 80就超时了
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int t;
        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        t= Integer.parseInt(br.readLine());
        t= sc.nextInt();
        for (int k = 0; k < t; k++) {
            int a=sc.nextInt();
//            int a = Integer.parseInt(br.readLine());
//            String[] split = Arrays.stream(br.readLine().split(" ")).toArray();
            int[] arr =new int[a];
            for (int i = 0; i < a; i++) {
//                arr[i]=Integer.valueOf(split[i]);
                arr[i]=sc.nextInt();
            }


            long res = 0;
            for (int i = 0; i < arr.length; i++) {
                Set<Integer> set = new HashSet<>();
                int max=-1;
                for (int j = i; j < arr.length; j++) {
                    if (set.contains(arr[j])) {
                        break;
                    }
                    set.add(arr[j]);
                    max=Math.max(max,arr[j]);
                    if ( max<= j - i+1&&set.size() == j - i + 1 && arr[j] <= j - i+1) {
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
