//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 104] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 
// 👍 653 👎 0


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
    public void reorderList(ListNode head) {
        if (head == null||head.next == null){
            return ;
        }

        ListNode first = head;
        ListNode prev = null;
        while (head != null&&head.next.next != null) {
            ListNode second = first.next.next;
            prev = first.next;
            first.next = first.next.next;
            prev = first;
            first = first.next;
        }

        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }

//        head.next = head.next.next;
//        head.next.next = head;
//        head = head.next;

    }

    public void reorderList3(ListNode head) {
        if (head == null||head.next == null||head.next.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;
        //找到中间结点
        while (fast.next != null&&fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //将链表折半

        ListNode second = slow.next; //结点赋值
        // 注意置空，分为两个链表
        // 第一个链表的长度大于（+1）等于第二个链表长度
        slow.next = null; //指针赋值
        // 先反转后半链表
        second = reverseList(second);

        ListNode first = head;
        // 合并两个链表,把第二个链表插在第一个链表中
        while (second != null){
            ListNode next = first.next; //结点赋值
            first.next = second; //指针赋值
            second = second.next; //结点赋值 后移
            first = first.next; //结点赋值 后移
            first.next = next; //指针赋值
            first = first.next; //结点赋值 后移
        }
    }

    //原地翻转链表 leetcode-206
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        while (head != null){
            next = head.next; //结点赋值
            head.next = prev; //指针赋值
            //后移
            prev = head;
            head = next;
        }
        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
