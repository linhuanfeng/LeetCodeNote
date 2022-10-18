package p3问路;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),m = sc.nextInt(),q=0;
        Map<Integer, Set> map=new HashMap<>();
        int[] arr=new int[m];
        for (int i = 0; i < m; i++) {
            arr[i]=sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            Set set = map.getOrDefault(arr[i],new HashSet(n-1));
            set.add(sc.nextInt());
            map.put(arr[i],set);
        }
        q=sc.nextInt();
        for (int i = 0; i < q; i++) {
            Set set = map.get(sc.nextInt());
            if(set.contains(sc.nextInt())) System.out.println("Yes");
            else System.out.println("No");
        }
        sc.close();
    }
}
