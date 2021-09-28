//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 810 👎 0


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
    public ListNode sortList(ListNode head) {
        if (head == null||head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        //快慢指针查找中间结点
        while (fast.next != null){
            fast = fast.next.next;
            if (fast == null)
                break;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;   //注意断链

        ListNode left = sortList(head);
        right = sortList(right);
        return mergeTwoLists(left,right);
    }

    //递归实现链表排序
    private ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode res = null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val <= l2.val){
            res = l1;
            l1.next = mergeTwoLists(l1.next,l2);
        }else {
            res = l2;
            l2.next = mergeTwoLists(l1,l2.next);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
