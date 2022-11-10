package com.lo.demoap.ExampleTwo;

import org.springframework.stereotype.Service;

@Service
public class StarterSep {
	public int add(int a,int b) {

		 int s=a+b;
		 return s;
	 }

	public int sub(int a, int b) {
		
		 int x=a-b;
		 return x;
	}

	public int mul(int a, int b) {
		
		 int y=a*b;
		 return y;
	}

	public int div(int a, int b) {
		
		 int z=a/b;
		 return z;
	}
}
