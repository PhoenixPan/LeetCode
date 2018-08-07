# LeetCode

The `Filter.java` is used to convert regular markdown files to Hexo posts markdown. 

## Common time complexity
O(1): 罕见
O(logn): 二分法
O(n): 高频，O(n) 不行八成二分
O(nlogn): 排序，或 logn 的数据结构，如 priority queue
O(n^2): 数组，枚举，DP
O(n^3): 数组，枚举，DP
O(2^n): 组合搜索
O(n!): 排列搜索

根据时间复杂度倒推算法

## Method
### Recursion 递归
1. 询问面试官是否要求使用 recursion
2. Recursion 深度会不会很深（LinkedList X，Tree √）
3. 工业界回避，因为占用栈空间（stack overflow）

## Algorithm
### Binary Search 二分法
#### 模板
```java
while (start + 1 < end) {
  int mid = start + (end - start) / 2;
  if (nums[mid] == target) {
    // ...
  } else if (nums[mid] < target) {
    // ...
  } else {
    // ...
  }
}
```

注意事项：
1. 结束条件使用 start + 1 < end 确保不会死循环，因为除2的结果偏左；
2. mid + 1 或 mid -1 会排除当前元素，若是错误使用则可能会导致无解；
3. 不建议将 == 代码块和 < 或 > 代码块合并为 <= 或 >= 处理，为此需要考虑解的范围，浪费时间；