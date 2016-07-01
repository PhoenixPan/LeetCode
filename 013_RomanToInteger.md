```
public class Solution {
    public int romanToInt(String s) {
	int num = 0;
	int length = s.length();
	char[] input = s.toCharArray();
	HashMap<Character, Integer> mymap = new HashMap<Character, Integer>();	
    mymap.put('I',1);
	mymap.put('V',5);
	mymap.put('X',10);
	mymap.put('L',50);
	mymap.put('C',100);
	mymap.put('D',500);
	mymap.put('M',1000);
    	
	for (int i = length - 1; i >= 0; i--) {
        char current = input[i];
		    
        if (i == length - 1) {
            num += mymap.get(current);
            continue;
        }
        
        char after = input[i + 1];
        
		if (mymap.get(current) < mymap.get(after)) 
		    num -= mymap.get(current);
		else 
		    num += mymap.get(current);
	}	
	return num;
    }
}
```


30 to 37~45.62 (15-16ms)
from char[] input = s.toCharArray()
to s.charAt(i)

25 to 30
from char current
to int current

18 to 25:
from  after = input[i +1]
to after = current 

Doesn't make difference:
length
charAt / char[]


```
public class Solution {
    public int romanToInt(String s) {
	int num = 0;
	int after = 0;
	int length = s.length();
	
	HashMap<Character, Integer> mymap = new HashMap<Character, Integer>();	
    mymap.put('I',1);
	mymap.put('V',5);
	mymap.put('X',10);
	mymap.put('L',50);
	mymap.put('C',100);
	mymap.put('D',500);
	mymap.put('M',1000);
    	
	for (int i = length - 1; i >= 0; i--) {
        int current = mymap.get(s.charAt(i));
		    
        if (i == length - 1) {
            num += current;
            after = current;
            continue;
        }
        
		if (current < after) 
		    num -= current;
		else 
		    num += current;
		after = current;
	}	
	return num;
    }
}
```


