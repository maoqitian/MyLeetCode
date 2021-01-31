//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串 
// 👍 271 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun lengthOfLastWord(s: String): Int {
        //时间复杂度 O(n)

        var resLen = 0

        for (i in s.length-1 downTo 0){
            if( s[i] != ' '){
                resLen ++
            }else if (resLen != 0){
                return resLen
            }
        }

        return resLen

    }
}
//leetcode submit region end(Prohibit modification and deletion)
