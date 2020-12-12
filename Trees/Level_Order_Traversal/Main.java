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

public class Main{
	public static void main(String [] args){
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(7);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(15);
        levelOrder(root);
	}

	public static void levelOrder(Node root){
		if(root == null){
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(q.isEmpty() == false){
			Node curr = q.poll();
			System.out.print(curr.key + " ");
			if(curr.left != null){
				q.add(curr.left);
			}

			if(curr.right != null){
				q.add(curr.right);
			}
		}
	}
}
