//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 数学 字符串 模拟 
// 👍 397 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        while (i >= 0||j >= 0){
            if (i >= 0){
                carry += num1.charAt(i) - '0';
            }
            if (j >= 0){
                carry += num2.charAt(j) - '0';
            }
            stringBuilder.append((char) (carry%10 + '0'));
            carry /= 10;
            i--;
            j--;
        }
        if (carry == 1){
            stringBuilder.append('1');
        }
        return stringBuilder.reverse().toString();
    }
//    public String addStrings(String num1, String num2) {
//        int i = num1.length() - 1,j = num2.length() - 1,carry = 0;
//        String res = "";
//        while (i >= 0||j <= 0){
//            if (i >= 0)
//                carry += num1.charAt(i--) - '0';
//            if (j >= 0)
//                carry += num2.charAt(j--) - '0';
//            res = Integer.toString(carry % 10) + res;
//            carry /= 10;
//        }
//        return carry != 0 ? "1" + res : res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
