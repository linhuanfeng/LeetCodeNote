package 软通杯.第五题;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        //翻转被减数和减数,从低位开始计算
        char[] numA = new StringBuilder(scan.next()).reverse().toString().toCharArray();
        char[] numB = new StringBuilder(scan.next()).reverse().toString().toCharArray();
        int[] result = new int[numA.length];
        for (int i = 0; i < result.length; i++) {
            int intA = i < numA.length ? numA[i] - '0' : 0;
            int intB = i < numB.length ? numB[i] - '0' : 0;
            result[i] = intA - intB;
        }
        //借位逻辑如果结果指针中存在负数,说明该位置向前借位了,处理借位
        for (int i = 0; i < result.length; i++) {
            if (result[i] < 0) {
                result[i + 1] -= 1;
                result[i] += 10;
            }
        }
        StringBuilder sbr = new StringBuilder();
        boolean bool = true;
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] == 0 && bool) {
                bool = false;
                continue;
            }
            sbr.append(result[i]);
        }
        System.out.println(sbr);
        scan.close();
    }
}
