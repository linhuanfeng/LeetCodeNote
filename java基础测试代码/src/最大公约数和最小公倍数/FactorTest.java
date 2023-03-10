package 最大公约数和最小公倍数;
 
import org.junit.Before;
import org.junit.Test;
 
import java.util.ArrayList;
import java.util.List;
 
public class FactorTest {
 
    /**
     * 最大公约数和最小公倍数：两个自然数的最大公约数与它们的最小公倍数的乘积等于这两个数的乘积
     *     质因数分解法：
     *         把每个数分别分解质因数，再把各数中的全部公有质因数提取出来连乘，所得的积就是这几个数的最大公约数
     *             例如：求24和60的最大公约数，先分解质因数，得24=2×2×2×3，60=2×2×3×5，24与60的全部公有的质因数是2、2、3，它们的积是2×2×3=12，所以，（24，60）=12
     *         把几个数先分别分解质因数，再把各数中的全部公有的质因数和独有的质因数提取出来连乘，所得的积就是这几个数的最小公倍数
     *             例如：求6和15的最小公倍数。先分解质因数，得6=2×3，15=3×5，6和15的全部公有的质因数是3，6独有质因数是2，15独有的质因数是5，2×3×5=30，
     *                  30里面包含6的全部质因数2和3，还包含了15的全部质因数3和5，且30是6和15的公倍数中最小的一个，所以[6，15]=30
     *
     *     短除法：
     *         短除法求最大公约数，先用这几个数的公约数连续去除，一直除到所有的商互质为止，然后把所有的除数连乘起来，所得的积就是这几个数的最大公约数
     *         求最大公因数便乘一边，求最小公倍数便乘一圈。
     *         短除法的本质就是质因数分解法，只是将质因数分解用短除符号来进行
     *         短除符号就是除号倒过来。短除就是在除法中写除数的地方写两个数共有的质因数，然后落下两个数被公有质因数整除的商，之后再除，以此类推，直到结果互质为止（两个数互质）。
     *         而在用短除计算多个数时，对其中任意两个数存在的因数都要算出，其它没有这个因数的数则原样落下。直到剩下每两个都是互质关系。
     *         无论是短除法，还是分解质因数法，在质因数较大时，都会觉得困难。这时就需要用新的方法
     *
     *     辗转相除法：求两个自然数的最大公约数的一种方法，也叫欧几里德算法
     *         377 ÷ 319 =1...58
     *         319 ÷ 58  =5...29
     *         58  ÷ 29  =2   ∴（319，377）=29
     *         用辗转相除法求几个数的最大公约数，可以先求出其中任意两个数的最大公约数，再求这个最大公约数与第三个数的最大公约数，依次求下去，直到最后一个数为止。
     *         最后所得的那个最大公约数，就是所有这些数的最大公约数
     *
     *     更相减损法：
     *         第一步：任意给定两个正整数；判断它们是否都是偶数。若是，则用2约简；若不是则执行第二步。
     *         第二步：以较大的数减较小的数，接着把所得的差与较小的数比较，并以大数减小数。继续这个操作，直到所得的减数和差相等为止。
     *         则第一步中约掉的若干个2与第二步中等数的乘积就是所求的最大公约数
     *         其中所说的“等数”，就是最大公约数。求“等数”的办法是“更相减损”法。所以更相减损法也叫等值算法。
     *
     */
 
    @Test
    public void method1() {
        System.out.println("质因数分解法：\n" +
                "        把每个数分别分解质因数，再把各数中的全部公有质因数提取出来连乘，所得的积就是这几个数的最大公约数\n" +
                "            例如：求24和60的最大公约数，先分解质因数，得24=2×2×2×3，60=2×2×3×5，24与60的全部公有的质因数是2、2、3，它们的积是2×2×3=12，所以，（24，60）=12\n" +
                "        把几个数先分别分解质因数，再把各数中的全部公有的质因数和独有的质因数提取出来连乘，所得的积就是这几个数的最小公倍数\n" +
                "            例如：求6和15的最小公倍数。先分解质因数，得6=2×3，15=3×5，6和15的全部公有的质因数是3，6独有质因数是2，15独有的质因数是5，2×3×5=30，\n" +
                "                 30里面包含6的全部质因数2和3，还包含了15的全部质因数3和5，且30是6和15的公倍数中最小的一个，所以[6，15]=30");
        int a = 60, b = 30;
        List<Integer> a1 = getPrimeFactors(a);
        List<Integer> b1 = getPrimeFactors(b);
 
        //得到他们的公有质因数：
        //求积
        a1.retainAll(b1); // 保留a1中出现在b1中的数
        int max = 1, min = 1;
        for (Integer x : a1) {
            if (b1.contains(x)) {
                b1.remove(x);
                max *= x;
            } else {
                min *= x;
            }
 
        }
 
        System.out.println("最大公因数：" + max);
 
/*        int quadrature2 = gcd;
        for (Integer x : a1) {
            if (!commonFactorList.contains(x)) {
                quadrature2 *= x;
            }
        }
        for (Integer x : b1) {
            if (!commonFactorList.contains(x)) {
                quadrature2 *= x;
            }
        }*/
 
        System.out.println("最小公倍数：" + min);
    }
 
    /**
     * @param num
     * @return 存储质因子序列的数组
     * @描述 返回一个数的质因子序列, 这里不考虑 1
     */
    private List<Integer> getPrimeFactors(int num) {
        List<Integer> factorList = new ArrayList<>();
 
        num = Math.abs(num);
        int i = 2;
        int k = 2;
        while (num >= k) {
            if (num == k) {
                factorList.add(k);
                break;
            } else if (num % k == 0) {
                factorList.add(k);
                num = num / k;
            } else {
                k++;
            }
        }
 
        /*int start = 2;
        while (start < num) {
            if (num % start == 0) {
                factorList.add(start);
                num /= start;
            //    start = 2;
            } else {
                start++;
            }
        }
        factorList.add(num);    //*/
        return factorList;
    }
 
 
    @Test
    public void method2() {
        System.out.println("短除法：\n" +
                "        短除法求最大公约数，先用这几个数的公约数连续去除，一直除到所有的商互质为止，然后把所有的除数连乘起来，所得的积就是这几个数的最大公约数\n" +
                "        求最大公因数便乘一边，求最小公倍数便乘一圈。\n" +
                "        短除法的本质就是质因数分解法，只是将质因数分解用短除符号来进行\n" +
                "        短除符号就是除号倒过来。短除就是在除法中写除数的地方写两个数共有的质因数，然后落下两个数被公有质因数整除的商，之后再除，以此类推，直到结果互质为止（两个数互质）。\n" +
                "        而在用短除计算多个数时，对其中任意两个数存在的因数都要算出，其它没有这个因数的数则原样落下。直到剩下每两个都是互质关系。\n" +
                "        无论是短除法，还是分解质因数法，在质因数较大时，都会觉得困难。这时就需要用新的方法");
        int a = 24, b = 240;
        int gcd = 1;
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                gcd *= i;
                a = a / i;
                b = b / i;
                i--;
            }
        }
        System.out.println("最大公因数：" + gcd);
        System.out.println("最小公倍数：" + (gcd * a * b));
    }
 
    @Test
    public void method3() {
        System.out.println("辗转相除法：求两个自然数的最大公约数的一种方法，也叫欧几里德算法\n" +
                "        377 ÷ 319 =1...58\n" +
                "        319 ÷ 58  =5...29\n" +
                "        58  ÷ 29  =2   ∴（319，377）=29\n" +
                "        用辗转相除法求几个数的最大公约数，可以先求出其中任意两个数的最大公约数，再求这个最大公约数与第三个数的最大公约数，依次求下去，直到最后一个数为止。\n" +
                "        最后所得的那个最大公约数，就是所有这些数的最大公约数");
        int a = 60, b = 24;
        int quadrature = a * b;
        int gcd = 1, remainder;
        for (; ; ) {
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            remainder = max % min;
            if (remainder == 0) {
                gcd = min;
                break;
            }
            a = min;
            b = remainder;
        }
        System.out.println("最大公因数：" + gcd);
        System.out.println("最小公倍数：" + (quadrature / gcd));
    }
 
    /**
     * 辗转相除法（欧几里得算法）
     * 思路：取两个数中最大的数做除数，较小的数做被除数，用最大的数除较小数，
     * 如果余数为0，则较小数为这两个数的最大公约数，
     * 如果余数不为0，用较小数除上一步计算出的余数，直到余数为0，则这两个数的最大公约数为上一步的余数。
     * 1、递归
     *
     * @param a
     * @param b
     * @return
     */
    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
 
    /**
     * 辗转相除法（欧几里得算法）
     * 2、非递归形式
     *
     * @param a
     * @param b
     * @return
     */
    private static int gcd2(int a, int b) {
        int rem = 0;
        while (b != 0) {
            rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
 
    @Test
    public void method4() {
        System.out.println("更相减损法：\n" +
                "        第一步：任意给定两个正整数；判断它们是否都是偶数。若是，则用2约简；若不是则执行第二步。\n" +
                "        第二步：以较大的数减较小的数，接着把所得的差与较小的数比较，并以大数减小数。继续这个操作，直到所得的减数和差相等为止。\n" +
                "        则第一步中约掉的若干个2与第二步中等数的乘积就是所求的最大公约数\n" +
                "        其中所说的“等数”，就是最大公约数。求“等数”的办法是“更相减损”法。所以更相减损法也叫等值算法");
        int a = 60, b = 24;
        int quadrature = a * b;
        int gcd = 1;
        while ((a & 1) == 0 && (b & 1) == 0) {  //如果a和b都是偶数
            gcd = gcd << 1;
            a = a >> 1;
            b = b >> 1;
        }
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        gcd *= a;
        System.out.println("最大公因数：" + gcd);
        System.out.println("最小公倍数：" + (quadrature / gcd));
    }
 
}