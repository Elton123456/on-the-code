//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 
// 👍 1511 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //经典的backtrack（回溯法）,又称为试探法
    //选优条件向前搜索，以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        helper(nums,0,new ArrayList<>(),resList);
        return resList;
    }

    private void helper(int[] nums, int from, List<Integer> cur, List<List<Integer>> resList){
        //空直接添加返回
        if(cur.size() == nums.length) {
            resList.add(new ArrayList<Integer>(cur));
            return;
        }
        //非空
        //选数过程：eg：比如有三个数1,2,3，首先在第一个位置可以有三种可能，可以选择1，2，3里面的任何一个， 第二个位置就只能在剩下的两个数里面选一个，最后一个位置就只能选最后一个数
        //选数的过程，可以通过交换位置来实现，每次把当前可以选择的数(from到nums.length-1)换到最前面，
        //然后把这个数加到当前选项(cur)中, 然后递归。 递归完了以后， 要记得backtrack，就是reset到原始的状态，
        //相当于什么都没发生过，然后在for循环中继续下一轮
        //递归需要有终止条件， 这里就是cur.size== nums.length, 说明已经递归到一个排列， 拷贝到resList里面
        for(int i = from; i < nums.length; ++i) {
            swap(nums, from, i);
            cur.add(nums[from]);
            helper(nums, from+1, cur, resList);
            cur.remove(cur.size()-1);
            swap(nums, from, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
