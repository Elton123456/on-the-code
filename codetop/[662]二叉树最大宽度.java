//给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节
//点为空。 
//
// 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。 
//
// 示例 1: 
//
// 
//输入: 
//
//           1
//         /   \
//        3     2
//       / \     \  
//      5   3     9 
//
//输出: 4
//解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
// 
//
// 示例 2: 
//
// 
//输入: 
//
//          1
//         /  
//        3    
//       / \       
//      5   3     
//
//输出: 2
//解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
// 
//
// 示例 3: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2 
//       /        
//      5      
//
//输出: 2
//解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
// 
//
// 示例 4: 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       /     \  
//      5       9 
//     /         \
//    6           7
//输出: 8
//解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
// 
//
// 注意: 答案在32位有符号整数的表示范围内。 
// Related Topics 树 
// 👍 173 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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
    public int widthOfBinaryTree(TreeNode root) {
        //最关键的就是辨别出每层开始或者每层结束
        if (root == null)
            return 0;
        //return maxWidthUseMap(root);
        return maxWithNoMap1(root);
    }

    public static int maxWithNoMap1(TreeNode head){
        if (head == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(head);
        TreeNode curEnd = head;
        TreeNode nextEnd = null;
        int max = 0;
        int curLevelNodes = 0;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur.left != null){
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null){
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelNodes++;
            if (cur == curEnd){
                max = Math.max(max,curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }

    private static int maxWidthUseMap(TreeNode head){
        //层序遍历的队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(head);
        //记录当前节点所在层
        HashMap<TreeNode,Integer> levelMap = new HashMap<TreeNode,Integer>();
        //把头节点作为key，记录其对应第一层
        levelMap.put(head,1);
        int curLevel = 1;//记录当前统计的是哪一层的宽度
        int curLevelNodes = 0;//记录当前层的宽度
        int max = 0;//宽度最大值
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (cur.left != null){
                levelMap.put(cur.left,curNodeLevel+1);//加入map，且节点对应层数+1
                queue.add(cur.left);
            }
            if (cur.right != null){
                levelMap.put(cur.right,curNodeLevel+1);//加入map，且节点对应层数+1
                queue.add(cur.right);
            }
            //如果该出队节点是当前层的节点
            if (curNodeLevel == curLevel){
                curLevelNodes++;//当前层的宽度++
            }else {//如果当前节点不属于这层
                max = Math.max(max,curLevelNodes);//将之前的最大值与当前层的宽度比较
                curLevel++;//到新层
                curLevelNodes = 1;//置当前层的节点为1
            }
        }
        //弥补while循环中，最后一层没有触发max比较机制，
        // 这里比较最后一层和之前最大层宽
        max = Math.max(max,curLevelNodes);
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
