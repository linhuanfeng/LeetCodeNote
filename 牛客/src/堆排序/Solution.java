package 堆排序;

import java.util.regex.Pattern;

public class Solution {
    void heapSort(int[] arr) {
        for (int i = arr.length - 1; i >= 1; i--) {
            doSort(arr, i);
            swap(arr, 0, i);
        }
    }

    // 大根堆调整
    /**
     * 找到最小的非叶子结点，和较大的左孩子进行比较，
     * 如果当前结点小于较大孩子结点，则进行交换，并使用较大孩子结点作为新的当前结点
     * 否则当前子树堆化成功
     * @param arr
     * @param n
     */
    void doSort(int[] arr, int n) {
        for (int j = (n - 1) / 2; j >= 0; j--) {
            int idx = j, left = 2 * idx + 1, right = left + 1, larger = left;
            while (left <= n) {
                // 较大的子节点
                if (right <= n && arr[right] > arr[left]) {
                    larger = right;
                }
                if (arr[larger] > arr[idx]) {
                    swap(arr, larger, idx);
                    idx = larger;
                    left = 2 * idx + 1;
                    right = left + 1;
                } else {
                    break;
                }
            }
        }
    }

    void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr={1,7,3,2};
        solution.heapSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
        Pattern.compile("s");
    }
}
