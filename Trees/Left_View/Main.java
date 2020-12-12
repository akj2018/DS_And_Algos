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
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.left = new Node(40);
        root.right.right = new Node(50);
        System.out.println("Left View Iterative: ");
        leftViewItr(root);
        System.out.println("\nLeft View Recursive: ");
        leftViewRecursive(root,1);
    }
    
    // Recursive
    public static int maxLevel = 0;
    public static void leftViewRecursive(Node root, int level){
        if (root == null){
            return;
        }
        
        if(maxLevel < level){
            System.out.print(root.key + " ");
            maxLevel = level;
        }
        
        leftViewRecursive(root.left, level + 1);
        leftViewRecursive(root.right, level + 1);
    }
    
    // Iterative
    public static void leftViewItr(Node root){
        if(root == null){
            return;
        }
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(q.isEmpty() == false){
            int count = q.size();
            for(int i=0;i<count;i++){
                Node curr = q.poll();
                if(i==0){
                    System.out.print(curr.key + " ");
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }
    
}