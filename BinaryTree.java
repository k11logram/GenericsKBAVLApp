// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
//Modified by kagiso dube
//Modified on the 15 March 2024

/*This class stores the nodes ain a binary tree
 * provides basic methods like getting the height of the tree and to traverse the tree
 */
public class BinaryTree
{
   AVLNode root;
   
   public BinaryTree ()
   {
      root = null;
   }
   //returns height of the tree
   public int getHeight ()
   {
      return getHeight (root);
   } 
   //reutrns height of a node  
   public int getHeight ( AVLNode node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   //returns size of the tree
   public int getSize ()
   {
      return getSize (root);
   }  
   //returns size of a node 
   public int getSize ( AVLNode node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   //prints a node
   public void visit ( AVLNode node )
   {
      System.out.println (node.data);
   }
   //prints the nodes from left to right but the root is printed out first
   public void preOrder ()
   {
      preOrder (root);
   }
   public void preOrder ( AVLNode node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }
   //prints the tree out from left to right but prints the root at the end
   public void postOrder ()
   {
      postOrder (root);
   }
   public void postOrder ( AVLNode node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }
   //prints the tree out in order
   public void inOrder ()
   {
      inOrder (root);
   }
   public void inOrder ( AVLNode node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }

}
