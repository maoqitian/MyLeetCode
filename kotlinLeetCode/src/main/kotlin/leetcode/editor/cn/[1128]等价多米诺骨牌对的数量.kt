//给你一个由一些多米诺骨牌组成的列表 dominoes。 
//
// 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。 
//
// 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 
//b==c。 
//
// 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i,
// j) 的数量。 
//
// 
//
// 示例： 
//
// 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dominoes.length <= 40000 
// 1 <= dominoes[i][j] <= 9 
// 
// Related Topics 数组 
// 👍 101 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {

        val map = IntArray(100)
        var res = 0
        for (i in dominoes.indices) {
            val m = dominoes[i][0]
            val n = dominoes[i][1]
            val k = if (m > n) m * 10 + n else n * 10 + m
            map[k]++
        }
        for (i in 0..99) {
            res += map[i] * (map[i] - 1) / 2
        }
        return res

    }
}
//leetcode submit region end(Prohibit modification and deletion)
