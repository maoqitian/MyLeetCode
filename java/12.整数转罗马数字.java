/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {

    //硬编码 时间复杂度 O(n)    
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    StringBuilder romanStr = new StringBuilder();

    romanStr.append(thousands[num/1000]).append(hundreds[num%1000/100]).append(tens[num%100/10]).append(ones[num%10]);
    return romanStr.toString();

    }
}
// @lc code=end

