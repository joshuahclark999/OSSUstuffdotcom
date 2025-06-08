import tester.*;

interface IShape { 
	<R> R accept(iVisitorShape<R> visitor);
}
class Circle implements IShape {
  int x, y;
  int radius;
  String color;
  Circle(int x, int y, int r, String color) {
    this.x = x;
    this.y = y;
    this.radius = r;
    this.color = color;
  }
  public <R> R accept(iVisitorShape<R> visitor) {
	  return visitor.visitCircle(this);
  }
}
class Rect implements IShape {
  int x, y, w, h;
  String color;
  Rect(int x, int y, int w, int h, String color) {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.color = color;
  }
  public <R> R accept(iVisitorShape<R> visitor){
	  return visitor.visitRect(this);
  }
}

//class Examples{
//	Examples(){}
//	
//	IList<IShape> shapes = new ConsList<IShape>(new Circle(0,0,10,"red"),
//			new ConsList<IShape>(new Rect(0,0,10,10,"blue"),
//					new MtList<IShape>()));
//	
//	IList<Double> expectedList = new ConsList<Double>(314.15,
//													   new ConsList<Double>(100.00,
//													    new MtList<Double>()     ));
//	IList<String> expectedList2 = new ConsList<String>("red",
//														new ConsList<String>("blue",
//														 new MtList<String>()  ));
//	
//boolean testIShapeMap(Tester t) {
//	return t.checkInexact(shapes.map(new VisitorShape()), expectedList, .01);
//}
//boolean testIShapeName(Tester t) {
//	return t.checkInexact(shapes.map(new VisitorStringShape()), expectedList2, .01);
//}
//	
//	
//}