import java.lang.StringBuilder

//给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello"
//输出："hello"
// 
//
// 示例 2： 
//
// 
//输入：s = "here"
//输出："here"
// 
//
// 示例 3： 
//
// 
//输入：s = "LOVELY"
//输出："lovely"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 由 ASCII 字符集中的可打印字符组成 
// 
// Related Topics 字符串 
// 👍 192 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun toLowerCase(s: String): String {

        var sb = StringBuilder()
        s.forEach { c ->
            if (c in 'A'..'Z'){
                //大写转换小写 arsii 相差32
                sb.append(c+32)
            }else{
                sb.append(c)
            }
        }

        return sb.toString()

    }
}
//leetcode submit region end(Prohibit modification and deletion)
