public class MaxLenRepeatedSubarray2 {

    // ac 5 97
    public static void main(String[] args) {
        MaxLenRepeatedSubarray2 test = new MaxLenRepeatedSubarray2();
        int[] nums1={1,2,3,2,1};
        int[] nums2={3,2,1,4,7,11,13,123,12,123};
        if (nums1.length<nums2.length){
            System.out.println(test.findLength(nums1,nums2));
        }else{
            System.out.println(test.findLength(nums2,nums1));
        }

    }
    public int getMax(int[] n1,int i,int[] n2,int j,int len){
        int t=0;
        int max=0;
        for (int k=0; k < len; k++) {
            if (n1[i+k]==n2[j+k]){
                t++;
            }else if(t>0){
                //进入到这个if判断体里面，说明当前 nums1[i+k]!=nums2[j+k],即之前的公共子数组不再连续，
                // 所以要记录最大值，同时将count置零
                max=Math.max(max,t);
                t=0;
            }
        }
        /**
         1，count>0,说明有公共子数组是以nums1[i+len-1],nums2[j+len-1]结尾的，
         上面最后一步for循环没有进入到else if判断题里面，所以最终结果要取当前count和res的最大值
         2，count=0，说明res已经更新过了，res即为最终结果
         */
        return t>0?Math.max(max,t):max;
    }
    public int findLength(int[] nums1, int[] nums2) {
        int max=0;
        int m=nums1.length,n=nums2.length;
        /**
         nums1,nums2中较短的数组不动，这里默认nums1，较长的数组滑动
         初始位置：nums2右边界挨着nums1左边界，nums2从左往右滑动
         */
        // 第一阶段：nums2从左往右滑动，两数组重合部分长度不断增加，重合部分长度len从1开始增加
        // 重合部分：nums1起点下标0，nums2起点下标n-len，
        for (int i=1;i<=m;i++){
            max=Math.max(max,getMax(nums1,0,nums2,n-i,i));
        }
        // 第二阶段：nums2从左往右滑动，两数组重合部分长度不变，重合部分长度始终为nums1长度m
        //  重合部分：nums1起点下标0，nums2起点下标n-m，然后递减
        for (int j = n-m; j>=0; j--) {
            max=Math.max(max,getMax(nums1,0,nums2,j,m));
        }
        // 第三阶段：nums2从左往右滑动，两数组重合部分长度递减，重合部分长度始终为nums1长度m-i
        //  重合部分：nums1起点下标i，递增，nums2起点下标0
        for (int i=1;i<m;i++){
            max=Math.max(max,getMax(nums1,i,nums2,0,m-i));
        }
        return max;
    }
}
