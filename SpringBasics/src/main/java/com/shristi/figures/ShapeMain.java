package com.shristi.figures;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class ShapeMain {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext("com.shristi.figures");
		ShapeFactory shapefactory=(ShapeFactory) context.getBean(ShapeFactory.class);
		shapefactory.printArea("s", 10, 5);
		System.out.println("shapefactory "+shapefactory.hashCode());
		
		ShapeFactory shapefactory1=(ShapeFactory) context.getBean(ShapeFactory.class);
		shapefactory1.printArea("r", 10, 5);
		System.out.println("shapefactory1 "+shapefactory1.hashCode());
		
		ShapeFactory shapefactory2=(ShapeFactory) context.getBean(ShapeFactory.class);
		shapefactory2.printArea("t", 10, 5);
		System.out.println("shapefactory2 "+shapefactory2.hashCode());
	}

}
