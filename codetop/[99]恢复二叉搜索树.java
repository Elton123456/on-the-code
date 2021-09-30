//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 565 👎 0


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
    /**
     * 让我们来考虑交换的位置的可能：
     * 1、根节点和左子树的某个数字交换 -> 由于根节点大于左子树中的所有数，所以交换后我们只要找左子树中最大的那个数，就是所交换的那个数
     * 2、根节点和右子树的某个数字交换 -> 由于根节点小于右子树中的所有数，所以交换后我们只要在右子树中最小的那个数，就是所交换的那个数
     * 3、左子树和右子树的两个数字交换 -> 找左子树中最大的数，右子树中最小的数，即对应两个交换的数
     * 4、左子树中的两个数字交换
     * 5、右子树中的两个数字交换
     * @param root
     */
    public void recoverTree(TreeNode root) {
        if (root == null){
            return;
        }
        // 寻找左子树中最大的结点
        TreeNode maxLeft = getMaxOfBST(root.left);
        // 寻找右子树中最大的结点
        TreeNode minRight = getMinOfBST(root.right);

        // 情况3
        if (maxLeft != null && minRight != null) {
            // 左子树大于根节点，右边小于根节点，对应情况3,左子树和右子树的两个数字交换
            if (maxLeft.val > root.val && minRight.val < root.val){
                int tmp = minRight.val;
                minRight.val = maxLeft.val;
                maxLeft.val = tmp;
            }
        }

        // 情况1
        if (maxLeft != null){
            // 左边最大的大于根节点，对应情况1,根节点和左子树的某个数做了交换
            if (maxLeft.val > root.val){
                int tmp = maxLeft.val;
                maxLeft.val = root.val;
                root.val = tmp;
            }
        }

        // 情况2
        if (minRight != null){
            //右边最小的小于根节点，对应情况 2，根节点和右子树的某个数做了交换
            if (minRight.val < root.val){
                int tmp = minRight.val;
                minRight.val = root.val;
                root.val = tmp;
            }
        }

        // 情况4,左子树中的两个数进行了交换
        recoverTree(root.left);
        // 情况 5，右子树中的两个数进行了交换
        recoverTree(root.right);
    }

    // 寻找树中最小的节点
    private TreeNode getMinOfBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode minLeft = getMinOfBST(root.left);
        TreeNode minRight = getMinOfBST(root.right);
        TreeNode min = root;
        if (minLeft != null && min.val > minLeft.val) {
            min = minLeft;
        }
        if (minRight != null && min.val > minRight.val) {
            min = minRight;
        }
        return min;
    }

    // 寻找树中最大的结点
    private TreeNode getMaxOfBST(TreeNode root){
        if (root == null) return null;
        //我的
//        int max = Integer.MIN_VALUE;
//        max = root.val > max ? root.val : max;
//        TreeNode maxLeft = getMaxOfBST(root.left);
//        TreeNode maxRight = getMaxOfBST(root.right);
//        return max;
        //参考
        TreeNode maxLeft = getMaxOfBST(root.left);
        TreeNode maxRight = getMaxOfBST(root.right);
        TreeNode max = root;
        if (maxLeft != null && max.val < maxLeft.val) {
            max = maxLeft;
        }
        if (maxRight != null && max.val < maxRight.val) {
            max = maxRight;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
