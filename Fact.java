//DUbe Kagiso
//DBXKAG003
//15 March 2024

/*this seperates the generic truth to three of it's core components 
  the term, statement and the confiedence score
*/

public class Fact{
  private String term;
  private String statement;
  private double confidence_score;
  
  public Fact(String term,String statement,double confidence_score){
    this.term=term;
    this.statement=statement;
    this.confidence_score=confidence_score;
    }
  //return term  
  public String getTerm(){
    return this.term;
    }
  //return statement
  public String getStatement(){
    return this.statement;
    }
  //return confidence score 
  public double getConfidence(){
    return this.confidence_score;
    }
  // set the term 
  public void setTerm(String term){
    this.term=term;
    }
   //set the statement 
  public void setStatement(String statement){
    this.statement=statement;
    }
   //set the confidence score 
  public void setConfidence(double confidence){
    this.confidence_score=confidence;
    }
    
   }