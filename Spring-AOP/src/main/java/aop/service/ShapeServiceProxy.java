package com.sumon.api.aop.service;

import com.sumon.api.aop.model.Circle;

public class ShapeServiceProxy extends ShapeService {

	public Circle getCircle() {
		return super.getCircle();
	}
}
