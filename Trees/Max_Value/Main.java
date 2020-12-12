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
        root.left = new Node(30);
        root.right = new Node(40);
        root.left.left = new Node(80);
        root.left.left.right = new Node(70);
        
        root.right.left = new Node(60);
        root.right.right = new Node(20);
        
        System.out.println("Max Iterative: "+maxItr(root));
        System.out.println("Max Recursive: "+maxRecursive(root));
    }
    
    public static int maxRecursive(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        
        return Math.max(root.key,Math.max(
            maxRecursive(root.left),maxRecursive(root.right)
            )
        );
    }
    
    // Using Level Order Tranversal
    public static int maxItr(Node root){
        if(root == null){
            return -1;
        }
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        
        int max = root.key;
        
        while(q.isEmpty() == false){
            Node curr = q.poll();
            if(max < curr.key){
                max = curr.key;
            }
            if(curr.left != null){
                q.add(curr.left);
            }
            
            if(curr.right != null){
                q.add(curr.right);
            }
        }
        
        return max;
    }
    
}