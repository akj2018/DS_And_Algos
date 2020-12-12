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
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.right = new Node(70);
        kDistance(root,2,0);
    }
    
    public static void kDistance(Node root,int k,int currDist){
        if(root == null){
            return;
        }
        
        if(currDist == k){
            System.out.print(root.key + " ");
            return;
        }
        
        kDistance(root.left,k,currDist + 1);
        kDistance(root.right,k,currDist + 1);
        
    }
}

