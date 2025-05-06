class posUnder50 implements IPred<Runner>{

	public boolean apply(Runner r) {
		return r.pos <= 50;
	}
	
}