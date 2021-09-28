//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3837 👎 0


class Solution {
    //动态规划
    //利用回文串的特性:
    //如果一个字串是回文字串，那么去掉左右两边的字符之后依然是回文。也可以说是一个回文字串，左右两边加上相同的字符，也是回文字串。
    public String longestPalindrome1(String s) {
        if(s.equals(""))  return s;

        int len = s.length(),left = 0,right = 0;
        // 使用索引 i 和 j 来表示一个字符串从索引 i 到 j 的子串，
        // db[i][j] 表示字符串区间 [i, j] 是否为回文串，true表示回文
        boolean[][] db = new boolean[len][len];
        // 注意,这里的遍历与平常我们对字符串的遍历不一样
        for(int j = 0;j<len;j++)
            for(int i =0;i<=j;i++){
                db[i][j] = (s.charAt(i) == s.charAt(j))&&(j-i<2 || db[i+1][j-1]);
                //如果是回文字符串，并且比之前的回文字符串要长，更新字符串长度，记录字符串
                if(db[i][j] && j-i>right-left){
                    left = i;
                    right = j;
                }
            }
        return s.substring(left,right+1);
    }

    //中心扩展算法
    public String longestPalindrome(String s) {
        if(s.equals(""))  return s;

        int start = 0,end = 0;
        for(int i =0;i<s.length();i++){
            int len1 = expandAroundCenter(s,i,i); //以一个点为中心向外扩展，直到不是回文为止
            int len2 = expandAroundCenter(s,i,i+1);// 以两个点为中心向外扩展，直到不是回文为止
            int len = Math.max(len1,len2); // //找出两个中的最大回文长度
            if(len >end-start+1){ //如果大于保存的最大回文长度，则计算并更新最大回文的位置
                start = i -(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    public int expandAroundCenter(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            i--;j++;//分别向左右拓展
        }
        return j-i-1;
    }
}
