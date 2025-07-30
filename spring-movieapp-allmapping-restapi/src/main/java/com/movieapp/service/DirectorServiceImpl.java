package com.movieapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.exception.DirectorNotFoundException;
import com.movieapp.model.Director;
import com.movieapp.model.DirectorDto;
import com.movieapp.repository.IDirectorRepository;


@Service
public class DirectorServiceImpl implements IDirectorService {
	@Autowired
	private ModelMapper mapper;
	
	private IDirectorRepository directorRepository;
	public DirectorServiceImpl(IDirectorRepository directorRepository) {
		super();
		this.directorRepository = directorRepository;
	}

	@Override
	public void addDirector(DirectorDto directorDto) {
		Director director=mapper.map(directorDto,Director.class);
		directorRepository.save(director);
		
		
	}

	@Override
	public void updateDirector(DirectorDto directorDto) {
		Director director=mapper.map(directorDto,Director.class);
		directorRepository.save(director);
		
	}

	@Override
	public void deleteDirector(int directorId) {
		directorRepository.deleteById(directorId);
		
	}

	@Override
	public DirectorDto getByDirectorId(int directorId)
			throws DirectorNotFoundException {
		
		Director director=directorRepository.findById(directorId)
				.orElseThrow(()->new DirectorNotFoundException("invalid id"));			
		DirectorDto directorDto=mapper.map(director,DirectorDto.class);
		return directorDto;
	}
	

}
