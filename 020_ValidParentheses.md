##First Version

This is an easy one.
```
public class Solution {
    public boolean isValid(String s) {
        Stack cache = new Stack();
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{')
                cache.push(current + "");
            

            if (current == ')')
                if (!cache.isEmpty() && cache.peek().equals("("))
                    cache.pop();  
                else
                    return false;
            if (current == ']')
                if (!cache.isEmpty() && cache.peek().equals("["))
                    cache.pop();  
                else
                    return false;
            if (current == '}')
                if (!cache.isEmpty() && cache.peek().equals("{"))
                    cache.pop();  
                else
                    return false;
            }
           
        
        
        return cache.isEmpty();
    }
}
```
