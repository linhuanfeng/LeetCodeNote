package 百度_代码算for循环的次数_堆;

import java.io.*;
import java.util.LinkedList;
// 20

/*
注意以字符为单位，以行为单位容易错；我可能就是错在以行为单位去计算了

import sys

lines = list(sys.stdin.readlines())
a = ''.join(lines)
stack = []
n = len(a)
ans = 0
cnt = 0

pf = 0  # 前一个是不是for
i = 0
while i < n - 4:
    if a[i] == '{':
        stack.append(pf)
        cnt += pf
        pf = 0
        i += 1
    elif a[i] == 'f' and a[i + 1] == 'o' and a[i + 2] == 'r':
        pf = 1
        i += 3
    elif a[i] == '}':
        cnt -= stack.pop()
        i += 1
    else:
        i += 1

    ans = max(ans, cnt)

print(ans)
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0, max = 0, cur = 0;

        LinkedList<String> stack = new LinkedList<>();

        while (true) { // 去掉开头的impor等，保证从“Class{”开始
            String line = br.readLine();
            if (line.indexOf("{") != -1) {
                sum++;
                stack.addLast("{");
                break;
            }
        }

        while (true) {
            String line = br.readLine();
            int left = line.indexOf("{"), right = line.indexOf("}");
            if (left != -1) { // 实现代码输入完成退出循环
                sum++;
            } else if (right != -1) {
                sum--;
            }
            if (line.indexOf("for") != -1) {
                stack.addLast("for");
                stack.addLast("{");
                cur++;
                max = Math.max(max, cur);
            } else {
                if (right != -1) {
                    stack.removeLast();
                    if (!stack.isEmpty() && stack.getLast().equals("for")) { // 去掉同层级的for去掉
                        stack.removeLast();// 去掉for
                        cur--;
                    }
                } else if (left != -1) {
                    stack.addLast("{");
                }
            }

            if (sum == 0) {
                break;
            }
        }
        bw.write(max+"");
        bw.flush();
    }
}

