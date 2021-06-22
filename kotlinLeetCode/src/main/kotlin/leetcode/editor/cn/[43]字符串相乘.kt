import java.lang.StringBuilder

//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 653 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun multiply(num1: String, num2: String): String {

        //使用数组保存字符串每一位 最后拼接
        // 时间复杂度 O(n*m) n m 为两个数组的长度
        var res = IntArray(num1.length + num2.length)

        for (i in num1.length-1 downTo 0){
            for (j in num2.length-1 downTo 0){
                //计算乘积
                var currMult = (num1[i] -'0') * (num2[j] - '0')
                //当前所在位置
                var p1 = i+j
                var p2 = i+j+1
                var sum = currMult + res[p2]
                //放置对应元素
                res[p1] += sum / 10
                res[p2] = sum % 10
            }
        }
        //拼接结果
        var stringBuilder = StringBuilder()
        res.forEach {
            if(!(stringBuilder.isEmpty() && it == 0)){
                stringBuilder.append(it)
            }
        }

        return if (stringBuilder.isEmpty()) "0" else stringBuilder.toString()


    }
}
//leetcode submit region end(Prohibit modification and deletion)
