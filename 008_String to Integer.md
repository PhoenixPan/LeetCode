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
