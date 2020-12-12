import java.util.*;
import java.lang.*;

class Node {
    int key;
    Node left;
    Node right;
    int height;
    
    Node(int k){
        this.key = k;
    }
}

public class Main{
    public static void main(String [] args){
        Node root = new Node(10);
        root.height = 1;
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(60);
        root.right.right.left = new Node(70);
        root.right.right.right = new Node(80);
        levelOrder(root);
    }
    
    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);
        while(q.size() > 1){
            Node curr = q.poll();
            if(curr == null){
                q.add(null);
            } else {
                System.out.print(curr.key + " ");
                if(curr.left!=null){
                    q.add(curr.left);
                } 
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            
        }
    }
    
}