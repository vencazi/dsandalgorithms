package com.hari.java;

import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

import com.hari.utils.IOUtils;

public class ReversePolish {

	public static void main(String[] str) {
		System.out.print("Enter operator and operands seperated by comma : ");
		String arr = IOUtils.readString();
		String[] array = arr.split(",");
		Stack<String> stack = new Stack<String>();
		int ans = -1; 
		for(String s:array) {
			if (StringUtils.isNumeric(s)) {
				stack.push(s);
			} else {
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				switch(s) {
				case "+":
					ans = num1 + num2;
					break;
				case "-":
					ans = num1 - num1;
					break;
				case "*":
					ans = num1 * num2;
					break;
				case "/":
					ans = num1 / num2;
					break;
				}
				stack.push(String.valueOf(ans));
			}
		}
		System.out.println("ans = " + ans);
	}
	
}
