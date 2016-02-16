//Author- Ryan Owens
//2-15-16
// Man Wolf assignment
  public class ManWolf {

	  private static final int q0 = 0;    //initiating states
      private static final int q1 = 1;
      private static final int q2 = 2;
      private static final int q3 = 3;
      private static final int q4 = 4;
      private static final int q5 = 5;
      private static final int q6 = 6;
      private static final int q7 = 7;
      private static final int q8 = 8;
      private static final int q9 = 9;
      private static final int q10 = 10;
      

      
    
      private static int state;
      private static char c;
	  private static int[] delta;
    
	  /* Using a switch case statement to map out all of the possibilities 
	   * of state change, given each case of input for each state.
	   * Taking in user input and scanning each character for a valid change of state
	   */
      	
    	  static int delta(int s, char c) {
    		  switch (state) {
			    case q0: switch (c) {
			    	case 'g': return q1;
			    	case 'w': return q10;
			    	case 'c': return q10;
			    	case 'n': return q10;
	    		  }
			    
			    case q1: switch (c) {
		    		case 'g': return q10;
		    		case 'w': return q10;
		    		case 'c': return q10;
		    		case 'n': return q2;
			    }
			    case q2: switch (c) {
	    			case 'g': return q10;
	    			case 'w': return q3;
	    			case 'c': return q5;
	    			case 'n': return q10;
			    }
			    case q3: switch (c) {
	    			case 'g': return q4;
	    			case 'w': return q10;
	    			case 'c': return q10;
	    			case 'n': return q10;
			    }
			    case q4: switch (c) {
	    			case 'g': return q10;
	    			case 'w': return q10;
	    			case 'c': return q7;
	    			case 'n': return q10;
			    }
			    case q5: switch (c) {
	    			case 'g': return q6;
	    			case 'w': return q10;
	    			case 'c': return q10;
	    			case 'n': return q10;
			    }
			    case q6: switch (c) {
	    			case 'g': return q10;
	    			case 'w': return q7;
	    			case 'c': return q10;
	    			case 'n': return q10;
			    }
			    case q7: switch (c) {
	    			case 'g': return q10;
	    			case 'w': return q10;
	    			case 'c': return q10;
	    			case 'n': return q8;
			    }
			    case q8: switch (c) {
	    			case 'g': return q9;
	    			case 'w': return q10;
	    			case 'c': return q10;
	    			case 'n': return q10;
			    }
			    case q9: switch (c) {
	    			case 'g': return q8;
	    			case 'w': return q10;
	    			case 'c': return q10;
	    			case 'n': return q10;
			    }
			    default: return q10;
		   	  }
    	  }
    	  /*Scans through user input with a for loop, checking each character, 
    	   * and passing it into the delta function
    	   */
    	  static void process(String in) {
    		  for (int i = 0; i < in.length(); i++) {
    			  char c = in.charAt(i);
    			  state = delta(state, c);
    		  }
    	  }
    	  
    	  
    	  public boolean accepted() {
    		  return state==q9;			//Checks if delta function returned valid state q9
    	  }
	      
    	  public void reset() {	
    		  state = q0;				//Resets to initial position q0 if necessary 
    	  }
	}
