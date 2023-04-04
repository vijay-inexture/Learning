package com.inexture.springCore;

public class PrototypeABean {
	
	private SingletonBBean singletonBBean;

	public SingletonBBean getSingletonABean() {
		return singletonBBean;
	}

	public void setSingletonABean(SingletonBBean singletonBBean) {
		this.singletonBBean = singletonBBean;
	}

	public PrototypeABean(SingletonBBean singletonBBean) {
		super();
		this.singletonBBean = singletonBBean;
	}
	

}
