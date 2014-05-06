package com.liuhao.acm.csdn;

import java.util.Scanner;

/**
 * @author liuhao 
 * 进制转换 
 * 题目详情: 我们通常用的十进制数包含0-9十个数字。假设有一种进制系统包含3种数字，从低到高分别为"oF8”，
 *         那么从1到9分别表示为F, 8, Fo, FF, F8, 8o, 8F, 88, Foo, FoF。
 *         给定一种进制的数和两种进制的数字表，请把它从第一种进制转换为第二种进制。
 * 
 *         输入格式： 第一行是T表示测测试数据组数。(0<T<=200）。
 *          以后T行，每行有3个部分： number number_table1 number_table2
 *         其中number_table1和number_table2表示从第一种进制的数字表和第二种进制的数字表。（数字由低到高。）
 *         number是第一种进制的一个数。 数字表可能包含的字符是数字0-9，
 *         还有!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~ 等几种字符。 1<=number<=1000000000 (十进制）。
 * 
 *         输出格式： 先输出Case #数目，再输出第二种进制下的数。 详见样例。
 * 
 *         答题说明: 
 *         输入样例 
 *         4 
 *         9 0123456789 oF8 
 *         Foo oF8 0123456789 
 *         13 0123456789abcdef
 *         01 CODE O!CDE? A?JM!.
 * 
 *         输出样例：
 *		   Case #1: Foo 
 *		   Case #2: 9 
 *		   Case #3: 10011 
 *		   Case #4: JAM!
 */
public class Convert {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		final int T = Integer.parseInt(sc.next()); // T组数据

		String[] srcArr = new String[T]; //存放原进制数据
		String[] str1Arr = new String[T]; //存放第一种进制的数字表
		String[] str2Arr = new String[T]; //存放第二种进制的数字表
		String[] outArr = new String[T]; //存放转换后的数据

		// 读入输入数据，并保存到相应数组
		for (int i = 0; i < T; i++) {
			srcArr[i] = sc.next();
			str1Arr[i] = sc.next();
			str2Arr[i] = sc.next();
		}

		for (int i = 0; i < T; i++) {
			outArr[i] = convert(srcArr[i], str1Arr[i], str2Arr[i]);
			System.out.println("Case #" + (i+1) + ": " + outArr[i]);
		}
	}

	
	/**
	 * @param src 第一种进制的数据
	 * @param str1  第一种进制的数字表
	 * @param str2  第二种进制的数字表
	 * @return 转换后的第二种进制的数据
	 */
	private static String convert(String src, String str1, String str2) {

		int len1 = str1.length();
		int len2 = str2.length();

		int mod = 1;
		int value = 0;// 存放中间十进制数

		StringBuilder out = new StringBuilder("");// 存放转换后的数据

		char[] charArr = src.toCharArray();

		// 将输入转化为10进制
		for (int i = charArr.length - 1; i >= 0; i--) {
			int temp = str1.indexOf(charArr[i]);
			value += temp * mod;
			mod *= len1;
		}

		// 将10进制数转化问目标进制数
		while (value > 0) {
			out.append(str2.charAt(value % len2));
			value /= len2;
		}

		return out.reverse().toString();
	}

}
