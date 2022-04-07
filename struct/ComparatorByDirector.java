package struct;

import java.util.Comparator;

public class ComparatorByDirector implements Comparator<Movie> {

	
		@Override
		public int compare(Movie a, Movie b) {
			return (a.getDirector().compareTo(b.getDirector()) >= 0) ? 1 : -1;
		}
	
}
