package com.liuhao.acm.csdn;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuhao
 * 绝对值最小
 * 给你一个数组A[n],请你计算出ans=min(|A[i]+A[j]|)(0<=i,j<n).
 */
public class MinAbsoluteValue {
	
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
		
		Arrays.sort(inputArr);
		
		//若数组中包含0，则最小值肯定是0
		if(Arrays.binarySearch(inputArr, 0) >= 0){
			return 0;
		}else{
			
			//若原数组全为正数，那么最小值就是正数组之中的最小值*2
			if(-1 - Arrays.binarySearch(inputArr, 0) == 0){
				return 2 * inputArr[0];
			} 
			//若全为负数，则最小值肯定是负数组之中最大值*-2
			else if(-1 - Arrays.binarySearch(inputArr, 0) == inputArr.length){
				return -2 * inputArr[inputArr.length-1];
			}
			//既有正数又有负数
			else{
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
	}
	
}
