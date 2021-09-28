//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1339 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
// 卡塔兰数 Catalan Numbe
class Solution {
    public int numTrees(int n) {
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n+1];
        // 把 n = 0 时赋为1，因为空树也算一种二叉搜索树
        dp[0] = 1;
        // 长度1~n
        for (int len = 1;len <= n;len++){
            // 将不同的数字作为根节点，只需要考虑到 len
            for (int root = 1;root <= len;root++){
                // 左子树的长度
                int left = root - 1;
                // 右子树的长度
                int right = len - root;
                dp[len] += dp[left]*dp[right];
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
