//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
//
// 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a
//-binary-tree/ 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 286 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //普通二叉树
    //解题思路：两个链表的第一个公共节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 防止特殊输入
        if (root == null||p == null||q == null) {
            return null;
        }

        ArrayList<TreeNode> pPath = new ArrayList<TreeNode>();
        ArrayList<TreeNode> qPath = new ArrayList<TreeNode>();
        // 寻找p、q路径
        findPath(root,p,pPath);
        findPath(root,q,qPath);
        // 寻找p、q路径的最后一个公共节点
        int minLength = Math.min(pPath.size(),qPath.size());
        int LCA = 0;
        for (int i = 0;i < minLength;i++){
            if (pPath.get(i) == qPath.get(i)){
                LCA = i;
            }
        }
        return pPath.get(LCA);
    }

    //查找从根节点到目标节点的路径
    private boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path){
        if (root == null)
            return false;
        path.add(root);
        if (root == target)
            return true;
        if (findPath(root.left,target,path)||findPath(root.right,target,path)){
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
