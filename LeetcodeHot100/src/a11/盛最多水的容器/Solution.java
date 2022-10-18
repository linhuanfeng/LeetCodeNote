package a11.盛最多水的容器;

/**
 * 容积=min(i,j)*(j-i)
 * <p>
 * 往内移动木板，宽度一定减少，
 * 若移动短板，高度可能增加，总容积可能变大
 * 若移动长版，高度不变或减少，总容积一定变小
 * 因此，移动短板才能找到最大值
 * <p>
 * 那么，如何证明移动短板不会错过最大值呢
 * 所有的组合为c(n,2),
 * 假设i为短板，移动i,也就是排除了所有的[i,i+1],...,[i,j-1],[i,j]
 * 而对于这些情况，高度小于等于[i,j],宽度小于等于[i,j],
 * 也就是都是小于等于当前容积，因此不会错过最大值
 *
 * 时间：O(n)
 * 空间：O(1)
 */
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                res = Math.max(res,height[left] * (right - left));
                left++;
            } else {
                res = Math.max(res,height[right] * (right - left));
                right--;
            }
        }
        return res;
    }
}