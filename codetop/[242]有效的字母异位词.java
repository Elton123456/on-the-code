//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 104 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 哈希表 字符串 排序 
// 👍 414 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arrCount = new int[26]; //一共26字母

        // s中的字符要加1，t中的字符要减一
        for (char ch : s.toCharArray()){
            arrCount[ch - 'a']++;
        }
        for (char ch : t.toCharArray()){
            arrCount[ch - 'a']--;
        }

        //最后判断里面字母个数是否为0
        for (int a : arrCount){
            if (a != 0)
                return false;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
