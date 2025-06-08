import tester.*;

interface IList<T>{
	IList<T> find(IPred<T> predicate);
	<R>IList<R> map(IFunction<T,R> function );
	<R> R foldr(IFunction2<T, R, R> function,  R baseValue);
	
	
}

class MtList<T> implements IList<T>{
	public IList<T> find(IPred<T> predicate){return new MtList<T>();}
	
	 public <R>IList<R> map(IFunction<T,R> function){
		return new MtList<R>();
	}
	 public <R> R foldr(IFunction2<T, R, R> function,  R baseValue) {
		 return baseValue;
	 }
		
	 
}

class ConsList<T> implements IList<T>{
	T first;
	IList<T> rest;
	
	ConsList(T first, IList<T> rest){
		this.first = first;
		this.rest = rest;
	}
	
	public IList<T> find(IPred<T> predicate){
		if(predicate.apply(this.first)) {
			return new ConsList<T>(this.first, this.rest.find(predicate));
		}else {
			return this.rest.find(predicate);
		}
	}
	 public <R>IList<R> map(IFunction<T,R> function){
			return new ConsList<R>(function.apply(this.first), this.rest.map(function));
		}
	 
	public  <R> R foldr(IFunction2<T, R, R> function,  R baseValue) {
		 return function.apply(this.first, this.rest.foldr(function, baseValue));
	 }
}



//class IListExamples {
//	IListExamples(){}
//	
//	Runner john = new Runner("Stonson", 4, 888, true, 227, 145);
//	Runner alf = new Runner("Michaels", 5, 222, true, 12,  45);
//	
//	IList<Runner> runnerList = new ConsList<Runner>(this.john, 
//												  new ConsList<Runner>(this.alf, 
//												  new MtList<Runner>()));
//	
//	Book got = new Book("Game of thrown", "JKR", 2008);
//	Book hp = new Book("Harry pottyer of thrown", "Tony Start", 2001);
//	
//	IList<Book> bookList = new ConsList<Book>(this.got, 
//										    new  ConsList<Book>(this.hp,
//										    new MtList<Book>()));
//
//	IList<String> stringList = new ConsList<String>("Goodbye", 
//											   new  ConsList<String>("Hello",
//											   new MtList<String>()));
//	
//	IPred<Runner> posUnder50Runner = new posUnder50();
//	IList<Runner> expectedRunnerList = new ConsList<Runner>(alf, new MtList<Runner>());
//	
//	IList<String> expectedRunnerNames = new ConsList<String>("Stonson",
//																		 new ConsList<String>("Michaels",
//																		 new MtList<String>()));
//	
//	boolean testIListExamples(Tester t) {
//		return t.checkExpect(runnerList.find(posUnder50Runner), expectedRunnerList);
//	}
//	
//	boolean testIListMap(Tester t) {
//		return t.checkExpect( this.runnerList.map(new runnerToName()), 
//														expectedRunnerNames);
//	}
//	
//	boolean testIListFoldr(Tester t) {
//		return t.checkExpect(runnerList.foldr(new totalAgeOfRunners(), 0) , 9);
//	}
//	
//}