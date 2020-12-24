//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻的孩子中，评分高的孩子必须获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 示例 1: 
//
// 输入: [1,0,2]
//输出: 5
//解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2: 
//
// 输入: [1,2,2]
//输出: 4
//解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 404 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun candy(ratings: IntArray): Int {

        //正逆序遍历一次 时间复杂度 O(n)

        val len = ratings.size

        if(len == 0) return 0;
        val candys = IntArray(len)
        //至少一个糖果
        candys[0] = 1
        for(i in 1 until len){
            if(ratings[i]>ratings[i-1]){
                //分数高加上一个糖果
                candys[i] = candys[i-1]+1
            }else{
                candys[i] =1
            }
        }

        //逆序在遍历一次
        for(i in len-2 downTo 0){
            //当前
            if(ratings[i]>ratings[i+1] && candys[i] <= candys[i+1]){
                //分数高加上一个糖果
                candys[i] = candys[i+1]+1
            }
        }
        var res = 0
        candys.forEach {
            res += it
        }
        return  res

    }
}
//leetcode submit region end(Prohibit modification and deletion)
