/**
 * @author looper
 * @create 2019-12-28 15:31
 **/
public class Search {
    /***
     *
     *  [2,   1,5]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 9};
//        int ans = f(arr, 0, arr.length - 1);
//        System.out.println(ans);
        int index = binarySearch(arr, 8);
        System.out.println(index);
    }

    /***
     * 二分查找，如果存在返回下标，如果不存在返回-1
     * @param arr
     * @param key
     * @return
     */
    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // 算出中间位置   防止超过int表示范围
            int mid = left + (right - left) / 2;
//             int mid = left + ((right - left)>>1);
            // 如果中间元素值 比查找的大 ，说明应该左半区间找，原右边界前移
            if (arr[mid] > key) {
                right = mid - 1;
            }
            // 如果中间元素值 比查找的小 ，说明应该右半区间找，原左边界后移
            else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /***
     * 从left-right位置找一个最大值
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int f(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = (left + right) / 2;
        int leftAns = f(arr, left, mid);
        int rightAns = f(arr, mid + 1, right);
        return leftAns > rightAns ? leftAns : rightAns;
    }

}
