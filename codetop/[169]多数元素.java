//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 数组 哈希表 分治 计数 排序 
// 👍 1107 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //摩尔投票法
    //该算法在其局部变量中创建一个序列元素和一个计数器，该计数器最初为零
    //它一次处理一个序列元素。在处理元素x时，如果计数器为零，则算法会将x存储为当前的序列元素，并将计数器设置为1。否则，
    // 它将x与存储的元素进行比较，或者增加计数器（如果它们相等）或减少计数器（不相等）。在此过程结束时，如果序列具有多数，它将是算法存储的元素。
    public int majorityElement(int[] nums) {
        int a = nums[0];
        int count = 0;

        for (int num : nums){
            if (num == a){
                count++;
            }else {
                count--;
                if (count < 0){
                    a = num;
                    count = 0;
                }
            }
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
