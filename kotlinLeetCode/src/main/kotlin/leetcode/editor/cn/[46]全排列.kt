import java.util.*
import kotlin.collections.ArrayList

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯算法 
// 👍 1423 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun permute(nums: IntArray): List<List<Int>> {

        //dfs 递归回溯
        var res = ArrayList<ArrayList<Int>>()

        //使用一个boolean 类型数组来记录是否使用过一个数字
        var isUse = BooleanArray(nums.size)

        dfs(0,isUse,nums.size,nums,LinkedList<Int>(),res)

        return res
    }

    private fun dfs(index: Int, use: BooleanArray, size: Int, nums: IntArray, stack: LinkedList<Int>, res: java.util.ArrayList<java.util.ArrayList<Int>>) {
        //递归结束条件
        if(index == size){
            res.add(ArrayList(stack))
        }
        //逻辑处理 进入下层循环
        for (i in nums.indices){
            //如果已经使用 跳过
            if (use[i]) continue
            //标记已经使用
            use[i] = true
            //保存当前数
            stack.addLast(nums[i])
            dfs(index+1,use,size,nums,stack,res)

            //不符合 回溯
            use[i] = false
            stack.removeLast()
        }
        //数据reverse
    }
}
//leetcode submit region end(Prohibit modification and deletion)
