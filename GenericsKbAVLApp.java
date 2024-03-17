//Dube Kagiso
//DBXKAG003
//16 March 2024

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class GenericsKbAVLApp{
 
  public static void main(String args[]){
    int i=0;
    AVLTree node= new AVLTree();
    String[] queries= new String[50000];
    try{
    BufferedReader read = new BufferedReader(new FileReader("GenericsKB-testQueries.txt"));
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
     
      try{
      BufferedReader readfile = new BufferedReader(new FileReader("GenericsKB.txt"));
      String file ="";
      while((file = readfile.readLine()) != null){
        String term = file.substring(0, file.indexOf("\t")+1);
        String no_item=file.substring(file.indexOf("\t")+1, file.length());
        String statement = no_item.substring(0,no_item.indexOf("\t")+1);
        double confidence = Double.parseDouble(no_item.substring(no_item.indexOf("\t")+1,no_item.length()));
        
      
       Fact truth = new Fact(term,statement,confidence);
       node.insert(truth);
        
        }
        readfile.close();
        }
        
    catch (IOException e){
          System.out.println("Enter proper file name");
  }
   for(int j=0;j<i;j++){
     
     AVLNode newNode=node.find(queries[j]);
      if(newNode != null){
        System.out.println(queries[j]+": "+newNode.data.getStatement().trim()+" ("+newNode.data.getConfidence()+")");
        }
      else{
      System.out.println("Term not found: "+queries[j]);}
      }
    }
   }

