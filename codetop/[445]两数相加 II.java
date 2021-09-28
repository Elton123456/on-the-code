//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表 
// 👍 309 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stcak = buildStack(l2);
        //返回求和链表
        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!l1Stack.isEmpty()||!l2Stcak.isEmpty()||carry != 0){
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stcak.isEmpty() ? 0 : l2Stcak.pop();
            //判读是否进位
            int sum = x + y + carry;
            ListNode node = new ListNode(sum%10);
            node.next = head.next;
            head.next = node;
            carry = sum/10;
        }
        return head.next;
    }

    private Stack<Integer> buildStack(ListNode l){
        Stack<Integer> stack = new Stack<Integer>();
        while(l != null){
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
