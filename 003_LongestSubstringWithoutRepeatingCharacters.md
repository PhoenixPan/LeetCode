##First version
27 ms, only beats 15%  
```
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        String temp = "";
        
        if (s.length() == 1)
            return 1;
        if (s.equals(""))
            return 0;
            
        for (int i = 0; i < s.length(); i++) {
            String current = s.charAt(i) + "";
            if (temp.length() == 0 || temp.indexOf(current) == -1) {
                temp = temp + current;
            }
            else {
                max = max > temp.length()? max : temp.length();
                temp = temp.substring(temp.indexOf(current) + 1, temp.length()) + current;
            }
        }    
        max = max > temp.length()? max : temp.length();
        
        return max;
    }
}
```
