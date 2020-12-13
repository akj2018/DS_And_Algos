import java.util.*;
import java.lang.*;

class Node{
    int key;
    Node left;
    Node right;
    Node(int k){
        this.key = k;
    }
}

public class Main{
    public static void main(String [] args){
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(20);
        root.left.left = new Node(10);
        root.left.right = new Node(45);
        root.right.left = new Node(13);
        root.left.right.left = new Node(70);
        root.left.right.right = new Node(70);
        System.out.print("Is Balanced: " + (isBalanced(root) == -1 ? "No": "Yes"));
    }
    
    public static int isBalanced(Node root){
        if(root == null){
            return 0;
        }
        
        int left_height = isBalanced(root.left);
        int right_height = isBalanced(root.right);
        
        if(left_height>=0 && right_height>=0 && Math.abs(left_height - right_height)<=1){
            return 1 + Math.max(left_height,right_height);
        } else {
            return -1;
        }
    }
}