package dbsi;

public class Movie {
	private static long uniqueCount = 1; 
	private long movieid;  
	private String movie;
	
	Movie(String movie){
		this.setMovieid(uniqueCount);
		this.setMovie(movie);
		uniqueCount += 1;
	}

	public Movie() {
	}

	public long getMovieid() {
		return movieid;
	}

	public void setMovieid(long movieid) {
		this.movieid = movieid;
	}
	
	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}
}
