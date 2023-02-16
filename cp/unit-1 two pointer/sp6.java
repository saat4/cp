
/*
Given a non-empty string s and an abbreviation abbr, return whether the string matches with 
the given abbreviation.
A string such as "word" contains only the following valid abbreviations:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"] 

Notice that only the above abbreviations are valid abbreviations of the string "word".

Any other string is not a valid abbreviation of "word".
Note: Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
Example 1:
Given s = "internationalization",
abbr = "i12iz4n": 
Return true.
Example 2: 
Given s = "apple", 
abbr = "a2e": 
Return false.
Time Complexity: O(n) where n=max(len(word),len(abbr)) Auxiliary Space: O(1).

Solution: 
We maintain two pointers, i pointing at word and j pointing at abbr. 
 There are only two scenarios: 
 j points to a letter. We compare the value i and j points to. If equal, we increment them. Otherwise, return False. 
 j points to a digit. We need to find out the complete number that j is pointing to, 
e.g. 123. Then we would increment i by 123. 
We know that next we will: 
 either break out of the while loop if i or j is too large 
 or we will return to scenario 1.



case1:
input=
Enter word
kmit
Enter Abbreviation
4
output=
true

case=2

input=
Enter word
apple
Enter Abbreviation
a2e
output=
false



*/

import java.util.*;
class sp6{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter word");
        String word=sc.next();
        System.out.println("Enter Abbreviation");
        String abbr=sc.next();
        System.out.println(validWordAbbreviation(word,abbr));
    }
    //valid word abbreviation using two pointer approach
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;++j;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }
}
