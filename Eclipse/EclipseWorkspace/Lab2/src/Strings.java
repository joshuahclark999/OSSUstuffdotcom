//import tester.*;
//
//interface ILoString {
//	String combine();
//	String toLowerCase();
//}
//
//class MtString implements ILoString{
//	public String combine() {
//	       return "";
//	    }  
//	public String toLowerCase() {return "";}
//}
//
//class NewList implements ILoString{
//	String first;
//	ILoString rest;
//	NewList(String first, ILoString rest){
//		this.first = first;
//		this.rest = rest;
//	}
//	  public String combine(){
//	        return this.first.concat(this.rest.combine());
//	} 
//	  public String toLowerCase() {
//		  return this.first.toLowerCase();
//		  
//	  }
//	
//}
//
//class Examples{
//	Examples(){}
//	ILoString mary = new NewList("Mary ",
//            new NewList("had ",
//                new NewList("a ",
//                    new NewList("little ",
//                        new NewList("lamb.", new MtString())))));
//	
//	ILoString ijwr = new NewList("I JUST WANNA ROCK", new MtString());
//	
//// test the method combine for the lists of Strings
//boolean testCombine(Tester t){
//return 
//    t.checkExpect(this.mary.combine(), "Mary had a little lamb.");
//}
//boolean testToLower(Tester t) {
//	return t.checkExpect(this.ijwr.toLowerCase(), "i just wanna rock");
//}	
//
//}