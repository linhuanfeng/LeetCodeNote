public class yaSuoDP {
    /*
    出现“已停止工作”的情况，编译成功，但无法运行
    应该把f[1<<21]挪到主函数外面做全局变量
    */
    public static void main(String[] args) {
        int[] f=new int[1<<21];
        int n, temp;
        int s, i;

        n=5;

        f[0] = 1;//边界条件
        for(s = 1; s <= (1<<n)-1; s++)
        {
            f[s] = 0;
            for(i = 1; i <= n; i++)
                if((s&(1<<(i-1)))>1)//排除掉第i行所有不能放置的位置之后的可放位置
                {
                    temp = s ^ (1<<(i-1));//可以得到s状态的状态
                    f[s] += f[temp];//s状态下的方案数
                }
        }
        System.out.println(f[(1<<n)-1]);
    }
}
