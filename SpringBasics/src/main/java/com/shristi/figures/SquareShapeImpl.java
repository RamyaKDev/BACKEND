package com.shristi.figures;

import org.springframework.stereotype.Component;

@Component
public class SquareShapeImpl implements IShape{

	@Override
	public void area(int length, int breadth) {
		System.out.println("Area of Square is "+length *length);		
	}

}
