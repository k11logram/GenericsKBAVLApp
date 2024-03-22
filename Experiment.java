//Dube Kagiso
//DBXKAG003
//16 March 2024

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JOptionPane;


/*Asks the user for size of the set the avl tree is suppose to store
 *facts sored randomly each time
 *after storing that size it goes through the query file and checks if any of the terms can be found in the tree
 *repeats this process for 10 times
 * returns the number of comparisons done for each of does times
 */

public class Experiment{
 
  public static void main(String args[]){
    //GUI interface
    JFrame frame = new JFrame("Experimental Data");
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.BLACK);
    frame.setVisible(true);
    //accept size of the set
    String input = JOptionPane.showInputDialog(frame,"Please enter the number of generic truths you wish to store in the tree, must be from 1 to 50000");
    
    //counter to see how many times have we executed tthis code(must be equal to 10)
    int x=0;
    //Store number of comparisons done each time
    List<Integer> insertCounter = new ArrayList<>();
    List<Integer> searchCounter = new ArrayList<>();
      do{
      
      //Variable declaration
        int j=0;
        //counts number of queries stored in array
        int i=0;
        AVLTree node= new AVLTree();
        String[] queries= new String[50000];
        List<Fact> nodeStorage = new ArrayList<>();
       
        //convert input into integer
        int Numterms=Integer.parseInt(input);
       //Store the query terms in a array
        try{
        BufferedReader read = new BufferedReader(new FileReader("GenericsKB-queries.txt"));
        String fileLine="";
   
    
        while((fileLine=read.readLine())!= null){
          queries[i]=fileLine;
          i++;
          }
        read.close();
        
        }
        catch(IOException e){
        System.out.println("Enter proper file name");
          } 
    


    // Storing the generic truths in a list so we can shuffle it 
    try{
    BufferedReader readfile = new BufferedReader(new FileReader("GenericsKB.txt"));
    String file ="";
    while((file = readfile.readLine()) != null){
        String term = file.substring(0, file.indexOf("\t")+1);
        String no_item=file.substring(file.indexOf("\t")+1, file.length());
        String statement = no_item.substring(0,no_item.indexOf("\t")+1);
        double confidence = Double.parseDouble(no_item.substring(no_item.indexOf("\t")+1,no_item.length()));
        
    
        Fact truth = new Fact(term,statement,confidence);
        nodeStorage.add(truth);
        
        }
    readfile.close();
    Collections.shuffle(nodeStorage);
        }
        
   catch (IOException e){
          System.out.println("Enter proper file name");
   
    }
   //Store facts in the list in the avl tree
   while(j<Numterms){
    node.insert(nodeStorage.get(j));
    j++;
   }
    //Comparing the terms in the query file to the terms in the AVL tree
   for(int y=0;y<i;y++){   
    AVLNode newNode=node.find(queries[y]);
    if(newNode != null){
//  System.out.println(queries[y]+": "+newNode.data.getStatement().trim()+" ("+newNode.data.getConfidence()+")");
        }
    else{}
   }
   //number of comparisons done for this round are stored here
    insertCounter.add(node.getInsertCount());
    searchCounter.add(node.getSearchCount());
   x++;
   }
   
  while((x<10));
//print out the comparisons 
 JOptionPane.showMessageDialog(frame,"insert Method Comparisons\n"+insertCounter); 
 JOptionPane.showMessageDialog(frame,"Search Method Comparisons\n"+searchCounter);
 frame.dispose();
}
}
    
   

