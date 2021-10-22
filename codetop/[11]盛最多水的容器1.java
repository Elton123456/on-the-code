//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
// Related Topics 贪心 数组 双指针 👍 2872 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    // 暴力解法
    public int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0;i < height.length;i++){
            for (int j = i+1;j < height.length;j++){
                int high = Math.min(height[i],height[j]);
                if (high * (j-i) > max){
                    max = high * (j-i);
                }
            }
        }
        return max;
    }

    //解法二
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length-1;
        while (l < r){
            maxarea = Math.max(maxarea,Math.min(height[l],height[r])* (r - l));
            if (height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return maxarea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
