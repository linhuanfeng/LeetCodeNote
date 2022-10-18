public class ClosestDivisors {
    public static void main(String[] args) {
        int[] divisors = closestDivisors(123);
        for (int divisor : divisors) {
            System.out.print(divisor+" ");
        }
    }
    public static int[] closestDivisors(int num) {
        // 以较大数 n2 = num + 2的平方根开始，递减找到最接近的小因数，
        int divisor=(int)Math.sqrt(num+2);
        int n2=num==1?num+1:num+2;
        /**
         * 设num=8
         * 若（num+2）%i=1则(num+1)%i=0
         * 当然(num+2)%i=0也符合条件
         * 当然越接近根号num的值最符合条件
         */
        while(n2%divisor>1){
            divisor--;// 往小减时间复杂度低很多
        }
        return new int[]{divisor,n2/divisor};// 当（num+2）%i==1时，当且仅当num！=1，(num+2)%i=(num+1)%i,结果为(num+2)/i
                                             // 当（num+2）%i==0时，结果为（num+2）/i
    }
}
