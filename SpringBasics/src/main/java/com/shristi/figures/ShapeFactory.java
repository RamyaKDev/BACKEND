package com.shristi.figures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class ShapeFactory {
	private String choice;
	private int x;
	private int y;
	@Autowired
	@Qualifier("squareShapeImpl")// Autowiring by type
	private IShape ishape;
	
	@Autowired// Autowiring by name
	private IShape rectangleShapeImpl;
	
	private IShape tshape;// Autowiring by Constructor
	public ShapeFactory(@Qualifier("triangleShapeImpl")IShape tshape) {
		super();
		this.tshape = tshape;
	}
	public void printArea(String choice, int x, int y){
		System.out.println("Printing area");
		if(choice.equals("s"))
			ishape.area(x, y);
		if(choice.equals("r"))
			rectangleShapeImpl.area(x, y);
		if(choice.equals("t"))
			tshape.area(x, y);
	} 
}
