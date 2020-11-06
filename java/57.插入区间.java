/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        //区间插入 比较数值 是否在遍历到的数组中 时间复杂度 O(n)

        List<int[]> listTemp = new ArrayList<>();
         
        //获取需插入区间左右边界
        int left = newInterval[0];
        int right = newInterval[1];


        //新区间是否已经插入数组

        boolean isAdd = false;
        //遍历目标数组集合

        for(int [] temp : intervals){

             //新插入区间在当前区间的左侧 不与当前数组区间重合
            if(right<temp[0]){
                if(!isAdd){
                    //后面区间肯定也在当前区间的右边,插入新区间
                    listTemp.add(new int[]{left,right});
                    isAdd = true;
                }
              listTemp.add(temp);
            }else if(left > temp[1]){ 
                //新加入区间在当前数组区间的右侧
               //插入当前的区间
               listTemp.add(temp);
               //这个地方不用插入新区间，因为还不能确定具体的插入位置
            }else {
                //区间重叠
                //重新计算left和right，把这两个区间合并成一个新的待插入区间
                left=Math.min(left,temp[0]);
                right=Math.max(right,temp[1]);
            }
        }
        //判断区间是否插入保存结果数组
        if(!isAdd){
            listTemp.add(new int[]{left,right});
        }
        //构造结果
        int [][]res = new int[listTemp.size()][2];
        for(int i=0;i<listTemp.size();i++){
            res[i] = listTemp.get(i);
        }

        return res;
    
    }
}
// @lc code=end

