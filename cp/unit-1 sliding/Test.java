/*
Rohan has given 2 numbers s and e. He has to find Bitwiseprime numbers starting with s and ending to e.
A number is called BitwisePrime, if the count of 1's in the binary representation of the number is prime.
Help Rohan to find number of Bitwiseprime numbers in the given range.

Input Format:
-------------
Line: 2 space seperated integers s and e.
 
Output Format:
--------------
Print an integer result.
 
Sample Input-1:
---------------
11 15
 
Sample Output-1:
----------------
4
 
Explanation:
------------
11- 1011-(3 bits, 3 is a prime number)
12- 1100-(2 bits, 2 is a prime number)
13- 1101-(3 bits, 3 is a prime number)
14- 1110-(3 bits, 3 is a prime number)
15- 1111-(4 bits, 4 is a not prime number)
 
Sample Input-2:
---------------
5 8

Sample Output-2:
----------------
3
 
Explanation:
------------
5- 101-(2 bits, 2 is a prime number)
6- 110-(2 bits, 2 is a prime number)
7- 111-(3 bits, 3 is a prime number)
8- 1000-(1 bits, 1 is not a prime number)


case =1
input =100 200
output =57
   
case =2
input =1 25
output =18
    
case =3
input =51 150
output =58
*/

import java.util.*;
class Test{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();
        int e=sc.nextInt();
        int count=0;
        for(int i=s;i<=e;i++){
            int n=i;
            int c=0;
            while(n>0){
                if(n%2==1) c++;
                n/=2;
            }
            if(isPrime(c)) count++;
        }
        System.out.println(count);
    }
    public static boolean isPrime(int n){
        if(n==1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}