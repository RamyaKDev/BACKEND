package com.movieapp.model;

import java.util.List;

public interface TheatreProjection {
	 String getTheatreName(); 
	 List<ShowTimeProjection > getShowTimes(); 
}
