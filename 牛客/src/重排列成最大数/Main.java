package 重排列成最大数;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序 （每个数不可拆分）使之组成一个最大的整数。
 * 输入：nums = [3,30,34,5,9] 输出：""9534330""
 * <p>
 * 采用快排，使用3+30和30+3拼接比较屏蔽了3和30的细节判断。比如31要排在3前面，3却要排在30前面
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {3, 30, 34, 5, 9}; // 注意得是对象数组，即Integer
        main.quickSort(nums, 0, nums.length - 1);

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        System.out.println(sb);
    }

    void quickSort(int[] nums, int left, int right) {
        int i = left, j = right, temp = nums[left];
        while (i < j) {
            while (i < j && (temp + "" + nums[j]).compareTo(nums[j] + "" + temp) >= 0) { // 3 1不需要移到
                j--;
            }
            if (i < j) { // 说明找到了才要进行替换
                nums[i] = nums[j];
                i++;
            }
            while (i < j && (temp + "" + nums[i]).compareTo(nums[i] + "" + temp) <= 0) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = temp;
        if (i + 1 < right) {
            quickSort(nums, i + 1, right);
        }
        if (i - 1 > left) {
            quickSort(nums, left, i - 1);
        }
    }
}
