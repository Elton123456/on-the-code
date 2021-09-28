//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 3443 👎 0


import org.datanucleus.store.types.simple.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int left = 0;
        int right = nums.length-1;
        //排序
        quickSort(nums,left,right);
        //双指针
        int len = nums.length;
        for(int i = 0;i < len;++i) {
            if(nums[i] > 0) return lists;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            int curr = nums[i];
            int L = i+1, R = len-1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if(tmp < 0) {
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> resList = new ArrayList<>();
//        if (nums == null||nums.length <= 3)
//            return resList;
//        //先排序
//        int left = 0;
//        int right = nums.length-1;
//        quickSort(nums,left,right);
//        //双指针
//        int len = nums.length;
//        for (int i = 0;i < len;i++){
//            //若 nums[i]>0nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果
//            if (nums[i] > 0)
//                return resList;
//            //对于重复元素：跳过，避免出现重复解
//            if (i > 0&&nums[i] == nums[i-1])
//                continue;
//            //双指针
//            int l = i + 1;
//            int r = len - 1;
//            while (l < r){
//                int tmp = nums[i]+nums[l]+nums[r];
//                if (tmp == 0){
//                    List<Integer> list = new ArrayList<>();
//                    list.add(nums[i]);
//                    list.add(nums[l]);
//                    list.add(nums[r]);
//                    resList.add(list);
//                    while (l<r&&nums[l] == nums[l+1])
//                        l = l+1;
//                    while (l<r&&nums[r] == nums[r-1])
//                        r = r-1;
//                    l = l+1;
//                    r = r-1;
//                }else if (tmp > 0){
//                    r = r-1;
//                }else {
//                    l = l+1;
//                }
//            }
//        }
//        return resList;
//    }

    public void quickSort(int[] nums,int left,int right){
        if (left < right){
            int index = partition(nums,left,right);
            quickSort(nums,left,index-1);
            quickSort(nums,index+1,right);
        }
    }

    public int partition(int[] nums,int left,int right){
        int pivot = nums[left];
        int j = left;
        for (int i = left+1;i <= right;i++){//重要
            if (nums[i] < pivot){
                j++;
                swap(nums,i,j);
            }
        }
        swap(nums,j,left);
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
