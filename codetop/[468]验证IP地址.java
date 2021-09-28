//编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。 
//
// 
// 如果是有效的 IPv4 地址，返回 "IPv4" ； 
// 如果是有效的 IPv6 地址，返回 "IPv6" ； 
// 如果不是上述类型的 IP 地址，返回 "Neither" 。 
// 
//
// IPv4 地址由十进制数和点来表示，每个地址包含 4 个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1； 
//
// 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。 
//
// IPv6 地址由 8 组 16 进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如, 2001:0db8:85a3:0000:0
//000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85
//a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。 
//
// 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334
// 是无效的 IPv6 地址。 
//
// 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的
//。 
//
// 
//
// 示例 1： 
//
// 输入：IP = "172.16.254.1"
//输出："IPv4"
//解释：有效的 IPv4 地址，返回 "IPv4"
// 
//
// 示例 2： 
//
// 输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
//输出："IPv6"
//解释：有效的 IPv6 地址，返回 "IPv6"
// 
//
// 示例 3： 
//
// 输入：IP = "256.256.256.256"
//输出："Neither"
//解释：既不是 IPv4 地址，又不是 IPv6 地址
// 
//
// 示例 4： 
//
// 输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334:"
//输出："Neither"
// 
//
// 示例 5： 
//
// 输入：IP = "1e1.4.5.6"
//输出："Neither"
// 
//
// 
//
// 提示： 
//
// 
// IP 仅由英文字母，数字，字符 '.' 和 ':' 组成。 
// 
// Related Topics 字符串 
// 👍 109 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String validIPAddress(String IP) {
        if (isIPv4(IP)){
            return "IPv4";
        }else if (isIPv6(IP)){
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPv4(String IP){
        int count = 0;
        for (char ch : IP.toCharArray()){
            if (ch == '.') {
                count++;
            }
        }
        if (count != 3) return false;

        String[] field = IP.split("\\.");
        if (field.length != 4){
            return false;
        }
        for (String filed:field){
            if (field.length() == 0||field.length() > 3){
                return false;
            }
            for (int i = 0;i < field.length();i++){
                if (!Character.isDigit(field.charAt(i))){
                    return false;
                }
            }
            int num = Integer.valueOf(filed);
            if (!String.valueOf(num).equals(filed)||num < 0||num > 255){
                return false;
            }
        }
        return true;
    }

    private boolean isIPv6(String IP){
        if (IP.length() < 15||IP.charAt(0) == ':'||IP.charAt(IP.length() - 1) == ':'){
            return false;
        }
        String[] strings = IP.split(":");
        if (strings.length != 8){
            return false;
        }
        for (String string : strings){
            if (string.length() == 0||string.length() > 4){
                return false;
            }
            for (int i = 0;i < strings.length();i++){
                char c = string.charAt(i);
                if (!((c >= 'a'&&c <= 'f') || (c >= 'A'&&c <= 'F')||(c >= '0'&&c <= '9'))){
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
