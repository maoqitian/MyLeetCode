//给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。 
//
// 返回仅包含 1 的最长（连续）子数组的长度。 
//
// 
//
// 示例 1： 
//
// 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释： 
//[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：
//[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 20000 
// 0 <= K <= A.length 
// A[i] 为 0 或 1 
// 
// Related Topics 双指针 Sliding Window 
// 👍 232 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestOnes(A: IntArray, K: Int): Int {

        //滑动窗口 时间复杂度 O（n）
        var left = 0
        var res = 0

        var k = K

        for (right in 0 until A.size ){
            //如果等于 0 已经遇 边界
            if (A[right] == 0){
                if (k==0){ //已经填充完成
                    //看当前窗口有多少个1
                    while (A[left] == 1){
                        left++
                    }
                    //执行完成继续
                    left++
                }else{
                    //继续填充
                    k--
                }
            }
            //更新最大值
            res = Math.max(res,right-left+1)
        }

        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
