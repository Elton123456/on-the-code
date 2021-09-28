//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 615 👎 0


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
    //当k==n时候，其实相当于没有做任何改变
    //总体思路可以分为 k<n 和 k>=n 如果k<n 就是 移动k次，如果k大于n就是移动k%n
    //循环k次，每次都把最后一个结点移动到最前面
    public ListNode rotateRight(ListNode head, int k) {
        //无结点或1个结点时
        if (head == null||head.next == null)
            return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode fast = res,slow = res;

        int i;
        for (i = 0;fast.next != null;i++)//Get the total length
            fast = fast.next;

        for (int j = i-n%i;j > 0;j--)//Get the i-n%i th node
            slow = slow.next;

        fast.next = res.next;//Do the rotation
        res.next = fast.next;
        slow.next = null;

        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
