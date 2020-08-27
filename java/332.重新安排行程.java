/*
 * @lc app=leetcode.cn id=332 lang=java
 *
 * [332] 重新安排行程
 */

// @lc code=start
class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    List<String> itinerary = new LinkedList<String>();
    public List<String> findItinerary(List<List<String>> tickets) {

        //欧拉路径 时间复杂度 O(mlogm)

        //遍历 入 map 保存
        for(List<String> ticket:tickets){
            //开始地点 结束地点
          String src = ticket.get(0),dst = ticket.get(1);
          if(!map.containsKey(src)){
              //不包含 保存
              map.put(src,new PriorityQueue<String>());
          }

          map.get(src).offer(dst);
        }

        //深度优先递归

        dfs("JFK");
        
        //倒置
        Collections.reverse(itinerary);

        return itinerary;
    }

    void dfs(String src){

        while(map.containsKey(src) && map.get(src).size() > 0){
            //获取 目的地开头寻找下一个
            String dstTemp = map.get(src).poll();
            dfs(dstTemp);
        }

        itinerary.add(src);

    }
}
// @lc code=end

