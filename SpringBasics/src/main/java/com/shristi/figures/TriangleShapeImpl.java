package com.shristi.figures;

import org.springframework.stereotype.Component;

@Component
public class TriangleShapeImpl implements IShape {

	@Override
	public void area(int length, int breadth) {
		System.out.println("Area of Triangle is "+0.5*length *breadth);
		
	}

}
