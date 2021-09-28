//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 
// 👍 1678 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int lengthOfLIS(int[] nums) {
        // 利用二分查找
        int length = nums.length;
        if (length == 0) return 0;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int res = 1;
        int maxIndex = 0;
        int left = 0;
        int right = 0;
        int middle = 0;
        for (int i = 1; i < length; ++i) {
            if (nums[i] <= dp[0]) dp[0] = nums[i];
            else if (nums[i] > dp[maxIndex]) {
                ++maxIndex;
                dp[maxIndex] = nums[i];
            } else {
                left = 0;
                right = maxIndex;
                while (left < right) {
                    if (left + 1 == right) {
                        dp[right] = nums[i];
                        break;
                    }
                    middle = (left + right) / 2;
                    if (dp[middle] == nums[i]) {
                        break;
                    } else if (dp[middle] < nums[i]) left = middle;
                    else right = middle;
                }
            }
            res = Math.max(res, maxIndex + 1);
            /*
            for (int k = 0; k <= maxIndex; ++k) {
                if (k == maxIndex) System.out.println(dp[k]);
                else System.out.print(dp[k]);
            }
            */
        }
        return res;
    }

    public int lengthOfLIS2(int[] nums)
    {
        int[] dp = new int[nums.length];
        // dp数组全部初始化为1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {// 这个for循环用于求出dp[i]的值
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 求dp数组中的最大值
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0||nums.length == 1)
            return nums.length;
        int[] dp = new int[nums.length];
        int res = 1;
        dp[0] = 1;

        for (int i = 1;i < dp.length;i++){
            dp[i] = 1;
            for (int j = 0;j < i;j++){
                if (nums[i] > nums[j]&&dp[i] < dp[j]+1){
                    dp[i] = dp[j] + 1;
                }
                if (dp[i] > res)
                    res = dp[i];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
