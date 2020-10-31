/*
 * @lc app=leetcode.cn id=381 lang=java
 *
 * [381] O(1) 时间插入、删除和获取随机元素 - 允许重复
 */

// @lc code=start
class RandomizedCollection {
    //存储元素
    List<Integer> list;
    //元素为key 下标为值
    Map<Integer, Set<Integer>> idx;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        idx = new HashMap<>();
        rand = new Random();
    }
    
   /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
   public boolean insert(int val) {
    idx.computeIfAbsent(val, set -> new HashSet<>()).add(list.size());
    list.add(val);
    return idx.get(val).size() == 1;
}

/** Removes a value from the collection. Returns true if the collection contained the specified element. */
public boolean remove(int val) {
    if (!idx.containsKey(val)) {
        return false;
    }
    int i = idx.get(val).iterator().next();
    idx.get(val).remove(i);
    if (idx.get(val).isEmpty()) {
        idx.remove(val);
    }
    if (i != list.size() - 1) {
        int last = list.get(list.size() - 1);
        list.set(i, last);
        idx.get(last).add(i);
        idx.get(last).remove(list.size() - 1);
        if (idx.get(last).isEmpty()) {
            idx.remove(last);
        }
    }
    list.remove(list.size() - 1);
    return true;
}

/** Get a random element from the collection. */
public int getRandom() {
    return list.get(rand.nextInt(list.size()));
}
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end

