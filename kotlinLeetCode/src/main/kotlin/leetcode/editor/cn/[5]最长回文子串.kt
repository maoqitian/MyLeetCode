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
// 👍 3635 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestPalindrome(s: String): String {

        //找出开始结束边界 左右扩散
        //时间复杂度 O（n）

        var start = 0
        var end = 0

        for(i in s.indices){
            //左右边界
            var tempChar = s[i]
            var left = i
            var right = i

            //字符相等
            //左边界查找
            while (left >= 0 && s[left] == tempChar){
                left --
            }

            //字符相等
            //右边界查找
            while (right < s.length && s[right] == tempChar){
                right ++
            }

            //字符串不相等
            while (left >=0 && right < s.length){
                if (s[left] != s[right]){
                    //字符不等跳过
                    break
                }
                left--
                right++
            }
            //更新初始值
            left += 1
            if(end - start < right - left){
                start = left
                end = right
            }
        }
        return s.substring(start,end)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
