//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 排序 
// 👍 823 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //排序+双指针
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        //每遍历一个值利用其下标i，形成一个固定值nums[i]
        for (int i = 0;i < nums.length;i++){
            //使用前指针指向start = i + 1处，后指针指向end = nums.length - 1处,也就是结尾处
            int start = i+1,end = nums.length - 1;
            while (start < end){
                int sum = nums[start]+nums[end]+nums[i];
                //判断sum与目标target的距离，如果更近则更新结果ans
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                //如果比目标值大，则尾指针左移可能结果更好
                if (sum > target){
                    end--;
                    //如果比目标值小，则头指针右移可能结果更好
                } else if (sum < target){
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
