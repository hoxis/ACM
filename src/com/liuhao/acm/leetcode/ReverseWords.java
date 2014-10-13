package com.liuhao.acm.leetcode;

/**
 * @author liuhao
 * 
 *         Given an input string, reverse the string word by word. For example,
 *         Given s = "the sky is blue", return "blue is sky the".
 */
public class ReverseWords {

	public static String reverseWords(String s) {

		// 若输入字符串直接是空串，则直接返回该字符串
		if (s.equals("")) {
			return "";
		}

		// 将字符串按空格"\\s{1,}"进行分割，一个或者多个空格的正则："\\s{1,}"
		String[] strArr = s.split("\\s{1,}");
		int len = strArr.length;

		// 分割后字符串变成空串，直接返回
		if (len == 0) {
			return "";
		}

		// 用StringBuilder更加有效
		StringBuilder sb = new StringBuilder("");

		// 反向输出之前分割的字符串数组
		for (int i = len - 1; i >= 0; i--) {
			if (!strArr[i].equals("")) {
				sb.append(strArr[i]);
				sb.append(" ");
			}
		}

		sb.deleteCharAt(sb.lastIndexOf(" "));
		
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(reverseWords(""));
	}

}
