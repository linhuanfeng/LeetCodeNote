package 最大公约数和最小公倍数;
// 求最大公约数：m*n=最大公约数*最小公倍数
public class Gcd {
    // 辗转相除法递归
    public int gcd1(int m,int n){
        while (n!=0){
            int remainder=m%n;
            m=n;
            n=remainder;
        }
        return m;
    }
    // 辗转相除法迭代
    public int gcd2(int m,int n){
        if(n==0)
            return m;
        return gcd2(n,m%n);
    }

    // 辗转相减法
    public int gcd3(int m,int n){
        while(m!=n){
            if(m>n){
                m=m-n;
            }
            else{
                n=n-m;
            }
        }
	    return m;
    }

    public static void main(String[] args) {
        Gcd gcd = new Gcd();
        int m=6,n=15;
        System.out.println("最大公约数："+gcd.gcd1(m,n)+" 最小公倍数："+m*n/gcd.gcd1(m,n));
        System.out.println("最大公约数："+gcd.gcd2(m,n)+" 最小公倍数："+m*n/gcd.gcd1(m,n));
        System.out.println("最大公约数："+gcd.gcd3(m,n)+" 最小公倍数："+m*n/gcd.gcd1(m,n));
    }
}
