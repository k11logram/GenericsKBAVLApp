//Dube Kagiso
//DBXKAG003
//16 March 2024

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Experiment{
 
  public static void main(String args[]){
    Scanner keyboard = new Scanner(System.in);
    String input="";
    int x=0;
    List<Integer> insertCounter = new ArrayList<>();
    List<Integer> searchCounter = new ArrayList<>();
    System.out.println("Please enter the number of generic truths you wish to store in the tree, must be from 1 to 50000");
    input= keyboard.nextLine().trim();
      do{
      
        //Variable declaration
        
        int j=0;
        int i=0;
        AVLTree node= new AVLTree();
        String[] queries= new String[50000];
        List<Fact> nodeStorage = new ArrayList<>();
       

        if(!(input.equals("Stop")||input.equals(""))){
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
       


       // Storing the generic truths in a AVL tree 
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
      }
    insertCounter.add(node.getInsertCount());
    searchCounter.add(node.getSearchCount());

  
   x++;
   }
   
  while((x<10));
  System.out.println(insertCounter);
  System.out.println(searchCounter);
}
}
    
   
