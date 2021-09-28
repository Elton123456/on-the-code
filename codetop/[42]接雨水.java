//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2496 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //双指针解法
    public int trap(int[] height) {
        if (height == null||height.length == 0)
            return 0;
        int left = 0, right = height.length-1; //左右指针
        int maxLeft = height[left],maxRight = height[right]; //左右高度
        //返回结果
        int res = 0;

        while (left < right){
            // 比较 maxLeft 和 maxRight，决定这次计算 left 还是 right 处的柱子
            // 如果maxLeft < maxRight,那水高取决于较低的一方：maxLeft，即找出左侧中最高的减去中间点的高度即可
            if (maxLeft < maxRight){
                left++;
                maxLeft = Math.max(maxLeft,height[left]); // update maxLeft
                res += maxLeft - height[left]; //高度差为水高
            }else {
                right--;
                maxRight = Math.max(maxRight,height[right]);
                res += maxRight - height[right];
            }
        }
        return res;
    }

    //备忘录解法
    public int trap1(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int res = 0;
        // 数组充当备忘录
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        // 初始化 base case
        maxLeft[0] = height[0];
        maxRight[n - 1] = height[n - 1];

        // 从左向右计算 maxLeft
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        // 从右向左计算 maxRight
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        // 计算答案
        for (int i = 1; i < n; i++) {
            res += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
