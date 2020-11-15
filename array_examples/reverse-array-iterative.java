package array_examples;/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class ReverseArray
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
	    int size = sc.nextInt();
	    int[] input = new int[size];
	    int start = 0;
	    int end = size-1;

	    for(int i=0;i < size; i++){
	        input[i] = sc.nextInt();
	    }

	    while(start!=end){
	        int temp = input[start];
	        input[start] = input[end];
	        input[end] = temp;
	        start++;
	        end--;
	    }

	    for(int i=0;i < size; i++){
	        System.out.print(input[i] + " ");
	    }

	}
}

