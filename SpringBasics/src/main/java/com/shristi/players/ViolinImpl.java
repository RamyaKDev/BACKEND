package com.shristi.players;

import org.springframework.stereotype.Component;

@Component
public class ViolinImpl implements IInstrument{

	@Override
	public void play(String song) {		
			System.out.println("playing this "+song +" using violin");
			} 
		
	}


