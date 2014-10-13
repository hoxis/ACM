package com.liuhao.acm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 计算逆波兰表达式
 * 
 * @author liuhao
 * 
 *         Evaluate the value of an arithmetic expression in Reverse Polish
 *         Notation.
 * 
 *         Valid operators are +, -, *, /. Each operand may be an integer or
 *         another expression.
 * 
 *         Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *         ["4","13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 */
public class EvalRPN {

	public static int evalRPN(String[] tokens) {

		// 栈，用于遍历初始字符串数组
		Deque<Integer> stack = new ArrayDeque<Integer>();

		int a, b;// 临时存放栈中弹出两个元素

		/**
		 * 遍历初始字符串数组，
		 * 若当前字符为 运算符 ，则从栈中弹出两个元素，并用该运算符对它们进行运算，然后再将运算结果压入栈
		 *  若读到的是数字，则直接将其压入栈，不作其他操作
		 */
		for (int i = 0; i < tokens.length; i++) {
			String temp = tokens[i];
			switch (temp) {
			case "+":
				a = stack.pop();
				b = stack.pop();
				stack.push((b + a));
				break;
			case "-":
				a = stack.pop();
				b = stack.pop();
				stack.push(b - a);
				break;
			case "*":
				a = stack.pop();
				b = stack.pop();
				stack.push(b * a);
				break;
			case "/":
				a = stack.pop();
				b = stack.pop();
				if (a == 0) {
					return -1;
				}
				stack.push(b / a);
				break;
			default:
				stack.push(Integer.parseInt(temp));
			}
		}

		int result = stack.peek();

		return result;
	}

	public static void main(String[] args) {
		String[] input = new String[] { "4", "13", "5", "/", "+" };
		System.out.println(evalRPN(input));
	}

}
