package com.sumon.api.aop.service;

import com.sumon.api.aop.model.Circle;
import com.sumon.api.aop.model.Triangle;

public class FactoryService {

	public Object getBean(String beanType) {
		if (beanType.equals("shapeService"))
			return new ShapeServiceProxy();
		if (beanType.equals("shapeService"))
			return new Circle();
		if (beanType.equals("shapeService"))
			return new Triangle();
		return null;
	}
}
