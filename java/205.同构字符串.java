/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s.length()!= t.length()) return false;
        //使用 HashMap 分别以键值 记录 s 和 t 对应位置的字符
        //时间复杂度 O(n) n为字符长度

        HashMap<Character,Character>map = new HashMap<>();
        for(int i = 0;i<s.length();i++){

            if(!map.containsKey(s.charAt(i))){
               //但是 t 存在对应值 说明不对称
               if(map.containsValue(t.charAt(i))){
                   return false;
               }
               //记录键值
               map.put(s.charAt(i),t.charAt(i));
            }else{
               //存在键 值不等
               if(map.get(s.charAt(i)) != t.charAt(i)){
                 return false;
               }
            }
        }

        return true;
        
    }
}
// @lc code=end

