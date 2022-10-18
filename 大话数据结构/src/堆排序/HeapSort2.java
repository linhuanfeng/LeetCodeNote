package 堆排序;

/**
 * 大根堆：
 * 从第一个非叶子结点（n/2-1）开始遍历，和较大的子节点比较并交换，
 * 然后把该子节点作为新的父节点递归
 */
public class HeapSort2 {
    public void doHSort(int[] nums) {
        for (int i = nums.length; i > 1; i--) {
            build(nums, i);
            swap(nums, 0, i - 1);
        }
    }

    // 构造小根堆
    public void build(int[] nums, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            int parent = i; // 当前i作为父节点
            for (int k = 2 * parent + 1; k < length; k = k * 2 + 1) { // 递归和较小的子结点交换
                if (k + 1 < length && nums[k + 1] < nums[k]) {
                    k++; // 找到较小的子节点
                }
                if (nums[parent] > nums[k]) {
                    swap(nums, parent, k); // 子节点小于父节点，进行交换
                    parent = k; // 以子节点作为父节点，遍历下一颗子树
                } else {
                    break; // 子节点也满足小根堆，递归结束
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        HeapSort2 heapSort = new HeapSort2();
        int[] nums = {4, 3, 7, 6, 9, 2, 4, 1, 2, 23};
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        heapSort.doHSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
