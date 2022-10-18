package a287.寻找重复数;

/**
 * 本质是一个找带环链表的入口
 * 如果转为链表，比如{1，3，2，2}
 * 0->1
 * 1->3
 * 3->2
 * 2->2 环入口为2
 *
 * 如何找到环的入口？(计开头到环入口a,环的长度为b)
 * 首先找到相遇的地点，利用快慢指针，如何存在环，那么快指针一定会追上慢指针的，
 * 此时f=2s且f=s+nb
 * =>s=nb,
 * 易知a+nb就能够到达环入口，于是s+a就能到环的入口，那里到环入口距离为a,答案是head!此时再双指针即可：slow和head指针
 *
 * 总结：快慢指针+双指针
 *
 * 时间：O(n):慢指针路程a+nb
 * 空间：O(1)
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0,fast=0;
        // 快慢指针找到相遇地点
        do{ // 防止第一次就跳出循环了
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        // 找到环入口 f=s+nb,f=2s,=>s=nb,又环入口：a+nb  =>a+s即可到达环入口，那么再用一次双指针
        fast=0;
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}