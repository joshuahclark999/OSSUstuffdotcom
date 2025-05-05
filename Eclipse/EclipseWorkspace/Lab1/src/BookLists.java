import tester.*;

interface IAT {
	int count();
	int countHelper();
	int femaleAncOver40();
	int getAge();
	int femaleAncOver40Helper();
	boolean wellFormed();
	boolean bornInOrBefore(int yob); 
	IAT youngestAnc(int gen);
	IAT youngestIAT(IAT other);
	IAT youngestIATHelper(IAT other, int otherYob);
	IAT youngestParent();
	IAT youngestGrandparent();
}
class Unknown implements IAT {
   Unknown() { }
   public int count() {
	   return 0;
   }
   public int countHelper() {
	   return 0;
   }
   public int femaleAncOver40(){
	   return 0;
   }
   public int getAge() {
	   return 0;
   }
   public int femaleAncOver40Helper() {
	   return 0;
   }
   public boolean wellFormed() {
	   return true;
   }
   public  boolean bornInOrBefore(int yob) {
	   return true;
   }
   public IAT  youngestAnc(int gen) {
		if (gen == 0) {
			return this;
		}else {
			 return new Unknown();
		}
	}
   public IAT youngestIAT(IAT other) {
	   return other;
   }
	public IAT youngestIATHelper(IAT other, int otherYob) {
		return other;
	}
	public IAT youngestParent() {
		return new Unknown();
	}
	public IAT youngestGrandparent() {
		return new Unknown();
	}

}
class Person implements IAT {
    String name;
    int yob;
    boolean isMale;
    IAT mom;
    IAT dad;
    Person(String name, int yob, boolean isMale, IAT mom, IAT dad) {
        this.name = name;
        this.yob = yob;
        this.isMale = isMale;
        this.mom = mom;
        this.dad = dad;
    }
    public int countHelper() {
    	return 1 + this.mom.countHelper() + this.dad.countHelper();
    	}
    public int count() {
    	return this.mom.countHelper() + this.dad.countHelper();
    	
    }
    public int getAge() {
    	return 2025- this.yob;
    }
	
	public int femaleAncOver40() {
		return this.mom.femaleAncOver40Helper() + this.dad.femaleAncOver40Helper();
	}
	public int femaleAncOver40Helper() {
		if (2015 - this.yob > 40 && !this.isMale) {
			return 1 + this.mom.femaleAncOver40Helper() + this.dad.femaleAncOver40Helper();
		}else return this.mom.femaleAncOver40Helper() + this.dad.femaleAncOver40Helper();
	}
	public boolean bornInOrBefore(int yob) {
		return this.yob <= yob;
	}
	public boolean wellFormed(int yob) {
		return this.mom.bornInOrBefore(yob) &&
				this.dad.bornInOrBefore(yob) &&
				this.mom.wellFormed() &&
				this.dad.wellFormed();
	}
	public IAT youngestIATHelper(IAT other, int otherYob) {
		if (this.yob > otherYob) {
			return this;
		}else {
			return other;
		}
	}
	 public IAT youngestIAT(IAT other) {
		   return other.youngestIATHelper(this, this.yob);
	   }

	@Override
	public boolean wellFormed() {
		// TODO Auto-generated method stub
		return false;
	}
	public IAT youngestParent() {
		return this.mom.youngestIAT(this.dad);
	}
	public IAT youngestGrandparent() {
		return this.mom.youngestParent().youngestIAT(this.dad.youngestParent());
	}
	  public IAT  youngestAnc(int gen) {
		if (gen == 0) {
			return this;
		}else if (gen == 1){
			 return this.youngestParent();
		}else if (gen == 2) {
			return this.youngestGrandparent();
		}else {
			return this.mom.youngestAnc(-1).youngestIAT(dad.youngestAnc(gen-1));
		}
	}
    
}



class ExamplesIAT {
    IAT enid = new Person("Enid", 1904, false, new Unknown(), new Unknown());
    IAT edward = new Person("Edward", 1902, true, new Unknown(), new Unknown());
    IAT emma = new Person("Emma", 1906, false, new Unknown(), new Unknown());
    IAT eustace = new Person("Eustace", 1907, true, new Unknown(), new Unknown());
 
    IAT david = new Person("David", 1925, true, new Unknown(), this.edward);
    IAT daisy = new Person("Daisy", 1927, false, new Unknown(), new Unknown());
    IAT dana = new Person("Dana", 1933, false, new Unknown(), new Unknown());
    IAT darcy = new Person("Darcy", 1930, false, this.emma, this.eustace);
    IAT darren = new Person("Darren", 1935, true, this.enid, new Unknown());
    IAT dixon = new Person("Dixon", 1936, true, new Unknown(), new Unknown());
 
    IAT clyde = new Person("Clyde", 1955, true, this.daisy, this.david);
    IAT candace = new Person("Candace", 1960, false, this.dana, this.darren);
    IAT cameron = new Person("Cameron", 1959, true, new Unknown(), this.dixon);
    IAT claire = new Person("Claire", 1956, false, this.darcy, new Unknown());
 
    IAT bill = new Person("Bill", 1980, true, this.candace, this.clyde);
    IAT bree = new Person("Bree", 1981, false, this.claire, this.cameron);
 
    IAT andrew = new Person("Andrew", 2001, true, this.bree, this.bill);
 
    boolean testCount(Tester t) {
        return
            t.checkExpect(this.andrew.count(), 16) &&
            t.checkExpect(this.david.count(), 1) &&
            t.checkExpect(this.enid.count(), 0) &&
            t.checkExpect(new Unknown().count(), 0)&&
        	t.checkExpect(this.andrew.getAge(), 24);
    }
    boolean testYoungestAnc(Tester t) {
    	return t.checkExpect(bree.youngestIAT(bill), bree) &&
    			   t.checkExpect(cameron.youngestIAT(candace), candace) ;
    }
    boolean testYoungestParent(Tester t) {
    	return t.checkExpect(andrew.youngestParent(), bree) && t.checkExpect(bree.youngestParent(), cameron);
    }
    boolean testYoungestGrandparent(Tester t) {
    	return t.checkExpect(andrew.youngestGrandparent(), candace) && t.checkExpect(bree.youngestGrandparent(), dixon);
    }
    boolean testYoungestAncGen(Tester t) {
    	return t.checkExpect(andrew.youngestAnc(0), andrew) &&
  			  t.checkExpect(andrew.youngestAnc(1), bree) &&
			  t.checkExpect(andrew.youngestAnc(2), candace) &&
			  t.checkExpect(andrew.youngestAnc(3), darren) &&
			  t.checkExpect(andrew.youngestAnc(4), edward);



    }

}

