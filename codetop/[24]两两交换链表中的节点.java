//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 链表 
// 👍 734 👎 0


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
class Solution {
    public ListNode swapPairs(ListNode head) {
            ListNode listNode = new ListNode(-1);
            listNode.next = head;
            ListNode prev = listNode;
            //当后面有两个及以上节点时，向后走，交换两个节点的值
            while(prev.next != null&&prev.next.next != null){
                ListNode l1 = prev.next,l2 = prev.next.next;
                ListNode next = l2.next;
                l1.next = next;
                l2.next = l1;
                prev.next = l2;
                prev = l1;
            }
            return listNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
