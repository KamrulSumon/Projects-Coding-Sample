package com.sumon.api.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sumon.api.aop.service.FactoryService;
import com.sumon.api.aop.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {

		ApplicationContext cfg = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = cfg.getBean("shapeService", ShapeService.class);
		// shapeService.getCircle().setName("Dummy name");
		// shapeService.getCircle().setNameandReturn("Dummy Name on Return");
		// System.out.println(shapeService.getCircle().getName());
		shapeService.getCircle();

		FactoryService factoryService = new FactoryService();
		ShapeService shapeService2 = (ShapeService) factoryService.getBean("shapeService");
		shapeService2.getCircle();
	}

}
