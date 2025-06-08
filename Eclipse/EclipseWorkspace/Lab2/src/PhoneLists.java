import tester.Tester;

interface IMutableLoP{
	void add(String name, int phone);
	void remove(String name);
	boolean contains(String name);
}

class MutableLoP implements IMutableLoP{
	ILoPerson sentinel;
	MutableLoP(Sentinel sentinel){
		sentinel = new Sentinel( new MtLoPerson());
	}
	
	public void add(String name, int phone) {
		this.sentinel = this.sentinel.insert(name, phone); 
	}
	public  void remove(String name) {
		this.sentinel.removePerson( );
	}
	public boolean contains(String name) {
		return false;
	}
}


interface ILoPerson{
	boolean contains(String name);
	int getNum(String name);
	void changePhone(String name, int newNum);
	void removePerson(String name);
	void removePersonHelper(String name, ASentinel prev);
	ILoPerson insert(String name, int phone);
}

abstract class ASentinel implements ILoPerson {
	ILoPerson rest;
	public ASentinel(ILoPerson rest) {
		this.rest = rest;
	}
	public abstract boolean contains(String name);
	public abstract int getNum(String name);
	public abstract void changePhone(String name, int newNum);
	public abstract void removePerson(String name);
	public abstract  void removePersonHelper(String name, ASentinel prev);

}
class Sentinel extends ASentinel {
	Sentinel(ILoPerson rest){
		super(rest);
	}
	public boolean contains(String name) {
		return this.rest.contains(name);
	}
	public int getNum(String name) {
		return this.rest.getNum(name);
	}
	//public ILoPerson changePhone(String name, int newNum) {return new MtLoPerson(); }
	public void changePhone(String name, int newNum) {
		this.rest.changePhone(name, newNum);
	}
	public void removePerson(String name) {
		this.rest.removePersonHelper(name, this);
	}
 
	public ILoPerson insert(String name, int phone) {
		return new Sentinel(this.rest.insert(name, phone));
	}
}

class MtLoPerson implements ILoPerson{
	public boolean contains(String name) {return false;}
	public int getNum(String name) {return -1;}
//	public ILoPerson changePhone(String name, int newNum) {return new MtLoPerson(); }
	public void changePhone(String name, int newNum) {return ;}
	public void removePerson(String name) {return ;}
	public void removePersonHelper(String name, ASentinel prev) {return ;}
	public ILoPerson insert(String name, int phone) {
		return new ConsLoPerson(new Person(name, phone), this);
	}
}

class ConsLoPerson extends ASentinel{
	Person first;
//	ILoPerson rest;
	ConsLoPerson(Person first, ILoPerson rest){
		super(rest);
		this.first = first;
		
	}
	public boolean contains(String name) {
		return this.first.name.equals(name) || this.rest.contains(name);
	}
	
	public int getNum(String name) {
		if (this.first.name != name){
			return this.rest.getNum(name);
		}else {
			return this.first.phone;
		}
}
	
	public void changePhone(String name, int newNum) {
		  if (this.first.name.equals(name)) {
		    this.first.changeNum(newNum); // do the update
		  }
		  else {
		    this.rest.changePhone(name, newNum); // keep searching the rest of the list
		  }
	}
	
	public void removePerson(String name) {
		this.rest.removePersonHelper(name, this);
	}
	
	public void removePersonHelper (String name, ASentinel prev) {
		if (this.first.name.equals(name)) {
			 
			prev.rest = this.rest;
			
		}else {
			this.rest.removePerson( name);
		}
	}
	
	public ILoPerson insert(String name, int phone) {
		return new ConsLoPerson(this.first, this.rest.insert(name, phone));
	}

}

class Person {
	  String name;
	  int phone;
	  Person(String name, int phone) {
	    this.name = name;
	    this.phone = phone;
	  }
	  // Returns true when the given person has the same name and phone number as this person
	  boolean samePerson(Person that) {
	    return this.name.equals(that.name) && this.phone == that.phone;
	  }
	  void changeNum(int newNum) {
		  this.phone = newNum;
	  }  
}


class Examples{
	Examples(){}
	Person anne = new Person("Anne", 1234);
	  Person bob = new Person("Bob", 3456);
	  Person clyde = new Person("Clyde", 6789);
	  Person dana = new Person("Dana", 1357);
	  Person eric = new Person("Eric", 12469);
	  Person frank = new Person("Frank", 7294);
	  Person gail = new Person("Gail", 9345);
	  Person henry = new Person("Henry", 8602);
	  Person irene = new Person("Irene", 91302);
	  Person jenny = new Person("Jenny", 8675309);
	  
	  
	  ILoPerson friends, family, work,list1 ;
	  void initData() {
	    this.friends =
	      new ConsLoPerson(this.anne, new ConsLoPerson(this.clyde,
	        new ConsLoPerson(this.gail, new ConsLoPerson(this.frank,
	          new ConsLoPerson(this.jenny, new MtLoPerson())))));
	    this.family =
	      new ConsLoPerson(this.anne, new ConsLoPerson(this.dana,
	        new ConsLoPerson(this.frank, new MtLoPerson())));
	    this.work =
	      new ConsLoPerson(this.bob, new ConsLoPerson(this.clyde,
	        new ConsLoPerson(this.dana, new ConsLoPerson(this.eric,
	          new ConsLoPerson(this.henry, new ConsLoPerson(this.irene,
	            new MtLoPerson()))))));
	    this.list1 = new Sentinel(
	    						new ConsLoPerson(anne,
	    						new ConsLoPerson(bob,
	    						new ConsLoPerson(clyde, 
	    						new ConsLoPerson(dana,
	    						new MtLoPerson())))));
		 
	  }
//	// In ExamplePhoneLists
//	  void testFindPhoneNum(Tester t) {
//	    this.initData();
//	    // Should be able to find the correct number of someone in a list
//	    t.checkExpect(this.friends.getNum("Frank"), 7294);
//	    // Should return -1 for someone not in a list
//	    t.checkExpect(this.work.getNum("Zelda"), -1);
//	    // When someone is in two lists, their number should be the same in both
//	    t.checkExpect(this.friends.getNum("Anne"),
//	                  this.family.getNum("Anne"));
//	  }
	  
	// In ExamplePhoneLists
	  void testChangeNum(Tester t) {
		    this.initData();
		    t.checkExpect(this.frank.phone, 7294);
		    this.frank.changeNum(9021);
		    t.checkExpect(this.frank.phone, 9021);
		  }
	  
	  
	  void testRemovePerson(Tester t) {
		  this.initData();
		    t.checkExpect(list1.contains("Anne"), true);
		    t.checkExpect(list1.contains("Bob"), true);
		    list1.removePerson("Anne");
		    t.checkExpect(list1.contains("Anne"), false);
		    t.checkExpect(list1.contains("Bob"), true);

	  }
	  
//	  void testMutablePerson(Tester t) {
//		  IMutableLoP newList = new MutableLoP();
//		  newList.add("John", 6666);
//		  newList.add("Henry", 1241);
//		  newList.add("Gertrude", 3298);
//		  
//		  newList.remove("Henry" );
//	  }
	  void testInsert(Tester t) {
		  this.initData();
		  ILoPerson expected = new ConsLoPerson(this.anne, new ConsLoPerson(this.bob, new ConsLoPerson(this.henry, new MtLoPerson())));
		  
		  ILoPerson listInsert = new MtLoPerson();
		  listInsert = listInsert.insert("Anne", 1234);
		  listInsert = listInsert.insert("Bob", 3456);
		  listInsert = listInsert.insert("Henry", 8602);

		  t.checkExpect(listInsert, expected);
		  
	  }
}
//
//friends
//|
//V
//+-------+  +-------+  +-------+  +-------+  +-------+  ++
//| rest --->| rest --->| rest --->| rest --->| rest --->||
//| first |  | first |  | first |  | first |  | first |  ||
//+--|----+  +--|----+  +--|----+  +--|----+  +--|----+  ++
// |          |          |          |          +------------------------------------------+
// |          +----+     +----------------------------------+                             |
// |               |                +------------+          |                             |
// V               V                             V          V                             V
//+------+ +------+ +-------+ +------+ +-------+ +-------+ +------+ +-------+ +-------+ +---------+
//| Anne | | Bob  | | Clyde | | Dana | | Eric  | | Frank | | Gail | | Henry | | Irene | | Jenny   |
//| 1234 | | 3456 | | 6789  | | 1357 | | 12469 | | 7924  | | 9345 | | 8602  | | 91302 | | 8675309 |
//+------+ +------+ +-------+ +------+ +-------+ +-------+ +------+ +-------+ +-------+ +---------+
// ^        ^        ^        ^ ^      ^          ^                 ^             ^
// |        |        |        | |      |          |                 +-----------+ |
// |        |        |        | |      +----------|--------------------------+  | |
// |        |        |        | +-----------------|---------------+          |  | +----------------+
// |        |        +--------|-------------------|----+          |          |  |                  |
// |        +-----------------|-------------+     |    |          |          |  |                  |
// |                          |             |     |    |          |          |  +-------+          |
// |          +---------------+             |     |    |          |          |          |          |
// |          |          +------------------|-----+    |          |          |          |          |
//+--|----+  +--|----+  +--|----+  ++         |          |          |          |          |          |
//| first |  | first |  | first |  ||      +--|----+  +--|----+  +--|----+  +--|----+  +--|----+  +--|----+  ++
//| rest --->| rest --->| rest --->||      | first |  | first |  | first |  | first |  | first |  | first |  ||
//+-------+  +-------+  +-------+  ++      | rest --->| rest --->| rest --->| rest --->| rest --->| rest --->||
//^                                       +-------+  +-------+  +-------+  +-------+  +-------+  +-------+  ++
//|                                         ^
//family                                      |
//                                       work