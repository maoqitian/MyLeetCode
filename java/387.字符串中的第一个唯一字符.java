/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {

        int len = s.length();
        if(s == null || len == 0) return -1;
        
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0;i < len; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
               map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        int res = -1;
        for(int i = 0; i< len; i++){
           if(map.get(s.charAt(i)) < 2){
               res = i;
               break;
           }
        }

        return res;
    }
}
// @lc code=end

