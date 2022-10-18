package 分饼干;

import java.util.Scanner;

/**
 *链接：https://www.nowcoder.com/questionTerminal/01158aa3d35841e9a7dd0e63f20f4838
 * 来源：牛客网
 *
 * 幼儿园老师想给她班上的孩子分饼干。所有的孩子都坐在一条线上，每个孩子都根据在课堂上的表现得到评分。
 * 老师必须给每个孩子至少1个饼干。如果两个孩子坐在一起，那么评分较高的孩子必须得到更多的饼干(孩子必须左右都比较)。
 * 输出老师购买的饼干总数的最小值。例如，假设她的学生的评分为[3,6,3,5,6,2]。她给学生饼干的数量如下：[1,2,1,2,3,1]。
 * 她必须购买至少10个饼干。
 *
 * 输入描述:
 * 假设学生评分为：[1,2,3],则输入应为：
 * 3
 * 1
 * 2
 * 3
 * 第1行为数组元素大小，2至n+1行为数组元素（每行一个）
 *
 * 输出描述:
 * 可分配最小值
 * 示例1
 * 输入
 * 6
 * 3
 * 6
 * 3
 * 5
 * 6
 * 2
 * 输出
 * 10
 * 说明
 * 孩子数量为6（第一个数），所以饼干数位  1+2+1+2+3+1=10
 *
 * 两次遍历：
 *  第一次就跟左边进行比较，保证权值大于左边的时候糖果要更多
 *  第二次就跟右边进行比较，只要大于右边的糖果就不用修改，保证糖果最少
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=sc.nextInt(),ans=0;
        int[] score=new int[count],arr=new int[count];
        for(int i=0;i<count;i++){
            score[i]=sc.nextInt();
            arr[i]=1;
        }
        for(int i=1;i<count;i++){
            if(score[i]>score[i-1]){ // 最小程度保证分值高的饼干要多
                arr[i]=arr[i-1]+1;
            }
        }
        for(int i=count-2;i>=0;i--){
            if(score[i]>score[i+1]
                    &&arr[i]<=arr[i+1]){ // 只要大于右边的数就可以了，不能再修改为arr[i+1]+1,因为可能会导致左边不满足条件
                arr[i]=arr[i+1]+1;
            }
        }
        for (int i : arr) {
            ans+=i;
        }
        System.out.println(ans);
    }
}
