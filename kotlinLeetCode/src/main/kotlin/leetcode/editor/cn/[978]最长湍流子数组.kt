//当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组： 
//
// 
// 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]； 
// 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。 
// 
//
// 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。 
//
// 返回 A 的最大湍流子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：[9,4,2,10,7,8,8,1,9]
//输出：5
//解释：(A[1] > A[2] < A[3] > A[4] < A[5])
// 
//
// 示例 2： 
//
// 输入：[4,8,12,16]
//输出：2
// 
//
// 示例 3： 
//
// 输入：[100]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 40000 
// 0 <= A[i] <= 10^9 
// 
// Related Topics 数组 动态规划 Sliding Window 
// 👍 142 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxTurbulenceSize(arr: IntArray): Int {

        //时间复杂度 O(n)
        var inc = 1 //递增长度
        var dec = 1 //递减长度
        var res = 1

        for (i in 1 until arr.size){
            if(arr[i] < arr[i-1]){
                //递减
                dec = inc +1
                inc = 1
            }else if(arr[i] > arr[i-1]){
                //递增
                inc = dec +1
                dec = 1
            }else{
                inc = 1
                dec = 1
            }
            res = Math.max(res,Math.max(inc,dec))
        }

        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
