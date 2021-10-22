//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 并查集 数组 哈希表 👍 946 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0;i < nums.length;i++){
            //当前要考虑的数字
            int num = nums[i];
            //已考虑过的数字就跳过，必须跳过，不然会出错
            //比如 [1 2 1]
            //最后的 1 如果不跳过，因为之前的 2 的最长长度已经更新成 2 了，所以会出错
            if (map.containsKey(num)){
                continue;
            }
            //找到左边数字结尾的最长序列，默认0
            int left = map.getOrDefault(num - 1,0);
            //找到以右边数开头的最长序列，默认为 0
            int right = map.getOrDefault(num + 1,0);
            int sum = left + 1 + right;
            max = Math.max(max,sum);

            //将当前数字放到map中，防止重复考虑数字，value 可以随便给一个值
            map.put(num,-1);
            //更新左边界长度
            map.put(num - left, sum);
            //更新右边界长度
            map.put(num + right, sum);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
