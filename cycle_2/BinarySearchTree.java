import java.util.*;
import java.io.*;


class Node{
	public int data;
	public Node lchild;
	public Node rchild;
	
	public Node(int s){
		data=s;
		lchild=rchild=null;
	}
	public void displayNode(){
		System.out.print(data+" ");
	}
}

class Tree{
	public Node root;
	
	public Tree(){
		root=null;
	}
	
	public boolean isEmpty(){
		return root==null;
	}
	public Node insert(int d){
	 Node newNode=new Node(d);
	 Node current=root;
	 Node parent;
	 if(current==null){
	 	root=newNode; 
	 	return newNode;
	}else{
		while(true){
		 parent=current;
			if(d<current.data){
				current=current.lchild;
				if(current==null){
					parent.lchild=newNode;
					return newNode;
				}
			}else{
				current=current.rchild;
				if(current==null){
					parent.rchild=newNode;
					return newNode;
				}
			}
		
		}
	}
	}
	
	public void search(int key){
	int flag=0;
	 Node current=root;
	 Node parent;
	 if(current==null){
	 	System.out.println("Tree is Empty"); 
	}else{
		while(true){
		parent=current;
			if(key<current.data){
				current=current.lchild;
				if(current==null){
					flag=0;
					break;
				}
			}else if(key>current.data){
				current=current.rchild;
				if(current==null){
					flag=0;
					break;
				}
			}else{
				flag=1;

				break;
			}
		
		}
		
		if(flag==1){
			System.out.println("Item Found");
		}else{
			System.out.println("Item not found");
		}
	}
	}
	
	public void inOrder(Node localRoot){
		
		if(localRoot==null){
			return;
		}
		inOrder(localRoot.lchild);
		localRoot.displayNode();
		inOrder(localRoot.rchild);
		
		
		
	}
	public void preOrder(Node localRoot){
		if(localRoot==null){
			return;
		}
		localRoot.displayNode();
		preOrder(localRoot.lchild);
		preOrder(localRoot.rchild);
		
	}
	public void postOrder(Node localRoot){
		if(localRoot==null){
			return;
		}
		postOrder(localRoot.lchild);
		postOrder(localRoot.rchild);
		localRoot.displayNode();
		
	}
	
	
	
}
class BinarySearchTree{
	public static void main(String args[]){
		Tree tr=new Tree();
		int choice=0;
		int d;
		Scanner scn=new Scanner(System.in);
		
		do{
		System.out.println("\n-------Menu--------");
		System.out.println("1.Insert\n2.Search\n3.PreOrder\n4.Inorder\n5.PostOrder\n6.Exit\nEnter Choice: ");
		choice=scn.nextInt();
		
		switch(choice){
			case 1:
				System.out.println("Enter value to insert: ");
				d=scn.nextInt();
				tr.insert(d);
				break;
			case 2:
				System.out.println("Enter value to search: ");
				d=scn.nextInt();
				tr.search(d);
				break;
			case 3:
				System.out.println("Preorder Traversal is: ");
				tr.preOrder(tr.root);
				
				break;
			case 4:
				System.out.println("Inorder Traversal is: ");
				tr.inOrder(tr.root);
				break;
			case 5:
				System.out.println("Postorder Traversal is: ");
				tr.postOrder(tr.root);
				break;
			case 6:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Some error occured");
		}		
		}while(choice!=6);		
	}
}
