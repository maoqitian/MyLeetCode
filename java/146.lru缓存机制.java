import java.util.LinkedHashMap;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache {

    //思想 直接使用 LinkedHashMap 内部使用 双端队列 加上 数组 Hashmap 基础上得扩展
    // 使得元素有序排列 新加入元素 尾部添加 删除元素 删除链表头部

    LinkedHashMap<Integer,Integer> map;

    public LRUCache(int capacity) {
        /**
         * capacity 存储上限
         * 0.75f 加载因子 数组最大容量 * 0.75  超过这个值数组扩容
         * true 表示按照顺序 排序
         */
        map = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
             @Override
             protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
            
                 return size() > capacity;
             }
        };

    }
    
    public int get(int key) {
          return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
         map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

