import java.util.*
import kotlin.collections.ArrayList

//给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。 
//
// 示例 3： 
//
// 
//输入：intervals = [], newInterval = [5,7]
//输出：[[5,7]]
// 
//
// 示例 4： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,3]
//输出：[[1,5]]
// 
//
// 示例 5： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,7]
//输出：[[1,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= intervals[i][0] <= intervals[i][1] <= 105 
// intervals 根据 intervals[i][0] 按 升序 排列 
// newInterval.length == 2 
// 0 <= newInterval[0] <= newInterval[1] <= 105 
// 
// Related Topics 数组 
// 👍 450 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        //将新区间加入集合 然后排序 执行和56题一样的逻辑处理
        //时间复杂度 O（nlogn）
         val mergeList = ArrayList<IntArray>()

         intervals.forEach {
             mergeList.add(it)
         }
        mergeList.add(newInterval)
        //排序
        mergeList.sortWith(Comparator { a: IntArray, b: IntArray -> a[0] - b[0] })

        val linkedList = LinkedList<IntArray>()
        
        mergeList.forEach {
            if(linkedList.isEmpty() || linkedList.last[1] < it[0]){
                linkedList.add(it)
            }else{
                //区间有重合
                linkedList.last[1] = Math.max( linkedList.last[1],it[1])
            }
        }
        return linkedList.toTypedArray()
    }
}
//leetcode submit region end(Prohibit modification and deletion)
