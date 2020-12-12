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
        Node root = new Node(80);
        root.left = new Node(30);
        root.right = new Node(40);
        root.left.left = new Node(90);
        root.right.right = new Node(100);
        root.right.right.left = new Node(60);
        System.out.println("Size Recursive: " + sizeRecursive(root));
        System.out.println("Size Iterative: " + sizeItr(root));
    }
    
    public static int sizeRecursive(Node root){
        if(root == null){
            return 0;
        }
        
        return 1 + sizeRecursive(root.left) + sizeRecursive(root.right);
    }
    
    public static int sizeItr(Node root){
        if(root == null){
            return 0;
        }
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        
        int counter = 0;
        while(q.isEmpty() == false){
            Node curr = q.poll();
            counter++;
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
        return counter;
    }
}