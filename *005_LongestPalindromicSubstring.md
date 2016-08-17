##Test sets:
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
"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
```

##First Version
This exceeds time limit in case of a 1000-characters-long string.
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

##Second Version

Replacing string manipulation with int values, but it dones't improve the performance.
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


##Third version

In this one we try to extend the number from a middle point, so we could stop at the maximum to avoid waste.  
This 53ms solution beats only 37%. There's still a way to improve! I can also make the loop part a method, so it would look better.  
```
public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        int start = 0;
        int max = 1;
        if (s == null || length < 2)
            return s;
        
        
        for (int i = 0; i < length; i++) {
            int left = i;
            int right = i;
            int thisLength = 0;
            
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            thisLength = right - left - 1;
            
            if (thisLength > max) {
                max = thisLength;
                start = left + 1;
            }
            
            left = i;
            right = i + 1;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            thisLength = right - left - 1;
            
            if (thisLength > max) {
                max = thisLength;
                start = left + 1;
            }
            
        }

    return s.substring(start, start + max);
    }
}
```



(http://fisherlei.blogspot.jp/search?q=Palindromic)
