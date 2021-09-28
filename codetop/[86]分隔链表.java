//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 
// 👍 441 👎 0


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
 * 8种链表结构：
 * 单项、双向
 * 带头、不带头
 * 循环、非循环
 *
 * 主要的三种链表：
 * 无头单项非循环链表、带头循环单链表、不带头双向循环链表
 */
class Solution {
    //新建两个链表了l1,l2，遍历原来的链表 ，把值小于x的节点都加入l1,把值大于或者等于x的节点都加入l2，最后将l2连接至l1的后面
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return head;
        // 头结点
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        // 当前结点
        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = head;
            } else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        //避免循环链表
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
