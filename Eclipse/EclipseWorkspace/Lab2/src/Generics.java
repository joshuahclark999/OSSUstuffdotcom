import tester.Tester;

class Book {
    String title;
    String author;
    int year;

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
class Runner  {
	String name; 
	int age;
	int bib;
	boolean isMale;
	int pos;
	int time;
	Runner(String name, int age, int bib, boolean isMale, int pos, int time){
		this.name = name;
		this.age = age;
		this.bib = bib;
		this.isMale = isMale;
		this.pos = pos;
		this.time = time;
	}
}

interface IBookPredicate {
	  boolean apply(Book b);
	}
interface IRunnerPredicate {
	  boolean apply(Runner r);
	}
	
interface IPred<T>{
	boolean apply(T t);
}

class BookByAuthor implements IPred<Book>{
	public boolean apply(Book b) {
		return b.author.equals("JKR");
	}
}
class RunnerPosUnder50 implements IPred<Runner>{
	public boolean apply(Runner r) {
		return r.pos <= 50;
	}
}

class Examples {
	Examples(){}
	 
	IPred<Book> byAuthor = new BookByAuthor();
	IPred<Runner> byRunner = new RunnerPosUnder50();
}