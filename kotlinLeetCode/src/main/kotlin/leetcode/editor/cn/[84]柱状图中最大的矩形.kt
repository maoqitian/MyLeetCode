import java.util.*


//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1101 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var len: Int = heights.size
        if (len == 0) {
            return 0
        }

        if (len == 1) {
            return heights[0]
        }

        var max = 0
        //新增哨兵数组
        val newHeights = IntArray(len + 2)

        //加入原数组值
        for (i in 0 until len) {
            newHeights[i + 1] = heights[i]
        }

        len += 2

        //创建栈
        val stack = LinkedList<Int>()
        stack.addLast(0)
        for (i in 1 until newHeights.size) {
            while (!stack.isEmpty() && newHeights[stack.last] > newHeights[i]){
                val cur = stack.removeLast()
                max = Math.max(max,(i-stack.last-1)*newHeights[cur])
            }
            stack.addLast(i)
        }

        return max
    }
}
//leetcode submit region end(Prohibit modification and deletion)
