import java.util.*

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 736 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {

        //暴力法 遍历每个窗口最大值 时间复杂度 O(n*k) 超出时间限制
        if (nums.size * k == 0) return IntArray(0)

        val res = IntArray(nums.size - k +1)

//        for (i in 0 until nums.size - k +1){
//            var max = Int.MIN_VALUE
//            for ( j in i until i+k){
//                max = Math.max(max,nums[j])
//            }
//            res[i] = max
//        }

        //方法二 队列存储下标数组 保证从大到小排列
        //双端队列
        val queue = LinkedList<Int>()
        for (i in 0 until nums.size){
            if (!queue.isEmpty() && queue.peek() < i-k+1){
                //下标大于链表值 出队
                queue.poll()
            }

            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]){
                queue.pollLast()
            }
            //当前下标值加入尾部
            queue.offer(i)
            //保存当前层最大值
            if(i-k +1 >=0){
                //没有超过边界
                res[i-k+1] = nums[queue.peek()]
            }
        }
        return res

    }
}
//leetcode submit region end(Prohibit modification and deletion)
