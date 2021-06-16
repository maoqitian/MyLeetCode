
import java.util.*
import kotlin.collections.ArrayList


//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1390 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

        //递归回溯 剪枝
        // 使用栈来保存当前层结果 栈顶操作 方便回溯移除不符合元素
        //时间复杂度 O（n） n 为组合长度
        //想法 每次从数组取出一个数与 target 相减 继续在数组中寻找数与 target 相减
        var res = ArrayList<ArrayList<Int>>()
        //递归

        if (candidates.isEmpty()) return res

        dfsCombination(0,LinkedList<Int>(),candidates,target,res)

        return  res
    }

    private fun dfsCombination(index: Int, stack: LinkedList<Int>, candidates: IntArray, target: Int, res: ArrayList<ArrayList<Int>>) {
        //递归结束条件
        if(target == 0){
          //符合条件 保存数组
          res.add(ArrayList(stack))
        }
        //逻辑处理 进入下层循环
        //index 为本分支上一节点的减数下标
        for(i in index until candidates.size){
           //目标值大于当前 index 值 继续寻找
            if (candidates[i] <= target){
                stack.addLast(candidates[i])
                dfsCombination(i,stack,candidates,target - candidates[i],res)
                //回溯不符合的值
                stack.removeLast()
            }
        }
        //数据reverse
    }
}
//leetcode submit region end(Prohibit modification and deletion)
