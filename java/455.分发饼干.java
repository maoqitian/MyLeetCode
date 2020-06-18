import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {

        //贪心算法  时间复杂度 O(n) 
        // 分配看是否合适
        //排序
        Arrays.sort(g);
        Arrays.sort(s);
        //两个数组取值指针
        int i = 0, j = 0;
 
        int glength = g.length;
        int slength = s.length;
        int res = 0;

        while(i<glength && j<slength){
            
            if(g[i] <= s[j] ){
              //足够分
              i++;
              j++;
              res++;
            }else{
                //不够分，继续找下一块
              j++;
            }
        }

        return res;


    }
}
// @lc code=end

