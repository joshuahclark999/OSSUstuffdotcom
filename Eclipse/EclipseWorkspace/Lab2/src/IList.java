import tester.*;

interface IList<T>{
	IList<T> find(IPred<T> predicate);
}

class MtList<T> implements IList<T>{
	public IList<T> find(IPred<T> predicate){return new MtList<T>();}
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
}

class IListExamples {
	IListExamples(){}
	
	Runner john = new Runner("Stonson", 32, 888, true, 227, 145);
	Runner alf = new Runner("Michaels", 29, 222, true, 12,  45);
	
	IList<Runner> runnerList = new ConsList<Runner>(this.john, 
												  new ConsList<Runner>(this.alf, 
												  new MtList<Runner>()));
	
	Book got = new Book("Game of thrown", "JKR", 2008);
	Book hp = new Book("Harry pottyer of thrown", "Tony Start", 2001);
	
	IList<Book> bookList = new ConsList<Book>(this.got, 
										    new  ConsList<Book>(this.hp,
										    new MtList<Book>()));

	IList<String> stringList = new ConsList<String>("Goodbye", 
											   new  ConsList<String>("Hello",
											   new MtList<String>()));
	
	IPred<Runner> posUnder50Runner = new posUnder50();
	
	boolean testIListExamples(Tester t) {
		return t.checkExpect(runnerList.find(posUnder50Runner),
				new ConsList<Runner>(alf, new MtList<Runner>()));
	}
	
	
}