package com.liuhao.acm.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liuhao 给出整数N(0 ≤ N ≤ 10^9)，找出一个最小的整数Q，使得将Q的每一位相乘之后等于N
 *         例如N=18，则Q可能取值为：29(2×9=18),36(3×6=18),63(6×3=18),92(9×2=18)
 *         那么我们只要取最小值29即为结果 输入：整数N(0 ≤ N ≤ 10^9) 输出：如果存在这样的Q，则输出Q，如果不存在，输出-1
 */
public class NewIntProduct {

	public static int getNew(int input) {
		// 若该数是各位数，那么最小的肯定是1X该数
		if (input >= 0 && input <= 9) {
			return 10 + input;
		}

		List<Integer> list = new ArrayList<Integer>();// 存放满足要求的乘数

		list = getNew(input, list);// 递归获取

		// 若list中含有-1，说明初始数input本身或者input的约数不满足条件
		if (list.contains(-1)) {
			return -1;
		}

		// 将list排序
		Collections.sort(list);

		int len = list.size();

		int result = 0;// 最终的返回值

		// 根据list中的各位数拼成最终的返回值
		for (int i = len - 1; i >= 0; i--) {
			result += Math.pow(10, len - 1 - i) * list.get(i);
		}

		return result;
	}

	/**
	 * @param n
	 *            初始数
	 * @param list
	 *            满足要求的乘数
	 * @return
	 */
	private static List<Integer> getNew(int n, List<Integer> list) {

		// 若初始数已经是一个个位数，则直接添加到list中，并跳出递归
		if (n >= 0 && n <= 9) {
			list.add(n);
			return list;
		}

		boolean flag = false;// 是否存在个位数的约数的标志

		// 依次用9-2,作为除数，看初始数是否存在个位数的约数
		for (int i = 9; i >= 2; i--) {
			// 若存在
			if (n % i == 0) {
				flag = true;
				list.add(i);// 将该约束添加到list中
				getNew(n / i, list);// 递归查找商数的满足条件的约束
				break;
			}
		}

		// 不存在，说明不满足条件
		if (!flag) {
			list.add(-1);
		}

		return list;
	}

	public static void main(String[] args) {
		System.out.println(getNew(18));
	}
}
