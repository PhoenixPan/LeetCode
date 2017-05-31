## Test sets:
```
""
"a"
"aa"
"aaa"
"aba"
"abba"
"kaba"
"abak"
"kabad"
"kabba"
"abbak"
"kabbad"
"aaaakabbad"
"kabbadaaaa"
"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
```

## Solution 1： time limit exceeded
```
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
            
        String output = "";
        
        for (int i = 0; i < s.length(); i++) {
           for (int j = 0; j < i + 1; j++) {
               int start = j;
               int end = i;
               while (s.charAt(start) == s.charAt(end)) {
                   if (end - start == 2 || end - start == 1) {
                        output = output.length() >= s.substring(j,i + 1).length()? output: s.substring(j,i + 1);
                        break;
                   }
                   if (end == 0 || start == i)
                       break;
                   start++;
                   end--;
               }
           }
        }
    return output;
    }
}
```
Mutation: Replacing string manipulation with int values, but it dones't improve the performance.
```
public class Solution {
    public String longestPalindrome(String s) {
        
        int length = s.length();
        int startLocation = 0;
        int longestLength = 0;
        if (s == null || length < 2)
            return s;
        
        for (int i = 0; i < length; i++) {
           for (int j = 0; j < i + 1; j++) {
               int start = j;
               int end = i;
               while (s.charAt(start) == s.charAt(end)) {
                   if (end - start == 2 || end - start == 1) {
                        if (longestLength < i - j + 1) {
                            startLocation = j;
                            longestLength = i - j + 1;
                        }
                        break;
                   }
                   if (end == 0 || start == i)
                       break;
                   start++;
                   end--;
               }
           }
        }
    return s.substring(startLocation, startLocation + longestLength);
    }
}
```

## Solution 2: was accepted, now exceeds time limit
中间开花

Time: O(n^2), Space: O(1) 
```
public static String longestPalindrome(String s) {
    	if (s == null || s.length() == 0) return s;
    	
    	int len = s.length();
    	String output = "";
        for(int i = 0; i < len; i++) { 
        	// for "aba"
        	int left = i;
        	int right = i;
        	
        	while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
        		left--;
        		right++;
        	}
        	left++; // restore the last modification
        	right--;
        	output = right - left >= output.length()? s.substring(left, right + 1) : output;      	
        	
        	// for "abba"
        	left = i;
        	right = i + 1;
        	
        	while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
        		left--;
        		right++;
        	}
        	left++; // restore the last modification
        	right--;
        	output = right - left >= output.length()? s.substring(left, right + 1) : output;
        }        
        return output;
    }
```

## Test case 1
Solution 1: ~100ms  
Solution 2: ~10ms  

```
System.out.println(longestPalindrome("") + "/");
System.out.println(longestPalindrome("a") + "/a");
System.out.println(longestPalindrome("aa") + "/aa");
System.out.println(longestPalindrome("aaa") + "/aaa");
System.out.println(longestPalindrome("abc") + "/a");
System.out.println(longestPalindrome("aabaa") + "/aabaa");
System.out.println(longestPalindrome("kaba") + "/aba");
System.out.println(longestPalindrome("abak") + "/aba");
System.out.println(longestPalindrome("kabad") + "/aba");
System.out.println(longestPalindrome("kabba") + "/abba");
System.out.println(longestPalindrome("kabbad") + "/abba");
System.out.println(longestPalindrome("aaaakabbad") + "/aaaa");
System.out.println(longestPalindrome("kabbadaaaa") + "/abba");
System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		
```
