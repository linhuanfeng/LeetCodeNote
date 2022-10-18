package 字节训练营.旋转数组查找;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        int target=next.charAt(next.length()-1)-'0';
        next=next.substring(1,next.length()-4);
        String[] split = next.split(",");
        int[] nums=new int[split.length];
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            nums[i]=Integer.valueOf(split[i]);
        }
        // 找到旋转点
        int i=0,j=len-1;
        while (i<j){
            int mid=(i+j)/2;
            if(nums[mid]==target){
                System.out.println(true);
                return;
            }else if(nums[mid]>target){
                if(mid-1>=0&&nums[mid-1]>nums[mid]){
                    //不存在
                    System.out.println(false);
                    return;
                }else {
                    j=mid-1;
                }
            }else {
                if(mid+1<len&&nums[mid+1]>nums[mid]){
                    i=mid+1;
                }else {
                    j=mid-1;
                }
            }
        }
        System.out.println(false);
    }
}
