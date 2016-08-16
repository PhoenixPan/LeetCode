In this question we need to rearrange a string according to certain order. We need to find out the order of rearrangement.

```
public static String convert(String s, int numRows) {

		if (numRows < 2 || s == null || s.length() < numRows)
			return s;

		StringBuilder sb = new StringBuilder();
		int circleLength = 0;
		if (numRows < 3)
			circleLength = numRows;
		else
			circleLength = numRows * 2 - 2;

		for (int i = 1; i <= numRows; i++) {
			for (int j = 1; j <= s.length(); j++) {
				if (j % circleLength == i) {
					sb.append(s.charAt(j - 1));
				}
				
				if (i == 2 && j % circleLength == 0) {
					sb.append(s.charAt(j - 1));
				}
				
				if (i > 2 && i != numRows && j % circleLength == circleLength - i + 2) {
					sb.append(s.charAt(j - 1));

				}
			}
		}
		
		return sb.toString();
	}
```
