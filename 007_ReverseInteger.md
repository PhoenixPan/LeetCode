Test cases:
-2147483412
2147483412

2147483648
-2147483647 // Why error?

1534236469
-1534236469


```
public class Solution {
    public int reverse(int x) {
        int reversed = 0;
    	int digit = 0;
    	while (x != 0) {
		if (digit == 9) {//2147483648
			if (reversed > 214748364 || reversed < -214748364)
				return 0;
			else if (reversed == 214748364 && x % 10 >7)
				return 0;
			else if (reversed == -214748364 && x % 10 >8)
				return 0; // not happening as input is int
		}
    		reversed = reversed * 10 + x % 10;
    		x = x / 10;
		digit++;
        }
	return reversed;
    }
}
```





```
public class Solution {
    public int reverse(int x) {
        int reversed = 0;
    	int digit = 0;
    	while (x != 0) {
		if (digit == 9) {//2147483648
			if (x % 10 > 2)
				return 0;
			else if (x % 10 == 2 && reversed > 147483647)
				return reversed;
			else if (x % 10 == 2 && reversed < -147483648)
				return 0;
		}
    		reversed = reversed * 10 + x % 10;
    		x = x / 10;
		digit++;
        }
	return reversed;
    }
}
```

