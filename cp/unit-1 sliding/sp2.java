

/*
A tenth standard student has been given a task, Given P number of subject marks 
and a number I, He has to print the I-th least value of sums among all the 
possible sub-arrays of marks.

Input Format:
-------------
Line-1: Two space separated inetegers, P and I.
Line-2: P space separated integers, marks[].

Output Format:
--------------
Print the I-th least value of possible sums.


Sample Input-1:
--------------
3 4
3 2 4

Sample output-1:
---------------
5

Explanation: 
------------
The subarrays of 3 2 4 are:
1st subarray: 3 the sum is 3
2nd subarray: 2 the sum is 2
3rd subarray: 4 the sum is 4
4th subarray: 3,2 the sum is 5
5th subarray: 2,4 the sum is 6
6th subarray: 3,2,4 the sum is 9

The 4th smallest is 5


Sample Input-2:
---------------
4 7
2 2 4 4

Sample output-2:
----------------
8


Explanation: 
------------
The subarrays of 2 2 4 4 are

1st subarray: 2 the sum is 2
2nd subarray: 2 the sum is 2
3rd subarray: 4 the sum is 4
4th subarray: 4 the sum is 4
5th subarray: 2,2 the sum is 4
6th subarray: 2,4 the sum is 6
7th subarray: 4,4 the sum is 8
8th subarray: 2,2,4 the sum is 8
9th subarray: 2,4,4 the sum is 10
10th subarray: 2,2,4,4 the sum is 8

The 7th smallest is 8


=== testcases ===
case=1
input=3 4
2 1 3
output=3

case=2
input=4 7
3 3 5 5
output=7

case=3
input=4 5
1 2 3 4
output=3

case=4
input=6 8
1 2 4 4 7 7
output=7

case=5
input=6 6
1 2 3 3 7 7
output=6

*/
import java.util.*;
class Test{
    public static void main(String ar[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println(small(nums,k));
    }
    //kth smallest subarray sum
    public static int small(int[] nums, int k) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }
        int low = min, high = sum;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int count = countSubarrays(nums, mid);
            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public static int countSubarrays(int[] nums, int threshold) {
        int count = 0;
        int sum = 0;
        int length = nums.length;
        int left = 0, right = 0;
        while (right < length) {
            sum += nums[right];
            while (sum > threshold) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}

