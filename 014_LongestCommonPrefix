

```
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        else if (length == 1){
            return strs[0];
        }
        else {
            //String previous = strs[0];
            String answer = strs[0];
            for (int i = 1; i < length; i++) {
                if (answer.equals(""))
                    break;
                else if (strs[i].startsWith(answer)) {
                   continue;
                }
                else {
                	while (!strs[i].startsWith(answer)) {
                		answer = answer.substring(0, answer.length() - 1);
                	}
                }
            }
            return answer;
        }
    }
}
```
