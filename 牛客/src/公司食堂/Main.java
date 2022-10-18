package 公司食堂;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 超时8/12
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.valueOf(br.readLine()); // 座位个数
            String table = br.readLine(); // 座位落座情况
            int m = Integer.valueOf(br.readLine()); // 人数
            String people = br.readLine(); // 排队的人

            int[] tableCount = new int[table.length()];
            for (int j = 0; j < table.length(); j++) {
                tableCount[j] = table.charAt(j) - '0';
            }

            int[] ans = new int[m];
            for (int a = 0; a < m; a++) {
                if (people.charAt(a) == 'M') {
                    int first0 = -1, tag = 0;
                    for (int b = 0; b < n; b++) {
                        if (first0 == -1 && tableCount[b] == 0) {
                            first0 = b; //  记录第一桌空位的
                        }
                        if (tableCount[b] == 1) {
                            tag = 1;
                            tableCount[b] = 2;
                            ans[a] = b + 1;
                            break;
                        }
                    }
                    if (tag == 0) {
                        tableCount[first0] = 1;
                        ans[a] = first0 + 1;
                    }
                } else {
                    int first1 = -1, tag = 0;
                    for (int b = 0; b < n; b++) {
                        if (first1 == -1 && tableCount[b] == 1) {
                            first1 = b; //  记录第一桌一个位的
                        }
                        if (tableCount[b] == 0) {
                            tag = 1;
                            tableCount[b] = 1;
                            ans[a] = b + 1;
                            break;
                        }
                    }
                    if (tag == 0) {
                        tableCount[first1] = 2;
                        ans[a] = first1 + 1;
                    }
                }
            }
            for (int an : ans) {
                System.out.println(an);
            }
        }
    }
}