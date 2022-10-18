public class bruce {

    // ac 暴力解法O(n3)
    public static void main(String[] args) {
        MaxLenRepeatedSubarray test = new MaxLenRepeatedSubarray();
        int[] A={1,2,3};
        int[] B={3,1,2,3,4};
        System.out.println(test.findLength(A,B));
    }
    public int findLength(int[] nums1, int[] nums2) {
        int a1,a2,b1,b2;
        int max=0;
        for (a1 = 0; a1 < nums1.length; a1++) {
            a2=a1;
            for (b1 = 0; b1 < nums2.length; b1++) {
                b2=b1;
                while(true){
                    if(b2<nums2.length&&a2<nums1.length&&nums2[b2]==nums1[a2]){
                        b2++;
                        a2++;
                    }else{
                        if(b2-b1>max){
                            max=b2-b1;
                        }
                        a2=a1;// a2回退和下一个b2比较
                        break;
                    }
                }
            }
        }
        return max;
    }
}
