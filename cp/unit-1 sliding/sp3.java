/*
Given an integer array nums and an integer k, you are asked to construct the array 
ans of size n-k+1 where ans[i] is the number of distinct numbers in the subarray 
nums[i:i+k-1] = [nums[i], nums[i+1], ..., nums[i+k-1]]. Return the array ans.

Example 1:
Input: nums = [1,2,3,2,2,1,3], k = 3
Output: [3,2,2,2,3]
Explanation: The number of distinct elements in each subarray goes as follows:
- nums[0:2] = [1,2,3] so ans[0] = 3
- nums[1:3] = [2,3,2] so ans[1] = 2
- nums[2:4] = [3,2,2] so ans[2] = 2
- nums[3:5] = [2,2,1] so ans[3] = 2
- nums[4:6] = [2,1,3] so ans[4] = 3


Example 2:

Input: nums = [1,1,1,1,2,3,4], k = 4
Output: [1,2,3,4]
Explanation: The number of distinct elements in each subarray goes as follows:
- nums[0:3] = [1,1,1,1] so ans[0] = 1
- nums[1:4] = [1,1,1,2] so ans[1] = 2
- nums[2:5] = [1,1,2,3] so ans[2] = 3
- nums[3:6] = [1,2,3,4] so ans[3] = 4

TIME COMPLEXITY:

The time complexity to O(n) by using the sliding window technique

The idea is to store the frequency of elements in the current window in a map and keep track of
the distinct elements count in the current window (of size k). The code can be optimized to 
derive the count of elements in any window using the count of elements in the previous
window by inserting the new element to the previous window from its right and removing
an element from its left. Write


Input:
enter array elements size
7
enter the elements
1 2 3 2 2 1 3
enter the subarray size
3
Output:
The count of distinct elements in subarray [0, 2] is 3
The count of distinct elements in subarray [1, 3] is 2
The count of distinct elements in subarray [2, 4] is 2
The count of distinct elements in subarray [3, 5] is 2
The count of distinct elements in subarray [4, 6] is 3


*/
import java.util.*;
class sp3{
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter array elements size");
        int n=sc.nextInt();
        System.out.println("enter the elements");
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println("enter the subarray size");
        int k=sc.nextInt();
        int[] res=distinct(nums,n,k);

    }
    //distinct numbers in each subarray of size k
    public static int[] distinct(int[] nums,int n,int k){
        int[] res = new int[n-k+1];
        HashMap<Integer,Integer> map = new HashMap<>();
        int start=0;
        int end=k-1;
        for(int i=0;i<k;i++){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        while(end<n){
            res[start]=map.size();
            map.put(nums[start],map.get(nums[start])-1);
            if(map.get(nums[start])==0){
                map.remove(nums[start]);
            }
            start++;
            end++;
            if(end<n){
                map.put(nums[end],map.getOrDefault(nums[end],0)+1);
            }
        }
        for(int i=0;i<res.length;i++){
            System.out.println("The count of distinct elements in subarray [" + i + ", " + (i + k - 1) + "] is " + res[i]);
        }
        
        return res;
    } 
}
