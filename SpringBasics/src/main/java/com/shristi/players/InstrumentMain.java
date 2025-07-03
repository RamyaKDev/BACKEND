package com.shristi.players;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InstrumentMain {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext("com.shristi.players");
		Performer performer= context.getBean("performer",Performer.class);
		performer.playSong("keyboard", "Hello Hello Song");
	}

}
