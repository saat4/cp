//Palindrome Linked List
/*
Given the head of a singly linked list, return true if it is a palindrome or 
false otherwise.

Example 1:
Input:
head = [1,2,2,1]
Output:
true
Example 2:
Input:
head= [1,2]
Output:
false

Approach:
Use two pointers left and right. 
Move right and left using recursion and check for following in each recursive call. 
1) Sub-list is a palindrome. 
2) Value at current left and right are matching. 
If both above conditions are true then return true. 
 The idea is to use function call stack as a container. Recursively traverse till 
the end of the list. When we return from the last NULL, we will be at the last node.
The last node is to be compared with the first node of the list. 

 In order to access the first node of the list, we need the list head to be available 
in the last call of recursion. Hence, we pass head also to the recursive function. 
If they both match we need to compare (2, n-2) nodes. 

 Again when recursion falls back to (n-2)nd node, we need a reference to 2nd node 
from the head. We advance the head pointer in the previous call, to refer to the next 
node in the list. However, the trick is identifying a double-pointer.

Passing a single pointer is as good as pass-by-value, and we will pass the 
same pointer again and again. 

 We need to pass the address of the head pointer for reflecting the changes 
in parent recursive calls.

Time Complexity: O(n) 
Auxiliary Space: O(n) if Function Call Stack size is considered, otherwise O(1).



Output: 

a->NULL
Not Palindrome

b->a->NULL
Not Palindrome

a->b->a->NULL
Is Palindrome

c->a->b->a->NULL
Not Palindrome

a->c->a->b->a->NULL
Not Palindrome

b->a->c->a->b->a->NULL
Not Palindrome

a->b->a->c->a->b->a->NULL
Is Palindrome


*/
import java.util.*;
class Test{
    static class Node{
        char data;
        Node next;
        Node(char d){
            data=d;
            next=null;
        }
    }
    static Node head;
    static Node left;
    static boolean isPalindromeUtil(Node right){
        left=head;
        if(right==null)
            return true;
        boolean isp=isPalindromeUtil(right.next);
        if(isp==false)
            return false;
        boolean isp1=(right.data==left.data);
        left=left.next;
        return isp1;
    }
    static boolean isPalindrome(Node head){
        left=head;
        return isPalindromeUtil(head);
    }
    static void printList(Node node){
        while(node!=null){
            System.out.print(node.data+"->");
            node=node.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        head=new Node('a');
        head.next=new Node('b');
        head.next.next=new Node('a');
        head.next.next.next=new Node('c');
        head.next.next.next.next=new Node('a');
        head.next.next.next.next.next=new Node('b');
        head.next.next.next.next.next.next=new Node('a');
        printList(head);
        if(isPalindrome(head))
            System.out.println("Is Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}
