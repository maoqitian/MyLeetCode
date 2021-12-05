import java.lang.StringBuilder
import javax.xml.stream.events.Characters

//为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
//
// 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符
//构成。 
//
// 如果可以构成，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 105 
// ransomNote 和 magazine 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 
// 👍 240 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        //时间复杂度 O(n)
        var stringBuilder = StringBuilder(magazine)

        var index = 0
        ransomNote.forEach { c ->
            index = stringBuilder.indexOf(c)
            if (index >=0){
                stringBuilder.deleteCharAt(index)
            }else{
                return false
            }
        }
        return true
    }
}
//leetcode submit region end(Prohibit modification and deletion)
