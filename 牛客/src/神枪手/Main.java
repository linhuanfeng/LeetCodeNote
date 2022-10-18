package 神枪手;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.valueOf(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] scores=new int[split.length];
        long ans=0;
        for (int i = 0; i < split.length; i++) {
            scores[i]=Integer.valueOf(split[i]);
            ans+=scores[i];
        }


        for (int i = 0; i < n; i++) {
            for (int j =i +1; j < n; j++) {
                ans+=scores[i]|scores[j];
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
