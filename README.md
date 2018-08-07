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
结束条件？start <= end
