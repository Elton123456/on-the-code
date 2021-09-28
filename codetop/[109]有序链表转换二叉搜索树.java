//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表 
// 👍 431 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import day16_List.ListNode;

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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        else if (head.next == null)
            return new TreeNode(head.val);
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode q = p.next;
        //找到链表的中点p
        while (q != null&&q.next != null){
            pre = pre.next;
            //p走一步
            p = pre.next;
            //q走两步
            q = q.next.next;
        }
        //将中点左边的链表分开
        pre.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }
//    public TreeNode sortedListToBST(ListNode head) {
//        if (head == null)
//            return null;
//        List<Integer> listNode = new ArrayList<Integer>();
//        ListNode node = head;
//        while (node != null){
//            listNode.add(node.val);
//            node = node.next;
//        }
//        int left = 0;
//        int right = listNode.size() - 1;
//        return build(left,right,listNode);
//    }
//
//    public TreeNode build(int left,int right,List<Integer> listNode){
//        if (left > right)
//            return null;
//        int mid = (left+right)/2;
//        TreeNode treeNode = new TreeNode(listNode.get(mid));
//        treeNode.left = build(left,mid-1,listNode);
//        treeNode.right = build(mid+1,right,listNode);
//        return treeNode;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
