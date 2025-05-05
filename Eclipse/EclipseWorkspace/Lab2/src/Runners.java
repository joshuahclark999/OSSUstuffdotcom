//import tester.Tester;
//
//interface ILoRunner{
//	ILoRunner findAllMaleRunners();
//	ILoRunner findAllFemaleRunners();
//	ILoRunner findRunnersInFirst50();
//	// In ILoRunner
//	ILoRunner find(IRunnerPredicate pred);
//	ILoRunner sortByTime(ICompareRunners comp);
//	ILoRunner insertByTime(ICompareRunners comp, Runner r);
//	ILoRunner insertBy(ICompareRunners comp, Runner r);
//	Runner findWinner();
//	Runner getFirst();
//
//}
//
//class MTLoRunner implements ILoRunner {
//	public ILoRunner findAllMaleRunners() { return this; }
//	public ILoRunner findAllFemaleRunners() { return this; }
//	public ILoRunner findRunnersInFirst50() { return this;}
//	// In MtLoRunner
//	public ILoRunner find(IRunnerPredicate pred) { return this; }
//	public ILoRunner sortByTime(ICompareRunners comp) {return this;}
//	public ILoRunner insertByTime(ICompareRunners comp, Runner r) {return new ConsLoRunner(r, this);}
//	public Runner findWinner() {
//		throw new RuntimeException("No winner in empty list of runners");
//		}
//	
//public Runner getFirst() {
//	  throw new RuntimeException("No first of an empty list of Runners");
//	}
//	
//	
//}
//
//class ConsLoRunner implements ILoRunner {
//	Runner first;
//	ILoRunner rest;
//	ConsLoRunner(Runner first, ILoRunner rest){
//		this.first = first;
//		this.rest = rest;
//	}
//	public ILoRunner findAllMaleRunners() {
//		if( this.first.isMaleRunner()) {
//			return new ConsLoRunner(this.first, this.rest.findAllMaleRunners());
//		}else {
//			return this.rest.findAllMaleRunners();
//		}
//	}
//	public ILoRunner findAllFemaleRunners() {
//		if (!this.first.isMale) {
//			return new ConsLoRunner (this.first, this.rest.findAllFemaleRunners());
//		}else {
//			return this.rest.findAllFemaleRunners();
//		}
//	}
//	public ILoRunner findRunnersInFirst50() {
//		if (this.first.posUnder50()) {
//			return new ConsLoRunner(this.first, this.rest.findRunnersInFirst50());
//		}else {
//			return this.rest.findRunnersInFirst50();
//		}
//	}

//	// In ConsLoRunner
//	public ILoRunner find(IRunnerPredicate pred) {
//	  if (pred.apply(this.first)) {
//	    return new ConsLoRunner(this.first, this.rest.find(pred));
//	  }
//	  else {
//	    return this.rest.find(pred);
//	  }
//	}
//	
//	public ILoRunner sortByTime(ICompareRunners comp) {
//		return this.rest.sortByTime(comp).insertByTime(comp, this.first);
//	}
//	public ILoRunner insertByTime(ICompareRunners comp, Runner r) {
//		if (comp.comesBefore(this.first, r)) {
//			return new ConsLoRunner(this.first, this.rest.insertByTime(comp, r));
//		}else {
//			return new ConsLoRunner(r, this);
//		}
//	}
//	public ILoRunner insertBy(IRunnerComparator comp, Runner r) {
//		if (comp.compare(this.first, r) > 0){
//			return new ConsLoRunner(this.first, this.rest.insertBy(comp, r));
//		}else {return new ConsLoRunner(r, this);}
//	}
//	public ILoRunner sortByTime() {
//		  return this.rest.sortByTime().insertByTime(this.first);
//		}
//		public ILoRunner insertByTime(Runner r) {
//		  if (this.first.finishesBefore(r)) {
//		    return new ConsLoRunner(this.first, this.rest.insertByTime(r));
//		  }
//		  else {
//		    return new ConsLoRunner(r, this);
//		  }
//		}
//	
//}
//interface  IRunnerComparator{
//	// returns -1 if r1 comes before r2
//	//returns 0 if r1 and r2 come at same time
//	// returns 1 if r1 comes after r2 
//	int compare(Runner r1, Runner r2);
//}
//
// class CompareByTime implements IRunnerComparator{
//	public int compare(Runner r1, Runner r2) {
//		return r1.time - r2.time;
//	}	
//}
//
//class Runner implements ILoRunner {
//	String name; 
//	int age;
//	int bib;
//	boolean isMale;
//	int pos;
//	int time;
//	Runner(String name, int age, int bib, boolean isMale, int pos, int time){
//		this.name = name;
//		this.age = age;
//		this.bib = bib;
//		this.isMale = isMale;
//		this.pos = pos;
//		this.time = time;
//	}
//	public boolean isMaleRunner() {
//		return this.isMale;
//	}
//	public boolean posUnder50() {
//		return this.pos <= 50;
//	}
//	public boolean finishesBefore(Runner r) {
//		return this.time < r.time;
//	}
//}
//
//interface ICompareRunners{
//	boolean comesBefore(Runner r1, Runner r2);
//}
//
//class  CompareRunnerTimes implements ICompareRunners{
//	public boolean comesBefore(Runner r1, Runner r2) {return r1.time < r2.time;}
//}
//
//interface IRunnerPredicate {
//	  boolean apply(Runner r);
//	}
//
//
//	class RunnerIsMale implements IRunnerPredicate {
//	  public boolean apply(Runner r) { return r.isMale; }
//	}
//	class RunnerIsFemale implements IRunnerPredicate {
//	  public boolean apply(Runner r) { return !r.isMale; }
//	}
//	class RunnerIsInFirst50 implements IRunnerPredicate {
//	  public boolean apply(Runner r) { return r.pos <= 50; }
//	}
//	class FinishIn4Hours implements IRunnerPredicate {
//		  public boolean apply(Runner r) { return r.time < 240; }
//		}
//	class AndPredicate implements IRunnerPredicate {
//		  IRunnerPredicate left, right;
//		  AndPredicate(IRunnerPredicate left, IRunnerPredicate right) {
//		    this.left = left;
//		    this.right = right;
//		  }
//		  public boolean apply(Runner r) {
//		    return this.left.apply(r) && this.right.apply(r);
//		  }
//		}
//
//
//class ExampleRunners {
//	// In Examples class
//	Runner johnny = new Runner("Kelly", 97, 999, true, 30, 360);
//	Runner frank  = new Runner("Shorter", 32, 888, true, 245, 130);
//	Runner bill = new Runner("Rogers", 36, 777, true, 119, 129);
//	Runner joan = new Runner("Benoit", 29, 444, false, 18, 155);
//	 
//	ILoRunner mtlist = new MTLoRunner();
//	ILoRunner list1 = new ConsLoRunner(johnny, new ConsLoRunner(joan, mtlist));
//	ILoRunner list2 = new ConsLoRunner(frank, new ConsLoRunner(bill, list1));
//	
//	boolean testFindMethods(Tester t) {
//		  return
//		    t.checkExpect(this.list2.findAllFemaleRunners(),
//		                  new ConsLoRunner(this.joan, new MTLoRunner())) &&
//		    t.checkExpect(this.list2.findAllMaleRunners(),
//		                  new ConsLoRunner(this.frank,
//		                    new ConsLoRunner(this.bill,
//		                      new ConsLoRunner(this.johnny, new MTLoRunner()))));
//		}
//
//	// In Examples class
//	boolean testFindUnder4Hours(Tester t) {
//	  return
//	    t.checkExpect(this.list2.find(new FinishIn4Hours()),
//	                  new ConsLoRunner(this.frank,
//	                    new ConsLoRunner(this.bill,
//	                      new ConsLoRunner(this.joan, new MTLoRunner()))));
//	}
//	boolean testCombinedQuestions(Tester t) {
//		  return
//		    t.checkExpect(this.list2.find(
//		                    new AndPredicate(new RunnerIsMale(), new FinishIn4Hours())),
//		                  new ConsLoRunner(this.frank,
//		                    new ConsLoRunner(this.bill, new MTLoRunner()))) &&
//		    t.checkExpect(this.list2.find(
//		                    new AndPredicate(new RunnerIsFemale(),
//		                      new AndPredicate(new RunnerIsFemale(),
//		                                       new RunnerIsInFirst50()))),
//		                  new ConsLoRunner(this.joan, new MTLoRunner()));
//		}
//
//	
//}
//
