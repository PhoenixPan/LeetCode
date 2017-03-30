## 1. Double Loop
Time complexity: O(n^2)  
Space complexity: O(1)  
```
public static int[] twoSum(int[] nums, int target) {
  if (nums == null)
    return null;
    
  int len = nums.length;
        
  for (int i = 0; i < nums.length; i++) {
    for (int j = i + 1; j < nums.length; j++) {
      if (nums[i] + nums[j] == target) {
        System.out.println(i + " " + j);
        return new int[] {i,j};
      }
    }
  }
  return new int[] {0,0};
}
```

O(n^2) because of two loops. Let's improve it.  

## 2. Two-pass Hashing
Use Hashmap to reduce the time for each lookup to O(1).  

Time complexity: O(n)  
Space complexity: O(n)  

```
public static int[] twoSumMap(int[] nums, int target) {
  if (nums == null)
  return null;
    
  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
  for (int i = 0; i < nums.length; i++) {
    int complement = target - nums[i];
    if (map.containsKey(complement) && map.get(complement) != i) { // Can't use any element twice
      return new int[] {i, map.get(complement)};
    }
    map.put(nums[i], i);
  }
  return null;
}
```
## 3. Array Approaching

Time complexity: O(nlogn + n) (time used to sort the array should be counted)    
Space complexity: O(n)  

We can also use array. We order the array first and then we find the indices of the minimum (0) and the maximum (n-1), and then add these two numbers together and compare the result with the target. If the result is larget than the target, we decrement the maximum index, otherwise we increment the minimum index.

## Other Notes

1. Creating a temporary array almost does not cost time: 
```
int[] array = new int[2];
array[0] = i;                      same as      return new int[] {i, j};
array[1] = j;                      ======>
return array;
```
2. Should verify the input;
3. Should return null while the result is not excepted;
4. Define nums.length to get a tiny gain;
