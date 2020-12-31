/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals,new Comparator<int [] >(){
            public int compare(int [] a1,int [] a2) {
                return a1[1] - a2[1];   //升序排列
            }
        });
        int count = 1;	//最多能组成的不重叠区间个数
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            count++;
        }
        return intervals.length - count;

    }
}
// @lc code=end

