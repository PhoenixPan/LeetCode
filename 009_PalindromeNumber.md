##First version
This passed, but it actually has a bug, when the number is 2147483648, 2147483649, -2147483649.
```
public class Solution {
    public boolean isPalindrome(int x) {
       if (x < 0 || x >= 2147483642) // making huge difference in performance, probably due to the speciality of the test cases 
		return false;
	int original = x;
	int reversed = 0;
	int digit = 0;

	while (x != 0) {
		if (digit == 9) {
			if (reversed > 214748364 || reversed < -214748364)
				return false;
		}
	
		reversed = reversed * 10 + x % 10;
		x = x / 10;
		digit++;
	}
	return original == reversed;
    }
}
```
##Second version
So we add two more judgements, but the performance drop from 10ms to 14ms

```
public class Solution {
    public boolean isPalindrome(int x) {
       if (x < 0 || x >= 2147483642)
		return false;
	int original = x;
	int reversed = 0;
	int digit = 0;

	while (x != 0) {
		if (digit == 9) {
			if (reversed > 214748364 || reversed < -214748364)
				return false;
		}
	    if (reversed == 214748364 && x % 10 > 7)
	        return false;
	    if (reversed == -214748364 && x % 10 > 8)
	        return false;
	        
		reversed = reversed * 10 + x % 10;
	    
		x = x / 10;
		digit++;
	}
	
	return original == reversed;
    }
}

```
