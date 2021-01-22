import java.util.*

//对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
//
// 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = [1,2,0,0], K = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
// 
//
// 示例 2： 
//
// 输入：A = [2,7,4], K = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
// 
//
// 示例 3： 
//
// 输入：A = [2,1,5], K = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
// 
//
// 示例 4： 
//
// 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
//输出：[1,0,0,0,0,0,0,0,0,0,0]
//解释：9999999999 + 1 = 10000000000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 0 <= A[i] <= 9 
// 0 <= K <= 10000 
// 如果 A.length > 1，那么 A[0] != 0 
// 
// Related Topics 数组 
// 👍 127 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun addToArrayForm(A: IntArray, K: Int): List<Int> {

        //遍历 取出每次遍历最后一位加入下一轮相加
        //时间复杂度 O（n）
        var res = LinkedList<Int>()
        var lastNum = K
        //数组遍历index 倒序
        var index = A.size-1

        while(index >=0 || lastNum>0){
           if (index>=0){
               lastNum += A[index]

           }
            res.addFirst(lastNum%10)
           //获取lastNum余数
           lastNum /= 10
           index--
        }

        return res


    }
}
//leetcode submit region end(Prohibit modification and deletion)
