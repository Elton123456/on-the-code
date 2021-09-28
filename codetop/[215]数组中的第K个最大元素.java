//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 1144 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len -1;
        //第 k 大元素的索引是 len - k
        int target = len - k;

        while (true){
            //此时，index左边均比index小，index右边均比index大
            int index = partition(nums,left,right);
            if (index == target){
                return nums[index];
            }else if(index < target){
                left = index + 1;
            }else if (index > target){
                right = index - 1;
            }
        }
    }

    //返回左小右大的索引
    private int partition(int[] nums,int left,int right){
        int pivot = nums[left];
        int j = left;
        for (int i = left+1;i <= right;i++){
            if (nums[i] < pivot){
                j++;
                swap(nums,j,i);
            }
        }
        swap(nums,j,left);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    //使用工具类
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
