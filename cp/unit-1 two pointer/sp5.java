
/*
Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element
from each array. 
We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we need to find the pair ar1[i] + ar2[j] such that absolute value of (ar1[i] + ar2[j] – x) is minimum. 

Example-1:
Input: ar1[] = {1, 4, 5, 7};
ar2[] = {10, 20, 30, 40};
x = 32
Output: 1 and 30

Example-2:
Input: ar1[] = {1, 4, 5, 7};
ar2[] = {10, 20, 30, 40};
x = 50
Output: 7 and 40

Solution: A Simple Solution is to run two loops. The outer loop considers every element of first array 
and inner loop checks for the pair in second array. 
We keep track of minimum difference between ar1[i] + ar2[j] and x. We can do it in O(n) time using following 
steps.
1. Merge given two arrays into an auxiliary array of size m+n using merge process of merge sort.
While merging keep another boolean array of size m+n to indicate whether the current element in merged
array is from ar1[] or ar2[]. 
2. Consider the merged array and use the linear time algorithm to find the pair with sum closest to x. 
One extra thing we need to consider only those pairs which have one element from ar1[] and 
other from ar2[], we use the boolean array for this purpose.



Algorithm:
1) Initialize a variable diff as infinite (Diff is used to store the difference between pair and x). We need to find the minimum diff.
2) Initialize two index variables l and r in the given sorted array.
(a) Initialize first to the leftmost index in ar1: l = 0
(b) Initialize second the rightmost index in ar2: r = n-1
3) Loop while l< length.ar1 and r>=0
(a) If abs(ar1[l] + ar2[r] - sum) < diff then
update diff and result
(b) If (ar1[l] + ar2[r] < sum ) then l++
(c) Else r--
4) Print the result.



input=
enter size of array_1
4
enter the values of array_1
1 4 5 7
enter size of array_2
4
enter the values of array_2
10 20 30 40
enter closest number
32
output=
The closest pair is [1, 30]

*/
import java.util.*;
class Test{
    //Closed pair in sub array
    public static void main(String a[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of array_1");
        int m=sc.nextInt();
        System.out.println("enter the values of array_1");
        int arr1[]=new int[m];
        for(int i=0;i<m;i++){
            arr1[i]=sc.nextInt();
        }
        System.out.println("enter size of array_2");
        int n=sc.nextInt();
        System.out.println("enter the values of array_2");
        int arr2[]=new int[n];
        for(int i=0;i<n;i++){
            arr2[i]=sc.nextInt();
        }
        System.out.println("enter closest number");
        int x=sc.nextInt();
        int l=0;
        int r=n-1;
        int diff=Integer.MAX_VALUE;
        int res[]=new int[2];
        while(l<m&&r>=0){
            if(Math.abs(arr1[l]+arr2[r]-x)<diff){
                diff=Math.abs(arr1[l]+arr2[r]-x);
                res[0]=arr1[l];
                res[1]=arr2[r];
                
            }
            if(arr1[l]+arr2[r]<x)l++;
            else r--;
        }
        System.out.println("The closest pair is ["+res[0]+","+ res[1]+"]");
    }
    
}
