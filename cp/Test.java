/*
 Mr.Suresh asked Mr.Ramesh to create a grid with set of words in such a way that if you read the word in i-th row and the word in i-th column should be equal.
Mr. Ramesh created the grid accordingly.
   
Now it’s your aim to check whether Mr.Ramesh’s grid has satisfied conditions given by Mr.Suresh.
   
If satisfied, print "true". Otherwise print "false"
  
Constraints:
-------------
N should be a positive integer.
0 < word[i].length <= N
word[i+1].length <= word[i].length
    
Input Format:
-------------
Line-1 -> an integer N, number of words
Line-2 -> N space separated words.
   
Output Format:
--------------
Print a boolean result.
   
Sample Input-1:
---------------
4
kmit made idol tell
  
Sample Output-1:
----------------
true
   
Explanation:
-------------
Given grid looks as follows:
k m i t
m a d e
i d o l
t e l l
if you read the words in every i-th row and i-th column,
both the words are same. so return true.
    
    
Sample Input-2:
---------------
5
abcde bcde cde de e
   
Sample Output-2:
----------------
true
*/
import java.util.*;
class Test{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<String>words=new ArrayList<>();
        for(int i=0;i<n;i++){
            words.add(sc.next());
        }
        System.out.println(valid(words));
    }
    static boolean valid(List<String>words){
        int n=words.length;
        for(int i=0;i<n;i++){
            String row=words.get(i);
            if(!row.equals(get(i,words))){
                return false;
            }
        }
        return true;
    }
    public String get(int col,List<String>words){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<words.length;i++){
            String word=words.get(i);
            if(col<word.length()){
                sb.append(word.charAt(col));
            };
        }
    return sb.toString();
    }
}