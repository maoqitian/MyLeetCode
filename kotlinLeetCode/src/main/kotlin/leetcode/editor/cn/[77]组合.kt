import java.util.*
import kotlin.collections.ArrayList

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 
// 👍 652 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {

        //递归 回溯

        var res = ArrayList<ArrayList<Int>>()

        dfs(1,n,k,LinkedList<Int>(),res)

        return res
    }

    private fun dfs(index: Int, n: Int, k: Int, tempList: LinkedList<Int>, res: java.util.ArrayList<java.util.ArrayList<Int>>) {
        //递归结束条件
        if (tempList.size == k){
            res.add(ArrayList(tempList))
            return
        }
        //逻辑处理
        for (i in index..n){
            tempList.add(i)
            dfs(i+1,n,k,tempList,res)
            //回溯
            tempList.removeLast()
        }

        //数据reverse
    }


}
//leetcode submit region end(Prohibit modification and deletion)
