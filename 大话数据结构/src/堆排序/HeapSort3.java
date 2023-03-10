package 堆排序;

/**
 * 时间：O(nlogn)
 * 空间：O(1)
 */
public class HeapSort3 {
    void heapSort(int[] arr) {
        for (int n = arr.length; n > 1; n--) {
            for (int i = n / 2 - 1; i >= 0; i--) {
                adjust(arr, i, n); // 从最后一个非叶子节点开始递归调整
            }
            int temp = arr[0]; // 将最小值移到队尾
            arr[0] = arr[n-1];
            arr[n-1] = temp;
        }
    }

    /**
     * 构建小根堆
     *
     * @param arr
     * @param i   当前节点
     * @param len 堆的长度
     */
    void adjust(int[] arr, int i, int len) {
        int temp = arr[i]; // 保存当前节点值
        for (int j = i * 2 + 1; j < len; j = i * 2 + 1) { // 遍历子节点
            if (j + 1 < len && arr[j + 1] < arr[j])
                j++; // 找到较小的子节点
            if (arr[j] < temp) { // 和较小的子节点交换或者说较小的节点往上移
                arr[i] = arr[j];
                i = j; // 较小子节点作为新的父节点递归调整
            } else break;
        }
        arr[i] = temp; // 放到最终的位置
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 2, 1, 7};
        new HeapSort3().heapSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
