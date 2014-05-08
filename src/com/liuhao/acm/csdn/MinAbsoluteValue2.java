package com.liuhao.acm.csdn;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author liuhao
 * 绝对值最小
 * 给你一个数组A[n],请你计算出ans=min(|A[i]+A[j]|)(0<=i,j<n).
 */
public class MinAbsoluteValue2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		
		while(sc.hasNext()){
			int n = sc.nextInt();
			int[] inputArr = new int[n];
			
			for(int i=0; i<n;i++){
				inputArr[i] = sc.nextInt();
			}
			
			System.out.println(minAbsoluteValue(inputArr));
		}
		
		sc.close();
		
//		//测试数据
//		int[] testArr1 = {1,2,3,4,23,45,67,4};
//		int[] testArr2 = {-32,-34,-53,-354,-67};
//		int[] testArr3 = {1,2,3,4,23,45,67,0,-32,-34,6,-53,-354,-67};
//		int[] testArr4 = {1,2,3,4,23,45,67,-32,-34,6,-53,-354,-67};
//		int[] testArr5 = {1,2,3,4,23,45,67,-32,-34,6,-53,-354,-68};
//		
//		System.out.println(minAbsoluteValue(testArr1));
//		System.out.println(minAbsoluteValue(testArr2));
//		System.out.println(minAbsoluteValue(testArr3));
//		System.out.println(minAbsoluteValue(testArr4));
//		System.out.println(minAbsoluteValue(testArr5));
		
	}
	
	private static int minAbsoluteValue(int[] inputArr){
	
		int ans = Math.abs(2 * inputArr[0]);
		
		for(int i=0;i<inputArr.length;i++){
			for(int j=i; j<inputArr.length;j++){
				if(ans > Math.abs(inputArr[i] + inputArr[j])){
					ans = Math.abs(inputArr[i] + inputArr[j]);
				}
			}
		}
	
		return ans;
	}
	
}
