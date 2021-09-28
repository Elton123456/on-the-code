//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 722 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;

        int begin = 1;
        int end = x;
        int middle = 0;
        while (begin <= end){
            middle = begin + (end - begin)/2;
            //不要写成middle*middle==x，会溢出
            if (middle == x/middle){
                return middle;
            }else if(middle < x/middle){
                begin = middle + 1;
            }else {
                end = middle - 1;
            }
        }
        //结束条件end一定<begin，所以返回end
        return end;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
