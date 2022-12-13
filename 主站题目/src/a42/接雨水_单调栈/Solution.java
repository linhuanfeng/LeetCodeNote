package a42.接雨水_单调栈;

/**
 * 动态规划
 * leftMax[i]表示i左边的最大高度,rightMax[i]表示i右边的最大高度
 * 因此i能乘的容量为min(leftMax[i],rightMax[i])*height[i]
 *
 * 时间：O(n)
 * 空间：O(n)
 */
class Solution {
    public int trap(int[] height) {
        int n=height.length,ans=0;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];

        leftMax[0]=height[0];
        rightMax[n-1]=height[n-1];
        for (int i = 1; i < n; i++) {
            leftMax[i]=Math.max(height[i],leftMax[i-1]);
        }
        for (int i = n-2; i >=0; i--) {
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
        }
        for (int i = 0; i < n; i++) {
            ans+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return ans;
    }
}