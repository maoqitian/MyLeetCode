import javax.xml.stream.events.Characters

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 105 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 426 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun isPalindrome(s: String): Boolean {

        //时间复杂度 O(n)
         if (s.isEmpty()) return true

          var left = 0
          var right = s.length-1

        while (left < right){
            //跳过大小写
            while (!Character.isLetterOrDigit(s[left]) && left<right) left++
            while (!Character.isLetterOrDigit(s[right]) && left<right) right--
            //字符是否相等
            if (Character.toLowerCase(s[left]) == Character.toLowerCase(s[right])){
                left++
                right--
            }else{
                return false
            }
        }
        return true
    }
}
//leetcode submit region end(Prohibit modification and deletion)
