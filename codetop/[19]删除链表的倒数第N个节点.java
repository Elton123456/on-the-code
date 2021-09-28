//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1096 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        //当n为0时，快指针走过n个节点，慢指针开始走，
        //当快指针到尾节点时，慢指针到达倒数第n个节点
        while(n-- > 0){
            fast = fast.next;
        }
        //若链表为空或此时为空（说明n大于链表的长度），返回尾节点null
        if(fast == null)
            return head.next;
        //设置慢指针
        ListNode slow = head;
        //当快指针未走到尾节点时，快指针走一步，慢指针走一步
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //通过连接next指针，删除当前倒数第n个节点
        slow.next = slow.next.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
