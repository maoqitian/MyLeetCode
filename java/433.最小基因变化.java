import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {

    //想法 DFS 递归 回溯

    int minCount = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        //使用 HashSet 存储基于组

        dfs(0,start,end,bank,new HashSet<String>());

        return (minCount == Integer.MAX_VALUE) ? -1 : minCount;

    }
    /**
     * @param setpCount  当前次数
     * @param currentStr 当前基于组
     * @param end 目标基于组
     * @param bank 基因库
     * @param set 存储基因组 集合 不可重复
     */
    void dfs(int setpCount,String currentStr,String end,String[] bank,HashSet<String> set){

        //递归结束条件
        if(setpCount >= minCount){
            //当前次数大于最小次数
           return;
        }
        //逻辑处理 进入下层循环
        if(currentStr.equals(end)){
           //如果已经匹配到 获取最新次数
           minCount = Math.min(minCount, setpCount);
        }

        //遍历基因库
        for (String str : bank) {
            int diff =0;
            //循环判断当前字符是否有不同
            for (int i = 0; i < str.length(); i++) {
                if(currentStr.charAt(i) != str.charAt(i)){
                  diff++;
                  if(diff>1){ //如果有一个不同直接跳出循环
                     break;
                  }
                }
            }
            if(diff == 1 && !set.contains(str)){//如果有不同,并且结合不含相同基因组
                set.add(str);
                //进入下层循环
                dfs(setpCount+1, str, end, bank, set);
                //回溯 数据 reverse
                set.remove(str);
            }
            
        }
    }
}
// @lc code=end
