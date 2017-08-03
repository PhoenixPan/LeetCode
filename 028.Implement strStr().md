## Solution 1: accepted 58%

Brutal force with decreased lookbacks.  

```java
public class Solution {
    public int strStr(String haystack, String needle) {    
        int hayLen = haystack.length(); 
        int nedLen = needle.length();   
        
        if (nedLen == 0) {
            return 0;
        }
        
        for(int i = 0; i < hayLen - nedLen + 1; i++) {
            int hay = i;
            int ned = 0;
            while (haystack.charAt(hay) == needle.charAt(ned)) {
                hay++;
                ned++;
                if (ned == nedLen)
                    return i;
                continue;
            }          
        }
        return -1;
    }
}
```
