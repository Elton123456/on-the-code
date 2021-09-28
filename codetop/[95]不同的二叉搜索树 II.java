//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
    //
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// 
// 
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 👍 993 👎 0


//leetcode submit region begin(Prohibit modification and deletion)



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return null;

        return helper(1,n);
    }

    public List<TreeNode> helper(int start,int end){
        List<TreeNode> rsList = new ArrayList<TreeNode>();
        // 加null至关重要
        if (start > end) {
            rsList.add(null);
            return rsList;
        }

//      之前java.lang.NullPointerException
//        if (start > end) return null;
//        List<TreeNode> rsList = new ArrayList<TreeNode>();

        for (int i = start;i <= end;i++){
            List<TreeNode> lchildren = helper(start,i-1);
            List<TreeNode> rchildren = helper(i+1,end);
            if(lchildren != null&&rchildren != null) {
                for (TreeNode lnode : lchildren) {
                    for (TreeNode rnode : rchildren) {
                        TreeNode rsnode = new TreeNode(i);
                        rsnode.left = lnode;
                        rsnode.right = rnode;
                        rsList.add(rsnode);
                    }
                }
            }
        }
        return rsList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
