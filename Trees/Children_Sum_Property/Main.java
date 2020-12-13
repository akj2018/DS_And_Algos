import java.util.*;
import java.lang.*;

class Node {
    int key;
    Node left;
    Node right;
    Node(int k){
        this.key = k;
    }
}

public class Main {
    public static void main(String [] args){
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.right.left = new Node(2);
        // root.right.right = new Node(2);
        System.out.println("Is Children Sum: " + (isChildrenSum(root)?"Yes":"No"));
    }
    
    public static boolean isChildrenSum(Node root){
        if(root == null){
            return true;
        }
        
        if(root.left == null && root.right == null){
            return true;
        }
        
        int sum = 0;
        if(root.left != null){
            sum = sum + root.left.key;
        }
        if(root.right != null){
            sum = sum + root.right.key;
        }
        
        return root.key == sum && isChildrenSum(root.left) && isChildrenSum(root.right);
    }
}