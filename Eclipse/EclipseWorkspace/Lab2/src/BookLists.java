//import tester.Tester;
//
//interface IShape {
//	boolean sameShape(IShape that);
//		  boolean sameCircle(Circle that);
//		  boolean sameRect(Rect that);
//		  boolean sameSquare(Square that);
//		boolean sameCombo(Combo that);
//}
//abstract class AShape implements IShape{
//	public boolean sameCircle(Circle that) { return false;  }
//	public boolean sameRect(Rect that)   { return false; }
//	public boolean sameSquare(Square that) { return false; }
//	public 	boolean sameCombo(Combo that) {return false;}
//
//}
//
//class Circle extends AShape {
//  int x, y;
//  int radius;
//  Circle(int x, int y, int radius) {
//    this.x = x;
//    this.y = y;
//    this.radius = radius;
//  }
//  public boolean sameCircle(Circle that) {
//	  /* Template:
//	   * Fields:
//	   * this.x, this.y, this.radius
//	   *
//	   * Fields of parameters:
//	   * that.x, that.y, that.radius
//	   */
//	  return this.x == that.x &&
//	         this.y == that.y &&
//	         this.radius == that.radius;
//	}
//
//  public boolean sameShape(IShape that) {
//	  return that.sameCircle(this);
//	}
//
//
//}
//class Rect extends AShape {
//  int x, y;
//  int w, h;
//  Rect(int x, int y, int w, int h) {
//    this.x = x;
//    this.y = y;
//    this.w = w;
//    this.h = h;
//  }
//  public boolean sameRect(Rect that) {
//	  /* Template:
//	   * Fields:
//	   * this.x, this.y, this.w, this.h
//	   *
//	   * Fields of parameters:
//	   * that.x, that.y, that.w, that.h
//	   */
//	  return this.x == that.x &&
//	         this.y == that.y &&
//	         this.w == that.w &&
//	         this.h == that.h;
//	}
////in Rect
//	public boolean sameShape(IShape that) {
//	 return that.sameRect(this);
//}
//	
//
//
//
//}
//class Square extends Rect {
//	  Square(int x, int y, int s) { super(x, y, s, s); }
//	  public boolean sameShape(IShape that) {
//		  return that.sameSquare(this);
//			  }
//	  public boolean sameSquare(Square that) {
//	    return this.x == that.x &&
//	           this.y == that.y &&
//	           this.w == that.w; // No need to check the h field, too...
//	  }
//	  
//	// in Square
//
//	}
//class Combo extends AShape {
//    IShape top;
//    IShape bot;
//    
//    Combo(IShape top, IShape bot) {
//        this.top = top;
//        this.bot = bot;
//    }
//    public boolean sameShape(IShape that) { return that.sameCombo(this); }
//    public boolean sameCombo(Combo that) {
//      return this.top == that.top &&
//    		  this.bot == that.bot;
//    }
//    
//}
//
//
//class ExampleShapes{
//	ExampleShapes(){	}
//	
//	Circle c1 = new Circle(3, 4, 5);
//	Circle c2 = new Circle(4, 5, 6);
//	Circle c3 = new Circle(3, 4, 5);
//	Rect r1 = new Rect(3, 4, 5, 5);
//	Rect r2 = new Rect(4, 5, 6, 7);
//	Rect r3 = new Rect(3, 4, 5, 5);
//	Square s1 = new Square(3, 4, 5);
//	Square s2 = new Square(4, 5, 6);
//	Square s3 = new Square(3, 4, 5);
//	 
//	boolean testcheckSame(Tester t) {
//		
//		return  t.checkExpect(c1.sameCircle(c2), false)&&
//				t.checkExpect(c2.sameCircle(c1), false)&&
//				t.checkExpect(c1.sameCircle(c3), true)&&
//				t.checkExpect(c3.sameCircle(c1), true)&&
//				 
//				t.checkExpect(r1.sameRect(r2), false)&&
//				t.checkExpect(r2.sameRect(r1), false)&&
//				t.checkExpect(r1.sameRect(r3), true)&&
//				t.checkExpect(r3.sameRect(r1), true)&&
//				 
//				t.checkExpect(s1.sameShape(s2), false)&&
//				t.checkExpect(s2.sameShape(s1), false)&&
//				t.checkExpect(s1.sameShape(s3), true)&&
//				t.checkExpect(s3.sameShape(s1), true)&&
//				 
//				// Comparing a Square with a Rect of a different size
//				t.checkExpect(s1.sameShape(r2), false)&&
//				t.checkExpect(r2.sameShape(s1), false)&&
//				// Comparing a Square with a Rect of the same size
//				t.checkExpect(s1.sameShape(r1), false)&&
//				t.checkExpect(r1.sameShape(s1), true);
//
//	}
//	
//}