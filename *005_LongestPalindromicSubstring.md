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





```
public class Solution {
    private int lo, maxLen;
    public String longestPalindrome(String s) {

    int len = s.length();
    if (len < 2)
        return s;

    for (int i = 0; i < len-1; i++) {
        extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
        extendPalindrome(s, i, i+1); //assume even length.
    }
    return s.substring(lo, lo + maxLen);
}

private void extendPalindrome(String s, int j, int k) {
    while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
        j--;
        k++;
    }
    if (maxLen < k - j - 1) {
        lo = j + 1;
        maxLen = k - j - 1;
    }

    }
}
```



(http://fisherlei.blogspot.jp/search?q=Palindromic)
