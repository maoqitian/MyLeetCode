/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {

        //数学二项式
        // n 行的第 i个数等于第 n−1 行的第 i-1个数和第 i个数之和
        List<List<Integer>> res  = new ArrayList<>();
         
        for(int i = 0; i< 34;i++){
            List<Integer> temp = new ArrayList<>();

            for(int j = 0; j<=i; j++){
               if(j == 0 || j == i) {
                   //首位固定为1
                   temp.add(1);
               }else{
                   temp.add(res.get(i-1).get(j)+res.get(i-1).get(j-1));
               }
            }
            res.add(temp);
        }

        return res.get(rowIndex);
    }
}
// @lc code=end

