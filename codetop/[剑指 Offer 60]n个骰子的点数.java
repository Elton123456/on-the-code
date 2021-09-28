//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。 
//
// 
//
// 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。 
//
// 
//
// 示例 1: 
//
// 输入: 1
//输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
// 
//
// 示例 2: 
//
// 输入: 2
//输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0
//.05556,0.02778] 
//
// 
//
// 限制： 
//
// 1 <= n <= 11 
// Related Topics 数学 动态规划 概率与统计 
// 👍 282 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //用两个数组来存储骰子点数的每个总数出现的次数（动态规划数组）
//    n个骰子，n轮
//    在第一轮循环中，第一个数组中的第n个数字表示骰子和为n出现的次数
//    在下一轮循环中，我们加上一个新的骰子，此时和为n的骰子出现的次数应该等于上一轮循环中骰子点数和为n-1、n-2、n-3、n-4、n-5与n-6的次数的总和
//    依次类推求解。
    public double[] dicesProbability(int n) {
        //动态规划数组要用long型，不然会有int型溢出
        double[] dp = new double[6];
        //初始化dp数组，只筛一轮时，概率为1/6
        Arrays.fill(dp,1.0 / 6.0);
        for (int i = 2;i <= n;i++){
            double[] tmp = new double[5*i+1];
            for (int j = 0;j < dp.length;j++){
                for (int k = 0;k < 6;k++){
                    tmp[j + k] += dp[j]/6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
