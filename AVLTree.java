public class AVLTree extends BinaryTree
{
 private int insCount,optCount;
   public int height ( AVLNode node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   
   public int balanceFactor ( AVLNode node )
   {
      return height (node.right) - height (node.left);
   }
   
   public void fixHeight ( AVLNode node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   public AVLNode rotateRight ( AVLNode p )
   {
      AVLNode q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   public AVLNode rotateLeft ( AVLNode q )
   {
      AVLNode p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
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

   public void insert ( Fact d )
   {
      root = insert (d, root);
   }
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
   
   public void delete ( AVLNode d )
   {
      root = delete (d, root);
   }   
   public AVLNode delete ( AVLNode d, AVLNode node )
   {
      if (node == null) return null;
      if (d.data.getTerm().compareTo (node.data.getTerm()) < 0)
         node.left = delete (d, node.left);
      else if (d.data.getTerm().compareTo (node.data.getTerm()) > 0)
         node.right = delete (d, node.right);
      else
      {
         AVLNode q = node.left;
         AVLNode r = node.right;
         if (r == null)
            return q;
         AVLNode min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
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

   public AVLNode find ( String d )
   {
      if (root == null){
         return null;}
      else{
      
         return find (d, root);}
   }
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
   
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   public void treeOrder ( AVLNode node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
   public int getInsertCount(){
    return insCount;}
   public int getSearchCount(){
    return optCount;}
}



  