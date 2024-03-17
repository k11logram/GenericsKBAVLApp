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
    
  public String getTerm(){
    return this.term;
    }
  public String getStatement(){
    return this.statement;
    }
    
  public double getConfidence(){
    return this.confidence_score;
    }
    
  public void setTerm(String term){
    this.term=term;
    }
    
  public void setStatement(String statement){
    this.statement=statement;
    }
    
  public void setConfidence(double confidence){
    this.confidence_score=confidence;
    }
    
   }