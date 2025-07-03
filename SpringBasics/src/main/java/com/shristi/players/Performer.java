package com.shristi.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Performer {
	@Autowired
	@Qualifier("violinImpl") // Autowiring by type
	private IInstrument iInstrument;

	@Autowired // Autowiring by name
	private IInstrument guitarImpl;

	private IInstrument instru;

	// Autowiring by constructor
	public Performer(@Qualifier("keyboardImpl") IInstrument instru) {
		super();
		this.instru = instru;
	}

	public void playSong(String type, String song) {
		if (type.equals("violin"))
			iInstrument.play(song);
		if (type.equals("guitar"))
			guitarImpl.play(song);
		if (type.equals("keyboard"))
			instru.play(song);

	}
}
