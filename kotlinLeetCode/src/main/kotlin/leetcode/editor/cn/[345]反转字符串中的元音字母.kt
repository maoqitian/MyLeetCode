//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 209 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun reverseVowels(s: String): String {

        //双指针遍历
        if(s.length <=1) return s

        val charArray = s.toCharArray()

        //使用 hashset 保存元音

        var hashSet = HashSet<Char>()
        hashSet.add('a')
        hashSet.add('e')
        hashSet.add('i')
        hashSet.add('o')
        hashSet.add('u')
        hashSet.add('A')
        hashSet.add('E')
        hashSet.add('I')
        hashSet.add('O')
        hashSet.add('U')

        var left = 0
        var right = s.length-1

        while (left < right){
            //当前序列遍历
            while (left < right && !hashSet.contains(charArray[left])){left++}
            while (left < right && !hashSet.contains(charArray[right])){right--}
            if(charArray[left] != charArray[right]){
                //替换
                val temp = charArray[left]
                charArray[left] = charArray[right]
                charArray[right] = temp
            }
            left++
            right--
        }


        return String(charArray)

    }
}
//leetcode submit region end(Prohibit modification and deletion)
