package com.Ecomm.stepdefination;

import java.util.HashSet;
import java.util.Set;

public class StringPractice {

	public static void main(String[] args) {
		String[] s = { "suwasua", "Wagh" };
		String str = "AbbbcbbbA", str2 = "SUWANRA";
		System.out.println(str);
		// printArray(s);
		// System.out.println(totalNumberOfCharInString(str));
		// System.out.println(totalNumberOfPunctuationCharExistInString(str));
		// System.out.println(countVowelsInString(str));
		// System.out.println(countConstantsInString(str));
		// System.out.println(isStringAnagram(str, str2));
		// divideStringInNParts(str, 4);
		// findAllSubsetOfString(str);
		// largestRepeatedString(str);
		//removeAllWhiteSPaces(str);
		//System.out.println(removeWhiteSpacesUsingReplaceAll(str));
		//changeCase(str);
		//replaceWHiteSpaceWithChar(str);
		//isStringPalindromUsingReverseMethod(str);
		//isStringPalindrom(str);
	}
	

	private static void isStringPalindrom(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i = str.length()-1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		if(str.equals(sb.toString())) {
			System.out.println(str + " is pallindrom string");
		}else {
			System.out.println(str + " is not pallindrom string");
		}
	}

	private static void isStringPalindromUsingReverseMethod(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		if(str.equals(sb.toString())) {
			System.out.println("String is pallindrome");
			}
		System.out.println(sb);
	}

	private static void replaceWHiteSpaceWithChar(String str) {
				str = str.replace(" ", "-");
				System.out.println(str);
				
	}

	private static void changeCase(String str) {
		StringBuffer sb = new StringBuffer(str);
		for(int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))) {
				sb.setCharAt(i, Character.toLowerCase(str.charAt(i)));
			}else {
				sb.setCharAt(i, Character.toUpperCase(str.charAt(i)));   
			}
		}
		System.out.println(sb);
	}

	private static String removeWhiteSpacesUsingReplaceAll(String str) {
		return str.replaceAll("\\s+", "");		
	}
	
	private static void removeAllWhiteSPaces(String str) {
		String str1;
		char[] ch = str.toCharArray();
		
		for(Character c: ch) {
			if(!c.isWhitespace(c)) {
				System.out.print(c);
			}
		}
	}



	private static void largestRepeatedString(String str) {
		
		String lrs = "";
		for (int i = 0; i < str.length(); i++) {
			for (int j = i+1; j < str.length(); j++) {
				String x = lcp(str.substring(i, str.length()), str.substring(j, str.length()));
				// If the current prefix is greater than previous one
				// then it takes the current one as longest repeating sequence
				if (x.length() > lrs.length())
					lrs = x;
			}
		}
		System.out.println(lrs);
	}

	public static String lcp(String s, String t) {
		int n = Math.min(s.length(), t.length());
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) != t.charAt(i)) {
				return s.substring(0, i);
			}
		}
		return s.substring(0, n);
	}

	private static void findAllSubsetOfString(String str) {
		int len = str.length();
		int temp = 0;
		// Total possible subsets for string of size n is n*(n+1)/2
		String arr[] = new String[len * (len + 1) / 2];

		// This loop maintains the starting character
		for (int i = 0; i < len; i++) {
			// This loop adds the next character every iteration for the subset to form and
			// add it to the array
			for (int j = i; j < len; j++) {
				arr[temp] = str.substring(i, j + 1);
				temp++;
			}
		}
		printArray(arr);
	}

	private static void printArray(String str[]) {

		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i] + ",");
		}

	}

	private static void divideStringInNParts(String str, int d) {
		if (str.length() % d == 0) {
			int a = str.length() / d;
			int temp = a;
			for (int i = 0; i < str.length(); i = i + a) {
				System.out.println(str.substring(i, temp));
				temp = temp + a;
			}
		} else {
			System.out.println("String can't be divided into equal parts");
		}

	}

	private static boolean isStringAnagram(String str, String str2) {
		if (str.length() != str2.length())
			return false;
		// user Arrays.sort(str) & Compare both string using .equals
		int cnt;
		for (int i = 0; i < str.toUpperCase().length(); i++) {
			for (int j = 0; j < str2.toUpperCase().length(); j++) {
				cnt = 0;
				if (str.charAt(i) == str2.charAt(j)) {
					cnt++;
					if (cnt > 1) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static int countConstantsInString(String str) {
		Set<Character> setOfV = new HashSet<>();
		int total = 0;
		str = str.toUpperCase();
		for (int i = 0; i < str.length(); i++) {
			if (!(str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O'
					|| str.charAt(i) == 'U')) {
				total++;
				setOfV.add(str.charAt(i));
			}
		}
		System.out.println(setOfV);
		return setOfV.size();
	}

	private static int countVowelsInString(String str) {
		Set<Character> setOfV = new HashSet<>();
		int total = 0;
		str = str.toUpperCase();
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O'
					|| str.charAt(i) == 'U')) {
				total++;
				setOfV.add(str.charAt(i));
			}
		}
		System.out.println(setOfV);
		return setOfV.size();
	}

	private static int totalNumberOfPunctuationCharExistInString(String str) {
		int total = 0;
		// if (Pattern.matches("\\p{IsPunctuation}", str)) {
		for (int i = 0; i < str.length(); i++) {
			int cnt = 0;
			switch (str.charAt(i)) {
			case '.':
				cnt++;
				break;
			case ',':
				cnt++;
				break;
			case ';':
				cnt++;
				break;
			}
			total = total + cnt;
		}
		// }
		return total;
	}

	private static int totalNumberOfCharInString(String string) {
		return string.length();

	}

}
