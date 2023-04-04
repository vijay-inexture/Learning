package com.inexture.springCore;

public class SingletonA {
	
	private PrototypeB prototypeB;

	public PrototypeB getPrototypeB() {
		return prototypeB;
	}

	public void setPrototypeB(PrototypeB prototypeB) {
		this.prototypeB = prototypeB;
	}

	public SingletonA(PrototypeB prototypeB) {
		super();
		this.prototypeB = prototypeB;
	}
	
	

}
