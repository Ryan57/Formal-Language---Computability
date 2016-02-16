  //Author- Ryan Owens
//2-15-16
// Man Wolf assignment

  import java.io.*;



  public class driverDFA {
	  public static void main(String[] args) throws IOException {
		  ManWolf m = new ManWolf();  
  //Links the functions from ManWolf.java to pass in user input
		  							  
    	  BufferedReader in = 
    			  new BufferedReader(new InputStreamReader(System.in));
    	  String s = in.readLine();
  //Takes Command line user input (in) and assigns it to string s 
  //which allows us to check input and see if they found a solution.
    	  
    	  while (s!=null) {
    		  m.reset();			//checks if input is null, and resets if true
    		  ManWolf.process(s);   //calls the process function from ManWolf.java on input s
    		  if(m.accepted())
    			  System.out.println("That is a solution.");
    		  else 
    			  System.out.println("That is not a solution.");
    		  	s = in.readLine();
    		  
    	  }
	  }
	

}
