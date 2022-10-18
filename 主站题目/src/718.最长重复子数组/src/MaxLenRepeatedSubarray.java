import java.util.*;

public class MaxLenRepeatedSubarray {

    // ac 12 78
    public static void main(String[] args) {
        MaxLenRepeatedSubarray test = new MaxLenRepeatedSubarray();
//        int[] A={2,3,4,5};
//        int[] B={3,1,2,3,4};
//        int[] nums1={2,3,4,5};
//        int[] nums2={2,3,4,5,6};
//        int[] nums1={0,0,0,0,1};
//        int[] nums2={1,0,0,0,0};
        int[] nums1={1,2,3,2,1};
        int[] nums2={3,2,1,4,7};
        if (nums1.length<nums2.length){
            System.out.println(test.findLength(nums1,nums2));
        }else{
            System.out.println(test.findLength(nums2,nums1));
        }

    }
    public int getMax(int[] n1,int i,int[] n2,int j){
        int t=0;
        int max=0;
        int minLen=n1.length>n2.length?n2.length:n1.length;
        for (int k=0; k < minLen; k++) {
            if (i+k<n1.length&&j+k<n2.length&&n1[i+k]==n2[j+k]){
                t++;
            }else{
                if(t>max){
                    max=t;
                }
                t=0;
            }
        }
        if(t>max){
            max=t;
        }
        return max;
    }
    public int findLength(int[] nums1, int[] nums2) {
        int max=0;

        int t=0;
        for (int b1=nums2.length-1;b1>=0;b1--){
            int[] tArr=Arrays.copyOfRange(nums2,b1,nums2.length);
            int res=getMax(nums1,0,tArr,0);
            if(max<res){
                max=res;
            }
        }
        for (int b1=1;b1<nums1.length;b1++){
            int res=getMax(nums1,b1,nums2,0);
            if(max<res){
                max=res;
            }
        }
        return max;
    }
}
