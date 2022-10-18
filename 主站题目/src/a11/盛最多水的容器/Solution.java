package a11.盛最多水的容器;

class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int res=0;
        while (i<j){
            if(height[i]<height[j]){
                res=Math.max(res,(j-i)*height[i]);
                i++;
            }else {
                res=Math.max(res,(j-i)*height[j]);
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height={1,1};
        System.out.println(solution.maxArea(height));
    }
}