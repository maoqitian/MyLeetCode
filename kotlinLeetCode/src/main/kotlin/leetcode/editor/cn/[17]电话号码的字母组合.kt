//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1326 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun letterCombinations(digits: String): List<String> {

        if(digits.isEmpty()) return ArrayList<String>()

        var map = HashMap<Char,String>()
        map['2'] =  "abc"
        map['3'] =  "def"
        map['4'] =  "ghi"
        map['5'] =  "jkl"
        map['6'] =  "mno"
        map['7'] =  "pqrs"
        map['8'] =  "tuv"
        map['9'] =  "wxyz"

        //返回值
        var res = ArrayList<String>()

        dealDigits(0,"",digits,map,res)

        return res

    }
    //递归遍历获取
    private fun dealDigits(level: Int, str: String, digits: String, map: java.util.HashMap<Char, String>, res: java.util.ArrayList<String>) {
         //递归退出条件
         if (level == digits.length) {
             res.add(str)
             return
         }
         //逻辑处理，进入下层循环
         //获取当前 key
         var key = digits[level]
         //获取key 对应的 字母值
         var strDigits = map[key]!!
         //循环组合
         for (i in strDigits.indices){
             dealDigits(level+1,str+strDigits[i],digits,map,res)
         }
         //数据reverse
    }
}
//leetcode submit region end(Prohibit modification and deletion)
