package 加k让每个元素都不一样;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
1 2 3 3 4

 */
// 20
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.valueOf(split[0]), k = Integer.valueOf(split[1]);
        String[] split1 = br.readLine().split(" ");
        int[] arr =new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.valueOf(split1[i]);
        }
        Arrays.sort(arr);
        int ans=0;
        Map<Integer,String> map=new HashMap<>();

        for (int i :arr) {
            if(map.containsKey(i)){
                int j=i+k;
                while (true){
                    ans++;
                    if(!map.containsKey(j)){
                        map.put(j,"");
                        break;
                    }
                    j+=k;
                }
            }else {
                map.put(i,"");
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(ans+"");
        bw.flush();
    }
}
