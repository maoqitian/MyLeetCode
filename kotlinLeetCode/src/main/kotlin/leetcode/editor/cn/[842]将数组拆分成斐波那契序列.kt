//给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
//
// 形式上，斐波那契式序列是一个非负整数列表 F，且满足： 
//
// 
// 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）； 
// F.length >= 3； 
// 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。 
// 
//
// 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。 
//
// 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。 
//
// 
//
// 示例 1： 
//
// 输入："123456579"
//输出：[123,456,579]
// 
//
// 示例 2： 
//
// 输入: "11235813"
//输出: [1,1,2,3,5,8,13]
// 
//
// 示例 3： 
//
// 输入: "112358130"
//输出: []
//解释: 这项任务无法完成。
// 
//
// 示例 4： 
//
// 输入："0123"
//输出：[]
//解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
// 
//
// 示例 5： 
//
// 输入: "1101111"
//输出: [110, 1, 111]
//解释: 输出 [11,0,11,11] 也同样被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 字符串 S 中只含有数字。 
// 
// Related Topics 贪心算法 字符串 回溯算法 
// 👍 153 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun splitIntoFibonacci(S: String): List<Int> {
        //递归回溯算法
        val res = ArrayList<Int>()
        backTrack(S,S.toCharArray(),0,res)
        return res
    }

    private fun backTrack(s:String,digit: CharArray, index: Int, res: ArrayList<Int>):Boolean{
        //递归结束条件
        if (index == digit.size && res.size >=3) return true
        //逻辑处理进入下层循环
        for(i in index until digit.size){
            //不能以零开头
            if(digit[index] == '0' && i > index) break
            //将截取的字符转为为数字

            //将截取的字符转为为数字
            val num: Long = s.substring(index,i+1).toLong()//subStrDigit(digit, index, i + 1).toLong()

            ///如果截取的数字大于int的最大值，则终止截取

            ///如果截取的数字大于int的最大值，则终止截取
            if (num > Int.MAX_VALUE) break

            //获取当前保存大小
            val size = res.size
            //不满足斐波拉契
            if (size >=2 && num.toInt() > res[size-1] + res[size-2]) break
            //满足
            if(size <=1 || num.toInt() == res[size-1] + res[size-2]){
                //保存结果
                res.add(num.toInt())
                //继续
                if(backTrack(s,digit,i+1,res))return true
                //回溯删除上次结果
                res.removeAt(res.lastIndex)
            }
        }
        return false
    }
}
//leetcode submit region end(Prohibit modification and deletion)
