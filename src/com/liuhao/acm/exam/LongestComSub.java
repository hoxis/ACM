package com.liuhao.acm.exam;

public class LongestComSub {

	public String getLongestComSub(String str1, String str2) {
		String longestStr = "";// 始终存放最长的子序列
		int maxLen = 0;// 存放最长子序列的长度

		for (int i = 0; i < str1.length(); i++) {
			String tempStr = "";// 存放本次遍历中的最长子序列
			int tempMax = 0;// 存放本次遍历最长子序列的长度
			int index = i;// 保存i的副本
			boolean eq = false;// 标记是否有公共子序列

			for (int j = 0; j < str2.length(); j++) {
				// 若当前字符相同，则index++
				if (index < str1.length() && str1.charAt(index) == str2.charAt(j)) {
					tempStr += str1.charAt(index);// 将当前字符添加到tempStr
					index++;
					tempMax++;
					eq = true;

					// maxLen中总是存放最长序列的长度
					if (tempMax > maxLen) {
						maxLen = tempMax;
						longestStr = tempStr;
					}

				}
				// 若不相等
				else {
					// 将第一个字符串的索引指向初始位置
					index = i;
					tempStr = "";
					tempMax = 0;

					//j要-1，否则会跳掉一个字符
					if (eq) {
						j--;
					}
					eq = false;
				}
			}

		}

		return longestStr;
	}

	public static void main(String[] args) {
		String str1 = "aaawwwwwaaaawaaaaaaa";
		String str2 = "aaawa1aaaaaaa";

		System.out.println(new LongestComSub().getLongestComSub(str1, str2));
	}
}
