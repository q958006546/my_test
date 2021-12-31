package com.lzyd.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SpringTest2 {
	@Autowired
	private SpringTest1 springTest1;

	public SpringTest2(SpringTest1 springTest1) {
		this.springTest1 = springTest1;
	}

	public void setSpringTest1(SpringTest1 springTest1) {
		this.springTest1 = springTest1;
	}
	@Async("getSpringTest2")
	public SpringTest1 getSpringTest1() {
		return springTest1;
	}
}
