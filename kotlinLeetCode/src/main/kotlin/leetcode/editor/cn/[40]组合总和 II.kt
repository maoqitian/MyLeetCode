import java.util.*
import kotlin.collections.ArrayList

//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 609 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {

        //和39 题 一样 递归回溯剪枝
        //先排序数组

        var res = ArrayList<ArrayList<Int>>()
        //排好序保证后续剪枝判断是否使用
        Arrays.sort(candidates)

        if (candidates.isEmpty()) return res

        dfsCombinationSum2(0,LinkedList<Int>(),candidates,target,res)

        return res
    }

    private fun dfsCombinationSum2(index: Int, stack: LinkedList<Int>, candidates: IntArray, target: Int, res: java.util.ArrayList<java.util.ArrayList<Int>>) {
        //递归结束条件
        if(target == 0){
            res.add(ArrayList(stack))
            return
        }
        //逻辑处理 进入下层循环
        for (i in index until candidates.size){

            //剪枝
            //接下来下的值大于目标值 数组排序递增 接下来也不可能有匹配的数 终止
            if (target - candidates[i] <0) break
            //同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if(i > index && candidates[i] == candidates[i-1]) continue

            stack.addLast(candidates[i])
            dfsCombinationSum2(i+1,stack,candidates,target - candidates[i],res)
            //回溯
            stack.removeLast()
        }
        //数据reverse
    }


}
//leetcode submit region end(Prohibit modification and deletion)
