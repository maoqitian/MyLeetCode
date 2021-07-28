import java.lang.StringBuilder

//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 位运算 数学 字符串 模拟 
// 👍 647 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun addBinary(a: String, b: String): String {

        //遍历循环相加 时间复杂度 O（max(m,n)） m n 为字符串长度

        var m = a.length-1
        var n = b.length-1
        //进位
        var carry = 0

        var resSb = StringBuilder()

        while (m >= 0 || n >= 0){
            // “0” 字符的 ASC 码为48 对应为 0 ，字符串ASE 减去零 等于对应的int值
            var sum = carry
            if(m >=0) sum+= a[m--] -'0'
            if(n >=0) sum+= b[n--] -'0'
            //拼接当前和
            resSb.append(sum%2)
            //计算进位
            carry = sum/2
        }
        //计算完成是否还有进位
        if (carry != 0) resSb.append(carry)
        return resSb.reverse().toString()

    }
}
//leetcode submit region end(Prohibit modification and deletion)
