//Hussein Suleman
//Modified by Kagiso Dube
//15 March 2024
//DBXKAG003

/* this class stores the nodes in the avl tree
 * it updates the height of the node every time they are store
 * it check the balance factor and if the is an imbalance it does rotations to make the tree a balanced tree
 * Counts the number of comparisons the insert and search method do
 */



public class AVLTree extends BinaryTree
{
   //Count number of comparisons done by insert and search method.
 private int insCount,optCount;
    //Returns the height of a node
   public int height ( AVLNode node )
   {
      if (node != null)
         return node.height;
      return -1;
   }

   //Check if the node is balanced or not
   public int balanceFactor ( AVLNode node )
   {
      return height (node.right) - height (node.left);
   }

   //Fix the height of a node
   public void fixHeight ( AVLNode node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }

   // If the balance factor of a node is 2 we do right rotation
   public AVLNode rotateRight ( AVLNode p )
   {
      AVLNode q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }
   //if balance factor of a node is -2 we do left rotation
   public AVLNode rotateLeft ( AVLNode q )
   {
      AVLNode p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   //Checks if our tree is balance and if not it does the proper rotations to fix the issue
   public AVLNode balance ( AVLNode p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }
   //This method inserts the node as our root node
   public void insert ( Fact d )
   {
      root = insert (d, root);
   }

   //This method inserts the node into the AVL tree
   public AVLNode insert ( Fact d, AVLNode node )
   {
      if (node == null){
         return new AVLNode (d, null, null);}
         insCount++;
      if (d.getTerm().compareTo (node.data.getTerm()) <= 0){
         node.left = insert (d, node.left);}
      else{
         node.right = insert (d, node.right);}
      return balance (node);
   }
   
   
   public AVLNode findMin ( AVLNode node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }

   public AVLNode removeMin ( AVLNode node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }
   
   //This method checks if the root node is null when searching for a term
   public AVLNode find ( String d )
   {
      if (root == null){
         return null;}
      else{
      
         return find (d, root);}
   }

   //This method searches for a term in the AVL treee
   public AVLNode find ( String d, AVLNode node )
   {
       optCount++; 
      if (d.compareTo (node.data.getTerm().trim()) == 0){   
         return node;}
     else if (d.compareTo (node.data.getTerm().trim()) < 0 ){
      
         if (node.left == null){
          return  null;
          }
         return find (d, node.left);        
        }
      else
         if(node.right == null){
          return null;
          }
        optCount++; 
       return find (d, node.right);
   }
   //This method returns the number of comparisons done by the insert method
   public int getInsertCount(){
    return insCount;}

   //This method returns number of comparisons done by the find method
   public int getSearchCount(){
    return optCount;}
}



  