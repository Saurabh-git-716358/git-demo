import java.util.Scanner;
public class appd {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	
	{
	
		BST a = new BST();
		BstIterator bt = new BstIterator();
		
		Node root = null;  
		root = a.insert(root, 8);
        root = a.insert(root, 3);
        root = a.insert(root, 10);
        root = a.insert(root, 4);
        root = a.insert(root, 2);
        root = a.insert(root, 9);
        root = a.insert(root, 11);
        
        
        char hasNext = bt.hasNext(root);
        if(hasNext=='a')
        System.out.println("Next Smallest Element Present in BST");
        else
        System.out.println("BST has no elements");	
        
        int next = bt.getNext(root);
        if(next!=-1)
        System.out.println("Value of next smallest element is = "+next);
        else
        System.out.println("No value present");
        
        a.printInOrder(root);
	}
	
	
		
}

//Structure of Node Used in BST
class Node{
	int value;
	Node lchild;
	Node rchild;
}



class BST{
	
	  public Node insert (Node node , int val) {
		 if(node==null)
		 {
			 return createNewNode(val);
		 }
		 if(val<node.value)
		 {
			 node.lchild = insert(node.lchild,val);
		 }
		 else if(val>node.value)
		 {
			 node.rchild = insert(node.rchild,val);
		 }
		 return node;
	  }

	 

	public Node createNewNode(int val) {
	    Node a = new Node();
	    a.value = val;
	    a.lchild = null;
	    a.rchild = null;
		return a;
	}
	
	public void printInOrder(Node root) {
		// TODO Auto-generated method stub
	    if(root!=null)
	    {
	    	printInOrder(root.lchild);
	    	System.out.print(root.value+" ");
	    	printInOrder(root.rchild);
	    }
				
	}
	
}

//Requirements
class BstIterator{
	
	
	public char hasNext(Node root) {
		if(root==null)
		{
			System.out.println("Tree Data Not present");
		}
		else if(root.lchild!=null)
		{
			return 'a';
		}
		return 'z';   //If Root is Null
	}
	
	
	public int getNext(Node root)
	{
		char hasNext = hasNext(root);
		if(hasNext=='a')
			return root.lchild.value;
		else
			return -1;
	}
	
}