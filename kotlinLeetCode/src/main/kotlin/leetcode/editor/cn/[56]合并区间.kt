import java.lang.Integer.compare
import java.util.*


//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 数组 排序 
// 👍 1002 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {

        //排序 时间复杂度 O(nlogn)
        Arrays.sort(intervals) { a: IntArray, b: IntArray -> a[0] - b[0] }

        //使用链表了来保存每个子集值
        var mergeLink = LinkedList<IntArray>()

        for (interval in intervals){
            //返回结果链表为空
            //或者链表的大区间小于当前区间的小区间
            //当前数组没有重合
            if(mergeLink.isEmpty() || mergeLink.last[1] < interval[0]){
               mergeLink.add(interval)
            }else{
                //区间有重复 合并区间值
               mergeLink.last[1] = Math.max(mergeLink.last[1],interval[1])
            }
        }

        return mergeLink.toTypedArray()
    }
}
//leetcode submit region end(Prohibit modification and deletion)
