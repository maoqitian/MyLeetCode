/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {

        if(points.length<1) return 0;

        //根据每个气球右边距进行排序 时间复杂度 O(nlogn)

        Arrays.sort(points,(x,y) -> Integer.compare(x[1],y[1]));
        //假设有一支箭射中

        int res = 1;

        //开始坐标
        int[]start = points[0];
        //遍历每个气球边界
        for(int i =0; i < points.length;i++){
           if(points[i][0] > start[1]){
               //减去一个气球 加一枝箭
               start = points [i];
               res++;
           }
        }
        return res;

    }
}
// @lc code=end

