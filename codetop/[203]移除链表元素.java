//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 473 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
//    public ListNode removeElements(ListNode head, int val) {
//        //如果head为空或者head的值等于val的值为val，则删除head
//        //如果删除head后，head的下一个节点的值仍为val，则继续删除，所以用while
//        while (head != null&&head.val == val){
//            ListNode delNode = head;    //定义待删除节点
//            head = head.next;   //head往后走一位
//            delNode.next = null;    //将头节点置为空
//        }
//
//        //给定链表中节点的值均为val，此时链表已经被删空
//        if(head == null)
//            return null;
//
//        //设置待删除节点的prev
//        ListNode prev = head;
//        //一直向后遍历，直到尾节点
//        while (prev.next != null){
//            //若后一个prev节点为待删除节点
//            if(prev.next.val == val){
//                //删除值为val的节点
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
//            }
//            else
//                prev = prev.next;
//        }
//        return head;
//    }

    /**
     * 递归解法
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        //递归到最基本的问题：当递归到链表的最后一个节点时
        if(head == null)
            return null;

        //把原问题转化为更小的问题：删掉值为val的节点
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next:head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
