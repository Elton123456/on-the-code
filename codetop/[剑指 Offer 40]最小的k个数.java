//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 298 👎 0


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
//Java 中提供了现成的 PriorityQueue（默认小根堆），所以实现起来最简单
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0||arr.length == 0){
            return new int[0];
        }
        //默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int num:arr){
            if (pq.size() < k){
                pq.offer(num);
            }else if(num < pq.peek()){
                pq.poll();
                pq.offer(num);
            }
        }

        //返回堆中元素
        int[] res = new int[pq.size()];
        int index = 0;
        for (int num : pq){
            res[index++] = num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
