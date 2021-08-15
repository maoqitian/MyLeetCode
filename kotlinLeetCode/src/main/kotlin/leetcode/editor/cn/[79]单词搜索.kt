//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 
// 👍 986 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //         (x-1,y)
    //  (x,y-1) (x,y) (x,y+1)
    //         (x+1,y)
    //路径数组
    private val direction =
            arrayOf(intArrayOf(-1, 0), intArrayOf(0, -1), intArrayOf(0, 1), intArrayOf(1, 0))
    //是否访问数组
    lateinit var marked:Array<BooleanArray>
    //行列
    var row = 0
    var col = 0
    fun exist(board: Array<CharArray>, word: String): Boolean {
        //递归深度优先遍历
        //上下左右匹配
        row = board.size
        if (row == 0) return false
        col = board[0].size
        marked = Array(row){ BooleanArray(col) }

        for (i in 0 until row){
            for (j in 0 until col){
                if(dfs(board,word,i,j,0)){
                    return true
                }
            }
        }
        return false
    }

    private fun dfs(board: Array<CharArray>, word: String, i: Int, j: Int, start: Int): Boolean {
        //递归结束条件
        if(start == word.length -1) return board[i][j] == word[start]
        //逻辑处理 进入下层循环
        if(board[i][j] == word[start]){
            //如果匹配 记录访问标志
            marked[i][j] = true
            for (k in 0 ..3){
                //上下左右匹配
                val newX = i+ direction[k][0]
                val nexY = j+ direction[k][1]
                if(inArea(newX,nexY) && !marked[newX][nexY]){
                    if (dfs(board,word,newX,nexY,start+1)){
                        return true
                    }
                }
            }
            //回溯
            marked[i][j] = false
        }
        //数据reverse
        return false
    }

    private fun inArea(x: Int, y: Int): Boolean {
        return x >= 0 && x < row && y >=0 && y<col
    }
}
//leetcode submit region end(Prohibit modification and deletion)
