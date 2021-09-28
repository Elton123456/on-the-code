//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 966 👎 0


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
    //1 2 3 4 5
    //解题思路：设pre为前驱节点，cur为当前节点。
    //当我们遍历到2的时候，2.next=3，pre的next节点是2，这时候，我们让2的后继变成前驱的后继，也就是2.next=pre.next，
    // 然后顺序就会变成1 3 2 4 5 ，这个时候，pre节点还是1，而2.next就变成了4。这时候，我们再让2.next=pre.next，顺序就会变成1 4 3 2 5了。
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        for (int i = 1;i < left;i++){
            pre = pre.next;
        }
        head = pre.next;
        for (int i = left;i < right;i++){
            ListNode node = head.next; //node是2的下一个节点.node=3
            head.next = node.next; //让3的下一个节点和2的下一个相同，相当于2->4
            node.next = pre.next;
            pre.next = node;
        }
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
