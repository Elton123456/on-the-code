//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1509 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 数组0、1下标空着
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) {
            return new ArrayList<String>();
        }
        List<String> rs = new LinkedList<String>();
        combination("", digits, 0, rs);
        return rs;
    }

    /**
     *
     * @param prefix 前缀
     * @param digits 仅包含数字 2-9 的字符串
     * @param offset 代表在加哪个数字
     * @param ret
     */
    private void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset == digits.length()) {
            ret.add(prefix);
            return;
        }
        // '9' - '0' = 9
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
