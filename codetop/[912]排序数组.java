//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 304 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //快排
    public int[] sortArray(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        quickSort(nums,left,right);
        return nums;
    }

    private void quickSort(int[] nums,int left,int right){
        if (left < right){
            int index = partiton(nums,left,right);
            quickSort(nums,left,index-1);
            quickSort(nums,index+1,right);
        }
    }

    private int partiton(int[] nums,int left,int right){
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

}
//leetcode submit region end(Prohibit modification and deletion)
