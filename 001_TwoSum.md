#####First version

```
public static int[] twoSum(int[] nums, int target) {
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

It is slow and beats only 14%, because two loops are too expensive. Let's improve it. 

#####Second version

```
public static int[] twoSumMap(int[] numbers, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
        if (map.containsKey(target - numbers[i])) {
            result[1] = i;
            result[0] = map.get(target - numbers[i]);
            return result;
        }
        map.put(numbers[i], i);
    }
    return result;
}
```

We can use map to achieve this (as above) or another method, in which we order the array first, and then we find the indices of the minimum (0) and the maximum (n-1), and then add these two numbers together and compare the result with the target. If the result is larget than the target, we decrement the maximum index, otherwise we increment the minimum index.

Other tricks:

1. Creating a temporary array almost does not cost time: 
```
int[] array = new int[2];
array[0] = i;                      same as      return new int[] {i, j};
array[1] = j;                      ======>
return array;
```
2. Should verify the input;
3. Should return null while the result is not excepted;
4. Define nums.length to get tiny gain;
