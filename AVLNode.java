//Dube Kagiso
//DBXKAG003
//15 March 2024

/*Foundation for the  AVL tree class
  Stores the height of the node
  Node has connection to the node less than it ang greater than it
*/

public class AVLNode{
  Fact data;
  int height;
  AVLNode left;
  AVLNode right;
  
  //Set the values for the left and right node and the height of the node
  public AVLNode(Fact generic_truth, AVLNode left, AVLNode right){
     this.data=generic_truth;
     this.left=left;
     this.right=right;
     height=0;
    }
    
  public AVLNode(){
    this.data=null;
    this.left=null;
    this.right=null;
    }
    
 public AVLNode(Fact term){
   this.data=term;
   this.left=null;
   this.right=null;
   height=0;
    }
  //Returns the left node
  public AVLNode getLeft(){
    return this.left;
    }
   //returns the right node. 
  public AVLNode getRight(){
    return this.right;
    }
    
   }