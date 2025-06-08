interface IPred <T> {
	boolean apply(T t);
}

interface IFunction<A, R> { //takes in A(rgument) and returns R
	R apply(A t);
}

interface IFunction2<A1, A2, R>{
	R apply(A1 arg1, A2 arg2) ;
}

class shapeArea implements IFunction<IShape, Double>{
	public Double apply(IShape shape) {
		
	}
}

interface iVisitorShape<R>{
	R visitCircle(Circle circle);
	R visitRect(Rect rect);
}

class VisitorShape implements iVisitorShape<Double>, IFunction<IShape, Double>{
	
	public Double apply(IShape shape) {
		return shape.accept(this);
	}
	
	public Double visitCircle(Circle circle) {
		return Math.PI * circle.radius * circle.radius;
	}
	public Double visitRect(Rect rect) {
		return rect.h * rect.w * 1.0;
	}
	
}

class VisitorStringShape implements iVisitorShape<String>, IFunction<IShape, String>{
	public String apply(IShape shape) {
		return shape.accept(this); 
	}	
	public String visitCircle(Circle circle) {
		return circle.color;
	}
	public String visitRect(Rect rect) {
		return rect.color;
	}
	
	
}


//
//class totalAgeOfRunners implements IFunction2<Runner, Integer ,Integer>{
//	public Integer apply(Runner runner, Integer sum ) {
//		return runner.age + sum;
//	}
//}
//
//
//class runnerToName implements IFunction<Runner, String>{
//	public String apply(Runner r) {
//		return r.name;
//	}
//}
//
//class runnerToAge implements IFunction<Runner, Integer>{
//	public Integer apply(Runner r) {
//		return r.age;
//	}
//}
//
//class posUnder50 implements IPred<Runner>{
//	public boolean apply(Runner r) {
//		return r.pos <= 50;
//	}
//	
//}
//
//class BookByAuthor implements IPred<Book>{
//	public boolean apply(Book b) {
//		return b.author.equals("JKR");
//	}
//}
//
//class IPredExamples{
//	IPredExamples (){}
//	
//	IPred<Book> byAuthor = new BookByAuthor();
//	IPred<Runner> runnerPosUnder50 =  new posUnder50();
//}