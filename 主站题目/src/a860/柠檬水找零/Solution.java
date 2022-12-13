package a860.柠檬水找零;

/**
 *
 * 贪心，每次先用10的去抵消，不行再用5，因为5可以组成10，即5的用途更多
 * bills[i] 不是 5 就是 10 或是 20
 *
 * 注意都是排队的，不能打乱顺序
 *
 * 时间：O（n）
 * 空间：O(1)
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int a=0,b=0; // 记录直到当前5和10剩余的容量
        for (int bill : bills) { // 只能按顺序，
            if(bill==5){
                a++;
            } else if (bill==10) {
                b++;
                if(a<1){
                    return false;
                }
                a--; // 消耗一张5
            }else {
                if(a<1){
                    return false;
                }
                a--; // 一定要消耗一张5，剩下10
                if(b>0){
                    b--; // 优先消耗一张10
                }else {
                    if(a<2){
                        return false; // 不够两张5
                    }
                    a=a-2;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lemonadeChange(
                new int[]{5, 5, 5, 5, 20, 20, 5, 5, 5, 5}
        ));
    }
}