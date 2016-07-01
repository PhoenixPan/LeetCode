```
public class Solution {
    public boolean isPalindrome(int x) {
       if (x < 0 || x >= 2147483642) // making huge difference!
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
