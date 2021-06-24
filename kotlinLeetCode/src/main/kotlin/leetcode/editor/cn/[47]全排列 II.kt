import java.util.*
import kotlin.collections.ArrayList

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯算法 
// 👍 734 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {

        //递归 回溯剪枝  dfs 重点是先排序数组 好判断是否重复剪枝
        var res = ArrayList<ArrayList<Int>>()

        Arrays.sort(nums)

        var isUse = BooleanArray(nums.size)

        dfs(0,isUse,nums.size,nums,LinkedList<Int>(),res)

        return res
    }

    private fun dfs(index: Int, use: BooleanArray, size: Int, nums: IntArray, stack: LinkedList<Int>, res: java.util.ArrayList<java.util.ArrayList<Int>>) {
        //递归结束条件
        if(index == size){
            res.add(ArrayList(stack))
        }
        //逻辑处理进入下层循环
        for (i in nums.indices){
            //剪枝 是否已经使用 或者是否重复数
            if(use[i]) continue
            //如果没有使用该数 并且该数与上一个数相等 重复 跳过
            if(i > 0 &&(nums[i] == nums[i-1]) && !use[i-1]) continue

            //正常处理逻辑 回溯
            use[i] = true
            stack.addLast(nums[i])

            dfs(index+1,use,size,nums,stack,res)
            //回溯
            use[i] = false
            stack.removeLast()
        }
        //数据reverse
    }
}
//leetcode submit region end(Prohibit modification and deletion)
