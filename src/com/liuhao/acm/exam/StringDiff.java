package com.liuhao.acm.exam;

public class StringDiff {

	public String diff(String a, String b){
		String result = "";
		LongestComSub lcs = new LongestComSub();
		
		while(true){
		
			//获取两个字符串的最长公共子串
			String maxSub = lcs.getLongestComSub(a, b);
			
			//若没有公共子串，则跳出while
			if(maxSub.length() == 0){
				break;
			}
			
			//将公共子串全部替换掉
			a = a.replaceAll(maxSub, "0");
			b = b.replaceAll(maxSub, "1");
			
		}
		
		//将a中剩下的输出
		for(int i=0; i<a.length();i++){
			if(a.charAt(i) != '0'){
				result += ("-" + a.charAt(i) + ",");
			}
		}
		
		for(int i=0; i<b.length();i++){
			if(b.charAt(i) != '1'){
				result += ("+" + b.charAt(i) + ",");
			}
		}
		
		result = result.substring(0, result.length()-1);
		
		return result;
	}
	
	public static void main(String[] args) {
		String a = "abcbc";
		String b = "aabcaa";
		System.out.println(new StringDiff().diff(a, b));
	}
	
}
