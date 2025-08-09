package com.movieapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.exception.TheatreNotFoundException;
import com.movieapp.model.Theatre;
import com.movieapp.model.TheatreDto;
import com.movieapp.repository.ITheatreRepository;

@Service
public class TheatreServiceImpl implements ITheatreService{
	@Autowired
	private ModelMapper mapper;
	
	private ITheatreRepository theatreRepository;	
	

	public TheatreServiceImpl(ITheatreRepository theatreRepository) {
		super();
		this.theatreRepository = theatreRepository;
	}


	@Override
	public void addTheatre(TheatreDto theatreDto) {
		Theatre theatre=mapper.map(theatreDto,Theatre.class);
		theatreRepository.save(theatre);
		
	}


	@Override
	public void updateTheatre(TheatreDto theatreDto) {
		Theatre theatre=mapper.map(theatreDto,Theatre.class);
		theatreRepository.save(theatre);
		
	}


	@Override
	public void deleteTheatre(int theatreId) {
		theatreRepository.deleteById(theatreId);
		
	}


	@Override
	public TheatreDto getByTheatreId(int theatreId) throws TheatreNotFoundException {
		Theatre theatre=theatreRepository.findById(theatreId)
				.orElseThrow(()->new TheatreNotFoundException("invalid id"));			
		TheatreDto theatreDto=mapper.map(theatre,TheatreDto.class);
		return theatreDto;
	}

	
}
