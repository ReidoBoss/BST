 public class BinarySearchTree{
   Node root;    
   
   public void insert(Node newNode){
      root = insertHelper(root, newNode);
   }
   private Node insertHelper(Node root,Node newNode){
   
      
      if(root == null){
         return newNode;
      }
      
      if(newNode.data < root.data){
         root.left = insertHelper(root.left,newNode);
      }
      if(newNode.data > root.data){
         root.right = insertHelper(root.right,newNode);
      }
      
      return root;
   }
   
   public void display(){
      displayHelper(root);
   }  
   
   public void displayHelper(Node root){
      if(root!=null){
         System.out.print(root.data+" ");
         displayHelper(root.left);
         displayHelper(root.right);
      }
   }
      
   public boolean search(int data){
      return searchHelper(root,data);
   }
   private boolean searchHelper(Node root, int data){
      if(root==null){
         return false;
      }
      if(data == root.data){
         return true;
      }
      else if(data < root.data){
         return searchHelper(root.left,data);
      }
      else{
         return searchHelper(root.right,data);
      }
   }
   
   public void delete(int data){
       // Call the deleteHelper method starting from the root of the tree
       root = deleteHelper(root, data);
   }

   private Node deleteHelper(Node root, int data){
      if(root == null){
         return null;
      }
      
      if(data < root.data){
         root.left = deleteHelper(root.left,data);
      }
      else if(data > root.data){
         root.right = deleteHelper(root.right,data);
      }
      else{
         if(root.right == null){
            return root.left;
         }
         else if(root.left == null){
            return root.right;
         }
         
         else{
            root.data = sucessor(root.right);
            root.right = deleteHelper(root.right,root.data);
         
         }
      }
      return root;
   }   
   
   private int sucessor (Node root){
      int minVal = root.data;
      while (root.left!=null){
         minVal = root.left.data;
         root = root.left;
      } 
      return minVal;
   }
   
   
   
      
}