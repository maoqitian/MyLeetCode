
import java.util.*


//给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values
//[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。 
//
// 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj =
// ? 的结果作为答案。 
//
// 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。 
//
// 
//
// 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"]
//,["b","a"],["a","e"],["a","a"],["x","x"]]
//输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
//解释：
//条件：a / b = 2.0, b / c = 3.0
//问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
// 
//
// 示例 2： 
//
// 
//输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], quer
//ies = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//输出：[3.75000,0.40000,5.00000,0.20000]
// 
//
// 示例 3： 
//
// 
//输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a
//","c"],["x","y"]]
//输出：[0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj 由小写英文字母与数字组成 
// 
// Related Topics 并查集 图 
// 👍 385 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        var count = 0

        //统计出现的所有字符，并赋予对应的index
        val map: MutableMap<String, Int> = HashMap()
        for (list in equations) {
            for (s in list) {
                if (!map.containsKey(s)) {
                    map[s] = count++
                }
            }
        }

        //构建一个矩阵来代替图结构
        val graph = Array(count + 1) { DoubleArray(count + 1) }


        //初始化
        for (s in map.keys) {
            val x = map[s]!!!!
            graph[x][x] = 1.0
        }
        var index = 0
        for (list in equations) {
            val a = list[0]
            val b = list[1]
            val aa = map[a]!!!!
            val bb = map[b]!!!!
            val value = values[index++]
            graph[aa][bb] = value
            graph[bb][aa] = 1 / value
        }

        //通过Floyd算法进行运算
        //通过Floyd算法进行运算
        val n = count + 1
        for (i in 0 until n) {
            for (j in 0 until n) {
                for (k in 0 until n) {
                    if (j == k || graph[j][k] != 0.toDouble()) continue
                    if (graph[j][i] != 0.toDouble() && graph[i][k] != 0.toDouble()) {
                        graph[j][k] = graph[j][i] * graph[i][k]
                    }
                }
            }
        }

        //直接通过查询矩阵得到答案
        //直接通过查询矩阵得到答案
        val res = DoubleArray(queries.size)
        for (i in res.indices) {
            val q = queries[i]
            val a = q[0]
            val b = q[1]
            if (map.containsKey(a) && map.containsKey(b)) {
                val ans = graph[map[a]!!][map[b]!!]
                res[i] = if (ans == 0.0) -1.0 else ans
            } else {
                res[i] = -1.0
            }
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
