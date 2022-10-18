package 堆排序;
/**
 * 大根堆：
 * 从第一个非叶子结点（n/2-1）开始遍历，和较大的子节点比较并交换，
 * 然后把该子节点的值赋值到父节点中，最后的位置才是目标结点位置
 */
public class HeapSort {
    public void heapSort(int[] nums) {
        // 1.构建大根堆，从第一个非叶子节点开始
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
        // 2. 把最大值和最后一个元素交换
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }

    // 调整成大根堆
    private void adjustHeap(int[] nums, int k, int len) {
        int temp = nums[k];
        for (int i = 2 * k + 1; i < len; i = i * 2 + 1) {
            if (i + 1 < len && nums[i + 1] > nums[i]) {
                // 找到较大的子节点
                i++;
            }
            if (nums[i] > temp) {
                nums[k] = nums[i]; // 较小的子结点上移
                k = i; // 递归子节点调整堆
            } else {
                break;
            }
        }
        nums[k] = temp; //放到最终的位置
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4, 8, 3, 10, 14};
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
