package com.movieapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class MovieDto {
		private String title;		
		private Integer movieId;
		private int releaseYear;
		private String language;
		private String genre;
		private String format;
		private String director;
}
