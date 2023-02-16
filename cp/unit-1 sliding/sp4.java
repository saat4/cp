
/*
You are given an array of integers nums, there is a sliding window of size k which is moving from 
the very left of the array to the very right. You can only see the k numbers in the window. 
Each time the sliding window moves right by one position.
Return the max sliding window.
Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3

Output: [3,3,5,5,6,7]

Explanation:
Window position Max
------------------------ -----
[1 3 -1] -3 5 3 6 7     3
1 [3 -1 -3] 5 3 6 7     3
1 3 [-1 -3 5] 3 6 7     5
1 3 -1 [-3 5 3] 6 7     5
1 3 -1 -3 [5 3 6] 7     6
1 3 -1 -3 5 [3 6 7]     7 

Example 2:
Input: nums = [1], k = 1
Output: [1]

Example-3 
Input: a[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, 
k = 3 

Output: 3 3 4 5 5 5 6 
Explanation: 
Maximum of subarray {1, 2, 3} is 3 
Maximum of subarray {2, 3, 1} is 3 
Maximum of subarray {3, 1, 4} is 4 
Maximum of subarray {1, 4, 5} is 5 
Maximum of subarray {4, 5, 2} is 5 
Maximum of subarray {5, 2, 3} is 5 
Maximum of subarray {2, 3, 6} is 6


input=
enter array elements size 
9
enter the elements     
1 2 3 1 4 5 2 3 6  
enter the subarray size
3
output=
3                                                                                                                       
3                                                                                                                       
4                                                                                                                       
5                                                                                                                       
5                                                                                                                       
5                                                                                                                       
6     


*/
import java.util.*;
public class sp4{
    //maximum of all subarrays of size k
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter array elements size");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("enter the elements");
        for (int i=0; i<n; i++) arr[i]=sc.nextInt();
        System.out.println("enter the subarray size");
        int k=sc.nextInt();
        int i=0, j=0, max=0;
        while (j<n) {
            max=Math.max(max, arr[j]);
            if (j-i+1<k) j++;
            else if (j-i+1==k) {
                System.out.println(max);
                if (arr[i]==max) max=0;
                i++;
                j++;
            }
        }
        System.out.println();
        sc.close();
    }
}