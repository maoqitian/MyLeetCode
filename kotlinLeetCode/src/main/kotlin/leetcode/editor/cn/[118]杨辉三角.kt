//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 451 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        //数学二项式
        // n 行的第 i个数等于第 n−1 行的第 i-1个数和第 i个数之和

        var res = ArrayList<ArrayList<Int>>()

        for (i in 0 until numRows){
            var temp = ArrayList<Int>()
            for (j in 0..i){
                if(j == 0 || j == i){
                    //首尾为1
                    temp.add(1)
                }else{
                    temp.add(res[i-1][j] + res[i-1][j-1])
                }
            }
            res.add(temp)
        }

        return  res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
