//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 广度优先搜索 数组 动态规划 
// 👍 1467 👎 0


import java.util.Arrays;
import java.util.Comparator;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 贪心算法2.0， 引入回溯法解决过于贪心的问题
    public int coinChange(int[] coins, int amount){
        // 倒序
        Arrays.sort(coins, Collections.reverseOrder());
        int minCount = getMinCoinCountLoop(coins,amount,0);

        //int valueCount = coins.length; //表示不同面额的数量


    }

    private int getMinCoinCountLoop(int[] coins, int amount,int min){

    }

    private int getMinCoinCountOfValue(int[] coins,int amount,int minCount){

    }

    // 贪心算法1.0， 出现过于贪心的问题
    // 问题case：[186,419,83,408] 6249 贪心算法返回-1，动态规划返回20
//    public int coinChange(int[] coins, int amount){
//        int res = amount;
//        int count = 0;
//        // int[] 转 Integer[]
//        Integer[] coinss = Arrays.stream(coins).boxed().toArray(Integer[]::new);
//        //从大到小排序数组元素
//        Arrays.sort(coinss,new Comparator<Integer>() {
//            @Override
//            public int compare(Integer i1, Integer i2) {
//                return i2 - i1;
//            }
//        });
//        // 从大到小遍历所有面值
//        // coins.length可表示不同面额的数量
//        for (int i = 0;i < coinss.length;i++){
//            System.out.println(coinss[i]);
//            int currentCount = res / coinss[i];
//            res -= currentCount*coinss[i];
//            count += currentCount;
//
//            if (res == 0){
//                return count;
//            }
//        }
//
//        //没有符合的条件
//        return -1;
//    }

//    public int coinChange(int[] coins, int amount) {
//        if (coins == null||coins.length == 0||amount <= 0){
//            return 0;
//        }
//        int[] dp = new int[amount+1];
//        Arrays.fill(dp,amount+1);
//        dp[0] = 0;
//        for (int j = 0;j < coins.length;j++){
//            for (int i = coins[j];i <= amount;i++){
//                dp[i] = Math.min(dp[i],dp[i-coins[j]] + 1);
//            }
//        }
//        return dp[amount] > amount ? -1 : dp[amount];
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


//        // Integer[] -> int[]
//        intArr  = Arrays.stream(integerArr).mapToInt(Integer::valueOf).toArray();

