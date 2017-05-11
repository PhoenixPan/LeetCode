## Solution 1: Time limit exceeded

Time: ?, Space: O(n)   

Improved brute force, reduced goback times, but still exceed the time limit.  
Plus: this solution can bring up the actual substring rather than just length
```
public class Solution {
  public static int lengthOfLongestSubstring(String s) {
    int len = s.length();
    if (s == null)
      return 0;
    if (len < 2)
      return len;
  
    HashMap<Character, Integer> map = new HashMap<>();
    int left = 0;
    int right = 0;
    int head = 0;
    int max = 0;
    for (int i = 0; i < len; i++) {
      char current = s.charAt(i);
    
      if (map.containsKey(current)) {
        if (right - left > max) { 
          max = right - left;
          head = left;
        }
        i = map.get(current);
        left = i + 1;
        right = left;
        map.clear();
      }
      else {
        map.put(current, i);
        right++;
      }  
    }
    if (right - left > max) { 
          max = right - left;
          head = left;
    }
    //System.out.println(head + ", " + s.substring(head, head+ max));
    return max;
  }
}
```

## Solution 2: Accepted

Time: ?, Space: O(n)  

Interesting: change from String to StringBuilder does not bring any performance boost.  

Using String  
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
Using StringBuilder
```
public int lengthOfLongestSubstring(String s) {
    int max = 0;
    StringBuilder temp = new StringBuilder();

    if (s.equals("") || s == null)
        return 0;

    for (int i = 0; i < s.length(); i++) {
        String current = Character.toString(s.charAt(i));
        if (temp.length() == 0 || temp.indexOf(current) == -1) {
            temp.append(current);
        }
        else {
            max = max > temp.length()? max : temp.length();
            String head = temp.substring(temp.indexOf(current) + 1, temp.length()) + current;
            temp.setLength(0);
            temp.append(head);
        }
    }    
    max = max > temp.length()? max : temp.length();

    return max;
}
```


## Solution 3

We use several int values to represent all the positions and avoid actually manipulating the strings.
