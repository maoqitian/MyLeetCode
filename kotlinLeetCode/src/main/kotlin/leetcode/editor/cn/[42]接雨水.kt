import java.util.*

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2424 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun trap(height: IntArray): Int {

        //方法一 双指针暴力破解
        var res =0
        for (i in 1 until height.size-1){
            var left = 0
            var right = 0
            for (j in i-1 downTo 0){
                left = Math.max(left,height[j])
            }

            for (k in i+1 until height.size){
                right = Math.max(right,height[k])
            }
            //双指针最小高度 说明能接住雨水最小高度
            var heightMin = Math.min(left,right)

            if (heightMin > height[i]){
                //计算面积
                res = res + heightMin-height[i]
            }

        }

        return res

        //方法二 使用栈 利用栈来存储对应遍历的数组下标 当前下标值小于栈顶元素值，则入栈，移动指针继续遍历。（能够积水）
        // 当前下标值大于栈顶元素，则出栈计算
        var stack = LinkedList<Int>()

        var res = 0
        //当前遍历下标
        var currIndex = 0

        while (currIndex < height.size){
            //当前值大于栈顶元素 说明可以积水 取出计算
            while(!stack.isEmpty() && height[currIndex] > height[stack.peek()]){
                var tempHeight = height[stack.removeFirst()]

                if (stack.isEmpty()) break

                //获取宽度
                var width = currIndex - stack.peek() -1
                //计算面积
                //获取高度
                var mHeight = Math.min(height[stack.peek()],height[currIndex])
                //计算面积
                res += width * (mHeight - tempHeight)
            }
            //保存下标
            stack.addFirst(currIndex)
            currIndex++
        }

        return res

    }
}
//leetcode submit region end(Prohibit modification and deletion)
