import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        

        //想法 BFS 
        //如果字典不包含目标单词 直接返回
        Set<String> wordSet = new HashSet<>(wordList);
        if(wordSet.size() == 0 || !wordSet.contains(endWord)){ 
            return 0;
        }
        Set<String> beginSet = new HashSet<>(),endSet = new HashSet<>();

        int len =1;

        HashSet<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
     
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
           if(beginSet.size() > endSet.size()){
              //优先尝试少的数据尝试
              Set<String> temp = beginSet;
              beginSet = endSet;
              endSet = temp;
           }        

           Set<String> nextLevelVisited = new HashSet<>();
           for (String string : beginSet) {
               //获取当前beginWord字符串的 每个字符集合
               char[] chs = string.toCharArray();

               int wordLen = string.length();
               for (int i = 0; i < wordLen; i++) {
                   char currentChar = chs[i];

                   for(char c= 'a';c<= 'z';c++){
                       //如果已经包含
                       if(chs[i] == c){
                         continue;
                       }
                       //替换
                       chs[i] = c;
                       String nextWord = String.valueOf(chs);

                       if(wordSet.contains(nextWord)){ //如果字典集合包含
                          if(endSet.contains(nextWord)){
                              return len+1;
                          }
                          if(!visited.contains(nextWord)){
                             nextLevelVisited.add(nextWord);
                             visited.add(nextWord);
                          }
                       }
                   }
                   //恢复下次用
                   chs[i] = currentChar;  
               }
           }
           // 当前操作了一次 从 begin 这一侧向外扩散了一层
           beginSet = nextLevelVisited;
           len++;
        }
        return 0;
    }
}
// @lc code=end

