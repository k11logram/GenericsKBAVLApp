//Dube Kagiso
//DBXKAG003
//16 March 2024

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JOptionPane;




public class GenericsKbAVLApp{
 
  public static void main(String args[]){
    //GUI interface
    JFrame frame = new JFrame("GenericsKbAVLApp");
    
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.BLACK);
    frame.setVisible(true);
    //both variables accpet user input
    String input = "";
    String input2 = "";
    //Store number of comparisons done by insert and find method
    List<Integer> insertCounter = new ArrayList<>();
    List<Integer> searchCounter = new ArrayList<>();
      
       //user enters proper/existing knowledge base
        do{
         input= JOptionPane.showInputDialog(frame,"Load Knowledge base");
         if(input==null || input.trim().equals("") ){
          JOptionPane.showMessageDialog(frame,"Enter an existing knowledge base");}
        }
        while(input==null || input.trim().equals(""));

        int i=0;
        AVLTree node= new AVLTree();
        String[] queries= new String[5000];

       
      //Store the query terms in a array
        try{
        BufferedReader read = new BufferedReader(new FileReader(input2));
        String fileLine="";
   
    
        while((fileLine=read.readLine())!= null){
          queries[i]=fileLine;
          i++;
          }
        read.close();
        
        }
        catch(IOException e){
          JOptionPane.showMessageDialog(frame,"Enter proper file name");
          input=JOptionPane.showInputDialog(frame,"Load Knowledge base").trim();
          } 
    


    /*Storing the generic truths in a AVL tree 
     *user enters an existing query file name
     */
    do{
      input2=JOptionPane.showInputDialog(frame,"Please enter the Query file").trim();
      if(input2==null || input2.trim().equals("") ){
        JOptionPane.showMessageDialog(frame,"Enter an existing knowledge base");}
      }
      while(input2==null || input2.trim().equals(""));

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
          JOptionPane.showMessageDialog(frame,"Enter proper file name");
          input2=JOptionPane.showInputDialog(frame,"Please enter the Query file").trim();
    
   
    }

    //Comparing the terms in the query file to the terms in the AVL tree
   for(int y=0;y<i;y++){   
    AVLNode newNode=node.find(queries[y]);
    if(newNode != null){
        System.out.println(queries[y]+": "+newNode.data.getStatement().trim()+" ("+newNode.data.getConfidence()+")");
        }
    else{}
   }
    insertCounter.add(node.getInsertCount());
    searchCounter.add(node.getSearchCount());

 JOptionPane.showMessageDialog(frame,"insert Method Comparisons\n"+insertCounter); 
 JOptionPane.showMessageDialog(frame,"Search Method Comparisons\n"+searchCounter);
 //Close jFrame
 frame.dispose();
}
}
    
   

