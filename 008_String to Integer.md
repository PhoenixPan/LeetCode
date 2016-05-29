#####First version

```
	public static int myAtoi(String str) {
		str = str.trim();
		if (str.length() == 0)
			return 0;
		if ((str.charAt(0) < '0' || str.charAt(0) > '9') && str.charAt(0) != '-' && str.charAt(0) != '+') {
			return 0;
		}

		String sign = "";
		int index = 0;
		if (str.charAt(0) == '-' || str.charAt(0) == '+') {
			index = 1;
			if (str.length() == 1 || str.charAt(1) < '0' || str.charAt(1) > '9')
				return 0;
			if (str.charAt(0) == '-')
				sign = "-";
		}

		StringBuilder sb = new StringBuilder();
		for (int i = index; i < str.length(); i++) {
			if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
				sb.append(str.charAt(i));
			} else
				break;
		}

		String value = sb.toString();
		if (value.length() >= 10 && sign.equals("-")) {
			if (value.length() >= 11)
				return Integer.parseInt("-2147483648");
			else if (value.length() == 10 && value.compareTo("2147483648") > 0)
				return Integer.parseInt("-2147483648");
			else
				return Integer.parseInt(sign + value);
		}

		else if (value.length() >= 10 && sign.equals("")) {
			if (value.length() >= 11)
				return Integer.parseInt("2147483647");
			else if (value.length() == 10 && value.compareTo("2147483647") > 0)
				return Integer.parseInt("2147483647");
			else
				return Integer.parseInt(value);
		} else
			return Integer.parseInt(sign + value);
	}
```

A primitive solution that manipulates Strings. Spent 7 ms and beats 9.5%.

#####Second version

Improved based on the first one, it now beats 14.9%.

```
	public static int myAtoi(String str) {

		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		int sign = 1;
		boolean start = false;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char thisChar = str.charAt(i);
			if (thisChar == ' ' && !start) {
				continue;
			} else if ((thisChar == '-' || thisChar == '+') && !start) {
				start = true;
				if (thisChar == '-')
					sign = -1;
			} else if (thisChar < '0' || thisChar > '9')
				break;
			else {
				start = true;
				sb.append(thisChar);
			}
		}

		if (sb.length() == 0)
			return 0;

		String value = sb.toString();
		if (value.length() >= 10 && sign == -1) {
			if (value.length() >= 11)
				return min;
			else if (value.length() == 10 && value.compareTo("2147483648") >= 0)
				return min;
			else
				return Integer.parseInt(value) * sign;
		}

		else if (value.length() >= 10 && sign == 1) {
			if (value.length() >= 11)
				return max;
			else if (value.length() == 10 && value.compareTo("2147483647") >= 0)
				return max;
			else
				return Integer.parseInt(value);
		} else
			return Integer.parseInt(value) * sign;

	}
```

#####Third version

Manipulate numbers are more efficient than manipulating Strings. Now we have 85%.

```
public static int myAtoi(String str) {

		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		int digit; 
		int result = 0; 
		boolean isNegative = false;
		boolean start = false; //whether we have the first valid character 

		for (int i = 0; i < str.length(); i++) {
			char thisChar = str.charAt(i);
			if (!start && thisChar == ' ') {
				continue;
			} else if (!start && (thisChar == '-' || thisChar == '+')) {
				start = true;
				if (thisChar == '-')
					isNegative = true;
			} else if (thisChar < '0' || thisChar > '9')
				break;
			else {
				start = true;
				digit = thisChar - '0';
				if (result > max / 10 || (result == max / 10 && digit > 7)) { // 7 is max % 10
					if (isNegative)
						return min;
					else
						return max;
				}
				result = result * 10 + digit;
			}
		}
```
