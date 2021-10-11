
// 20211011 美团面试题
//来源《编程之美》
public class MaxSubSum {

    public static int maxSubSum(int[] a) {
        //初始最大值
        a[1] = Math.max(a[1], a[0]);
        for (int i = 2; i < a.length; i++) {
            System.out.println(a[i] + " / " +a[i - 1]); // 3 / 2   50 / 5
            System.out.println(a[i - 2] + a[i]);        // 5       52
            a[i] = Math.max(Math.max(a[i], a[i - 1]), a[i - 2] + a[i]);
        }
        return a[a.length - 1];
    }

    public static void main(String[] args) {
        int[] a = {2, -3, 3, 50};
        int[] b = {-2, -3, 3, 50, 1, -1, 100};
        int result_a = maxSubSum(a);
        //int result_b = maxSubSum(b);
        System.out.println(result_a);
        //System.out.println(result_b);
    }
}
