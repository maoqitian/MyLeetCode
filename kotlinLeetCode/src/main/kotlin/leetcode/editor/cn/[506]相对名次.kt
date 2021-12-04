import java.util.*


//给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
//
// 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况： 
//
// 
// 名次第 1 的运动员获金牌 "Gold Medal" 。 
// 名次第 2 的运动员获银牌 "Silver Medal" 。 
// 名次第 3 的运动员获铜牌 "Bronze Medal" 。 
// 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。 
// 
//
// 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：score = [5,4,3,2,1]
//输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
//解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。 
//
// 示例 2： 
//
// 
//输入：score = [10,3,8,9,4]
//输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
//解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
// 
//
// 
//
// 提示： 
//
// 
// n == score.length 
// 1 <= n <= 104 
// 0 <= score[i] <= 106 
// score 中的所有值 互不相同 
// 
// Related Topics 数组 排序 堆（优先队列） 
// 👍 156 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findRelativeRanks(score: IntArray): Array<String> {

        val n: Int = score.size
        val desc = arrayOf("Gold Medal", "Silver Medal", "Bronze Medal")

        val arr = Array(n) { IntArray(2) }

        for (i in 0 until n) {
            arr[i][0] = score[i]
            arr[i][1] = i
        }
        //排序
        Arrays.sort(arr) { a: IntArray, b: IntArray -> b[0] - a[0] }

        var ans = Array<String>(n){ _ -> "" }
        for (i in 0 until n) {
            if (i >= 3) {
                ans[arr[i][1]] = (i + 1).toString()
            } else {
                ans[arr[i][1]] = desc[i]
            }
        }
        return ans

    }
}
//leetcode submit region end(Prohibit modification and deletion)
