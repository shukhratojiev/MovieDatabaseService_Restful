package struct;

import java.util.Comparator;

public class ComparatorByTitle implements Comparator<Movie>{

	@Override
	public int compare(Movie a, Movie b) {
		return (a.getTitle().compareTo(b.getTitle()) >= 0) ? 1 : -1;
	}
	
}
