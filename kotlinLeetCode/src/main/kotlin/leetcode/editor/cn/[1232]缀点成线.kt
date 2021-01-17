//在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为
// x、纵坐标为 y 的点。 
//
// 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 2 <= coordinates.length <= 1000 
// coordinates[i].length == 2 
// -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4 
// coordinates 中不含重复的点 
// 
// Related Topics 几何 数组 数学 
// 👍 63 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun checkStraightLine(c: Array<IntArray>): Boolean {

        //斜率公式
        //(y1-y0)/(x1-x0)=(yi-y0)/(xi-x0)
        //变化乘积形式
        //(y1-y0)*(xi-x0)==(x1-x0)*(yi-y0)
        //时间复杂度 O(n)

        for (i in 2 until c.size){
            if((c[1][1]-c[0][1])*(c[i][0]-c[0][0])!=(c[i][1]-c[0][1])*(c[1][0]-c[0][0])){
             return false
            }
        }

        return true

    }
}
//leetcode submit region end(Prohibit modification and deletion)
