//我们定义，在以下情况时，单词的大写用法是正确的： 
//
// 
// 全部字母都是大写，比如 "USA" 。 
// 单词中所有字母都不是大写，比如 "leetcode" 。 
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。 
// 
//
// 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "USA"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：word = "FlaG"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 100 
// word 由小写和大写英文字母组成 
// 
// Related Topics 字符串 
// 👍 157 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun detectCapitalUse(word: String): Boolean {

        //如果第一个字母是小写，第二个字母为大写
        if (word.length >= 2 && word[0].isLowerCase() && word[1].isUpperCase()) return false

        //无论第 1 个字母是否大写，其他字母必须与第 2 个字母的大小写相同
        for (i in 2 until word.length){
            if (word[1].isLowerCase()){
                //如果是小写
                if (!word[i].isLowerCase()){
                    return false
                }
            }else if(word[1].isUpperCase()){
                //如果为大写
                if (!word[i].isUpperCase()){
                    return false
                }
            }
        }
        return true
    }
}
//leetcode submit region end(Prohibit modification and deletion)
