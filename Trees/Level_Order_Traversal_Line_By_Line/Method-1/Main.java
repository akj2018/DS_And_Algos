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
        int height = 1;
        while(q.isEmpty() == false){
            Node num = q.poll();
            if(num.height > height){
                System.out.print("\n" + num.key + " ");
                height = num.height;
            } else {
                System.out.print(num.key+" ");               
            }
 
            if(num.left!=null){
                q.add(num.left);
                num.left.height = num.height + 1;
            }
            if(num.right!=null){
                q.add(num.right);
                num.right.height = num.height + 1;
            }
        }
    }
    
}