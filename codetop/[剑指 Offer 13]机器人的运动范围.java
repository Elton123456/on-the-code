//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 
// 👍 321 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int[][] next = {{0,-1},{0,1},{-1,0},{1,0}};
    private int cnt = 0; //记录能到达的方格数目
    private int rows; // 行
    private int cols; // 列
    private int threshold; //阈值
    private int[][] digitSum; //定义二维数组记录是否访问过

    //深度优先
    public int movingCount(int m, int n, int k) {
        this.rows = m;
        this.cols = n;
        this.threshold = k;
        initDigitSum();
        boolean[][] marked = new boolean[rows][cols]; ////定义二维数组记录是否访问过
        dfs(marked,0,0);
        return cnt;
    }

    //深度优先遍历（遍历范围，是否访问过，初始位置，下标和上限）
    private void dfs(boolean[][] marked,int r,int c){
        if (r < 0||r >= rows||c < 0||c >= cols||marked[r][c])
            return;
        marked[r][c] = true;
        if (this.digitSum[r][c] > this.threshold)
            return;
        cnt++;
        for (int[] n:next)
            dfs(marked,r + n[0],c + n[1]);
    }

    //记录访问下标的各个位数之和
    private void initDigitSum(){
        int[] digitSumOne = new int[Math.max(rows,cols)];
        for (int i = 0;i <digitSumOne.length;i++){
            int n = i;
            //数位之和计算
            while (n > 0){
                digitSumOne[i] += n%10;
                n /= 10;
            }
        }
        this.digitSum = new int[rows][cols];
        for (int i = 0;i < this.rows;i++){
            for (int j = 0;j< this.cols;j++){
                this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//解析
//通过循环求得数位和 s
//    int sums(int x)
//    int s = 0;
//    while(x != 0) {
//        s += x % 10; //令 xx 的十进制数向右移动一位，即删除个位数字
//        x = x / 10; //得到 xx 的个位数字
//    }
//    return s;
