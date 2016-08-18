##Version 1
25 ms, only beats 18%. It is slow as we constantly manipulate the strings.
```
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        String temp = "";
        
        if (s.equals("") || s == null)
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
##Version 2

We use several int values to represent all the positions and avoid actually manipulating the strings.
