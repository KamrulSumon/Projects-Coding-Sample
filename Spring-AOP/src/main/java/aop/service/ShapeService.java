package com.sumon.api.aop.service;

import com.sumon.api.aop.aspect.Loggable;
import com.sumon.api.aop.model.Circle;
import com.sumon.api.aop.model.Triangle;

public class ShapeService {

	private Circle circle = null;
	private Triangle triangle = null;

	public ShapeService() {

	}

	@Loggable
	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

}
