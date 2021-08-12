import java.util.*
import kotlin.collections.ArrayList

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 
// 👍 1275 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        //递归 回溯
        //使用栈来最为中间保存数组


        val res = ArrayList<ArrayList<Int>>()

        dfs(0,nums.size,nums, LinkedList<Int>(),res)

        return res

    }

    private fun dfs(index: Int, numLen: Int, nums: IntArray, tempStack: LinkedList<Int>, res: java.util.ArrayList<java.util.ArrayList<Int>>) {
        //递归结束条件
        if(index == numLen){
            //从零开始 空数组也算
            res.add(ArrayList(tempStack))
            return
        }
        //逻辑处理
        dfs(index+1,numLen,nums,tempStack, res)
        //取数字
        tempStack.addLast(nums[index])
        dfs(index+1,numLen,nums,tempStack, res)
        //不符合回溯
        tempStack.removeLast()
        //数据reverse
    }
}
//leetcode submit region end(Prohibit modification and deletion)
