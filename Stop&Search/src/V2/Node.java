package V2;

//Java AVL Tree 
class Node { 
 int height; 
 CrimeStopAndsearch key;
 Node left, right; 

 Node(CrimeStopAndsearch d) { 
     key = d; 
     height = 1; 
 } 
} 

class AVLTree { 

 Node root; 
 int height(Node N) { 
     if (N == null) 
         return 0; 

     return N.height; 
 } 
 int max(int a, int b) { 
     return (a > b) ? a : b; 
 } 
 Node rightRotate(Node y) { 
     Node x = y.left; 
     Node T2 = x.right; 
     x.right = y; 
     y.left = T2; 
     y.height = max(height(y.left), height(y.right)) + 1; 
     x.height = max(height(x.left), height(x.right)) + 1; 
     return x; 
 } 
 Node leftRotate(Node x) { 
     Node y = x.right; 
     Node T2 = y.left; 

     // Perform rotation 
     y.left = x; 
     x.right = T2; 

     //  Update heights 
     x.height = max(height(x.left), height(x.right)) + 1; 
     y.height = max(height(y.left), height(y.right)) + 1; 

     // Return new root 
     return y; 
 } 

 // Get Balance factor of node N 
 int getBalance(Node N) { 
     if (N == null) 
         return 0; 

     return height(N.left) - height(N.right); 
 } 
// Breaks on null values because left and right dont have a value
 Node insert(Node node, CrimeStopAndsearch key) { 

     /* 1.  Perform the normal BST insertion */
     if (node == null) 
         return (new Node(key)); 
     int var1 = key.Legislation.compareTo(node.key.Legislation);
     
     //Duplicate Legislation IDK what to do
     if(var1 == 0) {
    	 
     }
     if(var1 > 0) {
    	 node.right = insert(node.right, key);
     }
     if(var1 < 0) {
    	 node.left = insert(node.left, key);
     }
     node.height = 1 + max(height(node.left), 
                           height(node.right)); 
     int balance = getBalance(node);
     
     // https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
     // I am using the code from this website to try understanding more
     if(key != null && node.right != null && node.left != null) {   	 
     if(key.Legislation != null && node.right.key.Legislation != null) {
    	 
     int var2 = key.Legislation.compareTo(node.left.key.Legislation);
     int var3 = key.Legislation.compareTo(node.right.key.Legislation); 
     if(balance > 1 && var2 < 0) {
    	 return rightRotate(node); 
     }
     if(balance < -1 && var3 > 0) {
    	 return leftRotate(node);
     }
     if(balance > 1 && var2 > 0) {
    	 return rightRotate(node); 
     }
     if(balance < -1 && var3 < 0) {
    	 node.right = rightRotate(node.right); 
         return leftRotate(node);  
     }
     }
     }
     return node;
 }
 void preOrder(Node node) { 
     if (node != null) { 
         System.out.print(node.key + " "); 
         preOrder(node.left); 
         preOrder(node.right); 
     } 
     
 } 
}
 
