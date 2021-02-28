//如果数组是单调递增或单调递减的，那么它是单调的。 
//
// 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是
//单调递减的。 
//
// 当给定的数组 A 是单调数组时返回 true，否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：[1,2,2,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：[6,5,4,4]
//输出：true
// 
//
// 示例 3： 
//
// 输入：[1,3,2]
//输出：false
// 
//
// 示例 4： 
//
// 输入：[1,2,4,5]
//输出：true
// 
//
// 示例 5： 
//
// 输入：[1,1,1]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 50000 
// -100000 <= A[i] <= 100000 
// 
// Related Topics 数组 
// 👍 92 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun isMonotonic(A: IntArray): Boolean {

        //使用两个状态量 a=1 b=1 来标识目前是单调递增还是递减
        //时间复杂度 O(n)
        //数组元素2 以内 可以保证不管是单调递增还是递减
        if(A.size <=2) return true
        var a = 0
        var b = 0

        for (i in 0 until A.size-1){
            if (A[i] <A[i+1]) a =1
            if (A[i] >A[i+1]) b =1
        }
        // a+b == 2 说明有大有小不符合
        return a+b != 2

    }
}
//leetcode submit region end(Prohibit modification and deletion)
