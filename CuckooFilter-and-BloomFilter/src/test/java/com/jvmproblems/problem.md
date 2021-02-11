JavaProblem

Write a program in your preferred language that given an array of integers A will find all the pairs of numbers that if subtracted will result in a specific given number M. For example for the array A={4,5,10,11,6} and the number M=-1 will return the following pairs: 0-1, 2-3, 1-4. This means that A[0]-A[1]=4-5=-1 A[2]-A[3]=10-11=-1 si A[1]-A[4]=5-6=-1. Please explain the space/time performance and other trade-offs.

I have decided to solve this problem in both C++ and Java. In both cases we will have:

Time Performance: We have a for loop inside a for loop. The first for loop will have n steps and the second one n/2 steps => (n^2)/2 steps => Time Complexity = O(n^2)
Space Performance: n(number of elements in the array A) + 1(the variable n) + 2(variables i and j) => Space Complexity = n+3

	#include <bits/stdc++.h>
	
	using namespace std;
	
	int main()
	{
	    ifstream f ("date.in");
	
	    int n;
	    f>>n;
	
	    int *a;
	    a = (int*) malloc (n * sizeof(int));
	
	    int i;
	    for (i = 0; i < n; i++)
	        f>>a[i];
	
	    int j;
	    for (i = 0; i < n; i++)
	        for (j = i + 1; j < n; j++)
	        {
	            if(a[i] - a[j] == -1)
	                cout<<i<<"-"<<j<<endl;
	            else if(a[i] - a[j] == 1)
	                cout<<j<<"-"<<i<<endl;
	        }
	
	}

5
4 5 10 11 6