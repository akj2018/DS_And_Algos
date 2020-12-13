import java.util.*;
import java.lang.*;

class Node {
    int key;
    Node right;
    Node left;
    
    Node(int k){
        this.key = k;
    }
}

public class Main{
    public static void main(String [] args){
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(31);
        root.left.left.left = new Node(80);
        root.right.left = new Node(50);
        root.right.right = new Node(60);
        System.out.print("Max Width: "+ maxWidth(root));
    }
    
    public static int maxWidth(Node root){
        if(root == null){
            return 0;
        }
        int max_width = 0;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(q.isEmpty() == false){
            int count = q.size();
            if(count > max_width){
                max_width = count;
            }
            for(int i=0;i<count;i++){
                Node curr = q.poll();
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return max_width;
    }
}