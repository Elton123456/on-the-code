//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 
// 👍 511 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n1Len = nums1.length, n2Len = nums2.length;
        int res = 0;
        for (int i = 0;i < n1Len;i++){
            int len = Math.min(n2Len,n1Len-i);
            int maxLen = maxLength(nums1,nums2,i,0,len);
            res = Math.max(res,maxLen);
        }
        for (int i = 0;i < n2Len;i++){
            int len = Math.min(n1Len,n2Len-i);
            int maxLen = maxLength(nums1,nums2,0,i,len);
            res = Math.max(res,maxLen);
        }
        return res;
    }

    public int maxLength(int[] num1,int[] num2,int startN1,int startN2,int len){
        int res = 0,k = 0;
        for (int i = 0;i < len;i++){
            if (num1[startN1+i] == num2[startN2+i]){
                k++;
            }else {
                k = 0;
            }
            res = Math.max(res,k);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
